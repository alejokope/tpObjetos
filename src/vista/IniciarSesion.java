package vista;

import modelo.DataDummy;
import modelo.Usuario;

import javax.swing.*;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class IniciarSesion extends JFrame {

    private DataDummy dataDummy = new DataDummy();
    private JPanel iniciarSesionPanel;
    private JPasswordField contraseniaIngresadaTextField;
    private JButton aceptarButton;
    private JTextField nombreIngresadoTextField;
    private JTextField textField;

    public static void main(String[] args) {
        IniciarSesion iniciarSesion = new IniciarSesion();
        

    }

    public IniciarSesion(){
    	setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/imagenes/iconosombrero.png")));
        setTitle("Ingrese sus datos, detective.");
        iniciarSesionPanel =new JPanel();
        setContentPane(iniciarSesionPanel);
        //setContentPane(iniciarSesionPanel);
        setLocation(400,300);
        setSize(750,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       JPanel pBienvenido = new JPanel();
        pBienvenido.setPreferredSize(new Dimension(100, 100));
        getContentPane().add(pBienvenido, BorderLayout.NORTH);
        pBienvenido.setLayout(null);
        
        JLabel lBienvenida = new JLabel("Bienvenid@ al juego:¿Donde esta Carmen Sandiego?");
        lBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
        lBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lBienvenida.setBounds(12, 13, 708, 74);
        pBienvenido.add(lBienvenida);
        
        JPanel pCentro = new JPanel();
        getContentPane().add(pCentro, BorderLayout.CENTER);
        pCentro.setLayout(new GridLayout(2, 1, 0, 0));
        
        JPanel pUsuario = new JPanel();
        pCentro.add(pUsuario);
        pUsuario.setLayout(new GridLayout(0, 2, 0, 0));
        
        JLabel lblNombre = new JLabel("nombre");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
        pUsuario.add(lblNombre);
        
        JPanel pTextUsuario = new JPanel();
        pUsuario.add(pTextUsuario);
        pTextUsuario.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(35, 87, 295, 43);
        textField.setPreferredSize(new Dimension(250, 100));
        pTextUsuario.add(textField);
        textField.setColumns(10);
        
        JPanel pContraseña = new JPanel();
        pCentro.add(pContraseña);
        setVisible(true);
        aceptarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if(dataDummy.esUnUsuarioValido(nombreIngresadoTextField, contraseniaIngresadaTextField)){
                    dataDummy.setJugadorAsignado(dataDummy.obtenerJugadorAsignado(nombreIngresadoTextField));
                    PantallaDeInicio pantallaDeInicio = new PantallaDeInicio(dataDummy.getJugadorAsignado());
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(iniciarSesionPanel,"Debe ingresar un usuario valido!");
                }
            }
        });
    }
}
