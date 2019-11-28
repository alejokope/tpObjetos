package vista;

import modelo.CarmenSanDiegoMaster;
import modelo.Caso;
import modelo.Utils;
import viewmodel.SingletonDataDummy;

import javax.rmi.CORBA.Util;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmarViaje extends JFrame {
    private JPanel contentPane;
    private Caso caso;
    private Utils utils;
    private CarmenSanDiegoMaster carmenSanDiegoMaster;

    public ConfirmarViaje(final String paisProximo){
        System.out.println(SingletonDataDummy.getInstance().obtenerListaPaisesCaso());
        //setIconImage(Toolkit.getDefaultToolkit().getImage(PresentacionCaso.class.getResource("/imagenes/iconosombrero.png")));
        setResizable(false);
        utils = new Utils();
        carmenSanDiegoMaster = SingletonDataDummy.getInstance().getCarmenSanDiegoMaster();
        setTitle("CONFIRMAR VIAJE");
        //TODO FIJARSE FORMA DE CENTRAR EN EL MEDIO DE LA PANTALLA
        setBounds(500, 500, 383, 310);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);



        JButton bAceptar = new JButton("New button");
        bAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                carmenSanDiegoMaster.viajar(utils.obtenerPais(paisProximo));
                SingletonDataDummy.getInstance().getJugadorAsignado().setPaisActual(utils.obtenerPais(paisProximo));
                if(carmenSanDiegoMaster.isTermino()){
                    FinalDelJuego finalDelJuego = new FinalDelJuego(carmenSanDiegoMaster);
                    setVisible(false);
                    finalDelJuego.setVisible(true);
                }
                else{
                    JugandoCaso jugandoCaso = new JugandoCaso();
                    setVisible(false);
                    jugandoCaso.setVisible(true);
                }
            }
        });
        bAceptar.setBounds(129, 61, 97, 25);
        panel.add(bAceptar);

        JLabel lfondo = new JLabel("");
        lfondo.setBounds(0, 0, 481, 397);
        lfondo.setIcon(new ImageIcon(ConfirmarViaje.class.getResource("/imagenes/fondo4.png")));
        panel.add(lfondo);
        panel.setLayout(new BorderLayout(0, 0));

        JLabel lblUstedAViajado = new JLabel("USTED A VIAJADO!!!");
        lblUstedAViajado.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblUstedAViajado, BorderLayout.CENTER);

                JPanel panel_1 = new JPanel();
                panel_1.setPreferredSize(new Dimension(50, 50));
                panel.add(panel_1, BorderLayout.SOUTH);



                        JButton bAceptar = new JButton("Aceptar");
                        panel_1.add(bAceptar);
                bAceptar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        carmenSanDiegoMaster.viajar(utils.obtenerPais(paisProximo));
                        SingletonDataDummy.getInstance().getJugadorAsignado().setPaisActual(utils.obtenerPais(paisProximo));
                        JugandoCaso jugandoCaso = new JugandoCaso();
                        setVisible(false);
                        jugandoCaso.setVisible(true);
                    }
                });
    }



}
