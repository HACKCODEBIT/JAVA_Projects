
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Funciones;
import modelo.Propietario;
import modelo.TargetaP;
import modelo.Vehiculo;
import vista.VistaEliminarT;

public class ControladorEliminarT implements ActionListener{
    private Funciones fun;
    private VistaEliminarT visElimi;
    public ControladorEliminarT(VistaEliminarT visElimi, Funciones fun) {
        this.fun = fun;
        this.visElimi = visElimi;
        this.visElimi.btn_eliminarT.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==visElimi.btn_eliminarT){
            try{
                String code =visElimi.jtf_numCod.getText();
                int cod=Integer.parseInt(code);
                if(cod>0){
               if(code.isEmpty()){
                   JOptionPane.showMessageDialog(visElimi, "Ingrese un valor en el campo porfavor...");
                   visElimi.jtf_numCod.setText("");
                   return;
               }
               TargetaP encontrado = fun.BuscarT(cod);
               
               
               if(encontrado!=null){
                   
                 Vehiculo vehi =fun.borrarVehiculo(encontrado.getVehiculo().getPlaca());
                 Propietario pro =fun.borrarPropietario(encontrado.getPropietario().getDni());
                 fun.eliminarFilaPorValorP(pro.getDni());
                 fun.ActualizarTablaP();
                 fun.eliminarFilaPorValorV(vehi.getPlaca());
                 fun.ActualizarTablaV();
                fun.borrarTargeta(cod);
                fun.eliminarFilaPorValorT(cod);
                JOptionPane.showMessageDialog(visElimi, "ELiminada exitosamente");
                fun.ActualizarTablaT();
                visElimi.jtf_numCod.setText("");
               }else{
                   
               JOptionPane.showMessageDialog(visElimi,"No se pudo eliminar\n"+"La targeta de propiedad ingresada no se encuentra registrado...");
                visElimi.jtf_numCod.setText("");}
               
              }else{
                
                JOptionPane.showMessageDialog(visElimi, "Ingresa un numero mayor a (0)");}

            }catch(NullPointerException ex){
               JOptionPane.showMessageDialog(visElimi,"error, verifica si existe un propietario asociado con la targeta a eliminar.");
            }
        }
      
    }
}
