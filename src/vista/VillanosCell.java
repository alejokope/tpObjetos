package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import modelo.Persona;

public class VillanosCell extends JLabel implements ListCellRenderer<Persona> {
	public VillanosCell() {
		
	}
	private static final long serialVersionUID = 7113937991056162157L;
	

	@Override
	public Component getListCellRendererComponent(JList<? extends Persona> list, Persona value, int index,
			boolean isSelected, boolean cellHasFocus) {
		setFont(new Font("Tahoma",Font.PLAIN,20));
		setText(value.getNombre());
		if (isSelected) {
			setForeground(Color.MAGENTA);
		}
		else {
			setForeground(Color.BLACK);
		}
	
		return this;
	}
}
