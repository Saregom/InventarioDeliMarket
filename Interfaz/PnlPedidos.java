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

public class PnlPedidos extends PanelApp{
    private JFrame ventanaInforme; 
    private JPanel panelTitulo, panelTabla, panelDatos, panelBotones, panelVntInf;
    private JTable tablaProveedores;
    private String[] nombresColumnas;
    private Object[][] datosFilas;
    private JScrollPane panelScroll;
    private JLabel labelCod, labelNom, labelCate, labelCont, labelTitulo, labelFec;
    private JLabel labelTituloInf,labelP1, labelP2, labelP3;
    private Font fontCS;
    private JTextField textCod, textNom, textCate, textCont;
    
    private JButton btnHacerPedido, btnActualizar, btnCancelar, btnInforme;
            
    public PnlPedidos(){
        initComponenetes();
    }
    
    private void initComponenetes(){
        //paneles
        panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        
        panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setPreferredSize(new Dimension(500, 143));
        
        panelDatos = new JPanel();
        panelDatos.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelDatos.setPreferredSize(new Dimension(220, 140));
        Border borde1 = new TitledBorder(new BevelBorder(BevelBorder.RAISED),"Ingresar Datos");
        panelDatos.setBorder(borde1);
        
        panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        panelBotones.setPreferredSize(new Dimension(500, 70));
        Border borde2 = new TitledBorder(new BevelBorder(BevelBorder.RAISED),"Seleccionar operacion");
        panelBotones.setBorder(borde2);

        // fuente
        fontCS = new Font("", 0, 20);

        // Tabla
        tablaProveedores = new JTable();
        panelScroll = new JScrollPane(tablaProveedores);
        setDatosTabla();

        //Labels
        labelTitulo = new JLabel("PEDIDOS");
        labelTitulo.setFont(new Font("", Font.BOLD, 20));
        
        labelCod = new JLabel("Codigo:");
        labelFec = new JLabel("Fecha:");
        labelNom = new JLabel("Proveedor:");
        labelCate = new JLabel("Producto:");
        labelCont = new JLabel("Cantidad:");
        // String[] txtFileds = {"Codigo","Fecha","Proveedor","Producto","Cantidad"};

        listFields = new ArrayList<JTextField>();

        for(int i=0;i<4;i++){
            listFields.add(new JTextField(10));
        }
        
        // botones
        btnHacerPedido = new JButton("Hacer pedido");
        btnCancelar = new JButton("Cancelar pedido");
        //btnInforme = new JButton("Informe");
        
        //Segunda ventana
        // ventanaInforme = new JFrame();
        // ventanaInforme.setTitle("Informe");
        
        // panelVntInf = new JPanel();
        // panelVntInf.setLayout(new GridLayout(3,1));
        
        // labelTituloInf = new JLabel("Los tres productos con mayor precio son:");
        // labelTituloInf.setFont(fontCS);
        
        // labelP1 = new JLabel();
        // labelP1.setFont(fontCS);
        // labelP2 = new JLabel();
        // labelP2.setFont(fontCS);
        // labelP3 = new JLabel();
        // labelP3.setFont(fontCS);
        
        //ActionListeners botones
        btnHacerPedido.addActionListener((ActionEvent evt) -> {
            capturaErrores("AGREGAR");
        });
        btnCancelar.addActionListener((ActionEvent ae) -> {
            capturaErrores("BORRAR");
        });
        // btnInforme.addActionListener((ActionEvent ae) -> {
        //     // generarInforme();
        //     // ventanaInforme(); 
        //     ventanaInforme.setVisible(false);
        // });
        
        tablaProveedores.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = 0;
                for(JTextField TF : listFields){
                    Object obj = tablaProveedores.getValueAt(tablaProveedores.getSelectedRow(), i);
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
        panelDatos.add(labelCate);
        panelDatos.add(listFields.get(2));
        panelDatos.add(labelCont);
        panelDatos.add(listFields.get(3));
        
        panelBotones.add(btnHacerPedido);
        panelBotones.add(btnCancelar);
        // panelBotones.add(btnInforme);
        
        this.add(panelTitulo);
        this.add(panelTabla);
        this.add(panelDatos);
        this.add(panelBotones);

        this.setVisible(false);
        this.setMaximumSize(new Dimension(600, 540));
        this.setPreferredSize(new Dimension(600, 540));
        this.setLayout(new FlowLayout());
    }  
    
    // private void ventanaInforme(){
    //     panelVntInf.add(labelP1);
    //     panelVntInf.add(labelP2);
    //     panelVntInf.add(labelP3);
        
    //     ventanaInforme.add(labelTituloInf);
    //     ventanaInforme.add(panelVntInf);
        
    //     ventanaInforme.setVisible(true);
    //     ventanaInforme.setSize(450, 187);
    //     ventanaInforme.setLocationRelativeTo(this);
    //     ventanaInforme.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
    // }

    // Verificar un campo vacio
    
    
    // capturar errores en campos
    private void capturaErrores(String accion){
        if(campoVacio(listFields)){
            try{
                int cod = Integer.valueOf(listFields.get(0).getText());
                String prov = listFields.get(1).getText();
                String prod = listFields.get(2).getText();
                int cant = Integer.valueOf(listFields.get(3).getText());

                //Producto producto = new Producto(cod, prov, prod, cant);
            
                // switch(accion){
                //     case "AGREGAR": agregar(producto); break;
                //     case "ACTUALIZAR": actualizar(producto); break;
                //     case "BORRAR": borrar(producto); break;
                //     default: break;
                // }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Los campos codigo/cantidad, deben ser de tipo numerico", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // agregar los datos a la tabla grafica
    private void setDatosTabla(){
        datosFilas = new Object[controlPedidos.obtenerPedidos().size()][5]; 
        nombresColumnas = new String[]{"Codigo", "Proveedor", "Producto", "Cantidad", "Fecha"};
    
        int fila=0;
        for(Pedido ped : controlPedidos.obtenerPedidos()){
            datosFilas[fila][0] = ped.getCodigo();
            datosFilas[fila][1] = ped.getProveedor().getNombre();
            datosFilas[fila][2] = ped.getProducto().getNombre();
            datosFilas[fila][3] = ped.getCantidad();
            datosFilas[fila][4] = ped.getFecha();
            fila++;
        }
        DefaultTableModel model = new DefaultTableModel(datosFilas, nombresColumnas);
        tablaProveedores.setModel(model);
    }
    
    // metodo para agreagar datos  
    // public void agregar(Producto producto){
    //     if(controlProveedores.existeProdcuto(producto.getCodigo(), producto.getNombre())){
    //         JOptionPane.showMessageDialog(this, "El proveedor ya existe", "Error", JOptionPane.ERROR_MESSAGE);
    //     }else{
    //         int opcion = JOptionPane.showConfirmDialog(this, "¿Deses agregar el nuevo proveedor: "+producto.getNombre()+"?", "Confirmar",JOptionPane.YES_NO_OPTION);

    //         if(opcion == 0){
    //             controlProveedores.agregarProdcuto(producto);
    //             setDatosTabla();
    //             JOptionPane.showMessageDialog(this, "El provedor fue agregado", "Operacion completada", JOptionPane.INFORMATION_MESSAGE);
    //         }
    //     }
    // }

    // // metodo para actualizar datos 
    // public void actualizar(Producto producto){
    //     if(controlProveedores.existeProdcuto(producto.getCodigo(), "")){
    //         int opcion = JOptionPane.showConfirmDialog(this, "¿Deses actualizar el proveedor con codigo: "+producto.getCodigo()+"?", "Confirmar",JOptionPane.YES_NO_OPTION);

    //         if(opcion == 0){
    //             controlProveedores.actualizarProdcuto(producto);
    //             setDatosTabla();
    //             JOptionPane.showMessageDialog(this, "El proveedor fue actualizado", "Operacion completada", JOptionPane.INFORMATION_MESSAGE);
    //         }
    //     }else{
    //         JOptionPane.showMessageDialog(this, "El proveedor NO existe", "Error", JOptionPane.ERROR_MESSAGE);
    //     } 
    // }

    // //metodo para borrar datos 
    // public void borrar(Producto producto){
    //     if(controlProveedores.existeProdcuto(producto.getCodigo(), "")){
    //         int opcion = JOptionPane.showConfirmDialog(this, "¿Deseas borrar el proveedor con codigo: "+producto.getCodigo()+"?", "Confirmar",JOptionPane.YES_NO_OPTION);

    //         if(opcion == 0){
    //             controlProveedores.eliminarProdcuto(producto.getCodigo());
    //             setDatosTabla();
    //             JOptionPane.showMessageDialog(this, "El proveedor fue borrado", "Operacion completada", JOptionPane.INFORMATION_MESSAGE);
    //         }
    //     }else{
    //         JOptionPane.showMessageDialog(this, "El proveedor NO existe", "Error", JOptionPane.ERROR_MESSAGE);
    //     } 
    // }
    
    //  metodo que genera el informe sobre la base de datos(3 productos con mayor precio)
    // public void generarInforme(){
        // ArrayList<Float> listaPrecios = new ArrayList<>();
        // for(Producto prod : listaProductos.values()){
        //     listaPrecios.add(prod.precio);
        // }
        // Collections.sort(listaPrecios);
        // Collections.reverse(listaPrecios);
        
        // String n1="";
        // String n2="";
        // String n3="";
        // for(Producto prod : listaProductos.values()){
        //     if(listaPrecios.get(0)==prod.precio){
        //         n1=prod.nombre;
        //     }
        //     if(listaPrecios.get(1)==prod.precio){
        //         n2=prod.nombre;
        //     }
        //     if(listaPrecios.get(2)==prod.precio){
        //         n3=prod.nombre;
        //     }
        // }
        // labelP1.setText("1. "+n1);
        // labelP2.setText("2. "+n2);
        // labelP3.setText("3. "+n3);
    // }
}