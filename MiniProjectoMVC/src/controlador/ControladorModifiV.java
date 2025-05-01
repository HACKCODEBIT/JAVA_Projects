
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Funciones;
import modelo.Vehiculo;
import vista.VistaModifiv;

public class ControladorModifiV implements ActionListener{
    private Funciones fun;
    private String placa;
    private VistaModifiv vistaModifi;

    public ControladorModifiV(Funciones fun, VistaModifiv vistaModifi) {
        this.fun = fun;
        this.vistaModifi = vistaModifi;
        this.vistaModifi.btn_modificarV.addActionListener(this);
        
    }   
        
    //La funcion nos permite pedir la placa del vehiculo a modificar para hacer una verificacion y saber si se encuentra o no registrado...
    //"Esta funcion la llamamos en el controlador principal para que se pueda usar como un condicional para acceder a ingresar los nuevos datos"    
    public Vehiculo modifi(){
        placa = JOptionPane.showInputDialog(vistaModifi,"Ingresar la placa del vehiculo a modificar").toUpperCase();
        if(placa.matches("^[A-Z]{3}\\d{3}$")){
            Vehiculo encontrado = fun.BuscarV(placa);
            if(encontrado!=null){
                return encontrado;
               
            }
        } else {
            JOptionPane.showMessageDialog(vistaModifi, "La placa debe tener 3 letras y 3 números (ej: ABC123)");
            }
        
        return null;
    }
    //------------------------------------------------------------------------------------------------------------------------
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vistaModifi.btn_modificarV){
        try{
            
            Vehiculo vehi = fun.BuscarV(placa);
            if(vehi!=null){
                String plac = vistaModifi.jtf_nPlaca.getText().toUpperCase();
                if (plac.matches("^[A-Z]{3}\\d{3}$")) { 
                    vehi.setPlaca(plac);
                    
                } else {
                        JOptionPane.showMessageDialog(vistaModifi, "La placa debe tener 3 letras y 3 números (ej: ABC123)");
                        vistaModifi.jtf_nPlaca.setText("");
                        return;
                    }
                int anhoF =Integer.parseInt(vistaModifi.jtf_nNum.getText());
           
                if(anhoF >= 1886 && anhoF <= 2026 ){
                    vehi.setAnhoFabricacion(anhoF);
                    
                }else{
                    JOptionPane.showMessageDialog(vistaModifi,"El año de fabricacion ("+anhoF+") no es valido \n"+"!!Porfavor Ingrese una Año VALIDO¡¡");
                    vistaModifi.jtf_nNum.setText("");
                    return;
                }
                String marca = vistaModifi.jtf_nMarca.getText();
                if (marca.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El campo no puede estar VACIO ");
                    vistaModifi.jtf_nMarca.setText("");
                    return;
                }else{
                    vehi.setMarca(marca);
                }
                fun.ActualizarTablaV();
                fun.ActualizarTablaT();

                JOptionPane.showMessageDialog(vistaModifi, "Vehiculo "+marca+" modificado correctamente");
                vistaModifi.jtf_nNum.setText("");
                vistaModifi.jtf_nMarca.setText("");
                vistaModifi.jtf_nPlaca.setText("");
            }

        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(vistaModifi,"Error Valor invalido");
        }
    }
    }
}

