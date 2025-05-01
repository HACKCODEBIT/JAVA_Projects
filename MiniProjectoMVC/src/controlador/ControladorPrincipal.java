
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;
import controlador.ControladorModifiP;
import controlador.ControladorModifiV;
import controlador.ControladorModifiT;
public class ControladorPrincipal implements ActionListener{
        private Funciones funcion;
        private Ventana venPrin;
        private VistaAgregarP visAggP;
        private VistaAgregarT visAggT;
        private VistaAgregarV visAggV;
        private VistaBuscarP visBusP;
        private VistaBuscarT visBusT;
        private VistaBuscarV visBusV;
        private VistaEliminarP visElimiP;
        private VistaEliminarT visElimiT;
        private VistaEliminarV visElimiV;
        private VistaModifiP visModiP;
        private VistaModifiT visModiT;
        private VistaModifiv visModiV;
        private VistaTablaP visTablaP;
        private VistaTablaT visTablaT;
        private VistaTablaV visTablaV;
        private ControladorModifiP ctrlModifiP; 
        private ControladorModifiV ctrlModifiV;
        private ControladorModifiT ctrlModifiT;

    public ControladorPrincipal(Funciones funcion, Ventana venPrin, VistaAgregarP visAggP, VistaAgregarT visAggT, VistaAgregarV visAggV, VistaBuscarP visBusP, VistaBuscarT visBusT, VistaBuscarV visBusV, VistaEliminarP visElimiP, VistaEliminarT visElimiT, VistaEliminarV visElimiV, VistaModifiP visModiP, VistaModifiT visModiT, VistaModifiv visModiV, VistaTablaP visTablaP, VistaTablaT visTablaT, VistaTablaV visTablaV, ControladorModifiP ctrlModifiP, ControladorModifiV ctrlModifiV, ControladorModifiT ctrlModifiT) {
        
        this.ctrlModifiT = ctrlModifiT;
        this.ctrlModifiP = ctrlModifiP;
        this.ctrlModifiV = ctrlModifiV;
        this.funcion = funcion;this.venPrin = venPrin;
        this.visAggP = visAggP;this.visAggT = visAggT;
        this.visAggV = visAggV;this.visBusP = visBusP;
        this.visBusT = visBusT;this.visBusV = visBusV;
        this.visElimiP = visElimiP;this.visElimiT = visElimiT;
        this.visElimiV = visElimiV;this.visModiP = visModiP;
        this.visModiT = visModiT;this.visModiV = visModiV;
        this.visTablaP = visTablaP;this.visTablaT = visTablaT;
        this.visTablaV = visTablaV;
        this.venPrin.btn_aggP.addActionListener(this);
        this.venPrin.btn_aggV.addActionListener(this);
        this.venPrin.btn_aggT.addActionListener(this);
        this.venPrin.btn_buscarT.addActionListener(this);
        this.venPrin.btn_elimiT.addActionListener(this);
        this.venPrin.btn_modifiT.addActionListener(this);
        this.venPrin.btn_listarT.addActionListener(this);
        this.venPrin.btn_buscarP.addActionListener(this);
        this.venPrin.btn_elimiP.addActionListener(this);
        this.venPrin.btn_modifiP.addActionListener(this);
        this.venPrin.btn_listarp.addActionListener(this);
        this.venPrin.btn_buscaV.addActionListener(this);
        this.venPrin.btn_eliimiV.addActionListener(this);
        this.venPrin.btn_modifiV.addActionListener(this);
        this.venPrin.btn_listarV.addActionListener(this);
    }
public void InciarVista(){
    this.venPrin.setLocationRelativeTo(null);
    this.venPrin.setVisible(true);
    this.venPrin.setResizable(false);

}

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==venPrin.btn_aggP){
            this.visAggP.setLocationRelativeTo(null);
            this.visAggP.setVisible(true);
            this.visAggP.setResizable(false);
      }
      else if(e.getSource()==venPrin.btn_aggV){
            this.visAggV.setLocationRelativeTo(null);
            this.visAggV.setVisible(true);
            this.visAggV.setResizable(false);
      }
      else if(e.getSource()==venPrin.btn_aggT){
            this.visAggT.setLocationRelativeTo(null);
            this.visAggT.setVisible(true);
            this.visAggT.setResizable(false);
      }
      else if(e.getSource()==venPrin.btn_buscarT){
            this.visBusT.setLocationRelativeTo(null);
            this.visBusT.setVisible(true);
            this.visBusT.setResizable(false);
      }
      else if(e.getSource()==venPrin.btn_modifiT){
          try{
             TargetaP encontrado = ctrlModifiT.modifi();
             if(encontrado !=null){
                this.visModiT.setLocationRelativeTo(null);
                this.visModiT.setVisible(true);
                this.visModiT.setResizable(false);
             }else{
                JOptionPane.showMessageDialog(venPrin, "Error, Targeta no registra(codigo no existe)");
                
             }
             
          }catch(NumberFormatException ex){
          JOptionPane.showMessageDialog(venPrin, "Error, ingresa un valor valido");
          
          }
      }
      else if(e.getSource()==venPrin.btn_elimiT){
            this.visElimiT.setLocationRelativeTo(null);
            this.visElimiT.setVisible(true);
            this.visElimiT.setResizable(false);
      }
      else if(e.getSource()==venPrin.btn_listarT){
            this.visTablaT.setLocationRelativeTo(null);
            this.visTablaT.setVisible(true);
            this.visTablaT.setResizable(false);
      }
            else if(e.getSource()==venPrin.btn_buscaV){
            this.visBusV.setLocationRelativeTo(null);
            this.visBusV.setVisible(true);
            this.visBusV.setResizable(false);
      }
      else if(e.getSource()==venPrin.btn_modifiV){
            try{
              Vehiculo encontrado = ctrlModifiV.modifi();
              if(encontrado!=null){
               this.visModiV.setLocationRelativeTo(null);
               this.visModiV.setVisible(true);
               this.visModiV.setResizable(false);
              }else{
                   JOptionPane.showMessageDialog(venPrin, "Vehiculo no encontrado");
              }  
            }catch(NullPointerException ex ){
                JOptionPane.showMessageDialog(venPrin, "Ingresa un valor para la proxima!! Chao bambino..");
            }
        }
      else if(e.getSource()==venPrin.btn_eliimiV){
            this.visElimiV.setLocationRelativeTo(null);
            this.visElimiV.setVisible(true);
            this.visElimiV.setResizable(false);
      }
      else if(e.getSource()==venPrin.btn_listarV){
            this.visTablaV.setLocationRelativeTo(null);
            this.visTablaV.setVisible(true);
            this.visTablaV.setResizable(false);
      }
            else if(e.getSource()==venPrin.btn_buscarP){
            this.visBusP.setLocationRelativeTo(null);
            this.visBusP.setVisible(true);
            this.visBusP.setResizable(false);
      }
      else if(e.getSource()==venPrin.btn_modifiP){
         try{
          Propietario encontrado = ctrlModifiP.modifi();
          if(encontrado!=null){
            this.visModiP.setLocationRelativeTo(null);
            this.visModiP.setVisible(true);
            this.visModiP.setResizable(false);
          }else{
                JOptionPane.showMessageDialog(venPrin, "Propietario no encontrado");     
            }
        
        }catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(venPrin, "Error, Ingresa un valor valido");
        }
         
      }
      else if(e.getSource()==venPrin.btn_elimiP){
            this.visElimiP.setLocationRelativeTo(null);
            this.visElimiP.setVisible(true);
            this.visElimiP.setResizable(false);
      }
      else if(e.getSource()==venPrin.btn_listarp){
            this.visTablaP.setLocationRelativeTo(null);
            this.visTablaP.setVisible(true);
            this.visTablaP.setResizable(false);
      }
    }
    
}
