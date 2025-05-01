
package controlador;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Funciones;
import vista.VistaAgregarP;
import vista.VistaTablaP;
import javax.swing.table.DefaultTableModel;
public class ControladorAggP implements ActionListener{
    private Funciones fun;
    private VistaAgregarP visAggP;
    private VistaTablaP visTabla;
    
    

    public ControladorAggP(Funciones fun, VistaAgregarP visAggP,VistaTablaP visTabla) {
        this.visTabla = visTabla;
        this.fun = fun;
        this.visAggP = visAggP;
        this.visAggP.btn_guardarP.addActionListener(this);
        
    }
    
    private void AgregarFila(int dni,String nombres,String apellidos, String direccion){
    DefaultTableModel table =(DefaultTableModel)visTabla.jtableP.getModel();
        Object[] fila = {dni,nombres,apellidos,direccion};
        table.addRow(fila);
    
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== visAggP.btn_guardarP){
            try{

                int dni = Integer.parseInt(visAggP.jtf_dni.getText());
                if(dni>0){
                }else{
                JOptionPane.showMessageDialog(visAggP,"Debe ingresar un valor mayor a (0)");
                visAggP.jtf_dni.setText("");
                return;
                }
                String nombres = visAggP.jtf_nombres.getText();
                if(nombres.isEmpty()){
                    JOptionPane.showMessageDialog(visAggP,"No puede estar vacio el campo.");
                        visAggP.jtf_nombres.setText("");
                        return;
                }
                else if (!nombres.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    JOptionPane.showMessageDialog(visAggP, "Los nombres solo puede contener letras");
                                        visAggP.jtf_nombres.setText("");

                    return;
                }
                String apellidos = visAggP.jtf_apellidos.getText();
                if(apellidos.isEmpty()){
                    JOptionPane.showMessageDialog(visAggP,"No puede estar vacio el campo.");
                     visAggP.jtf_apellidos.setText("");
                     return;
                }
                else if (!apellidos.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    JOptionPane.showMessageDialog(visAggP, "Los Apellidos solo puede contener letras");
                                     visAggP.jtf_apellidos.setText("");

                    return;
                }
                String direccion = visAggP.jtf_direccion.getText();
                if(direccion.isEmpty()){
                    JOptionPane.showMessageDialog(visAggP,"No puede estar vacio el campo.");
                    visAggP.jtf_direccion.setText("");
                    return;
                }

                fun.AgregarPropietario(dni, nombres, apellidos, direccion);
                AgregarFila(dni,nombres,apellidos,direccion);
                JOptionPane.showMessageDialog(visAggP, "Propietario "+nombres+" "+apellidos+" agregado completamente");
                visAggP.jtf_dni.setText("");
                visAggP.jtf_nombres.setText("");
                visAggP.jtf_apellidos.setText("");
                visAggP.jtf_direccion.setText("");



            }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(visAggP,"Error Valor invalido");
                        visAggP.jtf_dni.setText("");

            }
        }
    }
    
}
