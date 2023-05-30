import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FrameApp extends JFrame implements ActionListener{
    private JMenuBar menuBar;
    private JMenu menuOperaciones, menuCuenta;
    private JMenuItem menuItProductos, menuItProveedores, menuItPedidos, menuItCerrarSesion;
    protected PanelApp panelActual, pnlLoguIn, pnlProdcutos, pnlProveedores, pnlPedidos, pnlInfoProductos, pnlInfoProveedores;
    protected static Boolean sesionIniciada;
    
    public FrameApp(){
        super.setTitle("DeliMarket - inicio de sesion");
        super.setIconImage(new ImageIcon("Interfaz/imagenes/iconLogo.jpg").getImage());

        panelActual = new PanelApp();
        pnlLoguIn = new PnlLogIn();
        pnlProdcutos = new PnlProductos();
        pnlInfoProductos = new PnlInfoProductos();
        pnlProveedores = new PnlProveedores();
        pnlPedidos = new PnlPedidos();
        pnlInfoProveedores = new PnlInfoProveedores();
        
        showComponents();
    }

    private void showComponents(){
        // menu
        menuBar = new JMenuBar();  
        menuBar.setVisible(false);

        menuOperaciones = new JMenu("Operaciones"); 
        menuCuenta = new JMenu("Cuenta"); 

        menuItProductos = new JMenuItem("Productos"); 
        menuItProveedores = new JMenuItem("Proveedores"); 
        menuItPedidos = new JMenuItem("Pedidos"); 
        menuItCerrarSesion = new JMenuItem("Cerrar sesion"); 

        //añadir componentes
        menuOperaciones.add(menuItProductos);  
        menuOperaciones.add(menuItProveedores);  
        menuOperaciones.add(menuItPedidos);  
        menuCuenta.add(menuItCerrarSesion); 
        menuBar.add(menuOperaciones);
        menuBar.add(menuCuenta); 

        // ActionListeners botones
        menuItProductos.addActionListener(this);
        menuItProveedores.addActionListener(this);
        menuItPedidos.addActionListener(this);
        menuItCerrarSesion.addActionListener(this);
        
        //Mostrar primer panel (inicio de sesion)
        changePanel(pnlLoguIn);
        
        //Añadir componentes
        this.setJMenuBar(menuBar); 
        this.add(panelActual);
        this.add(pnlLoguIn);
        this.add(pnlProdcutos);
        this.add(pnlPedidos);
        this.add(pnlProveedores);
        this.add(pnlInfoProductos);
        this.add(pnlInfoProveedores);

        this.setVisible(true);
        this.setSize(600, 540);
        this.setLayout(new FlowLayout());  
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    //Se llama al presionarse un boton o menu (Action listener)
    public void actionPerformed(ActionEvent e){
        String eventStr = e.getActionCommand();
        menuBar.setVisible(true);

        if(e.getSource() == menuItCerrarSesion){
            super.setTitle("DeliMarket - inicio de sesion");
            ((PnlLogIn) pnlLoguIn).limpiarCampos();
            menuBar.setVisible(false);
            changePanel(pnlLoguIn);
            
        }else if(e.getSource() == menuItProductos || eventStr.equals("Iniciar sesion") || eventStr.equals("Volver a productos")){
            super.setTitle("DeliMarket - productos");  
            changePanel(pnlProdcutos);

        }else if(e.getSource() == menuItProveedores || eventStr.equals("Volver a proveedores")){
            super.setTitle("DeliMarket - proveedores");  
            changePanel(pnlProveedores);

        }else if(e.getSource() == menuItPedidos){
            super.setTitle("DeliMarket - pedidos");  
            changePanel(pnlPedidos);

        }else if(eventStr.equals("Informe")){
            if(panelActual.getInforme().equals("Productos")){
              super.setTitle("DeliMarket - informe de productos");  
              changePanel(pnlInfoProductos);
            }
            if(panelActual.getInforme().equals("Proveedores")){
              super.setTitle("DeliMarket - informe de proveedores");  
              changePanel(pnlInfoProveedores);
            }
        }
    }    

    //Cambiar panel actual
    private void changePanel(PanelApp panel){
        panelActual.setVisible(false);
        panelActual = panel;
        panelActual.setVisible(true);
    }
}