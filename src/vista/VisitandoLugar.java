package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import modelo.CarmenSanDiegoMaster;
import modelo.Caso;
import modelo.Jugador;
import modelo.Pais;
import modelo.Villano;
import modelo.lugarInteres.LugarInteres;
import java.awt.GridLayout;

public class VisitandoLugar extends JFrame {

	private JPanel visitandoLugarPanel;
	private JTextArea pistasTextArea = new JTextArea();
    
    public String obtenerPista(){
        return pistasTextArea.getText();
    }

	public VisitandoLugar(CarmenSanDiegoMaster carmenSanDiegoMaster, LugarInteres lugarInteres) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		visitandoLugarPanel = new JPanel();
		visitandoLugarPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(visitandoLugarPanel);
		visitandoLugarPanel.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel visitandoPanel = new JPanel();
		visitandoLugarPanel.add(visitandoPanel);
		visitandoPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel visitandoLabel = new JLabel("New label");
		visitandoPanel.add(visitandoLabel);
		
		JPanel pistasPanel = new JPanel();
		visitandoLugarPanel.add(pistasPanel);
		pistasPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		pistasPanel.add(pistasTextArea);
		
		JPanel continuarPanel = new JPanel();
		visitandoLugarPanel.add(continuarPanel);
		continuarPanel.setLayout(new BorderLayout(0, 0));
		
		JButton continuarButton = new JButton("Continuar");
		continuarPanel.add(continuarButton, BorderLayout.SOUTH);
		setLocation(350,150);
        setSize(650,600);
        setVisible(true);
        
        Caso caso = carmenSanDiegoMaster.getCaso();
        Villano villano = carmenSanDiegoMaster.getVillano();
        Jugador jugador = carmenSanDiegoMaster.getJugador();
        Pais paisActual = jugador.getPaisActual();
        
        carmenSanDiegoMaster.actualizarEstadoDeMensaje();
        lugarInteres.darPista(jugador);
        
        setTitle("Resolviendo: " + carmenSanDiegoMaster.getCaso().getTitulo());
        visitandoLabel.setText("Estas visitando: " + lugarInteres.informacion());
        pistasTextArea.setText(carmenSanDiegoMaster.getEstadoDeMensaje().mostrarMensaje(carmenSanDiegoMaster,lugarInteres.getAyuda()));
        pistasTextArea.setEditable(false);
	}

}
