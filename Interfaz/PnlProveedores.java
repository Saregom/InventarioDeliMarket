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

public class PnlProveedores extends PanelApp implements ActionListener{
    private JFrame ventanaInforme; 
    private JPanel panelTitulo, panelTabla, panelDatos, panelBotones, panelVntInf;
    private JTable tablaProveedores;
    private String[] nombresColumnas;
    private Object[][] datosFilas;
    private JScrollPane panelScroll;
    private JLabel labelCod, labelNom, labelCate, labelCont, labelTitulo;
    private JLabel labelTituloInf,labelP1, labelP2, labelP3;
    private Font fontCS;
    private JTextField textCod, textNom, textCate, textCont;
    private JButton btnAgregar, btnActualizar, btnEliminar, btnInforme;
            
    public PnlProveedores(){
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
        panelBotones.setPreferredSize(new Dimension(520, 70));
        Border borde2 = new TitledBorder(new BevelBorder(BevelBorder.RAISED),"Seleccionar operacion");
        panelBotones.setBorder(borde2);

        // fuente
        fontCS = new Font("", 0, 20);

        // Tabla
        tablaProveedores = new JTable();
        panelScroll = new JScrollPane(tablaProveedores);
        setDatosTabla();

        //Labels
        labelTitulo = new JLabel("PROVEEDORES");
        labelTitulo.setFont(new Font("", Font.BOLD, 20));
        
        labelCod = new JLabel("Codigo:");
        labelNom = new JLabel("Nombre:");
        labelCate = new JLabel("Categoria:");
        labelCont = new JLabel("Contacto");

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
        
        tablaProveedores.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
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
    
    // capturar errores en campos
    private void capturaErrores(String accion){
        if(campoVacio(listFields)){
            try{
                int cod2 = Integer.valueOf(listFields.get(0).getText());
                String nom = listFields.get(1).getText();
                String cate2 = listFields.get(2).getText();
                int cont2 = Integer.valueOf(listFields.get(3).getText());

                Proveedor proveedor = new Proveedor(cod2, nom, cate2, cont2);

                 switch(accion){
                     case "AGREGAR": agregar(proveedor); break;
                     case "ACTUALIZAR": actualizar(proveedor); break;
                     case "BORRAR": borrar(proveedor); break;
                     default: break;
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Los campos codigo/contacto, deben ser de tipo numerico", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // agregar los datos a la tabla grafica
    private void setDatosTabla(){
        datosFilas = new Object[controlProveedores.obtenerProveedores().size()][4]; 
        nombresColumnas = new String[]{"Codigo", "Nombre", "Categoria", "Contacto"};
    
        int fila=0;
        for(Proveedor prod : controlProveedores.obtenerProveedores()){
            datosFilas[fila][0] = prod.getCodigo();
            datosFilas[fila][1] = prod.getNombre();
            datosFilas[fila][2] = prod.getCategoria();
            datosFilas[fila][3] = prod.getContacto();
            fila++;
        }
        DefaultTableModel model = new DefaultTableModel(datosFilas, nombresColumnas);
        tablaProveedores.setModel(model);
    }
    
    // metodo para agreagar datos  
     public void agregar(Proveedor proveedor){
         if(controlProveedores.existeProveedor(proveedor.getCodigo(), proveedor.getCategoria())){
             JOptionPane.showMessageDialog(this, "El proveedor ya existe", "Error", JOptionPane.ERROR_MESSAGE);
         }else{
             int opcion = JOptionPane.showConfirmDialog(this, "¿Deses agregar el nuevo proveedor: "+proveedor.getCategoria()+"?", "Confirmar",JOptionPane.YES_NO_OPTION);

             if(opcion == 0){
                 controlProveedores.agregarProveedor(proveedor);
                 controlProveedores.agregarInfoProveedor(new InfoProveedor(proveedor, "Agregado"));
                 setDatosTabla();
                 JOptionPane.showMessageDialog(this, "El provedor fue agregado", "Operacion completada", JOptionPane.INFORMATION_MESSAGE);
             }
         }
     }

    // // metodo para actualizar datos 
     public void actualizar(Proveedor proveedor){
         if(controlProveedores.existeProveedor(proveedor.getCodigo(), proveedor.getCategoria())){
             int opcion = JOptionPane.showConfirmDialog(this, "¿Deses actualizar el proveedor con codigo: "+proveedor.getCodigo()+"?", "Confirmar",JOptionPane.YES_NO_OPTION);

             if(opcion == 0){
                 controlProveedores.actualizarProveedor(proveedor);
                 controlProveedores.agregarInfoProveedor(new InfoProveedor(proveedor, "Actualizado"));
                 setDatosTabla();
                 JOptionPane.showMessageDialog(this, "El proveedor fue actualizado", "Operacion completada", JOptionPane.INFORMATION_MESSAGE);
             }
         }else{
             JOptionPane.showMessageDialog(this, "El proveedor NO existe", "Error", JOptionPane.ERROR_MESSAGE);
         } 
     }

    // //metodo para borrar datos 
     public void borrar(Proveedor proveedor){
         if(controlProveedores.existeProveedor(proveedor.getCodigo(), "")){
             int opcion = JOptionPane.showConfirmDialog(this, "¿Deseas borrar el proveedor con codigo: "+proveedor.getCodigo()+"?", "Confirmar",JOptionPane.YES_NO_OPTION);

             if(opcion == 0){
                 controlProveedores.eliminarProveedor(proveedor.getCodigo());
                 controlProveedores.agregarInfoProveedor(new InfoProveedor(proveedor, "Eliminado"));
                 setDatosTabla();
                 JOptionPane.showMessageDialog(this, "El proveedor fue borrado", "Operacion completada", JOptionPane.INFORMATION_MESSAGE);
             }
         }else{
             JOptionPane.showMessageDialog(this, "El proveedor NO existe", "Error", JOptionPane.ERROR_MESSAGE);
         } 
     }
    public void actionPerformed(ActionEvent e){ 
        informe = "Proveedores";
        Main.newApp.actionPerformed(e);
    }
}