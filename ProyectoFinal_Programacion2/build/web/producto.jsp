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
                <select name="dr_puesto" id="dr_puesto" class="form-control">
                    <option>Opcion 1</option>
                    <option>Opcion 2</option>
                    <option>+ Agregar</option>
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
