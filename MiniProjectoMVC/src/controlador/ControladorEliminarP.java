
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaEliminarP;
import modelo.Funciones;
import javax.swing.JOptionPane;
import modelo.Propietario;
import modelo.TargetaP;


public class ControladorEliminarP implements ActionListener{

    private VistaEliminarP visElimi;
    private Funciones fun;

    public ControladorEliminarP(VistaEliminarP visElimi, Funciones fun) {
        this.visElimi = visElimi;
        this.fun = fun;
        this.visElimi.btn_eliminarP.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==visElimi.btn_eliminarP){
            try{
                String pro =visElimi.jtf_numCedE.getText();
                int pri=Integer.parseInt(pro);
                
               if(pro.isEmpty()){
                   JOptionPane.showMessageDialog(visElimi, "Ingrese un valor en el campo porfavor...");
                   visElimi.jtf_numCedE.setText("");
                   return;
               }
               if(pri>0){
               }else{                   
                   JOptionPane.showMessageDialog(visElimi, "Ingrese un valor mayor a (0)");
                    visElimi.jtf_numCedE.setText("");
                    return;
                }
               Propietario encontrado = fun.BuscarP(pri);
               if(encontrado!=null){
                  
                    for(TargetaP encon: fun.listaTargetaP){
                        if(encontrado.getDni()==encon.getPropietario().getDni()){
                            int opc = JOptionPane.showConfirmDialog(visElimi, "El Propietario se encuentra asociado a una targeta de propiedad\n"+"Desea elimiinarlo?");
                            if(opc==0){                      
                            fun.listaTargetaP.remove(encon);
                            fun.eliminarFilaPorValorT(encon.getCodigo());
                            fun.ActualizarTablaT();                           
                            break;
                                    
                            }else{
                            return;
                            }
                        }
                    }
                   
                fun.borrarPropietario(pri);
                fun.eliminarFilaPorValorP(pri);
                JOptionPane.showMessageDialog(visElimi, "ELiminado exitosamente");
                fun.ActualizarTablaP();
                visElimi.jtf_numCedE.setText("");
               }else{
               JOptionPane.showMessageDialog(visElimi,"No se pudo eliminar\n"+"El Propietario ingresado no se encuentra registrado...");
                visElimi.jtf_numCedE.setText("");

               }

            }catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(visElimi,"Ingresa un valor valido(Valor Numerico)");
            }
        }
      
    }
    
}
