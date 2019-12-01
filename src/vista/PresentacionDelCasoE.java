package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.*;
import viewmodel.PresentacionCasoViewModel;
import viewmodel.SingletonDataDummy;

import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextArea;

public class PresentacionDelCasoE extends JDialog {
	private final JPanel detalleDelCasoPanel = new JPanel();
	private JTextArea relatoText;
	private JLabel SaludoLabel;
/*
 * le creamos el primer modelview
 */
	private PresentacionCasoViewModel modelo = new PresentacionCasoViewModel();
	
	public void iniciarPresentacionDelCaso(Jugador jugador) {
		modelo.setJugador(jugador);
    	this.setVisible(true);
	}
	
	private void mostrarCaso() {
    	this.relatoText.setText(modelo.getReporte());
    	this.setTitle(modelo.getTitulo());
    	this.SaludoLabel.setText("Detective " + modelo.getNombreDetective() + ", tenemos unos casos para ti.");
	}
	
	/**
	 * Create the dialog.
	 */
	public PresentacionDelCasoE(Jugador jugador) {
	    iniciarPresentacionDelCaso(jugador);
       // System.out.println("----------------------------------");
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

                        JugandoCaso siguienteVista= new JugandoCaso(modelo.getCasoAJugar());
                        siguienteVista.setVisible(true);
						setVisible(false);
					}
				});
				aceptarElCasoButton.setActionCommand("OK");
				buttonPane.add(aceptarElCasoButton);
				
					
			}
		}

        mostrarCaso();
    }
}
