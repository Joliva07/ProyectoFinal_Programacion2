/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josue
 */
public class Compra {
    private String id_compra;
    private int NoCompra;
    private String idProveedor;
    private String fechaOrden;
    private String fechaIngreso;
    private String idProducto;
    private int cantidad;
    private float preciounitario;
    private float precioVenta;
    private float total=0;
    private String producto;
    private int Codigo;

    Conexion cn;
    
    public Compra() {
    }

    public Compra(String id_compra, int NoCompra, String idProveedor, String fechaOrden, String fechaIngreso, String idProducto, int cantidad, float preciounitario, float precioVenta, String producto, int Codigo) {
        this.id_compra = id_compra;
        this.NoCompra = NoCompra;
        this.idProveedor = idProveedor;
        this.fechaOrden = fechaOrden;
        this.fechaIngreso = fechaIngreso;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.preciounitario = preciounitario;
        this.precioVenta = precioVenta;
        this.producto = producto;
        this.Codigo = Codigo;
    }
    

    
    
    public String getId_compra() {
        return id_compra;
    }

    public void setId_compra(String id_compra) {
        this.id_compra = id_compra;
    }

    public int getNoCompra() {
        return NoCompra;
    }

    public void setNoCompra(int NoCompra) {
        this.NoCompra = NoCompra;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(String fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(float preciounitario) {
        this.preciounitario = preciounitario;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }
    
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    public Proveedor buscar(String nit){
        Proveedor p = new Proveedor();
        cn = new Conexion();
        cn.abrir_con();
        try{
            PreparedStatement parametro;
            ResultSet consulta;
            String query="select * from proveedores where nit = "+nit;
            parametro=cn.conexionBD.prepareStatement(query);
            consulta=parametro.executeQuery();
            while(consulta.next()){
                p.setId_proveedor(consulta.getInt(1));
                p.setProveedor(consulta.getString(2));
                p.setNit(consulta.getString(3));
                p.setDireccion(consulta.getString(4));
                p.setTelefono(consulta.getString(5));              
            }
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        cn.cerrar_con();
        return p;
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
    public int ActExis(String id, int cant, float precioCo, float precioVen, String fechain){
        int retorno=0;
        cn = new Conexion();
        cn.abrir_con();
        try{
            PreparedStatement parametro;
            String query="UPDATE productos SET precio_costo = ?, precio_venta = ?, existencia = ?, fecha_ingreso = ? WHERE idproductos = ?;";
            parametro=cn.conexionBD.prepareStatement(query);
            
            parametro.setFloat(1,precioCo);
            parametro.setFloat(2,precioVen);
            parametro.setInt(3,cant);
            parametro.setString(4,fechain);
            parametro.setString(5, id);
            
            int ejecutar= parametro.executeUpdate();
            retorno = ejecutar;
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        
        cn.cerrar_con();
        return retorno;
    } 
    public String NoOrden(){
        String NoOr="";
        cn = new Conexion();
        cn.abrir_con();
        try{
            ResultSet consulta;
            PreparedStatement parametro;
            String query="SELECT max(no_orden_compra) FROM compras;";
            parametro=cn.conexionBD.prepareStatement(query);
            consulta=parametro.executeQuery();
            while(consulta.next()){
              NoOr=consulta.getString(1);
            }
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        cn.cerrar_con();
        
        //System.out.println("No: "+ NoFa);
        return NoOr;
    }
    public String IdCompra(){
        String idC="";
        cn = new Conexion();
        cn.abrir_con();
        try{
            ResultSet consulta;
            PreparedStatement parametro;
            String query="SELECT max(idcompra) FROM compras;";
            parametro=cn.conexionBD.prepareStatement(query);
            consulta=parametro.executeQuery();
            while(consulta.next()){
                idC=consulta.getString(1);
            }
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        cn.cerrar_con();
        return idC;
    }
    public int guardarCompra(){
        int retorno=0;
        cn = new Conexion();
        cn.abrir_con();
        try{
            PreparedStatement parametro;
            String query="insert into compras(no_orden_compra, idproveedor,fecha_orden,fechaingreso) values(?,?,?,?);";
            parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            
            parametro.setInt(1, this.getNoCompra());
            parametro.setString(2, this.getIdProveedor());
            parametro.setString(3, this.getFechaOrden());
            parametro.setString(4, this.getFechaIngreso());
            
            int ejecutar= parametro.executeUpdate();
            retorno = ejecutar;
        }catch(SQLException ex){
            System.out.println("Error compra: " + ex.getMessage());
        }
        cn.cerrar_con();
        return retorno;
    }
    public int guardarDetalleC(){
        int retorno=0;
        cn = new Conexion();
        cn.abrir_con();
        try{
            PreparedStatement parametro;
            String query="INSERT INTO compras_detalle (idcompra,idproducto,cantidad,precio_costo_unitario)VALUES(?,?,?,?);";
            parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            
            parametro.setString(1, this.getId_compra());
            parametro.setString(2, this.getIdProducto());
            parametro.setInt(3, this.getCantidad());
            parametro.setFloat(4, this.getPreciounitario());
            
            int ejecutar= parametro.executeUpdate();
            retorno = ejecutar;
        }catch(SQLException ex){
           System.out.println("Error Detalle compra: " + ex.getMessage()); 
        }
        cn.cerrar_con();
        return retorno;
    }
    
    public DefaultTableModel leerCompra(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
         cn = new Conexion();
         cn.abrir_con();
          String query;

              query = "select c.idcompra as id, c.no_orden_compra,p.nit, c.fecha_orden, p.idproveedores from compras as c inner join proveedores as p on c.idproveedor=p.idproveedores;";
           ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);

            String encabezado[] = {"id","no_orden_compra","nit","fecha_orden","idproveedores"};
            tabla.setColumnIdentifiers(encabezado);

            String datos[]=new String[5];

         while(consulta.next()){
            datos[0] = consulta.getString("id");
            datos[1] = consulta.getString("no_orden_compra");
            datos[2] = consulta.getString("nit");
            datos[3] = consulta.getString("fecha_orden");
            datos[4] = consulta.getString("idproveedores");
            tabla.addRow(datos);
            }
         cn.cerrar_con();

        }catch(SQLException ex){
            cn.cerrar_con();
            System.out.println("Error: " + ex.getMessage() );

        }
        return tabla;
    }

    public int EliminarComDet(String id){
        int retorno=0;
        cn = new Conexion();
        cn.abrir_con();
        try{
            PreparedStatement parametro;
            String query;
            query = "delete from compras_detalle where idcompra=?;";
            
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
    
    public int EliminarCom(String id){
        int retorno=0;
        cn = new Conexion();
        cn.abrir_con();
        try{
            PreparedStatement parametro;
            String query;
            query = "delete from compras where idcompra=?;";
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
