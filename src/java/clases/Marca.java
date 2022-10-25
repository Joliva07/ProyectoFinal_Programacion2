/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Javier
 */
public class Marca {
    private String marca;
    private int id_marca;
    private Conexion cn;

    public Marca() {
    }
    public Marca(String marca, int id_marca) {
        this.marca = marca;
        this.id_marca = id_marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }
    
    //Drop_Marca
    public HashMap drop_marca(){
    
        HashMap<String,String> drop = new HashMap();
try{
            String query = "SELECT idmarca as id,marca FROM marcas;";
            cn = new Conexion();
            cn.abrir_con();
            
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while(consulta.next()){
            drop.put(consulta.getString("id"), consulta.getString("marca"));
            }
        
        cn.cerrar_con();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    return drop;
    }
    
    
    
    
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
    try{
    cn = new Conexion();
    cn.abrir_con();
    String query;
    
      query = "SELECT idmarca,marca FROM marcas;";
     ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
     
     String encabezado[] = {"idmarca","marca"};
     tabla.setColumnIdentifiers(encabezado);
      
       String datos[]=new String[2];
      
      while(consulta.next()){
      datos[0] = consulta.getString("idmarca");
      datos[1] = consulta.getString("marca");
      
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
  //  @Override
    public int crear(){
    int retorno=0;
        
        try{
         PreparedStatement parametro;
         cn = new Conexion();
         
         String query;
            query = "INSERT INTO marcas (idmarca, marca)VALUES(?,?);";
         cn.abrir_con();
            parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         
         parametro.setInt(1, this.getId_marca());
         parametro.setString(2,getMarca());
         
         int executar= parametro.executeUpdate();
         retorno = executar;
         cn.cerrar_con();
     }catch(HeadlessException | SQLException ex){
         System.out.println("Error"+ex.getMessage());
         }
        return retorno;
    }
    
    //Funcion Modificar
  // @Override
    public int modificar(){
    int retorno=0;
        
        try{
         PreparedStatement parametro;
         cn = new Conexion();
         cn.abrir_con();
         String query;
            query = "UPDATE marcas SET marca =? WHERE idmarca =?;";
         parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         
        
         parametro.setString(1,getMarca());
         parametro.setInt(2, this.getId_marca());
         
         int executar= parametro.executeUpdate();
         
         retorno = executar;
         cn.cerrar_con();
             }catch(HeadlessException | SQLException ex){
         System.out.println("Error"+ex.getMessage());
         }
        
        return retorno;
    }

    //Funcion Eliminar
 //   @Override
    public int eliminar(){
    int retorno=0;
        
        try{
         PreparedStatement parametro;
         cn = new Conexion();
         cn.abrir_con();
         String query;
            query = "delete from marcas where idmarca=?;";
         parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         parametro.setInt(1, getId_marca());
         int executar= parametro.executeUpdate();
         retorno = executar;
         cn.cerrar_con();
        }catch(HeadlessException | SQLException ex){
         System.out.println("Error"+ex.getMessage());
         }
        
        return retorno;
    
    }

}
