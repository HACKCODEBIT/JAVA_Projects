
package modelo;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import vista.*;
public class Funciones {
    private List<Vehiculo> listaVehiculos = new ArrayList<>();
    private List<Propietario> listaPropietario = new ArrayList<>();
    public List<TargetaP> listaTargetaP = new ArrayList<>();
    private VistaTablaV visTablaV;
    private VistaTablaT visTablaT;
    private VistaTablaP visTablaP;

    public Funciones(VistaTablaP visTablaP, VistaTablaT visTablaT, VistaTablaV visTablaV) {
        this.visTablaV = visTablaV;
        this.visTablaT = visTablaT;
        this.visTablaP = visTablaP;
    }

    //--------------Funciones Para Agregar-----------------
    public void AgregarVehiculo(String placa,int anhoF,String marca){
        Vehiculo vehiculos = new Vehiculo(placa,anhoF,marca);
        listaVehiculos.add(vehiculos);
    }
    
    public void AgregarPropietario(int dni,String nombres,String apellidos,String direccion){
       Propietario propietario = new Propietario(dni,nombres,apellidos,direccion); 
       listaPropietario.add(propietario);
    }
    public void agregarTargeta(Vehiculo vehiculo,Propietario propietario,int codigo,String fechaEx){
        TargetaP targeta = new TargetaP(vehiculo,propietario,codigo,fechaEx);
        listaTargetaP.add(targeta);
    }
    //------------------------------------------------------
    
    //----------------Funciones Para Buscar-----------------
    public Propietario BuscarP(int dni){
    for(Propietario buscar: listaPropietario){
        if(buscar.getDni() == dni )
            return buscar;
        }
        return null;
    }
    
    public Vehiculo BuscarV(String placa){
        for(Vehiculo buscar: listaVehiculos){
            if(buscar.getPlaca().equals(placa)){
            return buscar;
            }    
        }
        return null;
    }
    public TargetaP BuscarT(int cod){
        for(TargetaP buscar:listaTargetaP){
            if(buscar.getCodigo()== cod)
                return buscar;
        }
        return null;
    }
    //------------------------------------------------------
    
    //---------------Funcion Para Eliminar Propietarios ----------------
    public Propietario borrarPropietario(int dni ){
            Propietario encontrado = BuscarP(dni);
                listaPropietario.remove(encontrado);
                return encontrado;
                  }
    public void eliminarFilaPorValorP(int valor) {
    DefaultTableModel modelo = (DefaultTableModel) visTablaP.jtableP.getModel();
        int filas = modelo.getRowCount();
            for (int i = 0; i < filas; i++) {
                if (modelo.getValueAt(i, 0).toString().equals(valor)) { 
                    modelo.removeRow(i);
                }
            }
    }
    
    public void ActualizarTablaP(){
        DefaultTableModel modelo = (DefaultTableModel) visTablaP.jtableP.getModel();
        modelo.setRowCount(0);
            for (Propietario p : listaPropietario) {
                modelo.addRow(new Object[]{p.getDni(), p.getNombres(), p.getApellidos(),p.getDireccion()});
            }
    }   
    //--------------------Funcion para eliminar vehiculos-----------------------------
    public Vehiculo borrarVehiculo(String placa ){
                Vehiculo encontrado = BuscarV(placa);
                    listaVehiculos.remove(encontrado);
                    return encontrado;
            }
        public void eliminarFilaPorValorV(String valor) {
    DefaultTableModel modelo = (DefaultTableModel) visTablaV.jtableV.getModel();
        int filas = modelo.getRowCount();
            for (int i = 0; i < filas; i++) {
                if (modelo.getValueAt(i, 0).toString().equals(valor)) { 
                    modelo.removeRow(i);
                }
            }
    }
    
    public void ActualizarTablaV(){
        DefaultTableModel modelo = (DefaultTableModel) visTablaV.jtableV.getModel();
        modelo.setRowCount(0);
            for (Vehiculo p : listaVehiculos) {
                modelo.addRow(new Object[]{p.getPlaca(), p.getAnhoFabricacion(), p.getMarca()} );
            }
    }
    //------------------Funcion Para eliminar Targetas de propiedad-----------------------------
    
    public TargetaP borrarTargeta(int cod ){
        TargetaP encontrado = BuscarT(cod);
                listaTargetaP.remove(encontrado);
                return encontrado;
    }
    public void eliminarFilaPorValorT(int valor) {
    DefaultTableModel modelo = (DefaultTableModel) visTablaT.jTableT.getModel();
        int filas = modelo.getRowCount();
            for (int i = 0; i < filas; i++) {
                if (modelo.getValueAt(i, 0).toString().equals(valor)) { 
                    modelo.removeRow(i);
                }
            }
    }
    
    public void ActualizarTablaT(){
        DefaultTableModel modelo = (DefaultTableModel) visTablaT.jTableT.getModel();
        modelo.setRowCount(0);
            for (TargetaP p : listaTargetaP) {
                modelo.addRow(new Object[]{p.getPropietario(),p.getVehiculo(),  p.getCodigo(),p.getFechaExpedicion()});
                
            }
    }
    
}
