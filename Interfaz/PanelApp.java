import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class PanelApp extends JPanel{
    protected static ControlProductos controlProductos;
    protected static ControlProveedores controlProveedores;
    protected static ControlPedidos controlPedidos;
    protected static ControlEmpleados controlEmpleados;
    protected ArrayList<JTextField> listFields;
    protected static String informe;

    public PanelApp(){
        controlProductos = new ControlProductos();
        controlProveedores = new ControlProveedores();
        controlPedidos = new ControlPedidos();
        controlEmpleados = new ControlEmpleados();
    }

    // Verfifica textFiels vacios
    public boolean campoVacio(ArrayList<JTextField> listFields){
        for(JTextField TF : listFields){
            if(TF.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Todos los campos son requeridos", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    
    // No se eimplemento
    public void stilizeButton(JButton btn){
        btn.setFont(new Font("", 0, 17));
        btn.setBackground(Color.decode("#C3ECF4"));
        btn.setFocusable(false);
        btn.setBorderPainted(false);
    }

    public String getInforme(){
      return informe;
    }
}