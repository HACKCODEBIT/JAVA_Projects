
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Funciones;
import modelo.Propietario;
import vista.VistaBuscarP;

public class ControladorBuscarP implements ActionListener{
    private Funciones fun;
    private VistaBuscarP visBuscarP;

    public ControladorBuscarP(Funciones fun, VistaBuscarP visBuscarP) {
        this.fun = fun;
        this.visBuscarP = visBuscarP;
        this.visBuscarP.btn_buscar.addActionListener(this);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==visBuscarP.btn_buscar){
          try{
          String dni = visBuscarP.jtf_numCed.getText();
          int ced = Integer.parseInt(dni);
          if(dni.isEmpty()){
          JOptionPane.showMessageDialog(visBuscarP, "Ingrese un valor porfavor");
                visBuscarP.jtf_numCed.setText("");

            return;
          }
          if(ced>0){
          }else{
                JOptionPane.showMessageDialog(visBuscarP,"Debe ingresar un valor mayor a (0)");
                visBuscarP.jtf_numCed.setText("");
                return;
          }
          Propietario encontrado = fun.BuscarP(ced);
          if(encontrado != null){
                JOptionPane.showMessageDialog(visBuscarP,"Propietario encontrado\n"+encontrado);
                visBuscarP.jtf_numCed.setText("");
            }else{
                JOptionPane.showMessageDialog(visBuscarP,"Propietario no encontrado\n");
                visBuscarP.jtf_numCed.setText("");

          }
          
      }catch(NumberFormatException ex ){
                JOptionPane.showMessageDialog(visBuscarP, "Ingrese un valor valido porfavor");
                visBuscarP.jtf_numCed.setText("");
      }
    }      
    }   
}
