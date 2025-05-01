/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author UNIVALLE
 */
public class TargetaP {
    private Vehiculo vehiculo;
    private Propietario propietario;
    private int codigo;
    private String fechaExpedicion;

    public TargetaP() {
    }

    public TargetaP(Vehiculo vehiculo, Propietario propietario, int codigo, String fechaExpedicion) {
        this.vehiculo = vehiculo;
        this.propietario = propietario;
        this.codigo = codigo;
        this.fechaExpedicion = fechaExpedicion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }
    public String toString(){
    return "** Vehiculo: "+vehiculo+
            "\n ** Propietario: \n"+propietario+
            "\n -- Codigo: "+codigo+
            "\n -- Fecha de Expedicion: "+fechaExpedicion;
    }
}
