package vista;

import modelo.*;
import modelo.lugarInteres.LugarInteres;

import javax.swing.*;

public class VisitandoLugar extends JDialog{
    private JPanel visitandoLugarPanel;
    private JTextArea pistasTextArea;
    private JButton continuarButton;
    private JPanel continuarPanel;
    private JPanel pistasPanel;
    private JPanel visitandoPanel;
    private JLabel visitandoLabel;

    public VisitandoLugar(CarmenSanDiegoMaster carmenSanDiegoMaster, LugarInteres lugarInteres) {
        setContentPane(visitandoLugarPanel);
        setLocation(350,150);
        setSize(650,600);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);

        Caso caso = carmenSanDiegoMaster.getCaso();
        Villano villano = carmenSanDiegoMaster.getVillano();
        Jugador jugador = carmenSanDiegoMaster.getJugador();
        Pais paisActual = jugador.getPaisActual();
        EstadoDeMensaje estadoDeMensaje = carmenSanDiegoMaster.getEstadoDeMensaje();
        paisActual.verificacionDeIngresoDelVillano(villano); //<- esto setea el paso del villano, si su plandeescape incluia este pais importante!!!

        carmenSanDiegoMaster.actualizarEstadoDeMensaje();

        setTitle("Resolviendo: " + caso.getTitulo());
        visitandoLabel.setText("Estás visitando: " + lugarInteres.informacion());
        pistasTextArea.setText(estadoDeMensaje.mostrarMensaje(carmenSanDiegoMaster,lugarInteres.getAyuda()));
        pistasTextArea.setEditable(false);
    }
}
