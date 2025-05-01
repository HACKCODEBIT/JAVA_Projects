
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Funciones;
import modelo.Vehiculo;
import vista.VistaBuscarV;
public class ControladorBuscarV implements ActionListener{
    private Funciones fun;
    private VistaBuscarV visBusV;
    
    public ControladorBuscarV(Funciones fun, VistaBuscarV visBusV) {
        this.fun = fun;
        this.visBusV = visBusV;
        this.visBusV.btn_buscarV.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==visBusV.btn_buscarV){
          String placa = visBusV.jtf_PlacaB.getText().toUpperCase();
    
          if(placa.matches("[A-Z]{3}\\d{3}$")){
          }else{
            JOptionPane.showMessageDialog(visBusV, "La placa debe de contener 3 letras y 3 numeros ej;AAA123");
            visBusV.jtf_PlacaB.setText("");
            return;
          }
          
          Vehiculo encontrado = fun.BuscarV(placa);
          if(encontrado != null){
                JOptionPane.showMessageDialog(visBusV,"Vehiculo encontrado\n"+encontrado);
                visBusV.jtf_PlacaB.setText("");
            }else{
                JOptionPane.showMessageDialog(visBusV,"Vehiculo no encontrado\n");
                visBusV.jtf_PlacaB.setText("");
            }
        }
    }      
}

    

