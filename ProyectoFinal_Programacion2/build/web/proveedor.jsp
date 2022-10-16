<%-- 
    Document   : proveedor
    Created on : Oct 6, 2022, 4:36:22 PM
    Author     : Josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proveedores</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <h1>Proveedores</h1>
        <form action="" method="get" class="form-group">
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Id Proveedor</span>
                <input type="text" name="txt_idproveedor" id="txt_idproveedor" class="form-control" placeholder="0" aria-label="Puesto" aria-describedby="addon-wrapping" readonly>
            </div>
            <br>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Proveedor</span>
                <input type="text" name="txt_proveedor" id="txt_proveedor" class="form-control" placeholder="Zapato Loco S.A." aria-label="Puesto" aria-describedby="addon-wrapping" required>
            </div>
            <br>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Nit</span>
                <input type="text" name="txt_nit" id="txt_nit" class="form-control" placeholder="12345678-9" aria-label="Puesto" aria-describedby="addon-wrapping" required>
            </div>
            <br>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Direccion</span>
                <input type="text" name="txt_direccion" id="txt_direccion" class="form-control" placeholder="Guatemala" aria-label="Puesto" aria-describedby="addon-wrapping" required>
            </div>
            <br>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Telefono</span>
                <input type="text" name="txt_telefono" id="txt_telefono" class="form-control" placeholder="12345678" aria-label="Puesto" aria-describedby="addon-wrapping" required>
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
