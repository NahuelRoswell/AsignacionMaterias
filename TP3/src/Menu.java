import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Menu {

	private JFrame frame;
	private JTextField textField;
	private JTextField textFieldFin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 397, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 379, 528);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAgregarMateria = new JButton("Agregar materia");
		btnAgregarMateria.setBounds(212, 47, 126, 31);
		panel.add(btnAgregarMateria);
		
		JLabel lblInicio = new JLabel("Inicio:");
		lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInicio.setBounds(12, 32, 65, 16);
		panel.add(lblInicio);
		
		textField = new JTextField();
		textField.setBounds(69, 31, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblFin = new JLabel("Fin:");
		lblFin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFin.setBounds(12, 78, 65, 16);
		panel.add(lblFin);
		
		textFieldFin = new JTextField();
		textFieldFin.setColumns(10);
		textFieldFin.setBounds(69, 77, 116, 22);
		panel.add(textFieldFin);
		
		JButton btnCargarMaterias = new JButton("Cargar materias");
		btnCargarMaterias.setBounds(129, 484, 126, 31);
		panel.add(btnCargarMaterias);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(288, 484, 79, 31);
		panel.add(btnGuardar);
		
		JButton btnCalcularAulas = new JButton("Calcular Aulas");
		btnCalcularAulas.setBounds(129, 427, 126, 31);
		panel.add(btnCalcularAulas);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(12, 484, 79, 31);
		panel.add(btnNuevo);
	}
}
