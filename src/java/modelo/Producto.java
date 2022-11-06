/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josue
 */
public class Producto {
    private String producto,descripcion,imagen,fecha_ingreso;
    private int id_marca,id_producto,existencia,cantidad=1;
    private float precio_costo,precio_venta;
    

    Conexion cn;
    public Producto() {
    }
    public Producto(String producto, String descripcion, String imagen, String fecha_ingreso, int id_marca, int id_producto, int existencia, float precio_costo, float precio_venta) {
        this.producto = producto;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.fecha_ingreso = fecha_ingreso;
        this.id_marca = id_marca;
        this.id_producto = id_producto;
        this.existencia = existencia;
        this.precio_costo = precio_costo;
        this.precio_venta = precio_venta;
    }


    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public float getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(float precio_costo) {
        this.precio_costo = precio_costo;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public DefaultTableModel leer(){
  DefaultTableModel tabla = new DefaultTableModel();
  try{
   cn = new Conexion();
   cn.abrir_con();
    String query;
    
     query = "SELECT e.idproductos as id,e.producto,e.idmarca,e.descripcion,e.imagen,e.precio_costo,e.precio_venta,e.existencia,e.fecha_ingreso,p.marca FROM productos as e inner join marcas as p on e.idmarca = p.idmarca;";
     ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
     
     String encabezado[] = {"id","producto","idmarca","descripcion","imagen","precio_costo","precio_venta","existencia","fecha_ingreso","marca"};
      tabla.setColumnIdentifiers(encabezado);
      
      String datos[]=new String[10];
      
      while(consulta.next()){
      datos[0] = consulta.getString("id");
      datos[1] = consulta.getString("producto");
      datos[2] = consulta.getString("idmarca");
      datos[3] = consulta.getString("descripcion");
      datos[4] = consulta.getString("imagen");
      datos[5] = consulta.getString("precio_costo");
      datos[6] = consulta.getString("precio_venta");
      datos[7] = consulta.getString("existencia");
      datos[8] = consulta.getString("fecha_ingreso");
     datos[9] = consulta.getString("marca");
      tabla.addRow(datos);
      }
   cn.cerrar_con();
   
}catch(SQLException ex){
      cn.cerrar_con();
      System.out.println("Error: " + ex.getMessage() );
  
  }
  return tabla;
  }

    public int crear(){
    
         int retorno=0;
        
        try{
            String fecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
         PreparedStatement parametro;
         cn = new Conexion();
         
         String query;
            query = "INSERT INTO productos(producto,idmarca,descripcion,imagen,precio_costo,precio_venta,existencia,fecha_ingreso) VALUES(?,?,?,?,?,?,?,?);";
         cn.abrir_con();
            parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         
      
         parametro.setString(1, getProducto());
         parametro.setInt(2, getId_marca());
         parametro.setString(3, getDescripcion());
         parametro.setString(4, getImagen());
         parametro.setFloat(5, getPrecio_costo());
         parametro.setFloat(6, getPrecio_venta());
         parametro.setInt(7, getExistencia());
         parametro.setString(8, fecha);
         
         int executar= parametro.executeUpdate();
         retorno = executar;
         cn.cerrar_con();
     }catch(HeadlessException | SQLException ex){
         System.out.println("Error"+ex.getMessage());
         }
        
        return retorno;
    
    }
    
    //Funcion Modificar
    public int modificar(){
    int retorno=0;
        
        try{
         PreparedStatement parametro;
         cn = new Conexion();
         cn.abrir_con();
         String query;
            query = "UPDATE productos SET producto=?,idmarca=?,descripcion=?,imagen=?,precio_costo=?,precio_venta=?,existencia=?,fecha_ingreso=? WHERE idproductos=?;";
         parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         
         parametro.setString(1, getProducto());
         parametro.setInt(2, getId_marca());
         parametro.setString(3, getDescripcion());
         parametro.setString(4, getImagen());
         parametro.setFloat(5, getPrecio_costo());
         parametro.setFloat(6, getPrecio_venta());
         parametro.setInt(7, getExistencia());
         parametro.setString(8, getFecha_ingreso());
         parametro.setInt(9, getId_producto());
         int executar= parametro.executeUpdate();
         
         retorno = executar;
         cn.cerrar_con();
             }catch(HeadlessException | SQLException ex){
         System.out.println("Error"+ex.getMessage());
         }
        
        return retorno;
    }

    //Funcion Eliminar

    public int eliminar(){
    int retorno=0;
        
        try{
         PreparedStatement parametro;
         cn = new Conexion();
         cn.abrir_con();
         String query;
            query = "delete from productos where idproductos=?;";
         parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         parametro.setInt(1, getId_producto());
         int executar= parametro.executeUpdate();
         retorno = executar;
         cn.cerrar_con();
        }catch(HeadlessException | SQLException ex){
         System.out.println("Error"+ex.getMessage());
         }
        
        return retorno;
    }

    
   

/*ArrayList<string> lista = new ArrayList<>();
 try {
     FileItemFactory file = new DiskFileItemFactory();
     ServletFileUpload fileUpload =new ServletFileUpload(file);
     List items = fileUpload.parseRequest (request);
     for (int i = = 0; i < items.size (); : i++) {
         FileItem fileItem = (FileItem) items.get (i);
         if (!fileItem. isFormField()) {
             File f new File + fileItem. getName ());
             fileItem. String ruta f);
            p.setRuta ("http://localhost/img/"+fileItem.getName ());
         } else {
             lista.add (fileItem.getString());
         }
 }
}
    p.setNombre (lista.get (0) );
    pdao.agregar (p);*/

    
    
}
