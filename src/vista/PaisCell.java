package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import modelo.Pais;

public class PaisCell extends JLabel implements ListCellRenderer<Pais> {

	@Override
	public Component getListCellRendererComponent(JList<? extends Pais> list, Pais value, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		setText(value.getNombre());
		
		mostrarPaisesFallidosYNoVisitados(value);
		
		return this;
	}

	private void mostrarPaisesFallidosYNoVisitados(Pais value) {
		if(!value.pasoElJugador()) {
			Font negrita = new Font("Courier", Font.BOLD, 12);
			setFont(negrita);
		}
		else if(value.estoyFallido()) {
			Font comun = new Font("Courier", Font.PLAIN, 12);
			setFont(comun);
			setForeground(Color.RED);
		}
	}
	
	

}
