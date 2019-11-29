package vista;

import modelo.CasoAJugar;
import modelo.Caso;
import modelo.Utils;
import viewmodel.SingletonDataDummy;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmarViaje extends JFrame {
    private JPanel contentPane;
    private Caso caso;
    private Utils utils;
    private CasoAJugar casoAJugar;

    public ConfirmarViaje(final String paisProximo){
        setResizable(false);
        utils = new Utils();
        casoAJugar = SingletonDataDummy.getInstance().getCasoAJugar();
        setTitle("CONFIRMAR VIAJE");
        //TODO FIJARSE FORMA DE CENTRAR EN EL MEDIO DE LA PANTALLA
        setBounds(500, 500, 383, 221);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new EmptyBorder(20, 0, 0, 0));
        panel_1.setPreferredSize(new Dimension(100, 100));
        panel.add(panel_1, BorderLayout.SOUTH);
        
        
        
                JButton bAceptar = new JButton("Aceptar");
                panel_1.add(bAceptar);
                
                JPanel panel_2 = new JPanel();
                panel_2.setBorder(new EmptyBorder(50, 0, 0, 0));
                panel.add(panel_2, BorderLayout.CENTER);
                
                JLabel lblSeHaViajado = new JLabel("Viajar a un nuevo destino");
                panel_2.add(lblSeHaViajado);
                bAceptar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        casoAJugar.viajar(utils.obtenerPais(paisProximo));
                        SingletonDataDummy.getInstance().getJugadorAsignado().setPaisActual(utils.obtenerPais(paisProximo));
                        if(casoAJugar.isTermino()){
                            FinalDelJuego finalDelJuego = new FinalDelJuego(casoAJugar);
                            setVisible(false);
                            finalDelJuego.setVisible(true);
                        }
                        else{
                            JugandoCaso jugandoCaso = new JugandoCaso(casoAJugar);
                            setVisible(false);
                            jugandoCaso.setVisible(true);
                        }
                    }
                });
    }
}
