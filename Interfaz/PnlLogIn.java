//package Interfaz;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

class PnlLogIn extends PanelApp{
    private JPanel pnlDatos;
    private JLabel lblImgLogo, lblTitle, lblTitle2, lblUser, lblPassword;
    private JButton btnLogIn;
    private Image imgLogo;
    private JTextField FldUser;
    private JPasswordField FldPassword;

    public PnlLogIn(){
        showComponents();
    }

    private void showComponents() {
        // Panels 
        pnlDatos = new JPanel();
        pnlDatos.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnlDatos.setMaximumSize(new Dimension(240, 80));
        pnlDatos.setPreferredSize(new Dimension(240, 80)); 
        pnlDatos.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Labels
        lblTitle = new JLabel("BIENVENIDO A LA APP DE INVENTARIO");
        lblTitle.setFont(new Font("", Font.BOLD, 20));
        lblTitle.setBorder(new EmptyBorder(19,0,0,0));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        imgLogo = new ImageIcon("Interfaz/imagenes/logo.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        lblImgLogo = new JLabel(new ImageIcon(imgLogo));
        lblImgLogo.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblTitle2 = new JLabel("Ingresa tus datos");
        lblTitle2.setFont(new Font("", Font.BOLD, 20));
        lblTitle2.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        lblUser = new JLabel("Usuario:");
        lblUser.setFont(new Font("", 0, 17));

        lblPassword = new JLabel("Contraseña:");  
        lblPassword.setFont(new Font("", 0, 17));
        
        // Fields
        FldUser = new JTextField(10);
        FldUser.setFont(new Font("", 0, 17));

        FldPassword = new JPasswordField(10);
        FldPassword.setFont(new Font("", 0, 17));

        // Buttons
        btnLogIn = new JButton("Iniciar sesion");
        btnLogIn.setMaximumSize(new Dimension(230, 30)); 
        btnLogIn.setPreferredSize(new Dimension(230, 30));
        btnLogIn.setAlignmentX(Component.CENTER_ALIGNMENT);
        stilizeButton(btnLogIn);
        
        // ActionListeners botones
        btnLogIn.addActionListener(this);

        // Añadir componentes
        pnlDatos.add(lblUser);
        pnlDatos.add(FldUser);
        pnlDatos.add(lblPassword);
        pnlDatos.add(FldPassword);

        this.add(lblTitle);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(lblImgLogo);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(lblTitle2);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(pnlDatos);
        this.add(btnLogIn);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setMaximumSize(new Dimension(600, 540));
        this.setPreferredSize(new Dimension(600, 540)); 
        this.setVisible(false);
    }

    public void limpiarCampos(){
        FldUser.setText("");
        FldPassword.setText("");
    }
}