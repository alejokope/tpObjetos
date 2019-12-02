package cell;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import modelo.Pais;
import modelo.Persona;

public class PaisCell extends JLabel implements ListCellRenderer<Pais> {
	public PaisCell() {
		
	}
	private static final long serialVersionUID = 7113937991056162157L;
	@Override
	public Component getListCellRendererComponent(JList<? extends Pais> list, Pais value, int index,
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
