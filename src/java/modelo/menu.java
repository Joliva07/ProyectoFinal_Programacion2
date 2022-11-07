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
import modelo.Conexion;
/**
 *
 * @author yoc91
 */
public class menu {
    private int id_menu, padre_id;
    private String nombre;
    
    Conexion cn;
    
    public menu(){}
    
    public menu(int id_menu, int padre_id, String nombre) {
        this.id_menu = id_menu;
        this.padre_id = padre_id;
        this.nombre = nombre;
    }

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public int getPadre_id() {
        return padre_id;
    }

    public void setPadre_id(int padre_id) {
        this.padre_id = padre_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
  public DefaultTableModel leer(){
  DefaultTableModel tabla = new DefaultTableModel();
  try{
   cn = new Conexion();
   cn.abrir_con();
    String query;
    
        query = "select id_menu, nombre, padre_id from menu;";
     ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      
      String encabezado[] = {"id_menu","nombre","padre_id"};
      tabla.setColumnIdentifiers(encabezado);
      
      String datos[]=new String[3];
        
   while(consulta.next()){
      datos[0] = consulta.getString("id_menu");
      datos[1] = consulta.getString("nombre");
      datos[2] = consulta.getString("padre_id");      
      tabla.addRow(datos);
      }
   
   cn.cerrar_con();
  }catch(SQLException ex){
      cn.cerrar_con();
      System.out.println("Error: " + ex.getMessage() );
  }
  return tabla;
  }

  
}
