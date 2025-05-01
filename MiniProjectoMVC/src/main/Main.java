
package main;

import modelo.*;
import vista.*;
import controlador.*;

public class Main {
    public static void main(String[] args){
            //creamos el obj para poder instanciar y generar la visibilidad de las vistas;
            
            VistaTablaP visTablaP = new VistaTablaP();
            VistaTablaT visTablaT = new VistaTablaT();
            VistaTablaV visTablaV = new VistaTablaV();
            
            Funciones fun = new Funciones(visTablaP,visTablaT,visTablaV);
            Ventana ven = new Ventana();
            
            VistaAgregarP visAggP = new VistaAgregarP();
            VistaAgregarT visAggT = new VistaAgregarT();
            VistaAgregarV visAggV = new VistaAgregarV();
            
            VistaBuscarP visBusP = new VistaBuscarP(); 
            VistaBuscarT visBusT = new VistaBuscarT ();
            VistaBuscarV visBusV = new VistaBuscarV();
            
            VistaEliminarP visElimiP = new VistaEliminarP();
            VistaEliminarT visElimiT = new VistaEliminarT();
            VistaEliminarV visElimiV = new VistaEliminarV();
            
            VistaModifiP visModiP = new VistaModifiP();
            VistaModifiT visModiT = new VistaModifiT();
            VistaModifiv visModiV = new VistaModifiv();
            
            ControladorModifiT ctrlModiT = new ControladorModifiT(fun,visModiT);
            ControladorModifiV ctrlModiV = new ControladorModifiV(fun,visModiV);
            ControladorModifiP ctrlModiP = new ControladorModifiP(fun,visModiP);
            
            ControladorPrincipal ctrPrin = new ControladorPrincipal(fun,ven,visAggP,visAggT,visAggV,visBusP,visBusT,visBusV,
                    visElimiP,visElimiT,visElimiV,visModiP,
                    visModiT,visModiV,visTablaP,visTablaT,visTablaV,ctrlModiP,ctrlModiV,ctrlModiT);

            
            ControladorAggP ctrAggP = new ControladorAggP(fun,visAggP,visTablaP);
            ControladorAggV ctrAggV = new ControladorAggV(visAggV,fun,visTablaV);
            ControladorAggT ctrAggT = new ControladorAggT(visAggT,fun,visTablaT);
            
            ControladorBuscarP ctrBuscP = new ControladorBuscarP(fun,visBusP);
            ControladorBuscarT ctrBuscT = new ControladorBuscarT(fun,visBusT);
            ControladorBuscarV ctrBuscV = new ControladorBuscarV(fun,visBusV);
            
            ControladorEliminarT ctrElimiT = new ControladorEliminarT(visElimiT,fun);
            ControladorEliminarP ctrElimiP = new ControladorEliminarP(visElimiP,fun);
            ControladorEliminarV ctrElimiV = new ControladorEliminarV(visElimiV,fun);
            
            
            ctrPrin.InciarVista();
    }
}
