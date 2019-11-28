package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PaginaDeInicio extends JFrame {

	private JPanel contentPane;
	private String nombreJugador;
	private JLabel jEnc= new JLabel();
	
	public void setNombreJugador(String nombreDetective) {
		nombreJugador = nombreDetective;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaDeInicio frame = new PaginaDeInicio();
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
	public PaginaDeInicio() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				
				jEnc.setText("¿Que haremos hoy detective "+nombreJugador+"?");
				
			}
			
			
		});
		setTitle("\u00BFDonde esta CarmenSanDiego?");
		setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSecion.class.getResource("/imagenes/iconosombrero.png")));
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
		
		jEnc.setHorizontalAlignment(SwingConstants.CENTER);
		jEnc.setHorizontalTextPosition(SwingConstants.CENTER);
		jEnc.setFont(new Font("Tahoma", Font.PLAIN, 23));
		panel.add(jEnc);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JButton btnInvertigar = new JButton("");
		btnInvertigar.setBounds(12, 60, 233, 143);
		btnInvertigar.setIcon(new ImageIcon(PaginaDeInicio.class.getResource("/imagenes/botonInvestigar.png")));
		
		panel_1.add(btnInvertigar);
		
		/*JButton btnExpedientes= new JButton("");
		btnInvertigar.setBounds(20, 69, 233, 143);
		panel_1.add(btnExpedientes);
		*/
		JButton btnExpedientes = new JButton("");
		btnExpedientes.setBounds(312, 60, 233, 143);
		btnExpedientes.setIcon(new ImageIcon(PaginaDeInicio.class.getResource("/imagenes/botonexpedientes.png")));
		panel_1.add(btnExpedientes);
	}
}
