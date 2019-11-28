package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import modelo.CarmenSanDiegoMaster;
import modelo.Caso;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class FinalDelJuego extends JFrame {
	
	private JPanel finalDelJuegoPanel;
	JPanel textoDeVictoriaODerrotaPanel = new JPanel();
	JLabel primeraOracionLabel = new JLabel("");
	JLabel segundaOracionLabel = new JLabel("");
	JLabel terceraOracionLabel = new JLabel("");
	JButton victoriaODerrotaButton = new JButton("");

	public FinalDelJuego(CarmenSanDiegoMaster carmenSanDiegoMaster) {
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
		
		victoriaODerrotaButton.setBounds(279, 92, 149, 25);
		botonFinalPanel.add(victoriaODerrotaButton);
		
		condicionDeVictoriaODerrota(carmenSanDiegoMaster);
	}
	
	private void condicionDeVictoriaODerrota(CarmenSanDiegoMaster carmenSanDiegoMaster) {
		if(carmenSanDiegoMaster.gano()) {
			textoDeVictoria(carmenSanDiegoMaster);
		}
		else {
			textoDeDerrota(carmenSanDiegoMaster);
		}
	}

	private void textoDeVictoria(CarmenSanDiegoMaster carmenSanDiegoMaster) {
		primeraOracionLabel.setText("En buena hora!");
		segundaOracionLabel.setText("Ha detenido a Carmen Sandiego y recuperado la "+ carmenSanDiegoMaster.getCaso().getObjeto());
		terceraOracionLabel.setForeground(Color.GREEN);
		terceraOracionLabel.setText("Felicitaciones!!!!!");
		victoriaODerrotaButton.setText("Disfrutar de la victoria");
	}

	private void textoDeDerrota(CarmenSanDiegoMaster carmenSanDiegoMaster) {
		primeraOracionLabel.setForeground(Color.RED);
		primeraOracionLabel.setText("Malas noticias.....");
		segundaOracionLabel.setText("Ha detenido a " + carmenSanDiegoMaster.getVillano() + ", pero usted tenia una orden contra "+ carmenSanDiegoMaster.getJugador().getSospechoso());
		terceraOracionLabel.setText("Lamentablemente este crimen quedara impune");
		victoriaODerrotaButton.setText("Aceptar");
	}


	

}
