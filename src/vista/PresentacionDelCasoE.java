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
import viewmodel.SingletonDataDummy;

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
import javax.swing.JTextArea;

public class PresentacionDelCasoE extends JDialog {
	private final JPanel detalleDelCasoPanel = new JPanel();
	private JTextArea relatoText;
	private JLabel SaludoLabel;
	//private SingletonDataDummy dataDummy;
	private Caso casoActual;
	private String nombreDetective;
		
	public void iniciarPresentacionDelCaso(String nombreDetective) {
		this.nombreDetective = nombreDetective;
    	mostrarCaso();
    	this.setVisible(true);
	}
	
	private void mostrarCaso() {
    	casoActual = SingletonDataDummy.getInstance().obtenerCasoAlAzar();
    	
    	this.relatoText.setText(casoActual.getReporte());
    	this.setTitle(casoActual.getTitulo());
    	this.SaludoLabel.setText("Detective " + nombreDetective + ", tenemos unos casos para ti.");
	}

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
			public void windowActivated(WindowEvent e) {
				mostrarCaso();
			}
		});
		setResizable(false);
		setBounds(100, 100, 500, 500);
		getContentPane().setLayout(new BorderLayout());
		detalleDelCasoPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(detalleDelCasoPanel, BorderLayout.CENTER);
		detalleDelCasoPanel.setLayout(null);		
		{
			SaludoLabel = new JLabel();
			SaludoLabel.setBounds(28, 11, 434, 34);
			detalleDelCasoPanel.add(SaludoLabel);
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 56, 434, 349);
		detalleDelCasoPanel.add(panel);
		panel.setLayout(null);
		
		relatoText = new JTextArea();
		relatoText.setFont(new Font("Monospaced", Font.PLAIN, 14));
		relatoText.setBounds(0, 0, 434, 349);
		panel.add(relatoText);
		relatoText.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton elegirOtroButton = new JButton("Elegir otro");
				elegirOtroButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						mostrarCaso();
					}
		        });
				buttonPane.add(elegirOtroButton);
				getRootPane().setDefaultButton(elegirOtroButton);
				
			}
			{
				JButton aceptarElCasoButton = new JButton("Aceptar el caso");
				aceptarElCasoButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JugandoCaso siguienteVista= new JugandoCaso();
						siguienteVista.setVisible(true);
						siguienteVista.agregarCasoAlmodelo(casoActual);
						setVisible(false);
						dispose();
					}
				});
				aceptarElCasoButton.setActionCommand("OK");
				buttonPane.add(aceptarElCasoButton);
				
					
			}
		}
	}
}
