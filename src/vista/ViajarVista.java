package vista;

import viewmodel.ResolviendoElCasoViewModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import modelo.Jugador;
import modelo.Pais;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ViajarVista extends JFrame {
    private JPanel contentPane;
    private JComboBox comboBox;
    private Pais paisDelConfirmarViaje;
    
    
    public void setPaisDelConfirmarViaje(Pais pais) {
    	this.paisDelConfirmarViaje = pais;
    }
    
    public Pais getPaisDelConfirmarViaje() {
    	return paisDelConfirmarViaje;
    }
    
    public ViajarVista(ResolviendoElCasoViewModel modelo, Jugador jugador){
        setTitle("Viajar");
        
        setBounds(500, 500, 700, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Label estasEn = new Label("Estas En: ");
        estasEn.setFont(new Font("Arial",Font.PLAIN, 14));
        estasEn.setBounds(20, 20, 70, 22);
        contentPane.add(estasEn);
        
        Label paisOrigen = new Label(modelo.getNombrePaisActual().toUpperCase());
        paisOrigen.setFont(new Font("Arial",Font.BOLD, 14));
        paisOrigen.setBounds(100, 20, 100, 22);
        contentPane.add(paisOrigen);

        comboBox = new JComboBox();
        comboBox.setBounds(20,70,230,50);
        comboBox.addItem("Posibles destinos");
        for(String destino : modelo.obtenerNombresDePaises()){
            comboBox.addItem(destino);
        }

        contentPane.add(comboBox);

        JButton viajar = new JButton("Viajar");
        viajar.setBounds(400, 180,180,50);
        viajar.setFont(new Font("Arial",Font.BOLD,12));
        viajar.setHorizontalAlignment(SwingConstants.CENTER);
        viajar.setVerticalAlignment(SwingConstants.CENTER);
        viajar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConfirmarViaje confirmarViaje = new ConfirmarViaje(comboBox.getSelectedItem().toString(),modelo,jugador);
                confirmarViaje.setVisible(true);
                confirmarViaje.addWindowListener(new VentanaSeCierraListener() {
                	@Override
                	public void windowClosed(WindowEvent arg0) {	
                		dispose();
                	}
                });
            }
        });

        contentPane.add(viajar);

        JButton cancelar = new JButton("Cancelar");
        cancelar.setBounds(20, 180,180,50);
        cancelar.setFont(new Font("Arial",Font.BOLD,12));
        cancelar.setHorizontalAlignment(SwingConstants.CENTER);
        cancelar.setVerticalAlignment(SwingConstants.CENTER);
        cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        contentPane.add(cancelar);
    }

}
