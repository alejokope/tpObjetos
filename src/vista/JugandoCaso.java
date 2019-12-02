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

import controllers.RecorridoExitosoController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

public class JugandoCaso extends JFrame {

	private JPanel contentPane;
	/*
	 * se crea el segundo modelview 
	 */
	private ResolviendoElCasoViewModel modelo = new ResolviendoElCasoViewModel();
	private List<String> paisesRecorridosConExito;
	private JList<Pais> listaRecorridoExitoso;

	public JugandoCaso(CasoAJugar caso, Jugador jugador) {
        modelo.setCasoAJugar(caso);
        
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
		
		JLabel lblPais = new JLabel();
		lblPais.setText(modelo.getNombrePaisActual());

		pArriba.add(lblPais);
		
		JPanel pCentro = new JPanel();
		pCentro.setPreferredSize(new Dimension(700, 400));
		contentPane.add(pCentro);
		pCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pLugares = new JPanel();
		pLugares.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lugares a visitar", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pCentro.add(pLugares);
		pLugares.setLayout(new BorderLayout(0, 0));
		
		JPanel pBotonera = new JPanel();
		pBotonera.setBorder(new EmptyBorder(30, 30, 30, 30));
		pLugares.add(pBotonera, BorderLayout.CENTER);
		pBotonera.setLayout(new GridLayout(5, 0, 0, 3));
		
		JLabel lOrdenDeArresto = new JLabel();
		lOrdenDeArresto.setText("No se ha emitido orden de arresto.");

        int y = 70;
        for(final LugarInteres lugarInteres : modelo.getLugaresDeInteres()){
            final JButton _lugarInteres = new JButton(lugarInteres.informacion().toUpperCase());
            _lugarInteres.setBounds(20, y,120,50);
            _lugarInteres.setFont(new Font("Arial",Font.BOLD,12));
            _lugarInteres.setHorizontalAlignment(SwingConstants.CENTER);
            _lugarInteres.setVerticalAlignment(SwingConstants.CENTER);
            _lugarInteres.addActionListener(e -> {
                LugarInteresVista lugarInteresVista = new LugarInteresVista(new LugarInteresViewModel(caso,lugarInteres));
                lugarInteresVista.setVisible(true);
                lugarInteresVista.addWindowListener(new VentanaSeCierraListener() {
					@Override
					public void windowClosed(WindowEvent arg0) {
						seEncuentranAmbosOGano(modelo);
					}
				});
            });
           pBotonera.add(_lugarInteres);
            y += 70;
        }


		JPanel pAcionesArealizar = new JPanel();
		pAcionesArealizar.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Acciones para realizar", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		panel.setPreferredSize(new Dimension(600, 125));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JScrollPane spRecorridoCorrecto = new JScrollPane();
		panel.add(spRecorridoCorrecto);
		
		listaRecorridoExitoso = new JList();
		listaRecorridoExitoso.setModel(new RecorridoExitosoController(modelo).getRecorridoCorrecto());
		listaRecorridoExitoso.setCellRenderer(new PaisCell());
		spRecorridoCorrecto.setViewportView(listaRecorridoExitoso);

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
