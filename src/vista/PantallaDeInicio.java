package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Jugador;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

public class PantallaDeInicio extends JFrame {

	private final JPanel pantallaDeInicioPanel = new JPanel();

	public PantallaDeInicio(Jugador jugador) {
		setTitle("¿Donde esta Carmen Sandiego?");
		setContentPane(pantallaDeInicioPanel);
		pantallaDeInicioPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		pantallaDeInicioPanel.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel bienvenidaLabel = new JLabel("Que haremos ahora detective?");
		pantallaDeInicioPanel.add(bienvenidaLabel);
		
		JPanel botonesPanel = new JPanel();
		pantallaDeInicioPanel.add(botonesPanel);
		botonesPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton resolverElMisterioButton = new JButton("Resolver el misterio");
		botonesPanel.add(resolverElMisterioButton);
		
		JButton expedientesButton = new JButton("Expedientes");
		botonesPanel.add(expedientesButton);
		setLocation(400,400);
        setSize(500,255);
        setVisible(true);
        resolverElMisterioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                PresentacionDelCaso presentacionDelCaso = new PresentacionDelCaso(jugador);
            }
        });
		
	}
}

