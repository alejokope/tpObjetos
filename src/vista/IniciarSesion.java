package vista;

import modelo.DataDummy;
import modelo.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class IniciarSesion extends JFrame {

	private JPanel iniciarSesionPanel = new JPanel();
	private DataDummy dataDummy = new DataDummy();
    private JTextField nombreIngresadoTextField;
    private JPasswordField contraseniaIngresadaTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IniciarSesion frame = new IniciarSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IniciarSesion() {
		setTitle("Ingrese sus datos, detective.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(400,300);
        setSize(500,500);
        iniciarSesionPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(iniciarSesionPanel);
		iniciarSesionPanel.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel nombrePanel = new JPanel();
		iniciarSesionPanel.add(nombrePanel);
		nombrePanel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel nombreLabel = new JLabel("Nombre:");
		nombrePanel.add(nombreLabel);
		
		nombreIngresadoTextField = new JTextField();
		nombrePanel.add(nombreIngresadoTextField);
		nombreIngresadoTextField.setColumns(10);
		
		JPanel contraseniaPanel = new JPanel();
		iniciarSesionPanel.add(contraseniaPanel);
		contraseniaPanel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel contraseniaLabel = new JLabel("Contrasenia:");
		contraseniaPanel.add(contraseniaLabel);
		
		contraseniaIngresadaTextField = new JPasswordField();
		contraseniaPanel.add(contraseniaIngresadaTextField);
		
		JPanel botonPanel = new JPanel();
		iniciarSesionPanel.add(botonPanel);
		botonPanel.setLayout(new BorderLayout(0, 0));
		
		JButton aceptarButton = new JButton("Aceptar");
		botonPanel.add(aceptarButton, BorderLayout.SOUTH);
		
		aceptarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if(dataDummy.esUnUsuarioValido(nombreIngresadoTextField, contraseniaIngresadaTextField)){
                    dataDummy.setJugadorAsignado(dataDummy.obtenerJugadorAsignado(contraseniaIngresadaTextField));
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
