import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;
	private JTextField horaInicio;
	private JTextField horaFin;
	private Instancia instancia;
	private JTextField nombreMateria;

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
		frame.setResizable(false);
		frame.setBounds(100, 100, 397, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 0, 379, 528);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblInicio = new JLabel("Inicio:");
		lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInicio.setBounds(12, 62, 65, 16);
		panel.add(lblInicio);

		horaInicio = new JTextField();
		horaInicio.setBounds(79, 61, 116, 22);
		panel.add(horaInicio);
		horaInicio.setColumns(10);

		JLabel lblFin = new JLabel("Fin:");
		lblFin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFin.setBounds(12, 97, 65, 16);
		panel.add(lblFin);

		horaFin = new JTextField();
		horaFin.setColumns(10);
		horaFin.setBounds(79, 96, 116, 22);
		panel.add(horaFin);

		JButton btnAgregarMateria = new JButton("Agregar materia");
		btnAgregarMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bienIngresadas(horaInicio, horaFin) && horarioCorrecto(horaInicio, horaFin)) {
					Integer inicio = Integer.parseInt(horaInicio.getText());
					Integer fin = Integer.parseInt(horaFin.getText());
					String nombre = nombreMateria.getText();
					
					if (instancia != null)
						instancia.agregar(new Materia(nombre, inicio, fin));
					else {
						instancia = Instancia.Cargar("Instancia");
						instancia.limpiar();
						instancia.agregar(new Materia(nombre, inicio, fin));
					}
				}
			}

			private boolean horarioCorrecto(JTextField horaInicio, JTextField horaFin) {
				Integer inicio = Integer.parseInt(horaInicio.getText());
				Integer fin = Integer.parseInt(horaFin.getText());

				if (inicio > fin) {
					mensajeDeError("El inicio es posterior al fin!");
					return false;
				}
				return true;
			}

			private boolean bienIngresadas(JTextField horaInicio, JTextField horaFin) {
				String inicio = horaInicio.getText();
				String fin = horaFin.getText();

				Pattern pat = Pattern.compile("[8-9]|[1]\\d|[2][0-2]"); // del 8 al 9 																		// ||
																		// del 10 al 19|
																		// 20 al 22
				return errorDeIngreso(inicio, fin, pat);
			}

			private boolean errorDeIngreso(String inicio, String fin, Pattern pat) {
				Matcher mat = pat.matcher(inicio);
				if (!mat.matches())
					return mensajeDeError("El horario de inicio es inv�lido! Inicio = " + inicio);

				mat = pat.matcher(fin);
				if (!mat.matches())
					return mensajeDeError("El horario de fin es inv�lido! Fin = " + fin);

				if (inicio.equals(fin))
					return mensajeDeError("El horario de inicio y fin son iguales! horario = " + inicio);

				return true;
			}

			private boolean mensajeDeError(String error) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, error, "�Error!", JOptionPane.ERROR_MESSAGE);

				return false;
			}
		});
		btnAgregarMateria.setBounds(218, 57, 126, 31);
		panel.add(btnAgregarMateria);

		JButton btnCargarMaterias = new JButton("Cargar materias");
		btnCargarMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				instancia = Instancia.Cargar("Instancia");
				
				
				//borrar
				ArrayList<Materia> materias = instancia.getMaterias();
				for(Materia materia: materias)
					System.out.println(materia);
			}
		});
		btnCargarMaterias.setBounds(129, 484, 126, 31);
		panel.add(btnCargarMaterias);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (instancia != null) {
					instancia.Guardar("Instancia");
					JOptionPane.showMessageDialog(null, "�Se guard� exitosamente! ", "", JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		btnGuardar.setBounds(288, 484, 79, 31);
		panel.add(btnGuardar);
 
		JButton btnCalcularAulas = new JButton("Calcular Aulas");
		btnCalcularAulas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPrueba ventana = new VentanaPrueba();
				ventana.frame.setVisible(true);
				frame.setVisible(false);
			
			}
		});
		btnCalcularAulas.setBounds(129, 427, 126, 31);
		panel.add(btnCalcularAulas);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (instancia != null)
					confirmarNuevo();
			}

			private void confirmarNuevo() {
				Toolkit.getDefaultToolkit().beep();
				int respuesta = JOptionPane.showConfirmDialog(null, "�Esta seguro? �Borrar� todos sus valores!",
						"Alerta!", JOptionPane.YES_NO_OPTION);

				if (respuesta == 0)
					instancia.limpiar();
			}
		});
		btnNuevo.setBounds(12, 484, 79, 31);
		panel.add(btnNuevo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNombre.setBounds(12, 24, 65, 16);
		panel.add(lblNombre);
		
		nombreMateria = new JTextField();
		nombreMateria.setColumns(10);
		nombreMateria.setBounds(79, 23, 116, 22);
		panel.add(nombreMateria);
	}
}
