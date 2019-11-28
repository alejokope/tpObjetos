package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import modelo.CarmenSanDiegoMaster;
import modelo.Caso;
import modelo.DataDummy;
import modelo.Jugador;
import modelo.Pais;
import modelo.Villano;
import modelo.lugarInteres.Banco;
import modelo.lugarInteres.Biblioteca;
import modelo.lugarInteres.Club;
import modelo.lugarInteres.Embajada;
import modelo.lugarInteres.LugarInteres;
import viewmodel.ResolviendoElCasoViewModel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class ResolviendoElCaso extends JFrame {

	private JPanel resolviendoElCasoPanel;

    private ResolviendoElCasoViewModel modelo;
    private CarmenSanDiegoMaster carmenSanDiegoMaster;
    private Caso caso;
    private Jugador jugador;
    private Villano villano;
    private LugarInteres lugarInteresActual;
    private Pais paisActual;
    

    private void chequearExistenciaDeLugarInteres(LugarInteres otroLugarInteres) {
        lugarInteresActual = modelo.obtenerLugarDeInteres(otroLugarInteres);
        if(lugarInteresActual.informacion() == otroLugarInteres.informacion()){
            modelo.jugadorIngresarA(lugarInteresActual);
            VisitandoLugar visitandoLugar = new VisitandoLugar(carmenSanDiegoMaster, lugarInteresActual);
        }
        else{
            JOptionPane.showMessageDialog(resolviendoElCasoPanel,"Este Lugar de interes no existe en este pais. Intenta otro!");
        }
    }

	public ResolviendoElCaso(ResolviendoElCasoViewModel modelo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(350,150);
        setSize(650,600);
		resolviendoElCasoPanel = new JPanel();
		resolviendoElCasoPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(resolviendoElCasoPanel);
		resolviendoElCasoPanel.setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel paisActualPanel = new JPanel();
		resolviendoElCasoPanel.add(paisActualPanel);
		paisActualPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel paisActualLabel = new JLabel("Estas en: " + modelo.getJugador().getPaisActual());
		paisActualPanel.add(paisActualLabel);
		
		JPanel opcionesPanel = new JPanel();
		resolviendoElCasoPanel.add(opcionesPanel);
		opcionesPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lugaresLabel = new JLabel("Lugares");
		opcionesPanel.add(lugaresLabel);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		opcionesPanel.add(separator);
		
		JLabel accionesLabel = new JLabel("Acciones");
		opcionesPanel.add(accionesLabel);
		
		JButton bibliotecaButton = new JButton("Biblioteca");
		opcionesPanel.add(bibliotecaButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		opcionesPanel.add(separator_1);
		
		JButton ordenDeArrestoButton = new JButton("Orden de Arresto");
		opcionesPanel.add(ordenDeArrestoButton);
		
		JButton bancoButton = new JButton("Banco");
		opcionesPanel.add(bancoButton);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		opcionesPanel.add(separator_2);
		
		JLabel ordenDeArrestoLabel = new JLabel("");
		opcionesPanel.add(ordenDeArrestoLabel);
		
		JButton clubButton = new JButton("Club");
		opcionesPanel.add(clubButton);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		opcionesPanel.add(separator_3);
		
		JButton viajarButton = new JButton("Viajar");
		viajarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Viajar viajar = new Viajar(modelo);
			}
		});
		opcionesPanel.add(viajarButton);
		
		JButton embajadaButton = new JButton("Embajada");
		opcionesPanel.add(embajadaButton);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		opcionesPanel.add(separator_4);
		
		JButton expedientesButton = new JButton("Expedientes");
		opcionesPanel.add(expedientesButton);
		
		JPanel separadorHorizontalPanel = new JPanel();
		resolviendoElCasoPanel.add(separadorHorizontalPanel);
		
		JSeparator separator_5 = new JSeparator();
		separadorHorizontalPanel.add(separator_5);
		
		JPanel viajesPanel = new JPanel();
		resolviendoElCasoPanel.add(viajesPanel);
		viajesPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JList recorridoCriminalList = new JList();
		viajesPanel.add(recorridoCriminalList);
		
		JList destinoFallidosList = new JList();
		viajesPanel.add(destinoFallidosList);
		setVisible(true);
		
		setTitle("Resolviendo: " + modelo.getCaso().getTitulo());

        bibliotecaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                chequearExistenciaDeLugarInteres(new Biblioteca());

            }
        });

        clubButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                chequearExistenciaDeLugarInteres(new Club());
            }

        });

        embajadaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                chequearExistenciaDeLugarInteres(new Embajada());
            }
        });

        bancoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                chequearExistenciaDeLugarInteres(new Banco());
            }
        });
    }
}
	
    


