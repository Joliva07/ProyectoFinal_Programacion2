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
import modelo.Ventas;
import modelo.Cliente;
import modelo.Producto;

/**
 *
 * @author Josue
 */
@WebServlet(name = "sr_ventas", urlPatterns = {"/sr_ventas"})
public class sr_ventas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    Cliente c = new Cliente();
    Ventas VN = new Ventas();
    Producto p = new Producto();
    List<Ventas>lista=new ArrayList<>();
    String nombre,Nofac;
    float precio,subtotal,total;
    int cantidad,idp,numero,cod=0;
    int num=0;
    int idvd=0;
    String Empleado;
    String FechaF;
    
                    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //try ( PrintWriter out = response.getWriter()) {
                String accion=request.getParameter("accion");
                if(accion==null){
                    accion="inicio";
                }
               // num=VN.BuscarIdVentaDet();
                //cod+=1;
                
                Nofac=VN.Nofactura();
                numero=Integer.parseInt(Nofac);
                numero+=1;
                Nofac=Integer.toString(numero);
                request.setAttribute("Nofac", Nofac);
                
            if("validacion".equals(request.getParameter("validarCliente"))){
              String nit = request.getParameter("txt_Nit");
              c.setNit(nit);
              c=VN.buscar(nit);
              request.setAttribute("c", c);
              FechaF=request.getParameter("Fecha_factura");
              request.setAttribute("FechaF", FechaF);
              
              Empleado=request.getParameter("txt_idEmpleado");
              request.setAttribute("Empleado", Empleado);
                            
            }
            if("buscar_producto".equals(request.getParameter("buscarprod"))){
                String id=request.getParameter("txt_Idproducto");
                p=VN.buscarP(id);
                request.setAttribute("c", c);
                request.setAttribute("producto", p);
                request.setAttribute("lista", lista);
                request.setAttribute("total", total);
                request.setAttribute("FechaF", FechaF);
                request.setAttribute("Empleado", Empleado);
                
            }
            if("AddProducto".equals(request.getParameter("agregarProd"))){
                
                request.setAttribute("c", c);
                total=0;
                
                idvd = idvd+1;
                idp=Integer.parseInt(request.getParameter("txt_Idproducto"));
                nombre=request.getParameter("txt_productoN");
                precio=Float.parseFloat(request.getParameter("txt_precio"));
                cantidad=Integer.parseInt(request.getParameter("txt_cantidad"));
                subtotal=precio*cantidad;
                
                VN=new Ventas();
                VN.setCodigo(idvd); 
                VN.setIdproducto(Integer.toString(idp));
                VN.setProducto(nombre);
                VN.setPrecioUnitario(precio);
                VN.setCantidad(cantidad);
                VN.setTotal(subtotal);
                lista.add(VN);
                for(int i=0; i< lista.size();i++){
                    total=total+lista.get(i).getTotal();
                }
                request.setAttribute("total", total);
                request.setAttribute("lista", lista);
                request.setAttribute("FechaF", FechaF);
                request.setAttribute("Empleado", Empleado);
                
            }
            switch (accion) {
                case "Generarventa":
                    //update existencia
                    for(int i=0;i<lista.size();i++){
                        int cantVendida=lista.get(i).getCantidad();
                        String idproducto=lista.get(i).getIdproducto();
                        int existencia = p.getExistencia() - cantVendida;
                        VN.ActExis(idproducto, existencia);
                    }
                    //venta
                VN.setNoFacrura(Integer.parseInt(Nofac));
                VN.setSerie("A");
                VN.setFechafactura(FechaF);
                VN.setIdcliente(Integer.toString(c.getId_cliente()));
                VN.setIdempleado(Empleado);
                VN.setFechaingreso(FechaF);
                VN.guardarVenta();
                //venta detalle
                String idv=VN.IdVenta();
                for(int i=0;i<lista.size();i++){
                    VN = new Ventas();
                    VN.setIdventa(idv);
                    VN.setIdproducto(lista.get(i).getIdproducto());
                    VN.setCantidad(lista.get(i).getCantidad());
                    VN.setPrecioUnitario(lista.get(i).getPrecioUnitario());
                    VN.guardarDetalleV();
                }
                lista.clear();
                break;
                case "Cancelarventa":
                    num=0;
                    lista.clear();
                    //request.setAttribute("lista", lista);
                break;
                case "modificarDetallev":
                    cod=Integer.parseInt(request.getParameter("id"));
                    cantidad=Integer.parseInt(request.getParameter("txt_cantidad"));
                    p = VN.buscarP(Integer.toString(cod));
                    //p.setCantidad(lista.get(cod).getCantidad());
                    request.setAttribute("c", c);
                    request.setAttribute("producto", p);
                    request.setAttribute("lista", lista);

                    request.setAttribute("total", total);
                    request.setAttribute("FechaF", FechaF);
                    request.setAttribute("Empleado", Empleado);
                break;
                
                case "AceptarModificarDetalleV":
                    
                    cod=Integer.parseInt(request.getParameter("id"));
                    nombre=request.getParameter("txt_productoN");
                    precio=Float.parseFloat(request.getParameter("txt_precio"));
                    cantidad=Integer.parseInt(request.getParameter("txt_cantidad"));
                    
                    subtotal=precio*cantidad;
                    VN=new Ventas();
                    VN.setCodigo(cod-1); 
                    VN.setIdproducto(Integer.toString(idp));
                    VN.setProducto(nombre);
                    VN.setPrecioUnitario(precio);
                    VN.setCantidad(cantidad);
                    VN.setTotal(subtotal);
                    lista.set(cod-1,VN);
                    
                    request.setAttribute("c", c);
                    request.setAttribute("producto", p);
                    request.setAttribute("lista", lista);
                    request.setAttribute("total", total);
                    request.setAttribute("FechaF", FechaF);
                    request.setAttribute("Empleado", Empleado);
                break; 
                case "Eliminar":
                    String idventa = request.getParameter("id");
                    int resultado=VN.EliminarVenDet(idventa);
                    if(resultado>0){
                        VN.EliminarVen(idventa);
                    }else{
                        System.out.println("Error");
                    }
                    
                    
                    
                break;
               /*c = new Cliente();
                VN = new Ventas();
                p = new Producto();
                lista=new ArrayList<>();*/
            }
            request.getRequestDispatcher("ventas.jsp").forward(request, response);
       // }
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
