package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JList;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cell.VillanosCell;
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
	
	public Expedientes() {
		setTitle("Expepedientes! puedes ver a los criminales mas peligrosos!");
		modelo = new ExpedientesViewModel();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 280, 778, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/imagenes/iconosombrero.png")));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel pLista = new JPanel();
		contentPane.add(pLista);
		pLista.setLayout(null);
		 
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
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		pNombreSexo.add(lblNombre);
		
		lblAquiNombre = new JLabel("Aqui nombre:");
		lblAquiNombre.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAquiNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAquiNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblAquiNombre.setHorizontalTextPosition(SwingConstants.CENTER);
		pNombreSexo.add(lblAquiNombre);
		
		JLabel lblSexo = new JLabel("Sexo: ");
		lblSexo.setVerticalAlignment(SwingConstants.TOP);
		lblSexo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pNombreSexo.add(lblSexo);
		
		lblAquiSexo = new JLabel("Aqui sexo: ");
		lblAquiSexo.setVerticalAlignment(SwingConstants.TOP);
		lblAquiSexo.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
                setVisible(false);
                dispose();
			}
		});
		
		btnAtras.setBounds(75, 231, 97, 25);
		pHobbies.add(btnAtras);
	}
}
