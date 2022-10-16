/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Josue
 */
public class Puesto {
    private String puesto;
    private int id_puesto;

    public Puesto() {
    }
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
    
    
}
