package vista;

import modelo.Jugador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PaginaDeInicio extends JFrame {

	private JPanel contentPane;

	public PaginaDeInicio(Jugador jugador) {
		
		setTitle("\u00BFDonde esta CarmenSanDiego?");
		setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/imagenes/iconosombrero.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599,353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100, 50));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JButton btnInvestigar = new JButton("");
		btnInvestigar.setBounds(12, 60, 233, 143);
		btnInvestigar.setIcon(new ImageIcon(PaginaDeInicio.class.getResource("/imagenes/botonInvestigar.png")));
		btnInvestigar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                PresentacionDelCaso pantallaPresentacionCaso= new PresentacionDelCaso(jugador);
				setVisible(false);
				dispose();
			}
		});
		
		panel_1.add(btnInvestigar);
		
		/*JButton btnExpedientes= new JButton("");
		btnInvertigar.setBounds(20, 69, 233, 143);
		panel_1.add(btnExpedientes);
		*/
		JButton btnExpedientes = new JButton("");
		btnExpedientes.setBounds(312, 60, 233, 143);
		btnExpedientes.setIcon(new ImageIcon(PaginaDeInicio.class.getResource("/imagenes/botonexpedientes.png")));
		btnExpedientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Expedientes pantallaExpedientes = new Expedientes();
				pantallaExpedientes.setNombreJugador(jugador.getNombre());
				pantallaExpedientes.setVisible(true);
			}
		});
		panel_1.add(btnExpedientes);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				JLabel jEnc= new JLabel();
				jEnc.setText("Que haremos hoy detective "+jugador.getNombre()+"?");
				jEnc.setHorizontalAlignment(SwingConstants.CENTER);
				jEnc.setHorizontalTextPosition(SwingConstants.CENTER);
				jEnc.setFont(new Font("Tahoma", Font.PLAIN, 23));
				panel.add(jEnc);				
			}
		});
	}
}
