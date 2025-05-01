
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Funciones;
import modelo.TargetaP;
import modelo.Vehiculo;
import vista.VistaEliminarV;

public class ControladorEliminarV implements ActionListener{
    private Funciones fun;
    private VistaEliminarV visElimi;
    public ControladorEliminarV(VistaEliminarV visElimi, Funciones fun) {
        this.fun = fun;
        this.visElimi = visElimi;
        this.visElimi.btn_eliminarV.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==visElimi.btn_eliminarV){
            try{
                String placa =visElimi.jtf_placaBor.getText().toUpperCase();
                if(placa.matches("[A-Z]{3}\\d{3}$")){
          
                }else{
                    JOptionPane.showMessageDialog(visElimi, "La placa debe de contener 3 letras y 3 numeros ej;AAA123");
                    visElimi.jtf_placaBor.setText("");
                    return;
                }
               Vehiculo encontrado = fun.BuscarV(placa);
               if(encontrado!=null){
                
                    for(TargetaP encon: fun.listaTargetaP){
                        if(encontrado.getPlaca().equals(encon.getVehiculo().getPlaca())){
                            int con  =JOptionPane.showConfirmDialog(visElimi, "Automovil asociado a una targeta ,Desea eliminarlo? ");
                            if(con==0){
                                fun.listaTargetaP.remove(encon);
                                fun.eliminarFilaPorValorT(encon.getCodigo());
                                fun.ActualizarTablaT();
                                break;
                        }else{
                                return;
                            }
                                                   
                        }
                    }
                    
                fun.borrarVehiculo(placa);
                fun.eliminarFilaPorValorV(placa);
                JOptionPane.showMessageDialog(visElimi, "ELiminada exitosamente");
                fun.ActualizarTablaV();
                visElimi.jtf_placaBor.setText("");
                
               }else{
                   
               JOptionPane.showMessageDialog(visElimi,"No se pudo eliminar\n"+"el vehiculo ingresado no se encuentra registrado...");
                visElimi.jtf_placaBor.setText("");}
               
  

            }catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(visElimi,"Ingresa un valor valido(Valor Numerico)");
            }
        }
      
    }
}