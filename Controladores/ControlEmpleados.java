import java.util.ArrayList;

public class ControlEmpleados extends Control{
    private ArrayList<Empleado> listaEmpleados;

    public ControlEmpleados(){
        this.listaEmpleados = bdd.getEmpleados();
    }

    public ArrayList<Empleado> obtenerEmpleados(){
        return this.listaEmpleados;
    }
    
    public boolean verificarDatos(String user, String password){
        for(Empleado emp : this.listaEmpleados){
            if(emp.getPassword().equals(password) && emp.getUsuario().equals(user)){
                return true;
            }
        }
        return false;
    }
}