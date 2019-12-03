package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ExpedientesController;
import jdk.nashorn.internal.runtime.ListAdapter;
import modelo.CasoAJugar;
import modelo.DataDummy;
import modelo.Jugador;
import modelo.Persona;
import viewmodel.ExpedientesViewModel;
import viewmodel.ResolviendoElCasoViewModel;
import viewmodel.SingletonDataDummy;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Choice;

public class OrdenDeArresto extends JFrame {

	private JPanel contentPane;
	private JComboBox <Persona>comboBox;
	private ExpedientesViewModel modeloExpedientes = new ExpedientesViewModel();
	private Choice choice;
	private ArrayList<Persona> listaVillanos;
	
	private String nombreVillano;

	public OrdenDeArresto(ResolviendoElCasoViewModel modeloResolviendoElCaso) {
		setTitle("Elige un villano y emite una orden de arresto!");
		addWindowListener(new WindowAdapter() {
			

			@Override
			public void windowActivated(WindowEvent arg0) {
				listaVillanos=modeloExpedientes.getVillanos();
				for(int i=0; i<listaVillanos.size(); i++	) {
					choice.add(listaVillanos.get(i).getNombre());
				}
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/imagenes/iconosombrero.png")));
		setContentPane(contentPane);
		
		JPanel pArriba = new JPanel();
		pArriba.setPreferredSize(new Dimension(20, 50));
		contentPane.add(pArriba, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Contra quien se emitira orden de arresto");
		lblNewLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
		pArriba.add(lblNewLabel);
		
		JPanel pCentro = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pCentro.getLayout();
		flowLayout.setVgap(30);
		flowLayout.setHgap(20);
		pCentro.setBorder(new EmptyBorder(20, 10, 10, 10));
		contentPane.add(pCentro, BorderLayout.CENTER);
		
		JLabel lblVillano = new JLabel("Villano : ");
		pCentro.add(lblVillano);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(250, 40));
		pCentro.add(scrollPane);
		
		choice = new Choice();
		scrollPane.setViewportView(choice);
		
		JButton btnNewButton = new JButton("cancelar");
		btnNewButton.setPreferredSize(new Dimension(170, 25));
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		pCentro.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("aceptar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modeloResolviendoElCaso.getJugador().getSospechoso()==null) {
					String nombreVillano = choice.getItem(choice.getSelectedIndex());
					Persona villano = buscarVillanoEnLaListaDeVillanos(nombreVillano);
					modeloResolviendoElCaso.getJugador().pedirOrdenDeArresto(villano);
					setNombreVillano(nombreVillano);
	                dispose();
				}
				else {
					JOptionPane.showMessageDialog(contentPane,"No puede volver a emitir otra orden de arresto");
				}

			}			
		});
		btnNewButton_1.setPreferredSize(new Dimension(170, 25));
		pCentro.add(btnNewButton_1);
	}
	
	public String getNombreVillano() {
		return nombreVillano;
	}
	
	public void setNombreVillano(String nombreVillano) {
		this.nombreVillano = nombreVillano;
	}
	
	private Persona buscarVillanoEnLaListaDeVillanos(String nombreVillano) {
		Persona villano;
		int i=0;
		while(nombreVillano!=listaVillanos.get(i).getNombre()) {
			i++;
		}
		villano = listaVillanos.get(i);
		return villano;
	}

}
