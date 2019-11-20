package vista;

import modelo.CarmenSanDiegoMaster;
import modelo.Caso;
import modelo.Utils;

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

    public ConfirmarViaje(final CarmenSanDiegoMaster carmenSanDiegoMaster, final Caso caso, final String paisProximo){
        this.caso = caso;
        utils = new Utils();
        setTitle("CONFIRMAR VIAJE");
        //TODO FIJARSE FORMA DE CENTRAR EN EL MEDIO DE LA PANTALLA
        setBounds(500, 500, 200, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton viajar = new JButton("ACEPTAR");
        viajar.setBounds(200, 140,80,50);
        viajar.setFont(new Font("Arial",Font.BOLD,12));
        viajar.setHorizontalAlignment(SwingConstants.CENTER);
        viajar.setVerticalAlignment(SwingConstants.CENTER);
        viajar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               ResolviendoCaso resolviendoCaso = new ResolviendoCaso(caso) ;
               carmenSanDiegoMaster.viajar(utils.obtenerPais(paisProximo));
               setVisible(false);
               resolviendoCaso.setVisible(true);
            }
        });
        contentPane.add(viajar);
    }
}
