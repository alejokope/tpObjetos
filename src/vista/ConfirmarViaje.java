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
                SingletonDataDummy.getInstance().addPaisVisitado(paisProximo);
                JugandoCaso jugandoCaso = new JugandoCaso();
                setVisible(false);
                jugandoCaso.setVisible(true);
            }
        });
        bAceptar.setBounds(129, 61, 97, 25);
        panel.add(bAceptar);

        JLabel lfondo = new JLabel("");
        lfondo.setBounds(0, 0, 481, 397);
        lfondo.setIcon(new ImageIcon(ConfirmarViaje.class.getResource("/imagenes/fondo4.png")));
        panel.add(lfondo);
    }
}
