package vista;

import javax.swing.*;

public class IniciarSesion extends JFrame {

    private JPanel iniciarSesionPanel;
    private JPasswordField contraseniaPasswordField;
    private JTextField nombreTextField;
    private JButton aceptarButton;
    private JLabel nombreLabel;
    private JLabel contraseniaLabel;

    public static void main(String[] args) {
        IniciarSesion iniciarSesion = new IniciarSesion();

    }

    public IniciarSesion(){
        setTitle("Ingrese sus datos");
        setContentPane(iniciarSesionPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
