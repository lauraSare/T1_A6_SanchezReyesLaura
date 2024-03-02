import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class VentanaInicio extends JFrame implements ActionListener {

	private JRadioButton radioMillas, radioPies, radioPulgadas;
	private JCheckBox checkTodos;
	private JLabel etiquetaKm, etiquetaResultado;
	private JTextField cajaKm, cajaResultadoM, cajaResultadoPies, cajaResultadoPulgadas;

	private JButton btn;
	private ConversorDistancias conversor;

	public VentanaInicio() {
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Evento COMBO");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);

		// Configuración de la ventana principal (JFrame)-------------------------------------------
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Ejemplo Eventos RadioButtons - Checkboxes");
		getContentPane().setLayout(new FlowLayout());
		setSize(200, 300);
		setLocationRelativeTo(null); // deber ir después del método setSize
		setVisible(true);

		// Agregar componentes al JFrame--------------------------------------------------
		etiquetaKm = new JLabel("Ingresa Kilometros:");
		add(etiquetaKm);

		cajaKm = new JTextField("70", 10);
		cajaKm.setHorizontalAlignment(JTextField.RIGHT);
		add(cajaKm);

		checkTodos = new JCheckBox(" <<< TODOS >>>");
		checkTodos.addActionListener(this);
		add(checkTodos);

		ButtonGroup bg1 = new ButtonGroup();

		radioMillas = new JRadioButton("   Millas     ");
		radioMillas.addActionListener(this);
		add(radioMillas);
		bg1.add(radioMillas);
		cajaResultadoM = new JTextField("", 5);
		add(cajaResultadoM);

		radioPies = new JRadioButton("    Pies     ");
		radioPies.addActionListener(this);
		add(radioPies);
		bg1.add(radioPies);
		cajaResultadoPies = new JTextField("", 5);
		add(cajaResultadoPies);

		radioPulgadas = new JRadioButton("  Pulgadas   ");
		add(radioPulgadas);
		bg1.add(radioPulgadas);
		radioPulgadas.addActionListener(this);

		cajaResultadoPulgadas = new JTextField("", 5);
		add(cajaResultadoPulgadas);

		btn = new JButton("OK");
		add(btn);
		btn.addActionListener(this);

		// Inicializar el ConversorDistancias
		conversor = new ConversorDistancias();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		double km = Double.parseDouble(cajaKm.getText());

		if (e.getSource() == btn) {
			conversor.conversionMillas(km, cajaResultadoM, radioMillas);
			conversor.conversionPies(km, cajaResultadoPies, radioPies);
			conversor.conversionPulgadas(km, cajaResultadoPulgadas, radioPulgadas);
		} else if (e.getSource() == checkTodos) {
			if (checkTodos.isSelected()) {
				conversor.conversionMillas(km, cajaResultadoM, radioMillas);
				conversor.conversionPies(km, cajaResultadoPies, radioPies);
				conversor.conversionPulgadas(km, cajaResultadoPulgadas, radioPulgadas);
			}
		}
	}

	public class PruebaEventosRadioCheck {

		public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new VentanaInicio();
				}
			});
		}
	}
}


