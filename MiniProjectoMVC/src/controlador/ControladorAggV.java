
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Funciones;
import vista.VistaAgregarV;
import vista.VistaTablaV;
public class ControladorAggV implements ActionListener{
    private VistaTablaV visTabla;
    private VistaAgregarV visAggV;
    private Funciones fun;

    public ControladorAggV(VistaAgregarV visAggV, Funciones fun,VistaTablaV visTabla ) {
        this.visTabla = visTabla;
        this.visAggV = visAggV;
        this.fun = fun;
        this.visAggV.btn_guardarV.addActionListener(this);
    }
    private void AgregarFila(String placa,int anhoF,String marca){
        DefaultTableModel tabla = (DefaultTableModel)visTabla.jtableV.getModel();
        Object[] fila  ={placa,anhoF,marca};
        tabla.addRow(fila);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== visAggV.btn_guardarV){
            try{
                String plac = visAggV.jtf_placa.getText().toUpperCase();
                if (plac.matches("^[A-Z]{3}\\d{3}$")) {        
                    } else {
                        JOptionPane.showMessageDialog(visAggV, "La placa debe tener 3 letras y 3 números (ej: ABC123)");
                        visAggV.jtf_placa.setText("");
                        return;
                    }
                    String anhoF =visAggV.jtf_anoF.getText();
                    int anho = Integer.parseInt(anhoF);
                    if(anho >= 1886 && anho <= 2026 ){

                    }else{
                        JOptionPane.showMessageDialog(visAggV,"El año de fabricacion ("+anhoF+") no es valido \n"+"!!Porfavor Ingrese una Año VALIDO¡¡");
                        visAggV.jtf_anoF.setText("");
                        return;
                    }
                    String marca = visAggV.jtf_marca.getText();
                    if (marca.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "El campo no puede estar VACIO ");
                        visAggV.jtf_marca.setText("");
                        return;
                    }

                    fun.AgregarVehiculo(plac, anho, marca);
                    AgregarFila(plac,anho,marca);
                    JOptionPane.showMessageDialog(visAggV, "Vehiculo "+marca+" agregado completamente");
                    visAggV.jtf_anoF.setText("");
                    visAggV.jtf_marca.setText("");
                    visAggV.jtf_placa.setText("");

            }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(visAggV,"Error Valor invalido");
            }
        }
    }
    
}
