//package Interfaz;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class PanelApp extends JPanel implements ActionListener{
    protected static ControlProductos controlProductos;
    protected static ControlProveedores controlProveedores;
    protected static ControlPedidos controlPedidos;
    protected ArrayList<JTextField> listFields;

    public PanelApp(){
        controlProductos = new ControlProductos();
        controlProveedores = new ControlProveedores();
        controlPedidos = new ControlPedidos();
    }

    // Action listener de botones o menu
    public void actionPerformed(ActionEvent e){ 
        Main.newApp.actionPerformed(e);
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
    
    public void stilizeButton(JButton btn){
        btn.setFont(new Font("", 0, 17));
        btn.setBackground(Color.decode("#C3ECF4"));
        btn.setFocusable(false);
        btn.setBorderPainted(false);
    }
}