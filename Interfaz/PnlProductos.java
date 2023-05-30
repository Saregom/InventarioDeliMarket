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
import java.awt.event.ActionListener;
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

public class PnlProductos extends PanelApp implements ActionListener{
    private JFrame ventanaInforme; 
    private JPanel panelTitulo, panelTabla, panelDatos, panelBotones, panelVntInf;
    private JTable tablaProductos;
    private String[] nombresColumnas;
    private Object[][] datosFilas;
    private JScrollPane panelScroll;
    private JLabel labelCod, labelNom, labelPrec, labelCant, labelTitulo;
    private JLabel labelTituloInf,labelP1, labelP2, labelP3;
    private Font fontCS;
    private JTextField textCod, textNom, textPrec, textCant;
    private JButton btnAgregar, btnActualizar, btnEliminar, btnInforme;
            
    public PnlProductos(){
        initComponenetes();
    }
    
    private void initComponenetes(){
        //paneles
        panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        
        panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setPreferredSize(new Dimension(500, 183));
        
        panelDatos = new JPanel();
        panelDatos.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelDatos.setPreferredSize(new Dimension(220, 140));
        Border borde1 = new TitledBorder(new BevelBorder(BevelBorder.RAISED),"Ingresar Datos");
        panelDatos.setBorder(borde1);
        
        panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        panelBotones.setPreferredSize(new Dimension(520, 70));
        Border borde2 = new TitledBorder(new BevelBorder(BevelBorder.RAISED),"Seleccionar operacion");
        panelBotones.setBorder(borde2);

        // fuente
        fontCS = new Font("", 0, 20);

        // Tabla
        tablaProductos = new JTable();
        panelScroll = new JScrollPane(tablaProductos);
        setDatosTabla();

        //Labels
        labelTitulo = new JLabel("PRODUCTOS");
        labelTitulo.setFont(new Font("", Font.BOLD, 20));
        
        labelCod = new JLabel("Codigo:");
        labelNom = new JLabel("Nombre:");
        labelPrec = new JLabel("Precio:");
        labelCant = new JLabel("Cantidad:");

        listFields = new ArrayList<JTextField>();

        for(int i=0;i<4;i++){
            listFields.add(new JTextField(10));
        }

        // botones
        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnInforme = new JButton("Informe");
        
        //ActionListeners botones
        btnAgregar.addActionListener((ActionEvent evt) -> {
            capturaErrores("AGREGAR");
        });
        btnActualizar.addActionListener((ActionEvent ae) -> {
            capturaErrores("ACTUALIZAR");
        });
        btnEliminar.addActionListener((ActionEvent ae) -> {
            capturaErrores("BORRAR");
        });
        btnInforme.addActionListener(this);
        
        tablaProductos.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt) {
                int i = 0;
                for(JTextField TF : listFields){
                    Object obj = tablaProductos.getValueAt(tablaProductos.getSelectedRow(), i);
                    TF.setText(String.valueOf(obj));
                    i++;
                }
            }
        });

        //añadir componentes
        panelTitulo.add(labelTitulo);
        
        panelTabla.add(panelScroll, BorderLayout.CENTER);

        panelDatos.add(labelCod);
        panelDatos.add(listFields.get(0));
        panelDatos.add(labelNom);
        panelDatos.add(listFields.get(1));
        panelDatos.add(labelPrec);
        panelDatos.add(listFields.get(2));
        panelDatos.add(labelCant);
        panelDatos.add(listFields.get(3));
        
        panelBotones.add(btnAgregar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnInforme);
        
        this.add(panelTitulo);
        this.add(panelTabla);
        this.add(panelDatos);
        this.add(panelBotones);

        this.setVisible(false);
        this.setMaximumSize(new Dimension(600, 540));
        this.setPreferredSize(new Dimension(600, 540));
        this.setLayout(new FlowLayout());
    }  

    // agregar los datos a la tabla grafica
    private void setDatosTabla(){
        datosFilas = new Object[controlProductos.obtenerProductos().size()][4]; 
        nombresColumnas = new String[]{"Codigo", "Nombre", "Precio", "Cantidad"};
    
        int fila=0;
        for(Producto prod : controlProductos.obtenerProductos()){
            datosFilas[fila][0] = prod.getCodigo();
            datosFilas[fila][1] = prod.getNombre();
            datosFilas[fila][2] = prod.getPrecio();
            datosFilas[fila][3] = prod.getCantidad();
            fila++;
        }
        DefaultTableModel model = new DefaultTableModel(datosFilas, nombresColumnas);
        tablaProductos.setModel(model);
    }
    
    // capturar errores en campos
    private void capturaErrores(String accion){
        if(campoVacio(listFields)){
            try{
                int cod2 = Integer.valueOf(listFields.get(0).getText());
                String nom = listFields.get(1).getText();
                double prec2 = Double.valueOf(listFields.get(2).getText());
                int cant2 = Integer.valueOf(listFields.get(3).getText());

                Producto producto = new Producto(cod2, nom, prec2, cant2);
            
                switch(accion){
                    case "AGREGAR": agregar(producto); break;
                    case "ACTUALIZAR": actualizar(producto); break;
                    case "BORRAR": borrar(producto); break;
                    default: break;
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Los campos codigo/precio/cantidad, deben ser de tipo numerico", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // metodo para agreagar datos  
    public void agregar(Producto producto){
        if(controlProductos.existeProdcuto(producto.getCodigo(), producto.getNombre())){
            JOptionPane.showMessageDialog(this, "El producto ya existe", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            int opcion = JOptionPane.showConfirmDialog(this, "¿Deses agregar el nuevo producto: "+producto.getNombre()+"?", "Confirmar",JOptionPane.YES_NO_OPTION);

            if(opcion == 0){
                controlProductos.agregarProdcuto(producto);
                controlProductos.agregarInfoProdcuto(new InfoProducto(producto, "Agregado"));
                setDatosTabla();
                JOptionPane.showMessageDialog(this, "El producto fue agregado", "Operacion completada", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    // metodo para actualizar datos 
    public void actualizar(Producto producto){
        if(controlProductos.existeProdcuto(producto.getCodigo(), producto.getNombre())){
            int opcion = JOptionPane.showConfirmDialog(this, "¿Deses actualizar el producto con codigo: "+producto.getCodigo()+"?", "Confirmar",JOptionPane.YES_NO_OPTION);

            if(opcion == 0){
                controlProductos.actualizarProdcuto(producto);
                controlProductos.agregarInfoProdcuto(new InfoProducto(producto, "Actualizado"));
                setDatosTabla();
                JOptionPane.showMessageDialog(this, "El producto fue actualizado", "Operacion completada", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "El producto NO existe", "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }

    //metodo para borrar datos 
    public void borrar(Producto producto){
        if(controlProductos.existeProdcuto(producto.getCodigo(), "")){
            int opcion = JOptionPane.showConfirmDialog(this, "¿Deseas borrar el producto con codigo: "+producto.getCodigo()+"?", "Confirmar",JOptionPane.YES_NO_OPTION);

            if(opcion == 0){
                controlProductos.eliminarProdcuto(producto.getCodigo());
                controlProductos.agregarInfoProdcuto(new InfoProducto(producto, "Eliminado"));
                setDatosTabla();
                JOptionPane.showMessageDialog(this, "El producto fue borrado", "Operacion completada", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "El producto NO existe", "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
    public void actionPerformed(ActionEvent e){ 
        informe = "Productos";
        Main.newApp.actionPerformed(e);
    }
}