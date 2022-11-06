<%-- 
    Document   : menu
    Created on : Oct 6, 2022, 12:51:12 PM
    Author     : Josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
    <style>
body {
    font-family: "Segoe UI", sans-serif;
    font-size:100%;
}

.sidebar {
    position: fixed;
    height: 100%;
    width: 0;
    top: 0;
    left: 0;
    z-index: 1;
    background-color: #00324b;
    overflow-x: hidden;
    transition: 0.4s;
    padding: 1rem 0;
    box-sizing:border-box;
}

.sidebar .boton-cerrar {
    position: absolute;
    top: 0.5rem;
    right: 1rem;
    font-size: 2rem;
    display: block;
    padding: 0;
    line-height: 1.5rem;
    margin: 0;
    height: 32px;
    width: 32px;
    text-align: center;
    vertical-align: top;
}

.sidebar ul, .sidebar li{
    margin:0;
    padding:0;
    list-style:none inside;
}

.sidebar ul {
    margin: 4rem auto;
    display: block;
    width: 80%;
    min-width:200px;
}

.sidebar a {
    display: block;
    font-size: 120%;
    color: #eee;
    text-decoration: none;
    
}

.sidebar a:hover{
    color:#fff;
    background-color: #f90;

}

h1 {
    color:#f90;
    font-size:180%;
    font-weight:normal;
}
#contenido {
    transition: margin-left .4s;
    padding: 1rem;
}

.abrir-cerrar {
    color: black;
    font-size:250%;
    
}

#abrir {
    
}
#cerrar {
    display:none;
}
#prueba{
    
}

</style>
<script type="text/javascript">
            history.forward();
</script>
</head>
<body>
    
    
    
<div id="sidebar" class="sidebar">
<a href="#" class="boton-cerrar" onclick="ocultar()">&times;</a>
<ul class="menu">
    <% 
            HttpSession sesion = request.getSession();
            String usuario;
            String nivel;
            
            if(sesion.getAttribute("user")!=null && sesion.getAttribute("user")!=null ){
                usuario = sesion.getAttribute("user").toString();
                nivel = sesion.getAttribute("nivel").toString();
                out.print( "<li><a href='index.jsp?cerrar=true'>User: "+ usuario +"<br> <label>Cerrar Sesion</label></a></li><br>  " );
                
            }else{
                out.print(" <script>location.replace('index.jsp'); </script>   ");
            }
            
        %>
    
    
<li><a href="puesto.jsp" target="prueba" onclick="ocultar()" >Puestos</a></li>
<li><a href="empleado.jsp" target="prueba" onclick="ocultar()">Empleados</a></li>
<li><a href="cliente.jsp" target="prueba" onclick="ocultar()">Clientes</a></li>
<li><a href="proveedor.jsp" target="prueba" onclick="ocultar()">Proveedores</a></li>
<li><a href="marca.jsp" target="prueba" onclick="ocultar()">Marcas</a></li>
<li><a href="producto.jsp" target="prueba" onclick="ocultar()">Productos</a></li>
<li><a href="ventas.jsp" target="prueba" onclick="ocultar()">Ventas</a></li>
<li><a href="compras.jsp" target="prueba" onclick="ocultar()">Compras</a></li>

</ul>
</div>
    
<div id="contenido">

<a id="abrir" class="abrir-cerrar" onclick="mostrar()" style="cursor: pointer"  >☰</a>
<p><img src="https://images.vexels.com/media/users/3/259041/isolated/preview/379b5ec6200e87b0ead9c22b731c2527-zapatos-planos-de-bolos.png" heigth=6.5% width=6.5% /></p>


</div>
    <p align="right"><iframe name="prueba" src="https://dpilaser.com/wp-content/uploads/2017/01/Bienvenido.png" style= "width: 1500px; height: 800px; border: none;"></iframe></p>  
<script>
function mostrar() {
    document.getElementById("sidebar").style.width = "300px";
    document.getElementById("contenido").style.marginLeft = "300px";
    document.getElementById("abrir").style.display = "none";
    document.getElementById("cerrar").style.display = "inline";
}

function ocultar() {
    document.getElementById("sidebar").style.width = "0";
    document.getElementById("contenido").style.marginLeft = "0";
    document.getElementById("abrir").style.display = "inline";
    document.getElementById("cerrar").style.display = "none";
}
</script>

<script defer src="https://static.cloudflareinsights.com/beacon.min.js/v652eace1692a40cfa3763df669d7439c1639079717194" integrity="sha512-Gi7xpJR8tSkrpF7aordPZQlW2DLtzUlZcumS8dMQjwDHEnw9I7ZLyiOj/6tZStRBGtGgN6ceN6cMH8z7etPGlw==" data-cf-beacon='{"rayId":"75609f1c8a8a6db6","version":"2022.8.1","r":1,"token":"f0aa520dc035432cb9fe5438c4f03b8b","si":100}' crossorigin="anonymous"></script>
</body>
