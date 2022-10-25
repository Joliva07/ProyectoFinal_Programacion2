<%-- 
    Document   : marca
    Created on : Oct 6, 2022, 4:41:32 PM
    Author     : Josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap" %>
<%@page import="clases.Marca" %>
<%@page import="javax.swing.table.DefaultTableModel"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Marcas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <h1>Marcas</h1>
        <div class="container mt-3">
        
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
       
       
         <table class="table table-bordered" >
                <thead class="table-success">
                <tr>
                    <th>Idmarca</th>
                    <th>Marca</th>
                    
                </tr>
                </thead>
                <tbody id="tbl_marca">
                
                <% Marca empleado = new Marca();
                    DefaultTableModel tabla = new DefaultTableModel();
                    tabla = empleado.leer();
                    for (int t= 0; t<tabla.getRowCount(); t++) {
                            out.println("<tr data-id="+ tabla.getValueAt(t, 0)+" data-id_p=" + tabla.getValueAt(t, 1)+">");
                            out.println("<td>"+ tabla.getValueAt (t,0) + "</td>");
                            out.println("<td>"+ tabla.getValueAt (t,1) + "</td>");
                            out.println("</tr>");
                        }
                  %>
                  
                  
                </tbody>
                
            </table>
                  <!-- Boton Para crear nuevo registro -->
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal_marca" onclick="limpiar()">Nuevo Registro</button>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <script type="text/javascript">
            function limpiar(){
                $('#txt_idmarca').val(0);
                $('#txt_marca').val('');
            }
            
            $('#tbl_marca').on('click','tr td',function(evt){
                var target,id,id_p;
                target = $(event.target);
                id =        target.parent().data('id');
                id_p =      target.parent().data('id_p');
                
                $('#txt_idmarca').val(id);
                $('#txt_marca').val(id_p);
                $("#modal_marca").modal('show');
            });
            
        </script>
                </body>
    
    
</html>
