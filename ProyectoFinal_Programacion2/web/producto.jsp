<%-- 
    Document   : producto
    Created on : Oct 6, 2022, 4:44:07 PM
    Author     : Josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Productos</h1>
        <form action="" method="get" class="form-group">
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Id producto</span>
                <input type="text" name="txt_producto" id="txt_producto" class="form-control" placeholder="0" aria-label="Puesto" aria-describedby="addon-wrapping" readonly>
            </div>
            <br>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Producto</span>
                <input type="text" name="txt_producto" id="txt_producto" class="form-control" placeholder="Zapato" aria-label="Puesto" aria-describedby="addon-wrapping" required>
            </div>
            <br>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Marca</span>
                <select id = "numbers" onchange = "myFunction()" name="dr_puesto" id="dr_puesto" class="form-control">
                    <option>Opcion 1</option>
                    <option>Opcion 2</option>
                    <option value = "3">+ Agregar</option>
                </select>
            </div>
            
<script>
function myFunction() {
var option_value = document.getElementById("numbers").value;
if (option_value == "3") {
  //  alert("Hai !");
   $("#myModal").modal();
 }
}
   

</script>
            
            <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Marcas</h4>
        </div>
        <div class="modal-body">
          
            <p align="center"><iframe name="prueba" src="marca.jsp" style= "width: 300px; height: 500px; border: none;"></iframe></p>
            
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
            
            <br>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Descripcion</span>
                <input type="text" name="txt_descripcion" id="txt_descripcion" class="form-control" placeholder="Tenis" aria-label="Puesto" aria-describedby="addon-wrapping" required>
            </div>
            <br>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Imagen</span>
                <input type="text" name="txt_imagen" id="txt_imagen" class="form-control" placeholder="Url" aria-label="Puesto" aria-describedby="addon-wrapping" required>
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
                <input type="date" name="txt_Fningreso" id="txt_Fningreso" class="form-control" placeholder="dd/mm/yyyy" aria-label="Puesto" aria-describedby="addon-wrapping" required>
            </div>
            <br>
            <div class="btn-group" role="group" aria-label="Basic mixed styles example">
                <button type="button" class="btn btn-success">Agregar</button>
                <button type="button" class="btn btn-warning">Actualizar</button>
                <button type="button" class="btn btn-danger">Eliminar</button>
            </div>
        </form>
    </body>
</html>
