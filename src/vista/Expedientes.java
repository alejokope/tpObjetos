package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import javax.swing.JList;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controllers.ExpedientesController;
import controllers.VillanosController;
import modelo.Persona;
import modelo.Villano;
import viewmodel.ExpedientesViewModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class Expedientes extends JFrame {

	private JPanel contentPane;
	private ExpedientesViewModel modelo;
	private JLabel lblAquiSexo ;
	private JLabel lblAquiNombre ;
	private JList<String> listSenia= new JList<String>();
	private JList<String> listHobbies= new JList<String>();
	private JPanel pfoto;
	private String nombreDetective;
	
	public void setNombreJugador(String nombreDetective) {
		this.nombreDetective = nombreDetective;
	}
	

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
		setBounds(100, 100, 778, 599);
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
		listVillano.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 2), "villanos", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		listVillano.setBounds(0, 0, 243, 515);
		listVillano.setPreferredSize(new Dimension(200, 200));
		listVillano.setModel(new ExpedientesController(modelo).getVillanos());
		listVillano.setCellRenderer(new VillanosCell());
		pLista.add(listVillano);
		
		listVillano.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Persona villano = listVillano.getSelectedValue();
				if(villano!= null) {
					seSelecciona(villano);
				}
				
			}
			private void seSelecciona(Persona villano) {
			modelo.setVillanoSeleccionado(villano);
			lblAquiNombre.setText(villano.getNombre());
			lblAquiSexo.setText(villano.getSexo());
			listSenia.setModel(new VillanosController(modelo).getCaracteristicasVillanoSeleccionado());
			listHobbies.setModel(new VillanosController(modelo).getHobbiesVillanoSeleccionado());
			//pfoto.set
			
			
		}
		});
		

		pfoto = new JPanel();
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
		
		lblAquiNombre = new JLabel("aqui nombre");
		lblAquiNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblAquiNombre.setHorizontalTextPosition(SwingConstants.CENTER);
		pNombreSexo.add(lblAquiNombre);
		
		JLabel lblSexo = new JLabel("sexo");
		lblSexo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pNombreSexo.add(lblSexo);
		
		lblAquiSexo = new JLabel("aqui sexo");
		lblAquiSexo.setHorizontalAlignment(SwingConstants.CENTER);
		pNombreSexo.add(lblAquiSexo);
		
		JPanel pDatos = new JPanel();
		contentPane.add(pDatos);
		pDatos.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel pSenialParticulares= new JPanel();
		pDatos.add(pSenialParticulares);
		pSenialParticulares.setLayout(null);

		listSenia.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 2), "Senia", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		listSenia.setBounds(0, 13, 256, 252);
		listSenia.setPreferredSize(new Dimension(200, 200));
		pSenialParticulares.add(listSenia);
		
		JPanel pHobbies = new JPanel();
		pDatos.add(pHobbies);
		pHobbies.setLayout(null);
		
		listHobbies = new JList();
		listHobbies.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 2), "Hobbies", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		listHobbies.setPreferredSize(new Dimension(200, 200));
		listHobbies.setBounds(0, 0, 244, 223);
		pHobbies.add(listHobbies);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PaginaDeInicio pantallaDeInicio = new PaginaDeInicio();
                pantallaDeInicio.setVisible(true);
                pantallaDeInicio.setNombreJugador(nombreDetective);
                setVisible(false);
                dispose();
			}
		});
		btnAtras.setBounds(75, 231, 97, 25);
		pHobbies.add(btnAtras);
	}
}
