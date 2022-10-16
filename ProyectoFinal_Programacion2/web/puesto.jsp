<%-- 
    Document   : puesto
    Created on : Oct 6, 2022, 2:12:24 PM
    Author     : Josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Puestos</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <h1>Puestos</h1>
        <form action="" method="get" class="form-group">
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Id puesto</span>
                <input type="text" name="txt_idpuesto" id="txt_idpuesto" class="form-control" placeholder="0" aria-label="Puesto" aria-describedby="addon-wrapping" readonly>
            </div>
            <br>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="addon-wrapping">Puesto</span>
                <input type="text" name="txt_puesto" id="txt_puesto" class="form-control" placeholder="Puesto" aria-label="Puesto" aria-describedby="addon-wrapping" required>
            </div>
            <br>
            <%--<label for="lbl_idpuesto"><b>Id puesto</b></label>
            <input type="text" name="txt_idpuesto" id="txt_idpuesto" value="0" class="form-control" readonly>
            <label for="lbl_codigo"><b>Puesto</b></label>
            <input type="text" name="txt_puesto" id="txt_puesto" placeholder="Ejemplo: Administrador" class="form-control" required> --%>
            <div class="btn-group" role="group" aria-label="Basic mixed styles example">
                <button type="button" class="btn btn-success">Agregar</button>
                <button type="button" class="btn btn-warning">Actualizar</button>
                <button type="button" class="btn btn-danger">Eliminar</button>
            </div>

        </form>
        
    </body>
</html>
