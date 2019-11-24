package vista;

import modelo.DataDummy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaDeInicio extends JDialog{

    private JPanel pantallaDeInicioPanel;
    private JButton resolverMisterioButton;
    private JButton expedientesButton;

    public PantallaDeInicio(DataDummy dataDummy, JTextField nombreIngresadoTextField){
        setTitle("¿Dónde está Carmen Sandiego?");
        setContentPane(pantallaDeInicioPanel);
        setLocation(400,400);
        setSize(500,255);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
        resolverMisterioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                PresentacionDelCaso presentacionDelCaso = new PresentacionDelCaso(dataDummy, nombreIngresadoTextField);
            }
        });
    }
}
