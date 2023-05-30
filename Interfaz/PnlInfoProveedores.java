import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import javax.swing.table.DefaultTableModel;

public class PnlInfoProveedores extends PanelApp implements ActionListener{
    private JPanel panelTitulo, panelTabla, panelBotones;
    private JTable tablaInfoProductos;
    private String[] nombresColumnas;
    private Object[][] datosFilas;
    private JScrollPane panelScroll;
    private JLabel labelTitulo;
    private JButton btnVolver, btnActualizar;
            
    public PnlInfoProveedores(){
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

        // Tabla
        tablaInfoProductos = new JTable();
        panelScroll = new JScrollPane(tablaInfoProductos);
        setDatosTabla();

        //Labels
        labelTitulo = new JLabel("INFO OPERACIONES PROVEEDORES");
        labelTitulo.setFont(new Font("", Font.BOLD, 20));

        // botones
        btnVolver = new JButton("Volver a proveedores");
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
        datosFilas = new Object[controlProveedores.obtenerInfoProveedor().size()][4]; 
        nombresColumnas = new String[]{"Codigo prov.", "Nombre prov.", "Fecha", "Operacion"};
        
        int fila=0;
        for(InfoProveedor infoProd : controlProveedores.obtenerInfoProveedor()){
            datosFilas[fila][0] = infoProd.getProveedor().getCodigo();
            datosFilas[fila][1] = infoProd.getProveedor().getNombre();
            datosFilas[fila][2] = infoProd.getFecha();
            datosFilas[fila][3] = infoProd.getOperacion();
            fila++;
        }
        DefaultTableModel model = new DefaultTableModel(datosFilas, nombresColumnas);
        tablaInfoProductos.setModel(model);
    }

    // metodo para actualizar datos 
    public void actualizar(){
        setDatosTabla();
    }

    public void actionPerformed(ActionEvent e){ 
        Main.newApp.actionPerformed(e);
    }
}