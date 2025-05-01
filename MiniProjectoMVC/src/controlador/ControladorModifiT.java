
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Funciones;
import modelo.TargetaP;
import vista.VistaModifiT;
import javax.swing.JOptionPane;
import modelo.Propietario;
import modelo.Vehiculo;

public class ControladorModifiT implements ActionListener{
    private int codigo;
    private Funciones fun;
    private VistaModifiT visModifiT;

    public ControladorModifiT(Funciones fun, VistaModifiT visModifiT) {
        this.codigo = codigo;
        this.fun = fun;
        this.visModifiT = visModifiT;
        this.visModifiT.btn_modificarT.addActionListener(this);
    }
    
    
    public TargetaP modifi(){

        codigo = Integer.parseInt(JOptionPane.showInputDialog(visModifiT,"Ingresar el codigo  de la targeta de propiedad a modificar"));
        if(codigo>0){
            TargetaP encontrado = fun.BuscarT(codigo);
            if(encontrado!=null){
                return encontrado;        
            }
        } else {
            JOptionPane.showMessageDialog(visModifiT, "El codigo debe ser un numero mayor que ;-> (0)");
            }
        
        return null;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== visModifiT.btn_modificarT){
            try{
                TargetaP encon = fun.BuscarT(codigo);
                if(encon != null){
                    
                String placa = visModifiT.jtf_placaT.getText().toUpperCase();
                if (placa.matches("^[A-Z]{3}\\d{3}$")) {        
                    } else {
                        JOptionPane.showMessageDialog(visModifiT, "La placa debe tener 3 letras y 3 números (ej: ABC123)");
                        visModifiT.jtf_placaT.setText("");
                        return;
                    }
                Vehiculo vehi = fun.BuscarV(placa);
                encon.setVehiculo(vehi);
                
                String dni = visModifiT.jtf_dniT.getText();
                int ced = Integer.parseInt(dni);
            
                if(ced>0){
                }else{
                JOptionPane.showMessageDialog(visModifiT,"Debe ingresar un valor mayor a (0)");
                visModifiT.jtf_dniT.setText("");
                return;
                }
                if(dni.isEmpty()){
                    JOptionPane.showMessageDialog(visModifiT, "El campo no puede estar vacio...");
                    visModifiT.jtf_dniT.setText("");
                    return;
                }else{
                    Propietario pro = fun.BuscarP(ced);
                    encon.setPropietario(pro);
                }


                int codigo = Integer.parseInt(visModifiT.jtf_codTargeta.getText());
                if(codigo>0){
                    encon.setCodigo(codigo);
                }else{            
                    JOptionPane.showMessageDialog(visModifiT, "Numero invalido, debe ser mayor a (0)");
                    visModifiT.jtf_codTargeta.setText("");
                    return;
                }
                 String fechaEx = visModifiT.jtf_fechaEx.getText();
                 
                if (fechaEx.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")) {
                    encon.setFechaExpedicion(fechaEx);
                } else {
                    JOptionPane.showMessageDialog(visModifiT, "Formato incorrecto. Usa dd/mm/yyyy (ej: 20/04/2025)");
                    visModifiT.jtf_fechaEx.setText("");
                    return;
                }

                fun.ActualizarTablaT();
                JOptionPane.showMessageDialog(visModifiT, "Targeta Modificada correctamente");
                visModifiT.jtf_dniT.setText("");
                visModifiT.jtf_placaT.setText("");
                visModifiT.jtf_codTargeta.setText("");
                visModifiT.jtf_fechaEx.setText("");
                }

            }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(visModifiT,"Error Valor invalido");
            }
        }
    }       
}
    

