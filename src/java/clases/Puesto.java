/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Josue
 */
public class Puesto {
    private String puesto;
    private int id_puesto;

    Conexion cn;
    
    public Puesto() {}
    public Puesto(String puesto, int id_puesto) {
        this.puesto = puesto;
        this.id_puesto = id_puesto;
    }

    
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }
    //Drop_Puesto
    public HashMap drop_puesto(){
        HashMap<String,String> drop = new HashMap();
        
        try{
            String query = "SELECT idPuesto as id,puesto FROM puestos;";
            cn = new Conexion();
            cn.abrir_con();
            
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while(consulta.next()){
            drop.put(consulta.getString("id"), consulta.getString("puesto"));
            }
        
        cn.cerrar_con();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return drop;
        
        }
    
    //Tabla Leer
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
    try{
   cn = new Conexion();
   cn.abrir_con();
    String query;
    query = "SELECT idPuesto as id,puesto FROM puestos;";
     ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      
      String encabezado[] = {"id","puesto"};
      tabla.setColumnIdentifiers(encabezado);
      
      String datos[]=new String[2];
      
   while(consulta.next()){
      datos[0] = consulta.getString("id");
      datos[1] = consulta.getString("puesto");
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
    public int crear(){
    int retorno=0;
        
        try{
         PreparedStatement parametro;
         cn = new Conexion();
         
         String query;
            query = "INSERT INTO puestos(puesto) VALUES (?);";
         cn.abrir_con();
            parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         parametro.setString(1, getPuesto());
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
            query = "update puestos set puesto=? where idPuesto=?;";
         parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         parametro.setString(1, getPuesto());
         parametro.setInt(2, getId_puesto());
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
            query = "delete from puestos where idPuesto=?;";
         parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         parametro.setInt(1, getId_puesto());
         int executar= parametro.executeUpdate();
         retorno = executar;
         cn.cerrar_con();
        }catch(HeadlessException | SQLException ex){
         System.out.println("Error"+ex.getMessage());
         }
        
        return retorno;
    }
    
}
