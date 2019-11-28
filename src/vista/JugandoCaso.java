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
import javax.swing.UIManager;
import java.awt.Color;

public class JugandoCaso extends JFrame {

	private JPanel contentPane;

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
		
		JLabel lblPais = new JLabel("PAIS");
		pArriba.add(lblPais);
		
		JPanel pCentro = new JPanel();
		pCentro.setPreferredSize(new Dimension(700, 400));
		contentPane.add(pCentro);
		pCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pLugares = new JPanel();
		pLugares.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lugares para visitar", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
	}
}
