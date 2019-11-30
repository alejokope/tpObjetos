package vista;

import modelo.*;
import modelo.lugarInteres.LugarInteres;
import viewmodel.LugarInteresViewModel;
import viewmodel.SingletonDataDummy;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class LugarInteresVista extends JFrame {
    private JPanel contentPane;

    public LugarInteresVista(LugarInteresViewModel modelo){
    	modelo.setLugarDeInteresDelJugador();
    	
        setTitle(modelo.getCaso().getTitulo());
        setBounds(500, 500, 700, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Label estasEn = new Label("Estas visitando: " + modelo.getLugarInteres().informacion());
        estasEn.setFont(new Font("Arial",Font.PLAIN, 14));
        estasEn.setBounds(20, 20, 200, 22);
        contentPane.add(estasEn);

        JLabel pistaText = new JLabel();
        pistaText.setText(modelo.darPista());
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
                setVisible(false);
            }
        });

        contentPane.add(continuar);
    }

}
