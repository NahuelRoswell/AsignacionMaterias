
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.text.TableView;
import javax.swing.text.TableView.TableRow;

public class VentanaPrueba {

	private JFrame frame;
	private JTable table;
	private Instancia instancia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrueba window = new VentanaPrueba();
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
	public VentanaPrueba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		instancia = Instancia.leerJSON("Instancia");
		frame = new JFrame();
		frame.setBounds(100, 100, 864, 773);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, frame.getWidth()-40/*ancho scrollPane*/, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, frame.getHeight()-57/*largo scrollPane*/, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		
		Solver solver = new Solver(instancia ,Comparador.porMenosHoras());
		ArrayList<Aula> aulas = solver.resolver();
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Horario/Aula ");
		//ArrayList<Aula> aulas = ret.getAulas();
		System.out.println(aulas.size());
		
		for (int i = 0; i < aulas.size(); i++) {
			model.addColumn("Aula " + String.valueOf(i + 1));
		}
		
		for (int i = 0; i < 15; i++) {
			model.addRow(new String[] { String.valueOf(i + 8) + " - " +String.valueOf(i+9) +"hs :" });
		}
		
		
		 //String s = (String)model.getValueAt(2,2); // fila y columna
		int ind = 1;
		for(Aula aula: aulas){
			if(aula!=null) 
			for(int j=0;j<aula.cantidadMaterias();j++){
				Materia mat = aula.getMateria(j);
				//System.out.println(mat);
				if(mat!=null){
					//System.out.println(mat.getNombre()+" entroo");
					model.setValueAt("Materia " +j, mat.getInicio()-8,ind);
				}
			}
			ind++;	
		} 
		

		
		
		table.setModel(model);

		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}
}