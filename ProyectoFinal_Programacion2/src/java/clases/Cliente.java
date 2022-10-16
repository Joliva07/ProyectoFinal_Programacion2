/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Josue
 */
public class Cliente extends Persona {
    private int id_cliente;
    private String nit,correo_e,fecha_ingreso;

    public Cliente(){
    }
    public Cliente(int id_cliente, String nit, String correo_e, String fecha_ingreso, String nombres, String apellidos, String direccion, String telefono, String genero) {
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
    
    
}
