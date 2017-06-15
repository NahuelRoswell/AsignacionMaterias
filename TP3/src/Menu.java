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
		
		
		JLabel lblInicio = new JLabel("Inicio:");
		lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInicio.setBounds(12, 32, 65, 16);
		panel.add(lblInicio);
		
		horaInicio = new JTextField();
		horaInicio.setBounds(69, 31, 116, 22);
		panel.add(horaInicio);
		horaInicio.setColumns(10);
		
		JLabel lblFin = new JLabel("Fin:");
		lblFin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFin.setBounds(12, 78, 65, 16);
		panel.add(lblFin);
		
		horaFin = new JTextField();
		horaFin.setColumns(10);
		horaFin.setBounds(69, 77, 116, 22);
		panel.add(horaFin);
		
		JButton btnAgregarMateria = new JButton("Agregar materia");
		btnAgregarMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bienIngresadas(horaInicio, horaFin)) {
					Integer inicio = Integer.parseInt(horaInicio.getText());
					Integer fin = Integer.parseInt(horaFin.getText());
					
					instancia.agregar(new Materia(inicio, fin));
				}
			}
			
			private boolean bienIngresadas(JTextField horaInicio, JTextField horaFin) {
				String inicio = horaInicio.getText();
				String fin = horaFin.getText();
				
				Pattern pat = Pattern.compile("[8-9]|[1]\\d|[2][0-2]"); //del 8 al 9   ||  del 10 al 19 || 20 al 22
				
				return errorDeIngreso(inicio, fin, pat);
			}

			private boolean errorDeIngreso(String inicio, String fin, Pattern pat) {
				Matcher mat = pat.matcher(inicio);
				if (!mat.matches())
					return mensajeDeError("inicio");
				
				mat = pat.matcher(fin);
				if (!mat.matches())
					return mensajeDeError("fin");
				
				if (inicio.equals(fin))
					return mensajeDeError("[inicio y fin]");
				
				return true;
			}

			private boolean mensajeDeError(String horario) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "¡El horario de " +horario +" es inválido! "
						,"¡Error em el horario de"+horario+"!" , JOptionPane.ERROR_MESSAGE);
				
				return false;
			}
		});
		btnAgregarMateria.setBounds(212, 47, 126, 31);
		panel.add(btnAgregarMateria);
		
		JButton btnCargarMaterias = new JButton("Cargar materias");
		btnCargarMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				instancia = Instancia.leerJSON("Instancia");
				
				
				
				//borrar
				ArrayList<Materia> materias = instancia.getMaterias();
				for(Materia m : materias)
					System.out.println(m);
			}
		});
		btnCargarMaterias.setBounds(129, 484, 126, 31);
		panel.add(btnCargarMaterias);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (instancia != null){
					instancia.Guardar("Instancia");
					JOptionPane.showMessageDialog(null, "¡Se guardó exitosamente! ", "",JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		btnGuardar.setBounds(288, 484, 79, 31);
		panel.add(btnGuardar);
		
		JButton btnCalcularAulas = new JButton("Calcular Aulas");
		btnCalcularAulas.setBounds(129, 427, 126, 31);
		panel.add(btnCalcularAulas);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(instancia!=null)	
					confirmarNuevo();
			}

			private void confirmarNuevo() {
				Toolkit.getDefaultToolkit().beep();
				int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro? ¡Borrará todos sus valores!"
						, "Alerta!", JOptionPane.YES_NO_OPTION);
				
				if (respuesta == 0)
					instancia.limpiar();
				
			}
		});
		btnNuevo.setBounds(12, 484, 79, 31);
		panel.add(btnNuevo);
	}
}
