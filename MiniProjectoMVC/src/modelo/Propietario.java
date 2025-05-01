/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author UNIVALLE
 */
public class Propietario {
    private int dni;
    private String nombres, apellidos,direccion;

    public Propietario() {
    }

    public Propietario(int dni, String nombres, String apellidos, String direccion) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    @Override
    public String toString(){
    return " -- Dni: "+dni+
            "\n -- Nombres: "+ nombres+
            "\n -- Apeliidos: "+apellidos+
            "\n -- Direccion: "+direccion;
    }
    
}
