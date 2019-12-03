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
    private JTextArea pistaText = new JTextArea();
    

    public LugarInteresVista(LugarInteresViewModel modelo){
    	setResizable(false);
    	modelo.setLugarDeInteresDelJugador();
    	
        setTitle(modelo.getCaso().getTitulo());
        setBounds(550, 280, 519, 264);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/imagenes/iconosombrero.png")));
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
        
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 50));
        contentPane.add(panel);

        Label estasEn = new Label("Estas visitando: " + modelo.getLugarInteres().informacion());
        panel.add(estasEn);
        estasEn.setFont(new Font("Arial", Font.PLAIN, 21));
        
        JPanel panel_1 = new JPanel();
        panel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setHgap(10);
        panel_1.setPreferredSize(new Dimension(350, 100));
        contentPane.add(panel_1);

        pistaText.setBackground(SystemColor.menu);
        pistaText.setEditable(false);
        panel_1.add(pistaText);
        pistaText.setText(modelo.darPista());
        pistaText.setFont(new Font("Arial", Font.PLAIN, 19));
        
        JPanel panel_2 = new JPanel();
        panel_2.setPreferredSize(new Dimension(400, 50));
        contentPane.add(panel_2);
        
        JButton continuar = new JButton("Continuar");
        panel_2.add(continuar);
        continuar.setFont(new Font("Arial",Font.BOLD,12));
        continuar.setHorizontalAlignment(SwingConstants.CENTER);
        continuar.setVerticalAlignment(SwingConstants.CENTER);
                
        continuar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	dispose();
        	}
        });
    }

	public String obtenerPista() {
		return pistaText.getText();
	}
	
	public void setLugarInteres() {
		
	}
}
