
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Funciones;
import modelo.Propietario;
import vista.VistaModifiP;

public class ControladorModifiP implements ActionListener {
    private Funciones fun;
    private int ced;
    private VistaModifiP vistaModifi;
    public ControladorModifiP(Funciones fun, VistaModifiP vistaModifi) {
        this.fun = fun;
        this.vistaModifi = vistaModifi;
        this.vistaModifi.btn_modificarP.addActionListener(this);
        
    }
    
    public Propietario modifi(){
            ced = Integer.parseInt(JOptionPane.showInputDialog(vistaModifi,"Ingresar la cedula del propietario a modificar"));
            if (ced >0){
                Propietario encontrado = fun.BuscarP(ced);
                if(encontrado!=null){
                    return encontrado;        
                }
            }else{                
                JOptionPane.showMessageDialog(vistaModifi,"Debe ingresar un valor mayor a (0)");
                
            }
        return null;
    }
        @Override

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vistaModifi.btn_modificarP){
        try{

                Propietario encontrado =fun.BuscarP(ced);
                if(encontrado!=null){
                    String dni = vistaModifi.jtf_nuevoCed.getText();
                    int dnis = Integer.parseInt(dni);
                    if(!dni.isEmpty() && dnis>0){
                    encontrado.setDni(dnis);
                    }else{
                        JOptionPane.showMessageDialog(vistaModifi,"Debe ingresar un valor mayor a (0)");
                        vistaModifi.jtf_nuevoCed.setText("");
                        return;
                    }
                    String nombres = vistaModifi.jtf_nuevoName.getText();
                    
                    if (!nombres.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                        JOptionPane.showMessageDialog(vistaModifi, "Ingresa una cadena porfavor");
                        vistaModifi.jtf_nuevoName.setText("");
                        return;
                    }else{encontrado.setNombres(nombres);}
                    
                    String apellidos = vistaModifi.jtf_nuevoApe.getText();
                    
                    if (!apellidos.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                         JOptionPane.showMessageDialog(vistaModifi, "Ingresa una cadena porfavor");
                         vistaModifi.jtf_nuevoApe.setText("");
                         return;
                     }else{encontrado.setApellidos(apellidos);}
                    
                    String direccion = vistaModifi.jtf_nuevaDirec.getText();
                    if(direccion.isEmpty()){
                        JOptionPane.showMessageDialog(vistaModifi, "No puede estar vacio el campo de la direccion");
                        vistaModifi.jtf_nuevaDirec.setText("");
                        return;
                    }else{encontrado.setDireccion(direccion);}
                    fun.ActualizarTablaP();
                    fun.ActualizarTablaT();

                    JOptionPane.showMessageDialog(vistaModifi, "Propietario "+nombres+" "+apellidos+" modificado correctamente");
                    vistaModifi.jtf_nuevoCed.setText("");
                    vistaModifi.jtf_nuevoName.setText("");
                    vistaModifi.jtf_nuevoApe.setText("");
                    vistaModifi.jtf_nuevaDirec.setText("");
                }
        
        }catch(NullPointerException ex){
                        JOptionPane.showMessageDialog(vistaModifi, "chao bambino");
                        vistaModifi.jtf_nuevoCed.setText("");
   
        }

        }     
     }
} 
