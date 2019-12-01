package vista;

import modelo.CasoAJugar;
import modelo.Jugador;
import modelo.Pais;
import modelo.Caso;
import modelo.Utils;
import viewmodel.ResolviendoElCasoViewModel;
import viewmodel.SingletonDataDummy;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmarViaje extends JFrame {
    private JPanel contentPane;
    private Utils utils;
    private Pais paisElegido;
    
    public void setPaisElegido(Pais paisElegido) {
    	this.paisElegido = paisElegido;
    }
    
    public Pais getPaisElegido() {
    	return paisElegido;
    }


    public ConfirmarViaje(final String paisProximo,ResolviendoElCasoViewModel modelo, Jugador jugador){
    	
        setResizable(false);
        utils = new Utils();
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
                    	modelo.getCasoAJugar().viajar(utils.obtenerPais(paisProximo));
                        if(modelo.getCasoAJugar().isTermino()){
                            FinalDelJuego finalDelJuego = new FinalDelJuego(modelo.getCasoAJugar());
                            setVisible(false);
                            finalDelJuego.setVisible(true);
                        }
                        else{
                            //setPaisElegido(modelo.getJugador().getPaisActual());
                            dispose();
                        }
                    }
                });
    }
}
