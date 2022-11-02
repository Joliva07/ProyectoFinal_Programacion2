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
<!DOCTYPE html>
<html>
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventas</title>    
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
         
    </head>
    <body>
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
                                    <input type="text" name="txt_Nit" id="txt_Nit" class="form-control" value="${c.getNit()}" placeholder="Nit" />
                                    <input type="submit" name="validarCliente" id="validarCliente" value="validacion" class="btn btn-outline-info"/>
                                </div>

                                <div class="col-sm-3">
                                <input type="nombre" name="nombre_cl" id="nombre_cl" class="form-control" value="${c.getNombres()}" placeholder="Nombre del cliente" readonly/>
                                <input type="nombre" name="apellido_cl" id="apellido_cl" class="form-control" value="${c.getApellidos()}" placeholder="Apellidos del cliente" readonly/>
                                </div>

                            </div>
                            <div class="form-group">
                                <br>
                                <label>ID de Empleado:</label> 
                            </div>
                            <div class="form-group">
                                <input type="text" name="txt_idEmpleado" id="txt_idEmpleado" class="form-control" placeholder="Id Empleado" />
                            </div>
                            <div class="form-group">
                                <br> 
                                <label>Fecha Ingreso:</label> 
                            </div>
                            <div class="form-group">
                                <input type="date" name="Fecha_factura" class="form-control" placeholder="dd/mm/yyyy" /><br>
                            </div>
                                
                            <div class="form-group">
                                <br>
                                <label>Producto</label> 
                            </div>
                           <div class="form-group d-flex">
                                <div class="col-sm-4">
                                <input type="text" name="txt_Idproducto" id="txt_Idproducto" class="form-control" placeholder="Id Producto" />
                                <button type="submit" name="buscarprod" id="buscarprod" value="buscar_producto" class="btn btn-outline-info">Buscar</button>
                                </div>
                                <div class="col-sm-6">
                                <input type="nombre" name="txt_productoN" id="txt_productoN" value="${producto.getProducto()}" class="form-control" placeholder="Nombre"/>
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-4">
                                <input type="text" name="txt_precio" id="txt_precio" value="${producto.getPrecio_venta()}" class="form-control" value="Q00.00" />
                                </div>
                                <div class="col-sm-2">
                                <input type="number" name="txt_cantidad" value="1" id="txt_cantidad" class="form-control" placeholder="Cantidad"/>
                                </div>
                                <div class="col-sm-4">
                                <input type="text" name="txt_stock" id="txt_stock" value="${producto.getExistencia()}" class="form-control" placeholder="Stock"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <button type="button" value="Agregar" id="agregarProd" name="agregarProd" class="form-control" class="btn btn-primary">Agregar producto</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="form-group">
                    <div class="card">
                        <div class="card-body">
                            <lable>Seleccion de productos</lable>
                            
                            <div class="d-flex col-6 ml-auto">
                                <label>No. Factura  </label>
                                <input type="text" name="txt_Nofactura" class="form-control"/>
                            </div>
                        <br>
                            <div>
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Nombre</th>
                                            <th>Precio</th>
                                            <th>Cantidad</th>
                                            <th>SubTotal</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>    
                                        <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                      <%--  <c:forEach var="list" items="${lista}">
                                            <tr>
                                                <td>${lista.getIdproducto()}</td>
                                                <td>${lista.getProducto()}</td>
                                                <td>${lista.getPrecioUnitario()}</td>
                                                <td>${lista.getCantidad()}</td>
                                                <td>${lista.getTotal()}</td>
                                                <td></td>
                                            </tr>
                                        </c:forEach>--%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        
                        <div class="card-footer">
                            <input type="submit" name="GenVenta" Value="Generar venta" class="btn btn-success"/>
                            <input type="submit" name="CanVenta" Value="Cancelar venta" class="btn btn-danger"/>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>    

                                                     
                                    
    <p>
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
        
        <br>
        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
        </html>