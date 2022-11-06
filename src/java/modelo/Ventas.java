/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


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
public class Ventas {
    private String idventa;
    private String idcliente;
    private String idVenta_detalle;
    private String fechafactura ;
    private String idempleado; 
    private String fechaingreso;
    private String idproducto;
    private String serie;
    private int cantidad = 0;
    private int noFacrura=0;
    private float precioUnitario=0;
    private float total=0;
    private String producto;
    private int codigo;

    Conexion cn;

    public Ventas(String idcliente) {
        this.idcliente = idcliente;
    }
    //@ClientCallable
    public Ventas() {
    }

    public Ventas(String idventa, String idcliente, String idVenta_detalle, String fechafactura, String idempleado, String fechaingreso, String idproducto, String producto) {
        this.idventa = idventa;
        this.idcliente = idcliente;
        this.idVenta_detalle = idVenta_detalle;
        this.fechafactura = fechafactura;
        this.idempleado = idempleado;
        this.fechaingreso = fechaingreso;
        this.idproducto = idproducto;
        this.producto = producto;
    }
    
    public String getIdventa() {
        return idventa;
    }
    public void setIdventa(String idventa) {
        this.idventa = idventa;
    }
    public String getIdcliente() {
        return idcliente;
    }
    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }
    public String getIdVenta_detalle() {
        return idVenta_detalle;
    }
    public void setIdVenta_detalle(String idVenta_detalle) {
        this.idVenta_detalle = idVenta_detalle;
    }
    public String getFechafactura() {
        return fechafactura;
    }
    public void setFechafactura(String fechafactura) {
        this.fechafactura = fechafactura;
    }
    public String getIdempleado() {
        return idempleado;
    }
    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }
    public String getFechaingreso() {
        return fechaingreso;
    }
    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }
    public String getIdproducto() {
        return idproducto;
    }
    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }
    public String getSerie() {
        return serie;
    }
    public void setSerie(String serie) {
        this.serie = serie;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getNoFacrura() {
        return noFacrura;
    }
    public void setNoFacrura(int noFacrura) {
        this.noFacrura = noFacrura;
    }
    public float getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }   
    public String getProducto() {
        return producto;
    }
    public void setProducto(String producto) {
        this.producto = producto;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
   
    public Cliente buscar(String nit){
        Cliente c = new Cliente();
        cn = new Conexion();
        cn.abrir_con();
        try{
            PreparedStatement parametro;
            ResultSet consulta;
            String query="select * from clientes where nit="+nit;
            parametro=cn.conexionBD.prepareStatement(query);
            consulta=parametro.executeQuery();
            while(consulta.next()){
                c.setId_cliente(consulta.getInt(1));
                c.setNombres(consulta.getString(2));
                c.setApellidos(consulta.getString(3));
                c.setNit(consulta.getString(4));
                c.setGenero(consulta.getByte(5));
                c.setTelefono(consulta.getString(6));
                c.setCorreo_e(consulta.getString(7));
                c.setFecha_ingreso(consulta.getString(8));                
            }
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        cn.cerrar_con();
        return c;
    }
    public Producto buscarP(String id){
        Producto p = new Producto();
        cn = new Conexion();
        cn.abrir_con();
        try{
            PreparedStatement parametro;
            ResultSet consulta;
            String query="select * from productos where idproductos="+id;
            parametro=cn.conexionBD.prepareStatement(query);
            consulta=parametro.executeQuery();
            while(consulta.next()){
                p.setId_producto(consulta.getInt(1));
                p.setProducto(consulta.getString(2));
                p.setId_marca(consulta.getInt(3));
                p.setDescripcion(consulta.getString(4));
                p.setImagen(consulta.getString(5));
                p.setPrecio_costo(consulta.getFloat(6));
                p.setPrecio_venta(consulta.getFloat(7));
                p.setExistencia(consulta.getInt(8));
                p.setFecha_ingreso(consulta.getString(9));
            }
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        cn.cerrar_con();
        return p;
    }
    public int ActExis(String id, int cant){
        int retorno=0;
        cn = new Conexion();
        cn.abrir_con();
        try{
            PreparedStatement parametro;
            String query="UPDATE productos SET existencia =?  WHERE idproductos = ?;";
            parametro=cn.conexionBD.prepareStatement(query);
            
            parametro.setInt(1,cant);
            parametro.setString(2, id);
            
            int ejecutar= parametro.executeUpdate();
            retorno = ejecutar;
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        
        cn.cerrar_con();
        return retorno;
    } 
    
    public String Nofactura(){
        String NoFa="";
        cn = new Conexion();
        cn.abrir_con();
        try{
            ResultSet consulta;
            PreparedStatement parametro;
            String query="SELECT max(nofactura) FROM ventas;";
            parametro=cn.conexionBD.prepareStatement(query);
            consulta=parametro.executeQuery();
            while(consulta.next()){
              NoFa=consulta.getString(1);
            }
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        cn.cerrar_con();
        return NoFa;
    }
    public String IdVenta(){
        String idV="";
        cn = new Conexion();
        cn.abrir_con();
        try{
            ResultSet consulta;
            PreparedStatement parametro;
            String query="SELECT max(idventa) FROM ventas;";
            parametro=cn.conexionBD.prepareStatement(query);
            consulta=parametro.executeQuery();
            while(consulta.next()){
                idV=consulta.getString(1);
            }
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        cn.cerrar_con();
        return idV;
    }
    public int guardarVenta(){
        int retorno=0;
        cn = new Conexion();
        cn.abrir_con();
        try{
            String fecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
            PreparedStatement parametro;
            String query="INSERT INTO ventas(nofactura,serie,fechafactura,idcliente,idempleado,fechaingreso)VALUES(?,?,?,?,?,?);";
            parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            
            parametro.setInt(1, getNoFacrura());
            parametro.setString(2, getSerie());
            parametro.setString(3, getFechafactura());
            parametro.setString(4, getIdcliente());
            parametro.setString(5, getIdempleado());
            parametro.setString(6, fecha);
            
            int ejecutar= parametro.executeUpdate();
            retorno = ejecutar;
        }catch(SQLException ex){
            System.out.println("Error Venta: " + ex.getMessage());
        }
        cn.cerrar_con();
        return retorno;
    }
    
    public int guardarDetalleV(){
        int retorno=0;
        cn = new Conexion();
        cn.abrir_con();
        try{
            PreparedStatement parametro;
            String query="INSERT INTO ventas_detalle(idventa,idproducto,cantidad,precio_unitario)VALUES(?,?,?,?);";
            parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            
            parametro.setString(1, this.getIdventa());
            parametro.setString(2, this.getIdproducto());
            parametro.setInt(3, this.getCantidad());
            parametro.setFloat(4, this.getPrecioUnitario());
            
            int ejecutar= parametro.executeUpdate();
            retorno = ejecutar;
        }catch(SQLException ex){
           System.out.println("Error Detalle Venta: " + ex.getMessage()); 
        }
        cn.cerrar_con();
        return retorno;
    }
    
     
    public DefaultTableModel leerVenta(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
         cn = new Conexion();
         cn.abrir_con();
          String query;

              query = "select v.idventa as id, v.nofactura,c.nit, v.idempleado, v.fechafactura,c.idcliente from ventas as v inner join clientes as c on v.idcliente= c.idcliente;";
           ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);

            String encabezado[] = {"id","nofactura","nit","idempleado","fechafactura","idcliente"};
            tabla.setColumnIdentifiers(encabezado);

            String datos[]=new String[6];

         while(consulta.next()){
            datos[0] = consulta.getString("id");
            datos[1] = consulta.getString("nofactura");
            datos[2] = consulta.getString("nit");
            datos[3] = consulta.getString("idempleado");
            datos[4] = consulta.getString("fechafactura");
            datos[5] = consulta.getString("idcliente");
            tabla.addRow(datos);
            }
         cn.cerrar_con();


        }catch(SQLException ex){
            cn.cerrar_con();
            System.out.println("Error: " + ex.getMessage() );

        }
        return tabla;
    }
    
    public DefaultTableModel leerDetalleV(String id){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
         cn = new Conexion();
         cn.abrir_con();
          String query;

            query = "SELECT d.idventas_detalle as id, d.idventa, p.producto, d.precio_unitario, p.idproductos  FROM ventas_detalle as d inner join productos as p on d.idproducto= p.idproductos where d.idventa="+id+";";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"id","idventa","producto","precio_unitario","idproductos"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[]=new String[5];
         while(consulta.next()){
            datos[0] = consulta.getString("id");
            datos[1] = consulta.getString("idventa");
            datos[2] = consulta.getString("producto");
            datos[3] = consulta.getString("precio_unitario");
            datos[4] = consulta.getString("idproductos");
            tabla.addRow(datos);
            }
         cn.cerrar_con();
        }catch(SQLException ex){
            cn.cerrar_con();
            System.out.println("Error: " + ex.getMessage() );
        }
        return tabla;
    }
    
    public int EliminarVenDet(String id){
        int retorno=0;
        cn = new Conexion();
        cn.abrir_con();
        try{
            PreparedStatement parametro;
            String query;
            query = "DELETE FROM ventas_detalle WHERE idventa=?;";
            
            parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1, id);
            
            int ejecutar= parametro.executeUpdate();
            retorno = ejecutar;
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage() );
        }
        cn.cerrar_con();
        
        return retorno;
    }
    
    public int EliminarVen(String id){
        int retorno=0;
        cn = new Conexion();
        cn.abrir_con();
        try{
            PreparedStatement parametro;
            String query;
            query = "DELETE FROM ventas WHERE idventa=?;";
            parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1, id);
            int ejecutar= parametro.executeUpdate();
            retorno = ejecutar;

        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage() );
        }
        cn.cerrar_con();
        return retorno;
    }
    
    
}
