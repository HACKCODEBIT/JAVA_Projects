
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Funciones;
import modelo.TargetaP;
import vista.VistaBuscarT;


public class ControladorBuscarT implements ActionListener{
    private Funciones fun;
    private VistaBuscarT visBusT;

    public ControladorBuscarT(Funciones fun, VistaBuscarT visBusT) {
        this.fun = fun;
        this.visBusT = visBusT;
        this.visBusT.btn_buscar.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==visBusT.btn_buscar){
            try{
                String code = visBusT.jtf_numCod.getText();
                int cod = Integer.parseInt(code);
                if(cod>0){
                    TargetaP encontrada =fun.BuscarT(cod);

                    if(code.isEmpty()){
                    JOptionPane.showMessageDialog(visBusT,"Eyyy -- esta en blanco el cuadro de texto-- :(");
                    visBusT.jtf_numCod.setText("");
                    }
                    if(encontrada != null){

                        JOptionPane.showMessageDialog(visBusT,"Targeta de propiedad encontrada: :) \n"+encontrada);
                        visBusT.jtf_numCod.setText("");

                    }else{
                        JOptionPane.showMessageDialog(visBusT,"Targeta de Propiedad no encontrada :(");
                        visBusT.jtf_numCod.setText("");

                    }
                }else{
                JOptionPane.showMessageDialog(visBusT, "Debe ingresar un valor mayor que (0)");
                    visBusT.jtf_numCod.setText("");

                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(visBusT, "El valor ingresado no es el correcto");
                visBusT.jtf_numCod.setText("");

            }

        }
      
    }
    
}
