/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Josue
 */
public class Empleado extends Persona{
    
    private String dpi,fecha_nacimiento,fecha_inicio_labores,fecha_ingreso;
    private int id_puesto,id_empleado;

    
    Conexion cn;
    public Empleado(){
    }

    public Empleado(String dpi, String fecha_nacimiento, String fecha_inicio_labores, String fecha_ingreso, int id_puesto, int id_empleado, String nombres, String apellidos, String direccion, String telefono, byte genero) {
        super(nombres, apellidos, direccion, telefono, genero);
        this.dpi = dpi;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_inicio_labores = fecha_inicio_labores;
        this.fecha_ingreso = fecha_ingreso;
        this.id_puesto = id_puesto;
        this.id_empleado = id_empleado;
    }


    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getFecha_inicio_labores() {
        return fecha_inicio_labores;
    }

    public void setFecha_inicio_labores(String fecha_inicio_labores) {
        this.fecha_inicio_labores = fecha_inicio_labores;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }
    
    
    public DefaultTableModel leer(){
  DefaultTableModel tabla = new DefaultTableModel();
  try{
   //SELECT e.idempleado as id,e.nombres,e.apellidos,e.direccion,e.telefono,e.dpi,e.genero,e.fecha_nacimiento,p.puesto,e.idpuesto,e.fecha_inicio_labores,e.fechaingreso FROM empleados as e inner join puestos as p on e.idPuesto = p.idPuesto;
   //select e.idempleado,e.nombres,e.apellidos,e.direccion,e.telefono,e.dpi, CASE when e.genero = 1 then 'masculino' when e.genero = 0 then 'femenino' end as genero,e.fecha_nacimiento, p.puesto, e.fecha_inicio_labores, e.fechaingreso from empleados as e inner join puestos as p on e.idpuesto=p.idPuesto;   
   cn = new Conexion();
   cn.abrir_con();
    String query;
        query = "SELECT e.idempleado as id,e.nombres,e.apellidos,e.direccion,e.telefono,e.dpi,e.genero,e.fecha_nacimiento,p.puesto,e.idpuesto,e.fecha_inicio_labores,e.fechaingreso FROM empleados as e inner join puestos as p on e.idPuesto = p.idPuesto;";
     ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      
      String encabezado[] = {"id","nombres","apellidos","direccion","telefono","dpi","genero","fecha_nacimiento","puesto","idpuesto","fecha_inicio_labores","fechaingreso"};
      tabla.setColumnIdentifiers(encabezado);
      
      String datos[]=new String[12];
        
   while(consulta.next()){
      datos[0] = consulta.getString("id");
      datos[1] = consulta.getString("nombres");
      datos[2] = consulta.getString("apellidos");
      datos[3] = consulta.getString("direccion");
      datos[4] = consulta.getString("telefono");
      datos[5] = consulta.getString("dpi");
      datos[6] = consulta.getString("genero");
      datos[7] = consulta.getString("fecha_nacimiento");
      datos[8] = consulta.getString("puesto");
      datos[9] = consulta.getString("idpuesto");
      datos[10] = consulta.getString("fecha_inicio_labores");
      datos[11] = consulta.getString("fechaingreso");
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
            query = "INSERT INTO empleados(nombres,apellidos,direccion,telefono,dpi,genero,fecha_nacimiento,idPuesto,fecha_inicio_labores,fechaingreso)  VALUES (?,?,?,?,?,?,?,?,?,?);";
         cn.abrir_con();
            parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         parametro.setString(1, getNombres());
         parametro.setString(2, getApellidos());
         parametro.setString(3, getDireccion());
         parametro.setString(4, getTelefono());
         parametro.setString(5, getDpi());
         parametro.setByte(6, getGenero());
         parametro.setString(7, getFecha_nacimiento());
         parametro.setInt(8, this.getId_puesto());
         parametro.setString(9, getFecha_inicio_labores());
         parametro.setString(10, getFecha_ingreso());
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
            query = "update empleados set nombres=?,apellidos=?,direccion=?,telefono=?,dpi=?,genero=?,fecha_nacimiento=?,idPuesto=?,fecha_inicio_labores=?,fechaingreso=? where idempleado=?;";
         parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         parametro.setString(1, getNombres());
         parametro.setString(2, getApellidos());
         parametro.setString(3, getDireccion());
         parametro.setString(4, getTelefono());
         parametro.setString(5, getDpi());
         //parametro.setString(6, getGenero());
         parametro.setString(7, getFecha_nacimiento());
         parametro.setInt(8, this.getId_puesto());
         parametro.setString(9, getFecha_inicio_labores());
         parametro.setString(10, getFecha_ingreso());
         parametro.setInt(11, getId_empleado());
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
            query = "delete from empleados where idempleado=?;";
         parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         parametro.setInt(1, getId_empleado());
         int executar= parametro.executeUpdate();
         retorno = executar;
         cn.cerrar_con();
        }catch(HeadlessException | SQLException ex){
         System.out.println("Error"+ex.getMessage());
         }
        
        return retorno;
    }
    
}
