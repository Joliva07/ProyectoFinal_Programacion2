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
public class Ventas {
    private String idventa;
    private String idcliente;
    private String idVenta_detalle;
    private String fechafactura ;
    private String idempleado; 
    private String fechaingreso;
    private String idproducto;
    private String serie="A";
    private int cantidad = 0;
    private int noFacrura=0;
    private float precioUnitario=0;
    private float total=0;
    private String producto;

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
   /* public String idCl(String nit){
       // DefaultTableModel tabla = new DefaultTableModel();
       // String idClt="Hola mundo lkjsdf;laks";
       String idClt;
        try{   
            PreparedStatement parametro;
        cn = new Conexion();
        cn.abrir_con();
        String query;
        query = "select idcliente from clientes where nit='?';";
         parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
         parametro.setString(1, nit);
        String encabezado[] = {"idcliente"};
        tabla.setColumnIdentifiers(encabezado);
         String datos[]=new String[1];
            if(tabla.getRowCount()==0){
                idClt="No existe el cliente";
                
            }else{
                idClt=datos[0];
            }
           // idClt=datos[0];
        cn = new Conexion();
        cn.abrir_con();
       /* PreparedStatement parametro;
        String query;
        query = "select idcliente from clientes where nit='?';";
        parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
        parametro.setString(1, nit);
        ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
        while(consulta.next()){
        texto=consulta.getString("idcliente");   
        }
        idClt=texto;
       /*PreparedStatement parametro;
       String query;
       query = "select idcliente from clientes where nit='" + nit + "';";
       /*String query;
       query = "select idcliente from clientes where nit='?';";
       PreparedStatement parametro = cn.conexionBD.prepareStatement(query);
       parametro.setString(1, nit);
       ResultSet consulta;
       consulta = parametro.executeQuery();
      // String datos[]=new String[1];
       while(consulta.next()){
            System.out.println(consulta.getString("idcliente"));
           String texto=consulta.getString("idcliente");
           idClt=texto;
        }
        //idClt=datos[0];
       //idClt=consulta;
        cn.cerrar_con();  
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return idClt;
    }*/
     /*public DefaultTableModel NomCl(String nit){
         DefaultTableModel tabla = new DefaultTableModel();
         try{
            cn = new Conexion();
            cn.abrir_con();
            String query;
            query = "select idcliente from clientes where nit='"+nit+"';";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"idcliente"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[]=new String[1];
            while(consulta.next()){
            datos[0] = consulta.getString("idcliente");
            tabla.addRow(datos);
            }
            cn.cerrar_con(); 
         }catch(SQLException ex){
            cn.cerrar_con();
            System.out.println("Error: " + ex.getMessage() );
         }
         return tabla;
     }*/
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

    
    
    
}
