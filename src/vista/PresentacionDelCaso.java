package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import modelo.CarmenSanDiegoMaster;
import modelo.DataDummy;
import modelo.Jugador;
import viewmodel.ResolviendoElCasoViewModel;

import java.awt.GridLayout;

public class PresentacionDelCaso extends JFrame {

	private JPanel presentacionDelCasoPanel = new JPanel();
	JLabel saludoLabel = new JLabel();
	JTextArea reporteTextArea = new JTextArea();
	
	private DataDummy dataDummy;
    

	public PresentacionDelCaso(Jugador jugador) {
		recargarCaso(jugador);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(350,150);
        setSize(650,600);
        presentacionDelCasoPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(presentacionDelCasoPanel);
		presentacionDelCasoPanel.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel saludoPanel = new JPanel();
		presentacionDelCasoPanel.add(saludoPanel);
		saludoPanel.setLayout(new BorderLayout(0, 0));
		
		saludoLabel.setText("Detective " + jugador.getNombre() + "tenemos un caso para usted!");
		saludoPanel.add(saludoLabel);
		
		JPanel reportePanel = new JPanel();
		presentacionDelCasoPanel.add(reportePanel);
		
		reportePanel.add(reporteTextArea);
		
		JPanel botonesPanel = new JPanel();
		presentacionDelCasoPanel.add(botonesPanel);
		botonesPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton elegirOtroButton = new JButton("Elegir otro");
		botonesPanel.add(elegirOtroButton);
		
		JButton aceptarElCasoButton = new JButton("Aceptar el caso");
		botonesPanel.add(aceptarElCasoButton);
		setVisible(true);
		
		elegirOtroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refrescar();
                recargarCaso(jugador);
            }

        });
        aceptarElCasoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            	crearModelo();
            }

			private void crearModelo() {
				CarmenSanDiegoMaster carmenSanDiegoMaster = 
            			new CarmenSanDiegoMaster(dataDummy.getCasoAsignado(), dataDummy.getJugadorAsignado(), dataDummy.getVillanoAsignado());
            	ResolviendoElCasoViewModel modelo = new ResolviendoElCasoViewModel(carmenSanDiegoMaster);
                ResolviendoElCaso resolviendoElCaso = new ResolviendoElCaso(modelo);
			}
        });
        
        
    }
	
	private void recargarCaso(Jugador jugador) {
        dataDummy = new DataDummy();
        dataDummy.setJugadorAsignado(jugador);
        dataDummy.obtenerCasoAlAzar();
        jugador.setPaisActual(dataDummy.getCasoAsignado().getPaisOrigen());
        setTitle(dataDummy.obtenerTituloDelCasoAsignado());
        saludoLabel.setText("Detective " + jugador.getNombre() + ", tenemos un caso para usted!");
        reporteTextArea.setText(dataDummy.obtenerReporteDelCasoAsignado());
        reporteTextArea.setEditable(false);
    }

    private void refrescar(){
         SwingUtilities.updateComponentTreeUI(presentacionDelCasoPanel);
    }
	
	
	
}
	
	


        

    


