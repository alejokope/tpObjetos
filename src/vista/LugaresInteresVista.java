package vista;

import modelo.*;
import modelo.lugarInteres.LugarInteres;
import viewmodel.SingletonDataDummy;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class  LugaresInteresVista extends JFrame {
    private JPanel contentPane;
    private Caso caso;
    private Villano villano;
    private Jugador jugador;
    private DataDummy dataDummy = SingletonDataDummy.getInstance();
    private Utils utils = new Utils();
    private String pista;

    public  LugaresInteresVista(LugarInteres lugarInteresVisitado){
        this.caso = dataDummy.getCasoAsignado();
        this.villano = dataDummy.getVillanoAsignado();
        this.jugador = dataDummy.getJugadorAsignado();
        setTitle(caso.getTitulo());
        setBounds(500, 500, 700, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lugarInteresVisitado.darPista(dataDummy.getJugadorAsignado());
        Ayuda ayuda = lugarInteresVisitado.getAyuda();
        Label estasEn = new Label("Estas visitando: " + lugarInteresVisitado.informacion());
        estasEn.setFont(new Font("Arial",Font.PLAIN, 14));
        estasEn.setBounds(20, 20, 200, 22);
        contentPane.add(estasEn);

        if(!villano.tienePaisProximo() && jugador.getPaisActual().getNombre().equalsIgnoreCase(villano.getPaisActual().getNombre())
        && !lugarInteresVisitado.informacion().equalsIgnoreCase(villano.getLugarInteresActual().informacion())){
            pista = "CUIDADO DETECTIVE!! Ha estado a punto de caer en una trampa. La persona que busca esta en esta ciudad";
        }
        else if(!utils.paisEstaEnElCaso(caso.getPlanEscape(),jugador.getPaisActual())){
            pista = "Lo siento, creo que se ha equivocado de ciudad, no hay nadie con esas caracteristicas";
        }
        else if (!jugador.getPaisActual().getNombre().equalsIgnoreCase(caso.getPaisOrigen().getNombre()) &&jugador.getPaisActual().getNombre().equalsIgnoreCase(villano.getPaisActual().getNombre()) && lugarInteresVisitado.informacion().equalsIgnoreCase(villano.getLugarInteresActual().informacion())){
            if(jugador.getSospechoso() != null && jugador.getSospechoso().getNombre().equalsIgnoreCase(villano.getNombre())){
                pista = "ALTO DETENGASE!! " + dataDummy.getJugadorAsignado().getSospechoso().getNombre();
            }
        }
        else{ pista = ayuda.darPistaMensaje(); }

        JLabel pistaText = new JLabel();
        pistaText.setText(pista);
        pistaText.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pistaText.setBounds(20,60,1200,40);
        contentPane.add(pistaText);

        JButton continuar = new JButton("Continuar");
        continuar.setBounds(200,120,180,50);
        continuar.setFont(new Font("Arial",Font.BOLD,12));
        continuar.setHorizontalAlignment(SwingConstants.CENTER);
        continuar.setVerticalAlignment(SwingConstants.CENTER);

        continuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JugandoCaso resolviendoCaso = new JugandoCaso();
                setVisible(false);
                resolviendoCaso.setVisible(true);
            }
        });

        contentPane.add(continuar);


        /*
        //TODO FIJARSE FORMA DE CENTRAR EN EL MEDIO DE LA PANTALLA



        List<String> pistas;
        int y = 70;
        if(villano.getPlanEscape().get(villano.getPlanEscape().size()-1).equals(jugador.getPaisActual()) && !villano.estoyEnElMismoLugarDeInteresQueJugador(jugador)){
            JLabel noPaso = new JLabel("<html>CUIDADO DETECTIVE!! Ha estado a punto de caer en una trampa... La persona que busca está en la ciudad!</html>");
            noPaso.setFont(new Font("Arial", Font.PLAIN, 14));
            noPaso.setBounds(30, y, 300, 100);
            contentPane.add(noPaso);
        }
        else if(!villano.getPlanEscape().contains(jugador.getPaisActual())){
            JLabel noPaso = new JLabel("<html>Lo siento, creo que se equivoco de ciudad, no hay nadie con esas caracteristicas.</html>");
            noPaso.setFont(new Font("Arial", Font.PLAIN, 14));
            noPaso.setBounds(30, y, 300, 100);
            contentPane.add(noPaso);
        }
        else if(lugarInteresVisitado.getPasoVillano()) {
            for (String pista : pistas) {
                Label _pista = new Label(pista);
                _pista.setFont(new Font("Arial", Font.PLAIN, 14));
                _pista.setBounds(30, y, 200, 22);
                contentPane.add(_pista);
                y += 20;
            }
        }
        else if(dataDummy.getCasoAsignado().getResponsable().estoyEnElMismoLugarDeInteresQueJugador(jugador) && villano.getPaisActual().equals(jugador.getPaisActual())){
            Label _pista = new Label("ALTO!!! Detengase: " + caso.getResponsable().getNombre());
            _pista.setFont(new Font("Arial", Font.PLAIN, 14));
            _pista.setBounds(30, y, 200, 22);
            contentPane.add(_pista);
            if(jugador.isFuePedida()){
                Label perdiste = new Label("PERDISTE!!");
                perdiste.setFont(new Font("Arial", Font.PLAIN, 14));
                perdiste.setBounds(100, y, 200, 22);
                contentPane.add(perdiste);
            }
        }

        JButton continuar = new JButton("Continuar");
        continuar.setBounds(200,120,180,50);
        continuar.setFont(new Font("Arial",Font.BOLD,12));
        continuar.setHorizontalAlignment(SwingConstants.CENTER);
        continuar.setVerticalAlignment(SwingConstants.CENTER);

        continuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JugandoCaso resolviendoCaso = new JugandoCaso();
                setVisible(false);
                resolviendoCaso.setVisible(true);
            }
        });

        contentPane.add(continuar);

         */
    }

}
