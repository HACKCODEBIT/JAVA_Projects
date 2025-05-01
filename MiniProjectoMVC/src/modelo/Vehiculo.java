/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author UNIVALLE
 */
public class Vehiculo {
    private String placa;
    private int anhoFabricacion;
    private String marca;

    public Vehiculo() {
    }

    public Vehiculo(String placa, int anhoFabricacion, String marca) {
        this.placa =placa;
        this.anhoFabricacion = anhoFabricacion;
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAnhoFabricacion() {
        return anhoFabricacion;
    }

    public void setAnhoFabricacion(int anhoFabricacion) {
        this.anhoFabricacion = anhoFabricacion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
    @Override
    public String toString(){
    return "--Placa: "+placa+
            "\n -- Año Fabricacion: "+anhoFabricacion+
            "\n -- Marca: "+marca;
    }
}
