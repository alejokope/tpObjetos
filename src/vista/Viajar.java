package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import controller.ConexionesController;
import modelo.Pais;
import viewmodel.ResolviendoElCasoViewModel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Viajar extends JFrame {

	private JPanel viajarPanel;
	private ResolviendoElCasoViewModel modelo;
	private PaisTableModel paisTableModel;
	
	
	public Viajar(ResolviendoElCasoViewModel modelo) {
		setTitle("Viajar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		viajarPanel = new JPanel();
		viajarPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(viajarPanel);
		viajarPanel.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel visitandoPanel = new JPanel();
		viajarPanel.add(visitandoPanel);
		visitandoPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel visitandoLabel = new JLabel("Estas en: " + modelo.getJugador().getPaisActual());
		visitandoPanel.add(visitandoLabel);
		
		JPanel conexionesPanel = new JPanel();
		viajarPanel.add(conexionesPanel);
		
		JList<Pais> conexionesList = new JList<Pais>();
		conexionesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		conexionesList.setCellRenderer(new PaisCell());
		conexionesList.setModel(new ConexionesController(modelo).getConexiones());
		conexionesList.add(new JScrollPane()); //esto la hace scrollear a la lista?
		conexionesPanel.add(conexionesList);
		
		conexionesList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				Pais pais = conexionesList.getSelectedValue();
				if(pais != null) {
					seSelecciono(pais);
				}
				
			}

			private void seSelecciono(Pais pais) {
				modelo.setPaisSeleccionado(pais);
				refrescar(); //no se si deberia refrescar la tabla
			}

		});
		
		ConexionesController conexionesController = new ConexionesController(modelo);
		
		JPanel botonesPanel = new JPanel();
		viajarPanel.add(botonesPanel);
		botonesPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton cancelarButton = new JButton("Cancelar");
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		botonesPanel.add(cancelarButton);
		
		JButton viajarButton = new JButton("Viajar");
		viajarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfirmarViaje confirmarViaje = new ConfirmarViaje(modelo);
				refrescar();
			}
		});
		botonesPanel.add(viajarButton);
		
		
		
	}
	private void refrescar() {
		SwingUtilities.updateComponentTreeUI(viajarPanel);
	}
	
	class PaisTableModel extends AbstractTableModel{
		List<Pais> paisList;
		String[] headerList = {"Posibles destinos"};
		Class[] classes = {String.class};
		
		public PaisTableModel (List<Pais> list) {
			paisList = list;
		}
		
		public Pais obtener(int index) {
			try {
				return paisList.get(index);
			}
			catch(IndexOutOfBoundsException e) {
				return null;
			}
		}

		@Override
		public int getColumnCount() {
			return headerList.length;
		}

		@Override
		public int getRowCount() {
			return paisList.size();
		}
		
		@Override
		public Class<?> getColumnClass(int index) {
			return classes[index];
		}

		public String getColumnName(int col) {
			return headerList[col];
		}

		@Override
		public Object getValueAt(int row, int column) {
			String pais = paisList.get(row).getNombre();
			return pais;
		}
		
	}
	
	

}
