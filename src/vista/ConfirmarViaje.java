package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viewmodel.ResolviendoElCasoViewModel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmarViaje extends JFrame {

	private JPanel confirmarViajePanel;

	public ConfirmarViaje(ResolviendoElCasoViewModel modelo) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		confirmarViajePanel = new JPanel();
		confirmarViajePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(confirmarViajePanel);
		confirmarViajePanel.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel mensajeConfirmarViajePanel = new JPanel();
		confirmarViajePanel.add(mensajeConfirmarViajePanel);
		
		JLabel mensajeLabel = new JLabel("Desea viajar a este pais?");
		mensajeConfirmarViajePanel.add(mensajeLabel);
		
		JPanel botonesConfirmarViajePanel = new JPanel();
		confirmarViajePanel.add(botonesConfirmarViajePanel);
		
		JButton siButton = new JButton("Si");
		siButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelo.jugadorViajoAPaisSeleccionado();
				dispose();
			}
		});
		botonesConfirmarViajePanel.add(siButton);
		
		JButton noButton = new JButton("No");
		noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		botonesConfirmarViajePanel.add(noButton);
	}

}
