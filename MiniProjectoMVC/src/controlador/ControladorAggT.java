
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.VistaAgregarT;
import vista.VistaTablaT;

public class ControladorAggT implements ActionListener{
    private VistaTablaT visTabla;
    private VistaAgregarT visAggT;
    private Funciones fun;

    public ControladorAggT(VistaAgregarT visAggT, Funciones fun,VistaTablaT visTabla) {
        this.visTabla = visTabla;
        this.visAggT = visAggT;
        this.fun = fun;
        this.visAggT.btn_guardarT.addActionListener(this);
    }
    private void AgregarFila(Propietario pro,Vehiculo vehi,int code, String fechaEx){
        DefaultTableModel table = (DefaultTableModel)visTabla.jTableT.getModel();
        Object fila[] = {pro,vehi,code,fechaEx};
        table.addRow(fila);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== visAggT.btn_guardarT){
            try{
                String placa = visAggT.jtf_placaT.getText().toUpperCase();
                if (placa.matches("^[A-Z]{3}\\d{3}$")) {        
                    } else {
                        JOptionPane.showMessageDialog(visAggT, "La placa debe tener 3 letras y 3 números (ej: ABC123)");
                        visAggT.jtf_placaT.setText("");
                        return;
                    }
                Vehiculo vehi = fun.BuscarV(placa);

                int dni = Integer.parseInt(visAggT.jtf_dniT.getText());

                Propietario pro = fun.BuscarP(dni);


                int codigo = Integer.parseInt(visAggT.jtf_codTargeta.getText());
                if(codigo>0){
                }else{            
                    JOptionPane.showMessageDialog(visAggT, "Numero invalido, debe ser mayor a (0)");
                    visAggT.jtf_codTargeta.setText("");
                    return;
                }
                 String fechaEx = visAggT.jtf_fechaEx.getText();

                if (fechaEx.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")) {

                } else {
                    JOptionPane.showMessageDialog(visAggT, "Formato incorrecto. Usa dd/mm/yyyy (ej: 20/04/2025)");
                    visAggT.jtf_fechaEx.setText("");
                    return;
                }
                fun.agregarTargeta(vehi, pro, codigo,fechaEx);
                AgregarFila(pro,vehi,codigo,fechaEx);
                JOptionPane.showMessageDialog(visAggT, "Targeta agregada completamente");
                visAggT.jtf_dniT.setText("");
                visAggT.jtf_placaT.setText("");
                visAggT.jtf_codTargeta.setText("");
                visAggT.jtf_fechaEx.setText("");


            }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(visAggT,"Error Valor invalido");
            }
        }
    }
    
}
