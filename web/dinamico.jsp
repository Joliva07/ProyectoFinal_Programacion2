<%-- 
    Document   : dinamico
    Created on : 27 oct 2022, 0:09:47
    Author     : yoc91
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.menu" %>
<%@page import="java.util.HashMap" %>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="java.util.Map.Entry"%>
<%@page session="true" %>


<!DOCTYPE html>
<html>
 
    <head>
        

        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu dinamico</title>
        
    </head>
    <body>
        <% 
            HttpSession sesion = request.getSession();
            String usuario;
            String nivel;
            
            if(sesion.getAttribute("user")!=null && sesion.getAttribute("user")!=null ){
                usuario = sesion.getAttribute("user").toString();
                nivel = sesion.getAttribute("nivel").toString();
                //out.print( "<a href='index.jsp?cerrar=true'>"+ usuario +"<h5>Cerrar Sesion</h5></a>  " );
                
            }else{
                out.print(" <script>location.replace('index.jsp'); </script>   ");
            }
            
        %>
        <h1 id="header">Menu Principal</h1>
        <div id="header">
            
                
            
                <% menu menu = new menu();
                    DefaultTableModel tabla = new DefaultTableModel();
                    tabla = menu.leer();
                    out.println("<ul class='nav'>");
                    //Inicio For                   
                    
                    
                    for (int t= 0; t<tabla.getRowCount(); t++){
                       
                                                     
                            if(tabla.getValueAt(t,2).equals("0")){
                                            out.println("<li>"+ tabla.getValueAt (t,1));
                                            out.println("</li>");
                                            }
                                            //Inicio Producto
                                            out.println("<ul>");
                                            if(tabla.getValueAt(t,2).equals("1")){
                                                                    out.println("<ul>");
                                                                    out.println("<li>"+ tabla.getValueAt (t,1) + "</li>" );
                                                                    out.println("</ul>"); 
                                                       } 
                                                       out.println("</ul>");
                                            // Fin Producto
                                            
                                            //Inicio Ventas 2
                                            out.println("<ul>");
                                            if(tabla.getValueAt(t,2).equals("3")){
                                                                    
                                                                    out.println("<li>"+ tabla.getValueAt (t,1));
                                                                    out.println("</li>");
                                                                    
                                                        }
                                            if(tabla.getValueAt(t,2).equals("5")){
                                                                    out.println("<ul>");
                                                                    out.println("<li>"+ tabla.getValueAt (t,1) + "</li>" );
                                                                    out.println("</ul>"); 
                                                       } 
                                                       out.println("</ul>");
                                                       //Fin Ventas 2
                                                       
                                            //Inicio compras 3
                                            out.println("<ul>");
                                            if(tabla.getValueAt(t,2).equals("7")){
                                                                    
                                                                    out.println("<li>"+ tabla.getValueAt (t,1));
                                                                    out.println("</li>");
                                                                    
                                                        }
                                                       out.println("</ul>");
                                            //Fin compras 3
            
                                            //Fin del For
                                           }                         
                           out.println("</ul>");
                  %>
            
        </div>
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>