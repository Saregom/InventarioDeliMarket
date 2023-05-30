// package Interfaz;
import java.util.ArrayList;
import java.util.Collections;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

// import Productos;
// import Producto;

class PnlInfoProductos extends PanelApp{
    private JFrame ventanaInforme; 
    private JPanel panelTitulo, panelTabla, panelDatos, panelBotones, panelVntInf;
    private JTable tablaInfoProductos;
    private String[] nombresColumnas;
    private Object[][] datosFilas;
    private JScrollPane panelScroll;
    private JLabel labelCod, labelNom, labelPrec, labelCant, labelTitulo;
    private JLabel labelTituloInf,labelP1, labelP2, labelP3;
    private Font fontCS;
    private JTextField textCod, textNom, textPrec, textCant;
    private JButton btnVolver, btnActualizar, btnBorrar, btnInforme;
            
    public PnlInfoProductos(){
        initComponenetes();
    }
    
    private void initComponenetes(){
        //paneles
        panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        
        panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setPreferredSize(new Dimension(500, 183));
        
        panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        panelBotones.setPreferredSize(new Dimension(500, 70));
        Border borde2 = new TitledBorder(new BevelBorder(BevelBorder.RAISED),"Seleccionar operacion");
        panelBotones.setBorder(borde2);

        // fuente
        fontCS = new Font("", 0, 20);

        // Tabla
        tablaInfoProductos = new JTable();
        panelScroll = new JScrollPane(tablaInfoProductos);
        setDatosTabla();

        //Labels
        labelTitulo = new JLabel("INFO OPERACIONES PRODUCTOS");
        labelTitulo.setFont(new Font("", Font.BOLD, 20));

        // botones
        btnVolver = new JButton("Volver a productos");
        btnActualizar = new JButton("Actualizar");
        
        //ActionListeners botones
        btnVolver.addActionListener(this);
        btnActualizar.addActionListener((ActionEvent e) -> {
            actualizar();
        });

        //añadir componentes
        panelTitulo.add(labelTitulo);
        
        panelTabla.add(panelScroll, BorderLayout.CENTER);

        panelBotones.add(btnVolver);
        panelBotones.add(btnActualizar);
        
        this.add(panelTitulo);
        this.add(panelTabla);
        this.add(panelBotones);

        this.setVisible(false);
        this.setMaximumSize(new Dimension(600, 540));
        this.setPreferredSize(new Dimension(600, 540));
        this.setLayout(new FlowLayout());
    }  
    
    // agregar los datos a la tabla grafica
    private void setDatosTabla(){
        datosFilas = new Object[controlProductos.obtenerInfoProductos().size()][4]; 
        nombresColumnas = new String[]{"Codigo prod.", "Nombre prod.", "Fecha", "Operacion"};
        
        int fila=0;
        for(InfoProducto infoProd : controlProductos.obtenerInfoProductos()){
            datosFilas[fila][0] = infoProd.getProducto().getCodigo();
            datosFilas[fila][1] = infoProd.getProducto().getNombre();
            datosFilas[fila][2] = infoProd.getFecha();
            datosFilas[fila][3] = infoProd.getOperacion();
            fila++;
        }
        DefaultTableModel model = new DefaultTableModel(datosFilas, nombresColumnas);
        tablaInfoProductos.setModel(model);
    }
    
    // metodo para agreagar datos  
    public void agregar(Producto producto){
        
    }

    // metodo para actualizar datos 
    public void actualizar(){
        setDatosTabla();
    }
}