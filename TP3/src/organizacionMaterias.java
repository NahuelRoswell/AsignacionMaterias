import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollPane;

public class organizacionMaterias {

	private JFrame frame;
	private JTable table;
	private Solver solver;
	private Instancia instancia;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					organizacionMaterias window = new organizacionMaterias();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public organizacionMaterias() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1021, 757);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ArrayList<Aula> aulas = construirSolucion();
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("hola");
		model.addColumn("hola2");
		model.addColumn("hola3");

		model.addRow(new String[] { "hola", "chau", "hola" });
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 47, 1003, 663);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		
		//editar y tomar valor de la celad
		TableModel model1 = table.getModel();
		String s = (String)model.getValueAt(0,0);
		model.setValueAt("dato", 0, 1);
		
		
		

//		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
//		dtcr.setHorizontalAlignment(JLabel.CENTER);
//		dtcr.setBackground(Color.black);
//		
//		TableColumn col = table.getColumnModel().getColumn(0);
//		col.setCellRenderer(dtcr);
		
			
		table.setModel(model);
	}

	private ArrayList<Aula> construirSolucion() {
		
		return null;
	}

}
