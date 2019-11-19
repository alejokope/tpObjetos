package vista;

import modelo.CarmenSanDiegoMaster;
import modelo.Caso;
import modelo.Jugador;
import modelo.Villano;
import modelo.lugarInteres.LugarInteres;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResolviendoCaso extends JFrame {
    private JPanel contentPane;
    private Caso caso;
    private CarmenSanDiegoMaster carmenSanDiegoMaster;
    private Villano villano;
    private Jugador jugador;



    public ResolviendoCaso(final Caso caso){
        this.caso = caso;
        this.villano = caso.getResponsable();
        this.jugador = new Jugador(caso);
        this.carmenSanDiegoMaster = new CarmenSanDiegoMaster(caso,jugador,villano);
        setTitle(this.obtenerTitulo());
        //TODO FIJARSE FORMA DE CENTRAR EN EL MEDIO DE LA PANTALLA
        setBounds(500, 500, 700, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Label estasEn = new Label("Estás en:");
        estasEn.setFont(new Font("Arial",Font.PLAIN, 14));
        estasEn.setBounds(20, 20, 70, 22);
        contentPane.add(estasEn);

        Label paisOrigen = new Label(caso.getPaisOrigen().getNombre().toUpperCase());
        paisOrigen.setFont(new Font("Arial",Font.BOLD, 14));
        paisOrigen.setBounds(100, 20, 100, 22);
        contentPane.add(paisOrigen);

        Label lugares = new Label("Lugares");
        lugares.setFont(new Font("Arial",Font.PLAIN, 14));
        lugares.setBounds(20, 40, 70, 22);
        contentPane.add(lugares);

        Label acciones = new Label("Acciones");
        acciones.setFont(new Font("Arial",Font.PLAIN, 14));
        acciones.setBounds(200, 40, 70, 22);
        contentPane.add(acciones);
        int y = 70;
        for(final LugarInteres lugarInteres : jugador.getPaisActual().getLugaresInteres()){
            final JButton _lugarInteres = new JButton(lugarInteres.informacion().toUpperCase());
            _lugarInteres.setBounds(20, y,120,50);
            _lugarInteres.setFont(new Font("Arial",Font.BOLD,12));
            _lugarInteres.setHorizontalAlignment(SwingConstants.CENTER);
            _lugarInteres.setVerticalAlignment(SwingConstants.CENTER);
            _lugarInteres.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    LugarInteresVista lugarInteresVista = new LugarInteresVista(lugarInteres,caso,villano,jugador);
                    setVisible(false);
                    lugarInteresVista.setVisible(true);
                }
            });
            contentPane.add(_lugarInteres);
            y += 70;
        }

        this.agregarAcciones();

    }
    public void agregarAcciones(){
        JButton ordenArresto = new JButton("ORDEN DE ARRESTO");
        ordenArresto.setBounds(200, 70,180,50);
        ordenArresto.setFont(new Font("Arial",Font.BOLD,12));
        ordenArresto.setHorizontalAlignment(SwingConstants.CENTER);
        ordenArresto.setVerticalAlignment(SwingConstants.CENTER);
            /*_lugarInteres.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ResolviendoCaso resolviendoCaso = new ResolviendoCaso(caso);
                    setVisible(false);
                    resolviendoCaso.setVisible(true);
                }
            });*/
        contentPane.add(ordenArresto);
        if(jugador.isFuePedida()){
            Label orden = new Label("Orden ya emitida: " + jugador.getSospechoso().getNombre());
            orden.setFont(new Font("Arial",Font.PLAIN, 12));
            orden.setBounds(200, 118, 200, 22);
            contentPane.add(orden);
        }

        final JButton viajar = new JButton("VIAJAR");
        viajar.setBounds(200, 140,180,50);
        viajar.setFont(new Font("Arial",Font.BOLD,12));
        viajar.setHorizontalAlignment(SwingConstants.CENTER);
        viajar.setVerticalAlignment(SwingConstants.CENTER);
            viajar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ViajarVista viajarVista = new ViajarVista();
                    setVisible(false);
                    viajarVista.setVisible(true);
                }
            });
        contentPane.add(viajar);

        JButton expedientes = new JButton("EXPEDIENTES");
        expedientes.setBounds(200, 210,180,50);
        expedientes.setFont(new Font("Arial",Font.BOLD,12));
        expedientes.setHorizontalAlignment(SwingConstants.CENTER);
        expedientes.setVerticalAlignment(SwingConstants.CENTER);
            /*_lugarInteres.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ResolviendoCaso resolviendoCaso = new ResolviendoCaso(caso);
                    setVisible(false);
                    resolviendoCaso.setVisible(true);
                }
            });*/
        contentPane.add(expedientes);


    }

    private String obtenerTitulo(){
        return "Resolviendo: " + caso.getObjeto();
    }
}
