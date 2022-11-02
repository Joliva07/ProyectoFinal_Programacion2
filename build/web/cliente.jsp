<%-- 
    Document   : cliente
    Created on : Oct 6, 2022, 4:26:58 PM
    Author     : Josue
--%>

<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="java.util.Map.Entry"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Puesto" %>
<%@page import="modelo.Cliente" %>
<%@page import="java.util.HashMap" %>



<!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
         <link rel="stylesheet" href="puesto.jsp"/>
    </head>
    
    <body>
        <div class="container mt-3">
        <h1>Clientes</h1>
        
      
          <!-- The Modal -->
        <div class="modal fade" id="modal_cliente">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Formulario Cliente</h4>
       </div>    
        
          <!-- Modal body -->
        <div class="modal-body">
        <form action="sr_cliente1" method="post" class="form-group">
            
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Id Cliente</span>
                <input type="text" name="txt_idcliente" id="txt_idcliente" class="form-control" placeholder="0" aria-label="Puesto" aria-describedby="addon-wrapping" readonly>
            </div>
            <br>
            
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Nombres</span>
                <input type="text" name="txt_nombres" id="txt_nombres" class="form-control" placeholder="Oseas" aria-label="Puesto" aria-describedby="addon-wrapping" required>
            </div>
            <br>
            
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Apellidos</span>
                <input type="text" name="txt_apellidos" id="txt_apellidos" class="form-control" placeholder="Xot" aria-label="Puesto" aria-describedby="addon-wrapping" required>
            </div>
            <br>
            
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Nit</span>
                <input type="text" name="txt_nit" id="txt_nit" class="form-control" placeholder="124565" aria-label="Puesto" aria-describedby="addon-wrapping" required>
            </div>
            <br>
            
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Genero</span>
                <select name="txt_genero" id="txt_genero" class="form-control">
                    <option disabled selected>Selecciona genero</option>
                    <option value="1">Hombre</option> 
                    <option value="0">Mujer</option>
                    </select>
            </div>
            <br>
            
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Telefono</span>
                <input type="text" name="txt_telefono" id="txt_telefono" class="form-control" placeholder="12345678" aria-label="Puesto" aria-describedby="addon-wrapping" required>
            </div>
            <br>
            
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Correo electronico</span>
                <input type="text" name="txt_correo" id="txt_correo" class="form-control" placeholder="example@gmail.com" aria-label="Puesto" aria-describedby="addon-wrapping" required>
            </div>
            <br>
            
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Fecha de Ingreso</span>
                <input type="datetime-local" name="txt_fechai" id="txt_fechai" class="form-control" placeholder="2000-01-01" aria-label="Puesto" aria-describedby="addon-wrapping" required>
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
            
            
  <!-- Inicio de la Tabla Leer -->
            <table class="table table-bordered" >
                <thead class="table-success">
                <tr>
             
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Nit</th>
                    <th>Genero</th>
                    <th>Telefono</th>
                    <th>Correo Electronico</th>
                    <th>Fecha de Ingreso</th>
                    
                </tr>
                </thead>
                <tbody id="tbl_cliente">
                
                <% Cliente cliente = new Cliente();
                    DefaultTableModel tabla = new DefaultTableModel();
                    tabla = cliente.leer();
                    for (int t= 0; t<tabla.getRowCount(); t++) {
                            out.println("<tr data-id="+ tabla.getValueAt(t, 0)+" data-id_p=" + tabla.getValueAt(t, 7)+">");
                            out.println("<td>"+ tabla.getValueAt (t,1) + "</td>");
                            out.println("<td>"+ tabla.getValueAt (t,2) + "</td>");
                            out.println("<td>"+ tabla.getValueAt (t,3) + "</td>");
                            out.println("<td>"+ tabla.getValueAt (t,4) + "</td>");
                            out.println("<td>"+ tabla.getValueAt (t,5) + "</td>");
                            out.println("<td>"+ tabla.getValueAt (t,6) + "</td>");
                            out.println("<td>"+ tabla.getValueAt (t,7) + "</td>");
                            out.println("</tr>");
                        }
                  %>
                         
                </tbody>
                
            </table>
            
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal_cliente" onclick="limpiar()">Nuevo Registro</button>
            </div>
            
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
            
        <script type="text/javascript">
            
            function myFunction() {
            var option_value = document.getElementById("numbers").value;
            if (option_value === "?") {
              //  alert("Hai !");
               $("#modal_puesto").modal();
             }
            }
            
            
            function limpiar(){
                $('#txt_idcliente').val(0);
                $('#dr_puesto').val(1);
                $('#txt_nombres').val('');
                $('#txt_apellidos').val('');
                $('#txt_nit').val('');
                $('#txt_genero').val('');
                $('#txt_telefono').val('');
                $('#txt_correo').val('');
                $('#txt_fechai').val('');
    
            }
            
            $('#tbl_cliente').on('click','tr td',function(evt){
                var target,id,id_p,nombres,apellidos,nit,genero,telefono,correo,fechai;
                target = $(event.target);
                id =            target.parent().data('id');
                id_p =          target.parent().data('id_p');
                nombres =       target.parent("tr").find("td").eq(0).html();
                apellidos =     target.parent("tr").find("td").eq(1).html();
                nit =           target.parent("tr").find("td").eq(2).html();
                genero =        target.parent("tr").find("td").eq(3).html();
                telefono =      target.parent("tr").find("td").eq(4).html();
                correo =        target.parent("tr").find("td").eq(5).html();
                fechai =        target.parent("tr").find("td").eq(6).html();
                
                
                
                $('#txt_idcliente').val(id);
                $('#txt_nombres').val(nombres);
                $('#txt_apellidos').val(apellidos);
                $('#txt_nit').val(nit);
                $('#txt_genero').val(genero);
                $('#txt_telefono').val(telefono);
                $('#txt_correo').val(correo);
                $('#txt_fechai').val(fechai);
                $("#modal_cliente").modal('show');
                
            });
        
        </script> 
        
    </body>
</html>