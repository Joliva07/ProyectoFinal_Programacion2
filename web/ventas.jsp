<%-- 
    Document   : ventas.jsp
    Created on : 27/10/2022, 16:44:30
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="java.util.Map.Entry"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Cliente" %>
<%@page import="modelo.Ventas" %>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventas</title>    
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <style>
            @media print{
                .parte01,.parte02,.parte03, .parte04, .btn, .accion{
                    display: none;
                }
            }
        </style>

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
        
        <h1 align="center">Ventas</h1>
        <div class="d-flex justify-content-center">
            <div class="col-sm-8" >
                <div class="card">
                    <form action="sr_ventas" action="POST">
                        <div class="card-body" >
                            <div class="form-group"> 
                                <label>NIT:</label> 
                            </div>
                            <div class="form-group d-flex">

                                <div class="col-sm-4">
                                    <input type="text" name="txt_Nit" id="txt_Nit" class="form-control" value="${c.getNit()}" placeholder="Nit" required/>
                                    <input type="submit" name="validarCliente" id="validarCliente" value="validacion" class="btn btn-outline-info"/>
                                    <a href="cliente.jsp" target="modal_cliente"  class="btn btn-outline-info">Nuevo cliente</a>
                                </div>

                                <div class="col-sm-3">
                                <input type="nombre" name="nombre_cl" id="nombre_cl" class="form-control" value="${c.getNombres()}" placeholder="Nombre del cliente" readonly/>
                                <input type="nombre" name="apellido_cl" id="apellido_cl" class="form-control" value="${c.getApellidos()}" placeholder="Apellidos del cliente" readonly/>
                                </div>

                            </div>
                            <div class="col-sm-8">
                                <div class="form-group">
                                <br>
                                <label>ID de Empleado:</label> 
                            </div>
                            <div class="form-group">
                                <input type="text" name="txt_idEmpleado" id="txt_idEmpleado" class="form-control" placeholder="Id Empleado" value="${Empleado}" required />
                            </div>
                            <div class="form-group">
                                <br> 
                                <label>Fecha</label> 
                            </div>
                            <div class="form-group">
                                <input type="date" name="Fecha_factura" id="Fecha_factura" class="form-control" placeholder="dd/mm/yyyy" value="${FechaF}" required/><br>
                            </div>
                                
                            <div class="form-group parte01">
                                <br>
                                <label>Producto</label> 
                            </div>
                           <div class="form-group d-flex parte02">
                                <div class="col-sm-4">
                                <input type="text" name="txt_Idproducto" id="txt_Idproducto" value="${producto.getId_producto()}" class="form-control" placeholder="Id Producto" />
                                <button type="submit" name="buscarprod" id="buscarprod" value="buscar_producto" class="btn btn-outline-info">Buscar</button>
                                </div>
                                <div class="col-sm-6">
                                <input type="nombre" name="txt_productoN" id="txt_productoN" value="${producto.getProducto()}" class="form-control" placeholder="Nombre" readonly/>
                                </div>
                            </div>
                            <div class="form-group d-flex parte03">
                                <div class="col-sm-4">
                                <input type="text" name="txt_precio" id="txt_precio" value="${producto.getPrecio_venta()}" class="form-control" placeholder="Q00.00" readonly />
                                </div>
                                <div class="col-sm-2">
                                <input type="number" name="txt_cantidad" value="${producto.getCantidad()}" id="txt_cantidad" class="form-control" placeholder="Cantidad"/>
                                </div>
                                <div class="col-sm-4">
                                <input type="text" name="txt_stock" id="txt_stock" value="${producto.getExistencia()}" class="form-control" placeholder="Stock" readonly/>
                                </div>
                            </div>
                            <div class="form-group">
                                <button type="submit" value="AddProducto" id="agregarProd" name="agregarProd" class="form-control" class="btn btn-primary">Agregar producto</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div <%--class="form-group"--%>>
                    <div class="card">
                        <div class="card-body">
                            <lable>Lista de productos</lable>
                            
                            <div class="d-flex col-6 ml-auto">
                                <label>No. Factura  </label>
                                <input type="text" name="txt_Nofactura" id="txt_Nofactura" value="${Nofac}" class="form-control" readonly/>
                            </div>
                        <br>
                            <div>
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>No.</th>
                                            <th>Id</th>
                                            <th>Nombre</th>
                                            <th>Precio</th>
                                            <th>Cantidad</th>
                                            <th>SubTotal (Q)</th>
                                            <%--<th class="accion">Acciones</th>--%>
                                        </tr>
                                    </thead>
                                    <tbody >    
                                        <c:forEach var="list" items="${lista}">
                                            <tr>
                                                <td>${list.getCodigo()}</td>
                                                <td>${list.getIdproducto()}</td>
                                                <td>${list.getProducto()}</td>
                                                <td>${list.getPrecioUnitario()}</td>
                                                <td>${list.getCantidad()}</td>
                                                <td>${list.getTotal()}</td>
                                                <td>
                                                    <a href="sr_ventas?accion=modificarDetallev&id=${list.getIdproducto()}&txt_cantidad=${list.getCantidad()}" class="btn btn-warning">Editar</a>   
                                                    <a href="sr_ventas?accion=AceptarModificarDetalleV&id=${list.getCodigo()}&txt_cantidad=${list.getCantidad()}&txt_precio=${list.getPrecioUnitario()}&txt_productoN=${list.getProducto()}" class="btn btn-warning">Realizar modificacion</a> 
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>                                        
                        </div>
                        
                        <div class="card-footer d-flex">
                                <a href="sr_ventas?accion=Generarventa" onclick="print()" class="btn btn-success">Generar Venta</a>
                                <a href="sr_ventas?accion=Modificarventa" onclick="" class="btn btn-warning">Modificar Venta</a>
                                <a href="sr_ventas?accion=Cancelarventa" class="btn btn-danger">Cancelar Venta</a>
                                
                                
                            </div>
                                <div class="col-sm-4 ml-auto">
                                    <input type="text" name="txt_total" id="txt_total" value="Q ${total}0" class="form-control" readonly>
                                </div>
                        </div>
                                        
                    </div>
                </div>
            </div>
        </div>    
                                <br>
                                <br>
         <div class="d-flex justify-content-center">
            <div class="col-sm-8 parte04" >
                <div class="card">
                    <form action="sr_ventas" action="POST">
                        <div class="card-body" >
                            <label>Ventas realizadas</label>
                            <div>
                                
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>No. Factura</th>
                                            <th>Nit Cliente</th>
                                            <th>Id empleado</th>
                                            <th>Fecha de Factura</th>
                                            <th class="accion">Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody id="tbl_venta">    
                                        <% Ventas v = new Ventas();
                                            DefaultTableModel tabla = new DefaultTableModel();
                                            tabla = v.leerVenta();
                                            for(int t = 0;t<tabla.getRowCount();t++ ){
                                                out.println("<tr data-id="+ tabla.getValueAt(t, 0)+" data-id_c=" + tabla.getValueAt(t, 5)+">");
                                                out.println("<td>"+ tabla.getValueAt (t,0) + "</td>");
                                                out.println("<td>"+ tabla.getValueAt (t,1) + "</td>");
                                                out.println("<td>"+ tabla.getValueAt (t,2) + "</td>");
                                                out.println("<td>"+ tabla.getValueAt (t,3) + "</td>");
                                                out.println("<td>"+ tabla.getValueAt (t,4) + "</td>");
                                                out.println("<td>");
                                                //out.println("<button type='button' class='btn btn-info btn-lg' data-toggle='modal' data-target='#myModal' value='"+tabla.getValueAt (t,0)+"'>Detalles</button>");
                                                //out.println("<a href='#ModalDetalle?id="+tabla.getValueAt (t,0)+"' class='btn btn-success'>Detalle</a>");
                                                out.println("<a href='sr_ventas?accion=Eliminar&id="+tabla.getValueAt (t,0)+"' class='btn btn-danger'>Eliminar</a>");
                                                out.println("</td>");
                                                out.println("</tr>");
                                            }
                                            
                                        %>
                                   </table>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
         </div>
         
                    
                            
                            <!-- Modal -->
                            <div class="modal fade" id="Modal_Detalle" >
                              <div class="modal-dialog">
                                  
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div>
                                    <label>Id Venta</label>
                                    <input type="text" name="txt_idVenta" id="txt_idVenta" class="form-control" />
                                    </div>
                                    <div class="modal-body">
                                            <label>Ventas realizadas</label>
                                            
                                                <div>
                                                    <table class="table table-hover">
                                                        <thead>
                                                            <tr>
                                                                <th>Id venta</th>
                                                                <th>Producto</th>
                                                                <th>Cantidad</th>
                                                                <th>Precio unitario</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>    
                                                            <% /*Ventas v = new Ventas();
                                                                DefaultTableModel tabla = new DefaultTableModel();
                                                                tabla = v.leerVenta();
                                                                for(int t = 0;t<tabla.getRowCount();t++ ){
                                                                    out.println("<tr data-id="+ tabla.getValueAt(t, 0)+" data-id_c=" + tabla.getValueAt(t, 5)+">");
                                                                    out.println("<td>"+ tabla.getValueAt (t,0) + "</td>");
                                                                    out.println("<td>"+ tabla.getValueAt (t,1) + "</td>");
                                                                    out.println("<td>"+ tabla.getValueAt (t,2) + "</td>");
                                                                    out.println("<td>"+ tabla.getValueAt (t,3) + "</td>");
                                                                    out.println("<td>"+ tabla.getValueAt (t,4) + "</td>");
                                                                    out.println("<td>");
                                                                    out.println("<a href='#' class='btn btn-warning'>Detalles</a>");
                                                                    out.println("<a href='sr_ventas?accion=Eliminar&id="+tabla.getValueAt (t,0)+"' class='btn btn-danger'>Eliminar</a>");
                                                                    out.println("</td>");
                                                                    out.println("</tr>");
                                                                }*/
                                                                /*Ventas v = new Ventas();
                                                                DefaultTableModel tabla = new DefaultTableModel();
                                                                tabla = v.leerVenta(request.getParameter("id"));*/
                                                            %>
                                                       </table>
                                                </div>
                                    </div>

                                  <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                  </div>
                                </div>

                              </div>
                            </div>
                                                       <script type="text/javascript">
                                                           
                                                           $('#tbl_venta').on('click','tr td',function(evt){
                                                               var target,id;
                                                              target = $(event.target);
                                                               id = target.parent().data('id');
                                                              $('#txt_idVenta').val(id);
                                                               $("#ModalDetalle").modal('show');
                                                           });
                                                           
                                                           /*$('#tbl_estudiantes').on('click','tr td',function(evt){
                                                                var target,id,id_s,carne,nombres,apellidos,direccion,telefono,correo,nacimiento;
                                                                target = $(event.target);
                                                                id=target.parent().data('id');
                                                                id_s=target.parent().data('id_s');
                                                                carne=target.parent("tr").find("td").eq(0).html();
                                                                nombres=target.parent("tr").find("td").eq(1).html();
                                                                apellidos=target.parent("tr").find("td").eq(2).html();
                                                                direccion=target.parent("tr").find("td").eq(3).html();
                                                                telefono=target.parent("tr").find("td").eq(4).html();
                                                                correo=target.parent("tr").find("td").eq(5).html();
                                                                nacimiento=target.parent("tr").find("td").eq(6).html();

                                                                $("#txt_id").val(id);
                                                                $("#txt_carne").val(carne);
                                                                $("#txt_nombre").val(nombres);
                                                                $("#txt_apellido").val(apellidos);
                                                                $("#txt_direccion").val(direccion);
                                                                $("#txt_telefono").val(telefono);
                                                                $("#txt_correoE").val(correo);
                                                                $("#drop_sangre").val(id_s);
                                                                $("#txt_Fn").val(nacimiento);
                                                                $("#modal_estudiante").modal('show');

                                                             });*/
                                                           
                                                       </script>                         
                            
                            
   <%-- <p>
    <br>
     <input type="button" value="Realizar Compra" id="ver_saldo" class="btn btn-success btn-lg" >
	</p>

	<p id="resultado"></p>
	<div class="container">            
            
            <div style="padding-left: 800px">                  
                <input type="text" class="form-control" value="Buscar"/>                            
            </div>
        </div>  
              
        <div class="container">               
            <!--<a  class="btn btn-success" href="Agregar.jsp">Nuevo Registro</a> Esto es Cuando se Crea un nuevo Archivo Agregar.jsp -->         
             <table class="table table-bordered"  id="tablaDatos">
                    <thead>
                        <tr>
                            <th class="text-center">NIT</th>
                            <th>Nombre Empleado</th>
                            <th class="text-center">Nombre Cliente</th>
                            <th class="text-center">Fecha</th>
                        </tr>
                    </thead>
                    <tbody id="tbodys">
                        
                        <tr>
                            <td class="text-center"></td>
                            <td></td>
                            <td class="text-center"></td>
                            <td class="text-center">
                                
                                <!-- <input type="hidden" value="<//%= rs.getInt("Id_Usuario")%>" id="Editar"/>
                                <input type="submit" class="btn btn-warning" data-toggle="modal" data-target="#myModal1" value="Editar"/>  -->
                                
                            </td>
                        </tr>
                </table>
            </div>
        
        <br>--%>
        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
        </html>