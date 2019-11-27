package viewmodel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JList;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;

import controllers.ExpedientesController;
import modelo.Persona;
import modelo.Villano;

import java.awt.Color;
import javax.swing.JButton;

public class Expedientes extends JFrame {

	private JPanel contentPane;
	private ExpedientesViewModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Expedientes frame = new Expedientes();
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
	public Expedientes() {
		modelo = new ExpedientesViewModel();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel pLista = new JPanel();
		contentPane.add(pLista);
		pLista.setLayout(null);
		/*
		 * 
		 * 
		 * SE TIENE QUE CAMBIAR EN VES DE PERSONA POR VILLANO
		 * 
		 * */
		 
		JList<Persona> listVillano = new JList<Persona>();
		listVillano.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		listVillano.setBounds(0, 46, 354, 629);
		listVillano.setPreferredSize(new Dimension(200, 200));
		pLista.add(listVillano);
		listVillano.setModel(new ExpedientesController(modelo).getVillanos());
		
		JLabel lblVillanos = new JLabel("Villanos");
		lblVillanos.setHorizontalAlignment(SwingConstants.CENTER);
		lblVillanos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVillanos.setBounds(89, 0, 132, 33);
		pLista.add(lblVillanos);
		
		JPanel pfoto = new JPanel();
		contentPane.add(pfoto);
		pfoto.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel pFotoVillano = new JPanel();
		pfoto.add(pFotoVillano);
		
		JPanel pNombreSexo = new JPanel();
		pfoto.add(pNombreSexo);
		pNombreSexo.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		pNombreSexo.add(lblNombre);
		
		JLabel lblAquiNombre = new JLabel("aqui nombre");
		lblAquiNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblAquiNombre.setHorizontalTextPosition(SwingConstants.CENTER);
		pNombreSexo.add(lblAquiNombre);
		
		JLabel lblSexo = new JLabel("sexo");
		lblSexo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pNombreSexo.add(lblSexo);
		
		JLabel lblAquiSexo = new JLabel("aqui sexo");
		lblAquiSexo.setHorizontalAlignment(SwingConstants.CENTER);
		pNombreSexo.add(lblAquiSexo);
		
		JPanel pDatos = new JPanel();
		contentPane.add(pDatos);
		pDatos.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel pSeñalParticulares = new JPanel();
		pDatos.add(pSeñalParticulares);
		pSeñalParticulares.setLayout(null);
		
		JList listsenia = new JList();
		listsenia.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		listsenia.setBounds(0, 13, 342, 311);
		listsenia.setPreferredSize(new Dimension(200, 200));
		pSeñalParticulares.add(listsenia);
		
		JPanel pHobbies = new JPanel();
		pDatos.add(pHobbies);
		pHobbies.setLayout(null);
		
		JList listhobbies = new JList();
		listhobbies.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		listhobbies.setPreferredSize(new Dimension(200, 200));
		listhobbies.setBounds(0, 13, 342, 279);
		pHobbies.add(listhobbies);
		
		JButton btnAtras = new JButton("atras");
		btnAtras.setBounds(209, 305, 97, 25);
		pHobbies.add(btnAtras);
	}
}
