package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class ViajarVista extends JFrame {
    private JPanel contentPane;
    private JList jList;

    DefaultListModel model = new DefaultListModel();
    JList list = new JList(model);

    public ViajarVista(){
        setTitle("Viajar");
        //TODO FIJARSE FORMA DE CENTRAR EN EL MEDIO DE LA PANTALLA
        setBounds(500, 500, 700, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        jList = new JList();
        jList.add(new Button("MESSI"));
        jList.add(new Button("MESSI"));
        jList.add(new Button("MESSI"));

        contentPane.add(jList);
    }
}
