package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;

import Extras.ResolviendoElCaso;
import modelo.Caso;
import viewmodel.ResolviendoElCasoViewModel;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollBar;

public class JugandoCaso extends JFrame {

	private JPanel contentPane;
	private ResolviendoElCasoViewModel modelo;
	
	
	public void agregarCasoAlmodelo(Caso caso) {
		modelo.setCaso(caso);
	}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					JugandoCaso frame = new JugandoCaso();
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
	public JugandoCaso() {
		modelo=new ResolviendoElCasoViewModel();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pArriba = new JPanel();
		pArriba.setBorder(new EmptyBorder(10, 10, 10, 10));
		pArriba.setPreferredSize(new Dimension(450, 50));
		contentPane.add(pArriba);
		
		JLabel lblEstasEn = new JLabel("Estas En :");
		pArriba.add(lblEstasEn);
		
		JLabel lblPais = new JLabel();
		lblPais.setText(modelo.getPaisDeOrigen().getNombre());
		
	
		
		pArriba.add(lblPais);
		
		JPanel pCentro = new JPanel();
		pCentro.setPreferredSize(new Dimension(700, 400));
		contentPane.add(pCentro);
		pCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pLugares = new JPanel();
		pLugares.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lugares a visitar", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pCentro.add(pLugares);
		pLugares.setLayout(new BorderLayout(0, 0));
		
		JPanel pBotonera = new JPanel();
		pBotonera.setBorder(new EmptyBorder(30, 30, 30, 30));
		pLugares.add(pBotonera, BorderLayout.CENTER);
		pBotonera.setLayout(new GridLayout(5, 0, 0, 3));
		
		JButton btnLugar = new JButton("Lugar1");
		btnLugar.setBorder(new EmptyBorder(10, 10, 10, 10));
		pBotonera.add(btnLugar);
		
		JLabel label = new JLabel("");
		pBotonera.add(label);
		
		JButton btnLugar_1 = new JButton("Lugar2");
		pBotonera.add(btnLugar_1);
		
		JLabel lblNewLabel = new JLabel("\r\n");
		pBotonera.add(lblNewLabel);
		
		JButton btnLugar_2 = new JButton("lugar3");
		pBotonera.add(btnLugar_2);
		
		JPanel pAcionesArealizar = new JPanel();
		pAcionesArealizar.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Acciones para realizar", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pCentro.add(pAcionesArealizar);
		pAcionesArealizar.setLayout(new BorderLayout(0, 0));
		
		
		JPanel pbotoneraAcciones = new JPanel();
		pbotoneraAcciones.setBorder(new EmptyBorder(30, 30, 30, 30));
		pAcionesArealizar.add(pbotoneraAcciones);
		pbotoneraAcciones.setLayout(new GridLayout(5, 0, 0, 3));
		
		JButton btnEmitirOrdenArresto = new JButton("Emitir Orden Arresto");
		pbotoneraAcciones.add(btnEmitirOrdenArresto);
		
		JLabel lOrdenDeArresto = new JLabel("");
		pbotoneraAcciones.add(lOrdenDeArresto);
		
		JButton btnViajar = new JButton("Viajar");
		pbotoneraAcciones.add(btnViajar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		pbotoneraAcciones.add(lblNewLabel_1);
		
		JButton btnExpedientes = new JButton("Expedientes");
		pbotoneraAcciones.add(btnExpedientes);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(600, 125));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JScrollPane spRecorrido = new JScrollPane();
		spRecorrido.setBorder(new TitledBorder(null, "Recorrido acertado", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.add(spRecorrido);
		
		JList lstRecorridoAcertado = new JList();
		spRecorrido.setRowHeaderView(lstRecorridoAcertado);
		
		JScrollBar scrollBar = new JScrollBar();
		spRecorrido.setViewportView(scrollBar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Recorrido incorrecto", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.add(scrollPane);
		
		JList listRecorridoErroneo = new JList();
		scrollPane.setRowHeaderView(listRecorridoErroneo);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollPane.setViewportView(scrollBar_1);
	}
}
