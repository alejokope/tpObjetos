package vista;

import viewmodel.ResolviendoElCasoViewModel;

import javax.swing.*;

public class VisitandoLugar extends JDialog{
    private JPanel visitandoLugarPanel;
    private JTextArea pistasTextArea;
    private JButton continuarButton;
    private JPanel continuarPanel;
    private JPanel pistasPanel;
    private JPanel visitandoPanel;
    private JLabel visitandoLabel;

    public VisitandoLugar(ResolviendoElCasoViewModel resolviendoElCasoViewModel) {
        setContentPane(visitandoLugarPanel);
        setLocation(350,150);
        setSize(650,600);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);

        setTitle("Resolviendo: " + resolviendoElCasoViewModel.obtenerTituloDelCaso());
        pistasTextArea.setText(resolviendoElCasoViewModel.obtenerAyuda().toString());
    }
}
