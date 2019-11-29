package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import modelo.DataDummy;
import viewmodel.SingletonDataDummy;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IniciarSecion extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField textContrasenia;
	private DataDummy dataDummy = SingletonDataDummy.getInstance();
	private String nombreDetective;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IniciarSecion frame = new IniciarSecion();
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
	public IniciarSecion() {
		setResizable(false);
		setTitle("Bienvenid@");
		setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSecion.class.getResource("/imagenes/iconosombrero.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pArriba = new JPanel();
		pArriba.setFont(new Font("Tahoma", Font.PLAIN, 26));
		pArriba.setPreferredSize(new Dimension(200, 100));
		pArriba.setMinimumSize(new Dimension(200, 100));
		contentPane.add(pArriba, BorderLayout.NORTH);
		pArriba.setLayout(null);
		
		JLabel lTitulo = new JLabel("BIENVENID@ AL JUEGO: DONDE ESTA CARMEN SAN DIEGO?");
		lTitulo.setBounds(12, 26, 651, 42);
		lTitulo.setHorizontalTextPosition(SwingConstants.CENTER);
		lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lTitulo.setFont(new Font("Eras Medium ITC", Font.PLAIN, 23));
		pArriba.add(lTitulo);
		
		JPanel pCentral = new JPanel();
		contentPane.add(pCentral, BorderLayout.CENTER);
		pCentral.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pUsuarioL = new JPanel();
		pCentral.add(pUsuarioL);
		pUsuarioL.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pNombre = new JPanel();
		pNombre.setPreferredSize(new Dimension(342, 170));
		pUsuarioL.add(pNombre);
		pNombre.setLayout(null);
		
		JLabel lblNombre = new JLabel("Usuario");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setPreferredSize(new Dimension(50, 50));
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNombre.setBounds(72, 49, 169, 50);
		pNombre.add(lblNombre);
		
		JPanel pUsuarioR = new JPanel();
		pUsuarioR.setPreferredSize(new Dimension(342, 220));
		pCentral.add(pUsuarioR);
		
		JPanel pTxtUsuario = new JPanel();
		pTxtUsuario.setPreferredSize(new Dimension(342, 220));
		pUsuarioR.add(pTxtUsuario);
		pTxtUsuario.setLayout(null);
		
		textUsuario = new JTextField();
		textUsuario.setBorder(new EmptyBorder(10, 10, 10, 10));
		textUsuario.setBounds(32, 60, 259, 44);
		pTxtUsuario.add(textUsuario);
		textUsuario.setColumns(10);
		
		JPanel pContraseniaL = new JPanel();
		pCentral.add(pContraseniaL);
		pContraseniaL.setLayout(null);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(100, 51, 166, 51);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		pContraseniaL.add(lblContrasea);
		
		JPanel pContraseniR = new JPanel();
		pCentral.add(pContraseniR);
		pContraseniR.setLayout(null);
		
		textContrasenia = new JPasswordField();//sadlj
		textContrasenia.setBounds(32, 60, 259, 44);
		textContrasenia.setColumns(10);
		textContrasenia.setBorder(new EmptyBorder(10, 10, 10, 10));
		pContraseniR.add(textContrasenia);
		
		JPanel panel = new JPanel();//DKJLDASJ
		panel.setPreferredSize(new Dimension(100, 100));
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(null);
		
		JButton btnJugar = new JButton("");
		btnJugar.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnJugar.setBounds(225, 5, 184, 82);
		btnJugar.setIcon(new ImageIcon(IniciarSecion.class.getResource("/imagenes/botonJugarGrande.png")));
		panel.add(btnJugar);
		btnJugar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(dataDummy.esUnUsuarioValido(textUsuario,textContrasenia)) {
					nombreDetective = textUsuario.getText().toString();
	                PaginaDeInicio pantallaDeInicio = new PaginaDeInicio(dataDummy.obtenerJugadorAsignado(textUsuario));
	                pantallaDeInicio.setVisible(true);
	                setVisible(false);
	                dispose();
				}
				else {
					JOptionPane.showMessageDialog(contentPane,"Debe ingresar un usuario valido!");
					
					//
				}				
			}
		});
	}
}
