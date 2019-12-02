package vista;

import modelo.CasoAJugar;
import viewmodel.SingletonDataDummy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinalDelJuego extends JFrame {

    private JPanel finalDelJuegoPanel;
    JPanel textoDeVictoriaODerrotaPanel = new JPanel();
    JLabel primeraOracionLabel = new JLabel("");
    JLabel segundaOracionLabel = new JLabel("");
    JLabel terceraOracionLabel = new JLabel("");
    JButton victoriaODerrotaButton = new JButton("");

    public FinalDelJuego(CasoAJugar casoAJugar) {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        finalDelJuegoPanel = new JPanel();
        finalDelJuegoPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(finalDelJuegoPanel);
        finalDelJuegoPanel.setLayout(new GridLayout(2, 0, 0, 0));

        finalDelJuegoPanel.add(textoDeVictoriaODerrotaPanel);
        textoDeVictoriaODerrotaPanel.setLayout(new GridLayout(3, 0, 0, 0));

        textoDeVictoriaODerrotaPanel.add(primeraOracionLabel);

        textoDeVictoriaODerrotaPanel.add(segundaOracionLabel);

        textoDeVictoriaODerrotaPanel.add(terceraOracionLabel);

        JPanel botonFinalPanel = new JPanel();
        finalDelJuegoPanel.add(botonFinalPanel);
        botonFinalPanel.setLayout(null);
        victoriaODerrotaButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		casoAJugar.getJugador().limpiarOrdenDeArrestoParaElNuevoJuego();
        		PaginaDeInicio paginaDeInicio = new PaginaDeInicio(casoAJugar.getJugador());
        		paginaDeInicio.setVisible(true);
        		dispose();
        	}
        });

        victoriaODerrotaButton.setBounds(279, 92, 149, 25);
        botonFinalPanel.add(victoriaODerrotaButton);

        condicionDeVictoriaODerrota(casoAJugar);
    }


    private void condicionDeVictoriaODerrota(CasoAJugar casoAJugar) {
        if(casoAJugar.gano()){
            textoDeVictoria(casoAJugar);
        }
        else {
            textoDeDerrota(casoAJugar);
        }
    }

    private void textoDeVictoria(CasoAJugar casoAJugar) {
        primeraOracionLabel.setText("Enhorabuena!");
        segundaOracionLabel.setText("Ha detenido a Carmen Sandiego y recuperado la "+ casoAJugar.getCaso().getObjeto());
        terceraOracionLabel.setForeground(Color.GREEN);
        terceraOracionLabel.setText("Felicitaciones!!!!!");
        victoriaODerrotaButton.setText("Disfrutar de la victoria");
    }

    private void textoDeDerrota(CasoAJugar casoAJugar) {
        primeraOracionLabel.setForeground(Color.RED);
        primeraOracionLabel.setText("Malas noticias.....");
        segundaOracionLabel.setText("Ha detenido a " + casoAJugar.getVillano().getNombre() + ", pero usted tenia una orden contra " + esSospechosoNulo(casoAJugar));
        terceraOracionLabel.setText("Lamentablemente este crimen quedara impune");
        victoriaODerrotaButton.setText("Aceptar");
    }


	private String esSospechosoNulo(CasoAJugar casoAJugar) {
		if(casoAJugar.getJugador().hayOrdenDeArresto()) {
			return casoAJugar.getJugador().getSospechoso().getNombre();
		}
		else {
			return "nadie.";
		}
		
	}
}
