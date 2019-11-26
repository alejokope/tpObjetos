package viewmodel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JList;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

public class expedientes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					expedientes frame = new expedientes();
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
	public expedientes() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel pLista = new JPanel();
		contentPane.add(pLista);
		pLista.setLayout(null);
		
		JList list = new JList();
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setBounds(0, 0, 354, 675);
		list.setPreferredSize(new Dimension(200, 200));
		pLista.add(list);
		
		JPanel pfoto = new JPanel();
		contentPane.add(pfoto);
		pfoto.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel pFotoVillano = new JPanel();
		pfoto.add(pFotoVillano);
		
		JPanel pNombreSexo = new JPanel();
		pfoto.add(pNombreSexo);
		pNombreSexo.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		pNombreSexo.add(lblNombre);
		
		JLabel lblAquiNombre = new JLabel("aqui nombre");
		lblAquiNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblAquiNombre.setHorizontalTextPosition(SwingConstants.CENTER);
		pNombreSexo.add(lblAquiNombre);
		
		JLabel lblSexo = new JLabel("sexo");
		lblSexo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pNombreSexo.add(lblSexo);
		
		JLabel lblAquiSexo = new JLabel("aqui sexo");
		lblAquiSexo.setHorizontalAlignment(SwingConstants.CENTER);
		pNombreSexo.add(lblAquiSexo);
		
		JPanel pDatos = new JPanel();
		contentPane.add(pDatos);
		pDatos.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel pSeñalParticulares = new JPanel();
		pDatos.add(pSeñalParticulares);
		pSeñalParticulares.setLayout(null);
		
		JList list_1 = new JList();
		list_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		list_1.setBounds(0, 13, 354, 311);
		list_1.setPreferredSize(new Dimension(200, 200));
		pSeñalParticulares.add(list_1);
		
		JPanel pHobbies = new JPanel();
		pDatos.add(pHobbies);
		pHobbies.setLayout(null);
		
		JList list_2 = new JList();
		list_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		list_2.setPreferredSize(new Dimension(200, 200));
		list_2.setBounds(0, 13, 342, 279);
		pHobbies.add(list_2);
		
		JButton btnAtras = new JButton("atras");
		btnAtras.setBounds(209, 305, 97, 25);
		pHobbies.add(btnAtras);
	}
}
