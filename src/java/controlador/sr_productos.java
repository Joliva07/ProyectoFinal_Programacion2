/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author javie
 */
@MultipartConfig
public class sr_productos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Producto producto;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_productos</title>");            
            out.println("</head>");
            out.println("<body>");
            producto = new Producto(request.getParameter("txt_producto"),request.getParameter("txt_descripcion"),request.getParameter("FileImagen"),request.getParameter("txt_Fningreso"),Integer.valueOf(request.getParameter("dr_marca")),Integer.valueOf(request.getParameter("txt_id")),Integer.valueOf(request.getParameter("txt_existencia")),Float.valueOf(request.getParameter("txt_PrecioCosto")),Float.valueOf(request.getParameter("txt_PrecioVenta")));
            
            //Agregar
            
             if("agregar".equals(request.getParameter("btn_agregar"))){
                 
                /* ArrayList<String> lista = new ArrayList<>();
                    try {
                        FileItemFactory file = new DiskFileItemFactory();
                        ServletFileUpload fileUpload =new ServletFileUpload(file);
                        List items = fileUpload.parseRequest(request);
                        for (int i= 0; i < items.size ();i++) {
                            FileItem fileItem = (FileItem) items.get (i);
                            if (!fileItem. isFormField()) {
                                File f = new File(""+fileItem.getName());
                                fileItem.write(f);
                                producto.setImagen(f.getAbsolutePath());
                            } else {
                                lista.add (fileItem.getString());
                            }
                    }
                   }catch(Exception ex){
                       
                   }*/
                 
            if(producto.crear()>0){
           response.sendRedirect("producto.jsp");
            }else{
                out.println("<h1> XXXXX Error XXXXX</h1>");
                out.println("<a href='producto.jsp'>Regresar...</a>");
            }
                }
         
              //Modificar
            if("modificar".equals(request.getParameter("btn_modificar"))){
            if(producto.modificar()>0){
           response.sendRedirect("producto.jsp");
            }else{
                out.println("<h1> XXXXX Error XXXXX</h1>");
                out.println("<a href='producto.jsp'>Regresar...</a>");
            }
                }
            //Eliminar
            if("eliminar".equals(request.getParameter("btn_eliminar"))){
            if(producto.eliminar()>0){
           response.sendRedirect("producto.jsp");
            }else{
                out.println("<h1> XXXXX Error XXXXX</h1>");
                out.println("<a href='producto.jsp'>Regresar...</a>");
            }
                } 
            
            
            out.println("</body>");
            out.println("</html>");
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
