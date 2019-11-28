package Extras;

import modelo.DataDummy;
import modelo.Jugador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PresentacionDelCaso extends JDialog{
/*    private DataDummy dataDummy;
    private JPanel presentacionDelCasoPanel;
    private JButton elegirOtroButton;
    private JButton aceptarElCasoButton;
    private JLabel saludoLabel;
    private JPanel reportePanel;
    private JTextArea reporteTextArea;
    private JPanel saludoPanel;
    private JPanel botonesPanel;

    public PresentacionDelCaso(Jugador jugador){
        recargarCaso(jugador);
        setContentPane(presentacionDelCasoPanel);
        setLocation(350,150);
        setSize(650,600);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);

        elegirOtroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refrescar();
                recargarCaso(jugador);
            }

        });
        aceptarElCasoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ResolviendoElCaso resolviendoElCaso = new ResolviendoElCaso(dataDummy);
            }
        });
    }

    private void recargarCaso(Jugador jugador) {
        dataDummy = new DataDummy();
        dataDummy.setJugadorAsignado(jugador);
        dataDummy.obtenerCasoAlAzar();
        setTitle(dataDummy.obtenerTituloDelCasoAsignado());
        saludoLabel.setText("Detective " + jugador.getNombre() + ", tenemos un caso para usted!");
        reporteTextArea.setText(dataDummy.obtenerReporteDelCasoAsignado());
        reporteTextArea.setEditable(false);
    }

    private void refrescar(){
         SwingUtilities.updateComponentTreeUI(presentacionDelCasoPanel);
    }

*/
}
