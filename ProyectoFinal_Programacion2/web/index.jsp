<%-- 
    Document   : index
    Created on : Oct 6, 2022, 12:00:00 PM
    Author     : Josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <style>
        body {
    font-family: 'Overpass', sans-serif;
    font-weight: normal;
    font-size: 100%;
    color: #1b262c;
    
    margin: 0;
    background-color: #FCFFA0;
    }

    #contenedor {
        display: flex;
        align-items: center;
        justify-content: center;

        margin: 0;
        padding: 0;
        min-width: 100vw;
        min-height: 40vh;
        width: 100%;
        height: 100%;
    }

    #central {
        max-width: 320px;
        width: 100%;
    }

    .titulo {
        font-size: 250%;
        color:#bbe1fa;
        text-align: center;
        margin-bottom: 20px;
    }

    #login {
        width: 100%;
        padding: 50px 30px;
        background-color: #3282b8;

        -webkit-box-shadow: 0px 0px 5px 5px rgba(0,0,0,0.15);
        -moz-box-shadow: 0px 0px 5px 5px rgba(0,0,0,0.15);
        box-shadow: 0px 0px 5px 5px rgba(0,0,0,0.15);

        border-radius: 3px 3px 3px 3px;
        -moz-border-radius: 3px 3px 3px 3px;
        -webkit-border-radius: 3px 3px 3px 3px;

        box-sizing: border-box;
    }

    #login input {
        font-family: 'Overpass', sans-serif;
        font-size: 110%;
        color: #1b262c;

        display: block;
        width: 100%;
        height: 40px;

        margin-bottom: 10px;
        padding: 5px 5px 5px 10px;

        box-sizing: border-box;

        border: none;
        border-radius: 3px 3px 3px 3px;
        -moz-border-radius: 3px 3px 3px 3px;
        -webkit-border-radius: 3px 3px 3px 3px;
    }

    #login input::placeholder {
        font-family: 'Overpass', sans-serif;
        color: #E4E4E4;
    }

    #login button {
        font-family: 'Overpass', sans-serif;
        font-size: 110%;
        color:#1b262c;
        width: 100%;
        height: 40px;
        border: none;

        border-radius: 3px 3px 3px 3px;
        -moz-border-radius: 3px 3px 3px 3px;
        -webkit-border-radius: 3px 3px 3px 3px;

        background-color: #F9BC2E;

        margin-top: 10px;
    }

    #login button:hover {
        background-color: #0f4c75;
        color:#bbe1fa;
    }

    .pie-form {
        font-size: 90%;
        text-align: center;    
        margin-top: 15px;
    }

    .pie-form a {
        display: block;
        text-decoration: none;
        color: #bbe1fa;
        margin-bottom: 3px;
    }

    .pie-form a:hover {
        color: #0f4c75;
    }

    .inferior {
        margin-top: 10px;
        font-size: 90%;
        text-align: center;
    }

    .inferior a {
        display: block;
        text-decoration: none;
        color: #bbe1fa;
        margin-bottom: 3px;
    }

    .inferior a:hover {
        color: #3282b8;
    }
        
    </style>
    <head>
        <style type="css/text"></style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proyecto Final</title>
        
    </head>
    <body>
    <center>
        <img src="https://images.vexels.com/media/users/3/259041/isolated/preview/379b5ec6200e87b0ead9c22b731c2527-zapatos-planos-de-bolos.png" heigth=15% width=15%>
        <div id="contenedor">
            <div id="central">
                <div id="login">
                    <div class="titulo">
                        Bienvenido
                    </div>
                        <form action="menu.jsp" id="loginform">
                        <input type="text" name="txt_usuario" id="txt_usuario" placeholder="Usuario" required>
                        
                        <input type="password" placeholder="Contraseña" id="txt_contraseña" name="txt_contraseña" required>
                        
                        <button type="submit" title="Ingresar" name="Ingresar">Login</button>
                    </form>
                    <div class="pie-form">
                        <a href="#">¿Perdiste tu contraseña?</a>
                        <a href="#">¿No tienes Cuenta? Registrate</a>
                    </div>
                </div>
                <div class="inferior">
                    <a href="#">Volver</a>
                </div>
            </div>
        </div>
            
        </center>
    </body>
</html>
