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

        listFields = new ArrayList<JTextField>();

        for(int i=0;i<4;i++){
            listFields.add(new JTextField(10));
        }
        
        // botones
        btnHacerPedido = new JButton("Hacer pedido");
        btnCancelar = new JButton("Cancelar pedido");
        
        //ActionListeners botones
        btnHacerPedido.addActionListener((ActionEvent evt) -> {
            capturaErrores("HACER");
        });
        btnCancelar.addActionListener((ActionEvent ae) -> {
            capturaErrores("CANCELAR");
        });
        
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
        
        this.add(panelTitulo);
        this.add(panelTabla);
        this.add(panelDatos);
        this.add(panelBotones);

        this.setVisible(false);
        this.setMaximumSize(new Dimension(600, 540));
        this.setPreferredSize(new Dimension(600, 540));
        this.setLayout(new FlowLayout());
    }  
    
    // capturar errores en campos
    private void capturaErrores(String accion){
        if(campoVacio(listFields)){
            try{
                int cod = Integer.valueOf(listFields.get(0).getText());
                String prov = listFields.get(1).getText();
                String prod = listFields.get(2).getText();
                int cant = Integer.valueOf(listFields.get(3).getText());

                if(controlProveedores.existeNombreProveedor(prov)){
                    Proveedor proveedor = controlProveedores.obtenerProveedor(prov);
                    Producto producto = new Producto(0, prod, 0, cant);

                    Pedido pedido = new Pedido(cod, proveedor, producto, cant, "Enviando");
            
                    switch(accion){
                        case "HACER": hacerPedido(pedido); break;
                        case "CANCELAR": cancelarPedido(pedido); break;
                        default: break;
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "El proveedor No existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Los campos codigo/cantidad, deben ser de tipo numerico", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // agregar los datos a la tabla grafica
    private void setDatosTabla(){
        datosFilas = new Object[controlPedidos.obtenerPedidos().size()][6]; 
        nombresColumnas = new String[]{"Codigo", "Proveedor", "Producto", "Cantidad", "Fecha", "Estado"};
    
        int fila=0;
        for(Pedido ped : controlPedidos.obtenerPedidos()){
            datosFilas[fila][0] = ped.getCodigo();
            datosFilas[fila][1] = ped.getProveedor().getNombre();
            datosFilas[fila][2] = ped.getProducto().getNombre();
            datosFilas[fila][3] = ped.getCantidad();
            datosFilas[fila][4] = ped.getFecha();
            datosFilas[fila][5] = ped.getEstado();
            fila++;
        }
        DefaultTableModel model = new DefaultTableModel(datosFilas, nombresColumnas);
        tablaProveedores.setModel(model);
    }
    
    // metodo para agreagar datos  
    public void hacerPedido(Pedido pedido){
        int opcion = JOptionPane.showConfirmDialog(this, "¿Deses hacer el nuevo pedido de: "+pedido.getProducto().getCantidad()+" "+pedido.getProducto().getNombre()+"?", "Confirmar",JOptionPane.YES_NO_OPTION);

        if(opcion == 0){
            controlPedidos.hacerPedido(pedido);
            setDatosTabla();
            JOptionPane.showMessageDialog(this, "El pedido fue creado", "Operacion completada", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //metodo para borrar datos 
    public void cancelarPedido(Pedido pedido){
        if(controlPedidos.existePedido(pedido.getCodigo())){
            int opcion = JOptionPane.showConfirmDialog(this, "¿Deseas cancelar el pedido con codigo: "+pedido.getCodigo()+"?", "Confirmar",JOptionPane.YES_NO_OPTION);

            if(opcion == 0){
                controlPedidos.cancelarPedido(pedido.getCodigo());
                setDatosTabla();
                JOptionPane.showMessageDialog(this, "El pedido fue cancelado", "Operacion completada", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "El pedido NO existe", "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
}