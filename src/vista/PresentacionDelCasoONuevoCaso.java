package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.CarmenSanDiegoMaster;
import modelo.DataDummy;
import modelo.Jugador;
import viewmodel.InvestigarViewModel;

import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class PresentacionDelCasoONuevoCaso extends JFrame {

	private JPanel contentPane;
	private JButton btnIrAinvestigar;
	private JButton btnOtroCaso;
	private DataDummy dataDummy;
	private CarmenSanDiegoMaster carmenSanDiegoMaster;
	private JLabel lCaso;
	private InvestigarViewModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PresentacionDelCasoONuevoCaso frame = new PresentacionDelCasoONuevoCaso();
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
	public PresentacionDelCasoONuevoCaso() {
		
		modelo= new InvestigarViewModel();
		
		setTitle(modelo.getTituloDummy());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pCentro = new JPanel();
		contentPane.add(pCentro, BorderLayout.CENTER);
		
		lCaso = new JLabel("aca va el caso");
		pCentro.add(lCaso);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(20);
		panel.setPreferredSize(new Dimension(200, 100));
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnIrAinvestigar = new JButton("Ir aInvestigar");
		panel.add(btnIrAinvestigar);
		
		btnOtroCaso = new JButton("Otro Caso");
		panel.add(btnOtroCaso);
		
	}
 /*   private void recargarCaso() {
        dataDummy = new DataDummy();
      //  dataDummy.setJugadorAsignado(jugador);
        dataDummy.obtenerCasoAlAzar();
        setTitle(dataDummy.obtenerTituloDelCasoAsignado());
        //saludoLabel.setText("Detective " + jugador.getNombre() + ", tenemos un caso para usted!");
        lCaso.setText(dataDummy.obtenerReporteDelCasoAsignado());
  
    }*/

}
