/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import modelo.Compra;
import modelo.Proveedor;
import modelo.Producto;
/**
 *
 * @author Josue
 */
@WebServlet(name = "sr_compras", urlPatterns = {"/sr_compras"})
public class sr_compras extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Proveedor pr = new Proveedor();
    Compra Com = new Compra();
    Producto p=new Producto();
    List<Compra>lista=new ArrayList<>();
    String nombre,NoOrden;
    float precioCom, PrecioVen, subtotal,total;
    int cantidad, idp, numero, cod;
    int num=0;
    String FechaF;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //try ( PrintWriter out = response.getWriter()) {
            String accion=request.getParameter("accion");
                if(accion==null){
                    accion="inicio";
                }
            NoOrden=Com.NoOrden();
            numero=Integer.parseInt(NoOrden);
            numero+=1;
            NoOrden=Integer.toString(numero);
            request.setAttribute("Nofac", NoOrden);
            
            if("validacion".equals(request.getParameter("validarProveedor"))){
              String nit = request.getParameter("txt_proveedor");
              pr.setNit(nit);
              pr=Com.buscar(nit);
              request.setAttribute("pr", pr);
              FechaF=request.getParameter("Fecha_factura");
              request.setAttribute("FechaF", FechaF);     
              
            }
            if("buscar_producto".equals(request.getParameter("buscarprod"))){
                String id=request.getParameter("txt_Idproducto");
                p=Com.buscarP(id);
                request.setAttribute("pr", pr);
                request.setAttribute("producto", p);
                request.setAttribute("lista", lista);
                request.setAttribute("total", total);
                request.setAttribute("FechaF", FechaF);
            }
            if("AddProducto".equals(request.getParameter("agregarProd"))){
                request.setAttribute("pr", pr);
                total=0;
                num = num+1;
                idp=Integer.parseInt(request.getParameter("txt_Idproducto"));
                nombre=request.getParameter("txt_productoN");
                precioCom=Float.parseFloat(request.getParameter("txt_precio"));
                cantidad=Integer.parseInt(request.getParameter("txt_cantidad"));
                subtotal=precioCom*cantidad;
                Com=new Compra();
                Com.setCodigo(num); 
                Com.setIdProducto(Integer.toString(idp));
                Com.setProducto(nombre);
                Com.setPreciounitario(precioCom);
                Com.setCantidad(cantidad);
                Com.setTotal(subtotal);
                lista.add(Com);
                for(int i=0; i< lista.size();i++){
                    total=total+lista.get(i).getTotal();
                }
                request.setAttribute("total", total);
                request.setAttribute("lista", lista);
                request.setAttribute("FechaF", FechaF);   
            }
            switch (accion) {
                case "GenerarCom":
                    //update existencia
                    for(int i=0;i<lista.size();i++){
                        int cantComprada=lista.get(i).getCantidad();
                        String idproducto=lista.get(i).getIdProducto();
                        float precio= lista.get(i).getPreciounitario();
                        float aumento=(float) (precio * 0.25);
                        float precioVen = precio + aumento;
                        int existencia = p.getExistencia() + cantComprada;
                        String fecha=FechaF;
                        Com.ActExis(idproducto, existencia,precio,precioVen,fecha);
                    }
                    //compra
                    
                /*Com.setNoCompra(Integer.parseInt(NoOrden));
                Com.setFechaOrden(FechaF);
                Com.setIdProducto(Integer.toString(pr.getId_proveedor()));
                Com.setFechaIngreso(FechaF);*/
                Com.setNoCompra(Integer.parseInt(NoOrden));
                Com.setIdProveedor(Integer.toString(pr.getId_proveedor()));
                Com.setFechaOrden(FechaF);
                Com.setFechaIngreso(FechaF);
                Com.guardarCompra();
                //compra detalle
                String idc=Com.IdCompra();
                for(int i=0;i<lista.size();i++){
                    Com = new Compra();
                    Com.setId_compra(idc);
                    Com.setIdProducto(lista.get(i).getIdProducto());
                    Com.setCantidad(lista.get(i).getCantidad());
                    Com.setPreciounitario(lista.get(i).getPreciounitario());
                    Com.guardarDetalleC();
                }
                lista.clear();
                break;
                case "CancelarCom":
                    //num=0;
                    //lista.clear();
                    //request.setAttribute("lista", lista);
                break;
                case "Eliminar":
                    String idventa = request.getParameter("id");
                    int resultado=Com.EliminarComDet(idventa);
                    if(resultado>0){
                        System.out.println("Detalle eliminado");
                        Com.EliminarCom(idventa);
                    }else{
                        System.out.println("Error");
                    }
                    
                break;
            }
            request.getRequestDispatcher("compras.jsp").forward(request, response);
        //}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
