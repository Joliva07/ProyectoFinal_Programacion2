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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente c = new Cliente();
        Ventas VN = new Ventas();
        Producto p = new Producto();
        //List<Ventas>lista=new ArrayList<>();
        String nombre,descricion;
        float precio,subtotal;
        int cantidad,idp;
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            if("validacion".equals(request.getParameter("validarCliente"))){
              String nit = request.getParameter("txt_Nit");
              c.setNit(nit);
              Cliente cl=VN.buscar(nit);
              request.setAttribute("c", cl);
              //response.sendRedirect("ventas.jsp");
              request.getRequestDispatcher("ventas.jsp").forward(request, response);
            }
            if("buscar_producto".equals(request.getParameter("buscarprod"))){
                String id=request.getParameter("txt_Idproducto");
                p=VN.buscarP(id);
                request.setAttribute("producto", p);
                request.getRequestDispatcher("ventas.jsp").forward(request, response);
            }
            /*if("Agregar".equals(request.getParameter("agregarProd"))){
                idp=p.getId_producto();
                nombre=request.getParameter("txt_productoN");
                precio=Float.parseFloat(request.getParameter("txt_precio"));
                cantidad=Integer.parseInt("txt_cantidad");
                subtotal=precio*cantidad;
                
                VN.setIdproducto(Integer.toString(idp));
                VN.setProducto(nombre);
                VN.setPrecioUnitario(precio);
                VN.setCantidad(cantidad);
                VN.setTotal(subtotal);
                lista.add(VN);
                
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("ventas.jsp").forward(request, response);
            }*/
            
            //out.println("<h1>Servlet sr_ventas at " + request.getContextPath() + "</h1>");
            //out.println("</body>");
            //out.println("</html>");
        }
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
