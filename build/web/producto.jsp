<%-- 
    Document   : producto
    Created on : Oct 6, 2022, 4:44:07 PM
    Author     : Josue
--%>


<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap" %>
<%@page import="modelo.Marca" %>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="modelo.Producto" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
        
        <div class="modal fade" id="modal_marca">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Formulario Puestos</h4>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
          
           <form action="sr_marca" method="post" class="form-group">
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Id marca</span>
                <input type="text" name="txt_idmarca" id="txt_idmarca" value ="0" class="form-control" placeholder="0" aria-label="Puesto" aria-describedby="addon-wrapping" readonly>
            </div>
            <br>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Marca</span>
                <input type="text" name="txt_marca" id="txt_marca" class="form-control" placeholder="Puesto" aria-label="Puesto" aria-describedby="addon-wrapping" required>
            </div>
            <br>
            <div class="btn-group" role="group" aria-label="Basic mixed styles example">
                <button name="btn_agregar" value="agregar" class="btn btn-success" id="btn_agregar">Agregar</button>
                <button name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-primary" > Modificar</button>
                <button name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger" onclick="javascript:if(!confirm('¿Desea Eliminar?, consulte de nuevo')) return false" > Eliminar </button>
                <button type="button" class="btn btn-warning" data-dismiss="modal">Cerrar</button>
            </div>

        </form>
        
      </div>

    </div>
  </div>
</div>  
        <h1>Productos</h1>
        <div class="container mt-3">
        <div class="modal fade" id="modal_producto">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Formulario Productos</h4>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
                  <form action="sr_productos" method="post" class="form-group">
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Id producto</span>
                <input type="text" name="txt_id" id="txt_id" value="0" class="form-control" placeholder="0" aria-label="Puesto" aria-describedby="addon-wrapping" readonly>
            </div>
            <br>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Producto</span>
                <input type="text" name="txt_producto" id="txt_producto" class="form-control" placeholder="Zapato" aria-label="Puesto" aria-describedby="addon-wrapping" required>
            </div>
            <br>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Marca</span>
                <select id="numbers" onchange="myFuntion()" name="dr_marca" id="dr_marca" class="form-control">
                    <% Marca puesto = new Marca();
                HashMap<String,String> drop = puesto.drop_marca();
                    for(String i : drop.keySet()){
                    out.println("<option value='" + i +"'>" + drop.get(i) + "</option>");
                    }
                %>
                <option value="?">+agregarmarca</option>
                </select>
            </div>
            <br>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Descripcion</span>
                <input type="text" name="txt_descripcion" id="txt_descripcion" class="form-control" placeholder="Tenis" aria-label="Puesto" aria-describedby="addon-wrapping" required>
            </div>
            <br>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Imagen</span>
                <input type="file" name="fileImagen" id="fileImagen" class="form-control" placeholder="Url" aria-label="Puesto" aria-describedby="addon-wrapping" required>
            </div>
            <br>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Precio Costo</span>
                <span class="input-group-text" id="addon-wrapping">Q</span>
                <input type="text" name="txt_PrecioCosto" id="txt_PrecioCosto" class="form-control" placeholder="xx.xx" aria-label="Puesto" aria-describedby="addon-wrapping" required>
            </div>
            <br>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Precio Venta</span>
                <span class="input-group-text" id="addon-wrapping">Q</span>
                <input type="text" name="txt_PrecioVenta" id="txt_PrecioVenta" class="form-control" placeholder="xx.xx" aria-label="Puesto" aria-describedby="addon-wrapping" required>
            </div>
            <br>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Existencia</span>
                <input type="text" name="txt_existencia" id="txt_existencia" class="form-control" placeholder="10" aria-label="Puesto" aria-describedby="addon-wrapping" required>
            </div>
            <br>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Fecha de ingreso</span>
                <input type="datetime-local" name="txt_Fningreso" id="txt_Fningreso" class="form-control" placeholder="dd/mm/yyyy" aria-label="Puesto" aria-describedby="addon-wrapping" required>
            </div>
            <br>
            <div class="btn-group" role="group" aria-label="Basic mixed styles example">
                <button name="btn_agregar" value="agregar" class="btn btn-success" id="btn_agregar">Agregar</button>
                <button name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-primary" > Modificar</button>
                <button name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger" onclick="javascript:if(!confirm('¿Desea Eliminar?, consulte de nuevo')) return false" > Eliminar </button>
                <button type="button" class="btn btn-warning" data-dismiss="modal">Cerrar</button>
            </div>
        </form>
          
          
      </div>

    </div>
  </div>
</div> 
             <table class="table table-bordered" >
                <thead class="table-success">
                <tr>
                    <th>Producto</th>
                    <th>Idmarca</th>
                    <th>Descripcion</th>
                    <th>Imagen</th>
                    <th>Precio_Costo</th>
                    <th>Precio_venta</th>
                    <th>Existencia</th>
                    <th>Fecha_ingreso</th>
                    <th>Marca</th>
               
                </tr>
                </thead>
                <tbody id="tbl_producto">
                
                <% Producto empleado = new Producto();
                    DefaultTableModel tabla = new DefaultTableModel();
                    tabla = empleado.leer();
                    for (int t= 0; t<tabla.getRowCount(); t++) {
                            out.println("<tr data-id="+ tabla.getValueAt(t, 0)+" data-id_p=" + tabla.getValueAt(t, 9)+">");
                            out.println("<td>"+ tabla.getValueAt (t,1) + "</td>");
                            out.println("<td>"+ tabla.getValueAt (t,2) + "</td>");
                            out.println("<td>"+ tabla.getValueAt (t,3) + "</td>");
                            out.println("<td>"+ tabla.getValueAt (t,4) + "</td>");
                            out.println("<td>"+ tabla.getValueAt (t,5) + "</td>");
                            out.println("<td>"+ tabla.getValueAt (t,6) + "</td>");
                            out.println("<td>"+ tabla.getValueAt (t,7) + "</td>");
                            out.println("<td>"+ tabla.getValueAt (t,8) + "</td>");
                            out.println("<td>"+ tabla.getValueAt (t,9) + "</td>");
                            out.println("</tr>");
                        }
                  %>
                  
                  
                </tbody>
                
            </table>
            
            
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal_producto" onclick="limpiar()">Nuevo Registro</button>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <script type="text/javascript">
            function myFunction() {
            var option_value = document.getElementById("numbers").value;
            if (option_value === "?") {
              //  alert("Hai !");
               $("#modal_marca").modal();
             }
            }
             function limpiar(){
                $('#txt_id').val(0);
                $('#dr_marca').val(1);
                $('#txt_producto').val('');
                $('#txt_descripcion').val('');
                $('#txt_imagen').val('');
                $('#txt_PrecioCosto').val('');
                $('#txt_PrecioVenta').val('');
                $('#txt_existencia').val('');
                $('#txt_Fningreso').val('');

            }
            
            $('#tbl_producto').on('click','tr td',function(evt){
                var target,id,id_p,producto,idmarca,descripcion,imagen,precio_costo,precio_venta,existencia,fecha_ingreso;
                target = $(event.target);
                id =        target.parent().data('id');
                id_p =      target.parent().data('id_p');
                producto =     target.parent("tr").find("td").eq(0).html();
                idmarca =   target.parent("tr").find("td").eq(1).html();
                descripcion = target.parent("tr").find("td").eq(2).html();
                imagen = target.parent("tr").find("td").eq(3).html();
                precio_costo =  target.parent("tr").find("td").eq(4).html();
                precio_venta =    target.parent("tr").find("td").eq(5).html();
                existencia= target.parent("tr").find("td").eq(6).html();
                fecha_ingreso =    target.parent("tr").find("td").eq(7).html();
                
                $('#txt_id').val(id);
                $('#txt_producto').val(producto);
                $('#dr_marca').val(id_p);
                $('#txt_descripcion').val(descripcion);
                $('#txt_imagen').val(imagen);
                $('#txt_PrecioCosto').val(precio_costo);
                $('#txt_PrecioVenta').val(precio_venta);           
                $('#txt_existencia').val(existencia);
                $("#txt_Fningreso").val(fecha_ingreso);
                $("#modal_producto").modal('show');
            });
            
            
            
        </script>
    </body>
</html>
