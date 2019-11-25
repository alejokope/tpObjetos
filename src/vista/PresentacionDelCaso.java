package vista;

import modelo.DataDummy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PresentacionDelCaso extends JDialog{
    private JPanel presentacionDelCasoPanel;
    private JButton elegirOtroButton;
    private JButton aceptarElCasoButton;
    private JLabel saludoLabel;
    private JPanel reportePanel;
    private JTextArea reporteTextArea;
    private JPanel saludoPanel;
    private JPanel botonesPanel;

    public PresentacionDelCaso(DataDummy dataDummy){
        recargarCaso(dataDummy);
        setContentPane(presentacionDelCasoPanel);
        setLocation(350,150);
        setSize(650,600);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);

        elegirOtroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refrescar();
                recargarCaso(dataDummy);
            }

        });
        aceptarElCasoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ResolviendoElCaso resolviendoElCaso = new ResolviendoElCaso(dataDummy.obtenerCasoAsignado());
            }
        });
    }

    private void recargarCaso(DataDummy dataDummy) {
        setTitle(dataDummy.obtenerCasoAlAzar().getTitulo());
        saludoLabel.setText("Detective " + dataDummy.obtenerNombreDelJugadorAsignado() + ", tenemos un caso para usted!");
        reporteTextArea.setText(dataDummy.obtenerCasoAlAzar().getReporte());
        reporteTextArea.setEditable(false);
    }

    private void refrescar(){
         SwingUtilities.updateComponentTreeUI(presentacionDelCasoPanel);
    }


}
