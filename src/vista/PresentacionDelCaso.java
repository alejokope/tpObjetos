package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.*;
import viewmodel.PresentacionCasoViewModel;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class PresentacionDelCaso extends JDialog {
	private JPanel detalleDelCasoPanel = new JPanel();
	private JTextArea relatoText;
	private JLabel saludoLabel;

	private PresentacionCasoViewModel modelo = new PresentacionCasoViewModel();
	
	public PresentacionDelCaso(Jugador jugador) {
	    iniciarPresentacionDelCaso(jugador);
	    
	    setVisible(true);
		setResizable(false);
		setBounds(550, 280, 500, 500);
		getContentPane().setLayout(new BorderLayout());
		detalleDelCasoPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(detalleDelCasoPanel, BorderLayout.CENTER);
		setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/imagenes/iconosombrero.png")));

		detalleDelCasoPanel.setLayout(null);
		
		saludoLabel = new JLabel();
		saludoLabel.setBounds(28, 11, 434, 34);
		detalleDelCasoPanel.add(saludoLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 56, 434, 349);
		detalleDelCasoPanel.add(panel);
		panel.setLayout(null);
		
		relatoText = new JTextArea();
		relatoText.setBounds(0, 0, 434, 349);
		panel.add(relatoText);
		relatoText.setColumns(10);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
				
		mostrarCaso(modelo);
		
		JButton elegirOtroButton = new JButton("Elegir otro");
		elegirOtroButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pedirOtroCaso(modelo);
				SwingUtilities.updateComponentTreeUI(detalleDelCasoPanel);
				mostrarCaso(modelo);
				}
			});
		buttonPane.add(elegirOtroButton);
		getRootPane().setDefaultButton(elegirOtroButton);
				
		JButton aceptarElCasoButton = new JButton("Aceptar el caso");
		aceptarElCasoButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JugandoCaso siguienteVista= new JugandoCaso(modelo.getCasoAJugar(),jugador);
			siguienteVista.setVisible(true);
			setVisible(false);
			}
		});
		aceptarElCasoButton.setActionCommand("OK");
		buttonPane.add(aceptarElCasoButton);
	}	

	public void iniciarPresentacionDelCaso(Jugador jugador) {
		modelo.setJugador(jugador);
	}
	
	public void mostrarCaso(PresentacionCasoViewModel modelo) {
		setTitle(modelo.getTitulo());
		saludoLabel.setText("Detective " + modelo.getNombreDetective() + ", tenemos unos casos para ti.");
    	relatoText.setText(modelo.getReporte());
	}
	
	public void pedirOtroCaso(PresentacionCasoViewModel modelo) {
		modelo.obtenerOtroCaso();
	}
	
	public String mostrarTitulo() {
		return getTitle();
	}
	
	public String mostrarSaludo() {
		return saludoLabel.getText();
	}
	
	public String mostrarRelato() {
		return relatoText.getText();
	}
}