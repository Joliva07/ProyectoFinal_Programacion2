/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josue
 */
public class Cliente extends Persona {
    private int id_cliente;
    private String nit,correo_e,fecha_ingreso;
    
    
    Conexion cn;
    public Cliente(){
    }

    public Cliente(int id_cliente, String nombres, String apellidos, String nit, byte genero, String telefono, String correo_e, String fecha_ingreso,String direccion) {
        super(nombres, apellidos, direccion, telefono, genero);
        this.id_cliente = id_cliente;
        this.nit = nit;
        this.correo_e = correo_e;
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCorreo_e() {
        return correo_e;
    }

    public void setCorreo_e(String correo_e) {
        this.correo_e = correo_e;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
    
    public DefaultTableModel leer(){
  DefaultTableModel tabla = new DefaultTableModel();
  try{
   cn = new Conexion();
   cn.abrir_con();
    String query;
    
        query = "SELECT idcliente,nombres,apellidos,nit,CASE when genero = 1 then 'masculino' when genero = 0 then 'femenino' end as gen,telefono,correo_electronico,fechaingreso FROM clientes;";
     ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      
      String encabezado[] = {"idcliente","nombres","apellidos","nit","gen","telefono","correo_electronico","fechaingreso"};
      tabla.setColumnIdentifiers(encabezado);
      
      String datos[]=new String[8];
        
   while(consulta.next()){
      datos[0] = consulta.getString("idcliente");
      datos[1] = consulta.getString("nombres");
      datos[2] = consulta.getString("apellidos");
      datos[3] = consulta.getString("nit");
      datos[4] = consulta.getString("gen");
      datos[5] = consulta.getString("telefono");
      datos[6] = consulta.getString("correo_electronico");
      datos[7] = consulta.getString("fechaingreso");
     
      tabla.addRow(datos);
      }
   cn.cerrar_con();
    
      
  }catch(SQLException ex){
      cn.cerrar_con();
      System.out.println("Error: " + ex.getMessage() );
  
  }
  return tabla;
  }
    

    //Funcion Crear
    @Override
    public int crear(){
    int retorno=0;
        
        try{
         PreparedStatement parametro;
         cn = new Conexion();
         
         String query;
            query = "INSERT INTO clientes(nombres,apellidos,nit,genero,telefono,correo_electronico,fechaingreso) VALUES(?,?,?,?,?,?,?);";
         cn.abrir_con();
            parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         
         parametro.setString(1, getNombres());
         parametro.setString(2, getApellidos());
         parametro.setString(3, getNit());
         parametro.setByte  (4, getGenero());
         parametro.setString(5, getTelefono());
         parametro.setString(6, getCorreo_e());
         parametro.setString(7, getFecha_ingreso());
         
         int executar= parametro.executeUpdate();
         retorno = executar;
         cn.cerrar_con();
     }catch(HeadlessException | SQLException ex){
         System.out.println("Error"+ex.getMessage());
         }
        
        return retorno;
    }
    
    //Funcion Modificar
    @Override
    public int modificar(){
    int retorno=0;
        
        try{
         PreparedStatement parametro;
         cn = new Conexion();
         cn.abrir_con();
         String query;
            query = "UPDATE clientes SET nombres=?,apellidos=?,nit=?,genero=?,telefono=?,correo_electronico=?,fechaingreso=? WHERE idcliente=?;";
         parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         
        
         parametro.setString(1, getNombres());
         parametro.setString(2, getApellidos());
         parametro.setString(3, getNit());
         parametro.setByte(4, getGenero());
         parametro.setString(5, getTelefono());
         parametro.setString(6, getCorreo_e());
         parametro.setString(7, getFecha_ingreso());
         parametro.setInt(8, this.getId_cliente());
         
         int executar= parametro.executeUpdate();
         
         retorno = executar;
         cn.cerrar_con();
             }catch(HeadlessException | SQLException ex){
         System.out.println("Error"+ex.getMessage());
         }
        
        return retorno;
    }
    
    //Funcion Eliminar
    @Override
    public int eliminar(){
    int retorno=0;
        
        try{
         PreparedStatement parametro;
         cn = new Conexion();
         cn.abrir_con();
         String query;
            query = "delete from clientes where idcliente=?;";
         parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         parametro.setInt(1, getId_cliente());
         int executar= parametro.executeUpdate();
         retorno = executar;
         cn.cerrar_con();
        }catch(HeadlessException | SQLException ex){
         System.out.println("Error"+ex.getMessage());
         }
        
        return retorno;
    }

    
    
}
