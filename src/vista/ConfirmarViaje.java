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
        setBounds(500, 500, 347, 210);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
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
