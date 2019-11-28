package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Caso;
import modelo.DataDummy;
import modelo.Jugador;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PresentacionDelCasoE extends JDialog {
	
	private DataDummy dataDummy;
	private final JPanel detalleDelCasoPanel = new JPanel();
	private Jugador jugador;
	private JTextField textRelato;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PresentacionDelCasoE frame = new PresentacionDelCasoE();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the dialog.
	 */
	public PresentacionDelCasoE() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				Caso caso = dataDummy.obtenerCasoAlAzar();
				textRelato.setText(caso.getReporte());
			}
		});
		setResizable(false);
		setBounds(100, 100, 500, 500);
		getContentPane().setLayout(new BorderLayout());
		detalleDelCasoPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(detalleDelCasoPanel, BorderLayout.CENTER);
		detalleDelCasoPanel.setLayout(null);		
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 56, 434, 349);
		detalleDelCasoPanel.add(panel);
		panel.setLayout(null);
		
		textRelato = new JTextField();
		textRelato.setEditable(false);
		textRelato.setBounds(0, 0, 434, 349);
		panel.add(textRelato);
		textRelato.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton elegirOtroButton = new JButton("Elegir otro");
				elegirOtroButton.setActionCommand("OK");
				elegirOtroButton.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent actionEvent) {
		            	Caso otroCaso = dataDummy.obtenerCasoAlAzar();
		            	textRelato.setText(otroCaso.getReporte());
		            }

		        });
				buttonPane.add(elegirOtroButton);
				getRootPane().setDefaultButton(elegirOtroButton);
			}
			{
				JButton aceptarElCasoButton = new JButton("Aceptar el caso");
				aceptarElCasoButton.setActionCommand("OK");
				buttonPane.add(aceptarElCasoButton);
			}
		}
	}
	
	/*
	 * private void recargarCaso(Jugador jugador) { dataDummy = new DataDummy();
	 * dataDummy.setJugadorAsignado(jugador); dataDummy.obtenerCasoAlAzar();
	 * setTitle(dataDummy.obtenerTituloDelCasoAsignado());
	 * 
	 * JLabel SaludoLabel = new JLabel("Detective " + jugador.getNombre() +
	 * ", tenemos un caso para usted!"); SaludoLabel.setFont(new Font("Tahoma",
	 * Font.PLAIN, 16)); SaludoLabel.setBounds(28, 11, 364, 14);
	 * detalleDelCasoPanel.add(SaludoLabel); }
	 * 
	 * private void refrescar(){
	 * SwingUtilities.updateComponentTreeUI(detalleDelCasoPanel); }
	 */
}