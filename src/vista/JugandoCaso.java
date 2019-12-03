package vista;

import modelo.CasoAJugar;
import modelo.Jugador;
import modelo.Pais;
import modelo.lugarInteres.LugarInteres;
import viewmodel.LugarInteresViewModel;
import viewmodel.ResolviendoElCasoViewModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import cell.PaisCell;
import controllers.RecorridoController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.WindowAdapter;
import javax.swing.border.LineBorder;

public class JugandoCaso extends JFrame {

	private JPanel contentPane;
	
	
	/*
	 * se crea el segundo modelview 
	 */
	private ResolviendoElCasoViewModel modelo = new ResolviendoElCasoViewModel();
	private JLabel lblPais;
	
	RecorridoController controlador=new RecorridoController(modelo);

	private JList<String> RecorridoVillanoList;


	private JList<String> DestinosFallidosList;

	public JugandoCaso(CasoAJugar caso, Jugador jugador) {
		setTitle("A resolver el caso :D ");
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				if(modelo.estaPaisActualEnPlanEscape()) {
					RecorridoVillanoList.setModel(controlador.paisesCorrectos());
				}
				else {
					DestinosFallidosList.setModel(controlador.paisesIncorrectos());
					
				}
				

			}
		});
        modelo.setCasoAJugar(caso);
        
        setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/imagenes/iconosombrero.png")));

		setContentPane(contentPane);
				
		JPanel pArriba = new JPanel();
		pArriba.setBorder(new EmptyBorder(10, 10, 10, 10));
		pArriba.setPreferredSize(new Dimension(450, 50));
		contentPane.add(pArriba);
		
		JLabel lblEstasEn = new JLabel("Estas En :");
		pArriba.add(lblEstasEn);
		
		lblPais = new JLabel();
		lblPais.setText(modelo.getNombrePaisActual());

		pArriba.add(lblPais);
		
		JPanel pCentro = new JPanel();
		pCentro.setPreferredSize(new Dimension(700, 400));
		contentPane.add(pCentro);
		pCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pLugares = new JPanel();
		pLugares.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 2), "Lugares a visitar", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 128)));
		pCentro.add(pLugares);
		pLugares.setLayout(new BorderLayout(0, 0));
		
		JPanel pBotonera = new JPanel();
		pBotonera.setBorder(new EmptyBorder(30, 30, 30, 30));
		pLugares.add(pBotonera, BorderLayout.CENTER);
		pBotonera.setLayout(new GridLayout(5, 0, 0, 3));
		
		JButton embajadaButton = new JButton("EMBAJADA");
		pBotonera.add(embajadaButton);
		embajadaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				abroVentanaDeLugarInteres(caso, "EMBAJADA");
			}
		});
		
		JButton clubButton = new JButton("CLUB");
		pBotonera.add(clubButton);
		clubButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				abroVentanaDeLugarInteres(caso, "CLUB");
			}
		});
		
		JButton bancoButton = new JButton("BANCO");
		pBotonera.add(bancoButton);
		bancoButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				abroVentanaDeLugarInteres(caso, "BANCO");
			}
		});
		
		JButton bibliotecaButton = new JButton("BIBLIOTECA");
		pBotonera.add(bibliotecaButton);
		bibliotecaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				abroVentanaDeLugarInteres(caso, "BIBLIOTECA");
			}
		});
		
		JLabel lOrdenDeArresto = new JLabel();
		lOrdenDeArresto.setText("No se ha emitido orden de arresto.");

		
		JPanel pAcionesArealizar = new JPanel();
		pAcionesArealizar.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 2), "Acciones para realizar", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 128)));
		pCentro.add(pAcionesArealizar);
		pAcionesArealizar.setLayout(new BorderLayout(0, 0));
		
		
		JPanel pbotoneraAcciones = new JPanel();
		pbotoneraAcciones.setBorder(new EmptyBorder(30, 30, 30, 30));
		pAcionesArealizar.add(pbotoneraAcciones);
		pbotoneraAcciones.setLayout(new GridLayout(5, 0, 0, 3));
		
		JButton btnEmitirOrdenArresto = new JButton("Emitir Orden Arresto");
		btnEmitirOrdenArresto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	OrdenDeArresto ordenArrestoVista = new OrdenDeArresto(modelo);	
				ordenArrestoVista.setVisible(true);
				ordenArrestoVista.addWindowListener(new VentanaSeCierraListener() {
					@Override
					public void windowClosed(WindowEvent arg0) {
						SwingUtilities.updateComponentTreeUI(contentPane);
						if(modelo.hayVillanoCapturado()) {
							String nombreVillano= jugador.getSospechoso().getNombre();
							lOrdenDeArresto.setText("Se emitio orden de arresto contra: " +nombreVillano);
							
						}
					}
				});
            }
        });
		pbotoneraAcciones.add(btnEmitirOrdenArresto);
		pbotoneraAcciones.add(lOrdenDeArresto);
		
		
		JButton btnViajar = new JButton("Viajar");
        btnViajar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViajarVista viajarVista = new ViajarVista(modelo,jugador);
                viajarVista.setVisible(true);
                viajarVista.addWindowListener(new VentanaSeCierraListener() {
					@Override
					public void windowClosed(WindowEvent arg0) {
						actualizoPaisOFinalizoElJuego(modelo, lblPais);
					}
				});
            }
        });
		pbotoneraAcciones.add(btnViajar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		pbotoneraAcciones.add(lblNewLabel_1);
		
		JButton btnExpedientes = new JButton("Expedientes");
		btnExpedientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Expedientes siguienteVentana= new Expedientes();
				siguienteVentana.setVisible(true);
			}
		});
		pbotoneraAcciones.add(btnExpedientes);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(600, 120));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		RecorridoVillanoList = new JList<String>();
		RecorridoVillanoList.setBorder(new TitledBorder(new LineBorder(new Color(154, 205, 50)), "Recorrido acertado", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(154, 205, 50)));
		panel.add(RecorridoVillanoList);
		
		DestinosFallidosList = new JList<String>();
		DestinosFallidosList.setBorder(new TitledBorder(new LineBorder(new Color(255, 69, 0)), "Destinos Fallidos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 69, 0)));
		panel.add(DestinosFallidosList);
	}


	protected List<LugarInteres> obtenerLugaresDeInteres(CasoAJugar caso) {
		return caso.getJugador().obtenerLugaresDeInteresDelPaisActual();
	}
	
	protected List<String> obtenerNombresLugaresDeInteres(CasoAJugar caso) {
		return obtenerLugaresDeInteres(caso).stream()
				.map(lugar -> lugar.informacion())
				.collect(Collectors.toList());
	}
	protected void abroVentanaDeLugarInteres(CasoAJugar caso, String lugarDeInteres) {
		if(obtenerLugaresDeInteres(caso).stream().anyMatch(lugar -> lugar.informacion().equalsIgnoreCase(lugarDeInteres))) {
			LugarInteresVista lugarInteresVista = new LugarInteresVista(new LugarInteresViewModel(caso, obtenerUnLugarDeInteres(caso,lugarDeInteres)));
			lugarInteresVista.setVisible(true);
			lugarInteresVista.addWindowListener(new VentanaSeCierraListener() {
				@Override
				public void windowClosed(WindowEvent arg0) {
					seEncuentranAmbosOGano(modelo);
				}
			});
		}
		else {
			JOptionPane.showMessageDialog(contentPane,"No existe este lugar de interes en este pais, prueba otro!");
		}
	}
	
	protected LugarInteres obtenerUnLugarDeInteres(CasoAJugar caso, String lugarDeInteres) {
		for(LugarInteres lugarInteres: obtenerLugaresDeInteres(caso)){
	            if(lugarInteres.informacion().equalsIgnoreCase(lugarDeInteres)){
	                return lugarInteres;
	            }
	        }
		return null;
	}


	private void seEncuentranAmbosOGano(ResolviendoElCasoViewModel modelo) {
		if(modelo.getCasoAJugar().estaElCasoCerrado()) {
			abroVentanaDeFinalDelJuego(modelo);
		}
	}

	private boolean escucharSiFinalizaElJuegoYCerrar(ResolviendoElCasoViewModel modelo) {
		return modelo.getCasoAJugar().isTermino();
	}
	
	private void actualizoPaisOFinalizoElJuego(ResolviendoElCasoViewModel modelo, JLabel lblPais) {
		if(escucharSiFinalizaElJuegoYCerrar(modelo)) {
			abroVentanaDeFinalDelJuego(modelo);
		}
		else {
			SwingUtilities.updateComponentTreeUI(contentPane);
			lblPais.setText(modelo.getJugador().getPaisActual().getNombre());
		}
	}
	
	private void abroVentanaDeFinalDelJuego(ResolviendoElCasoViewModel modelo) {
		FinalDelJuego finalDelJuego = new FinalDelJuego(modelo.getCasoAJugar());
		dispose();
	}
}
