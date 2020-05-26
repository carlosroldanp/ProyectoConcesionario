package vistaGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.VentaControl;
import modelo.Venta;

public class VistaVentas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	String[] nombreColumna = { "ID", "MARCA COCHE", "NOMBRE CLIENTE", "MODALIDAD", "PRECIO" };
	Object[][] datos;
	private List<Venta> listaVentas;
	private final JLabel lblBuscar = new JLabel("BUSCAR");
	private final JTextField txtBusca = new JTextField();
	private Map<String, Object> variables = new HashMap<>();

	public void ingresarDatos() {
		datos = new Object[listaVentas.size()][5];

		for (int i = 0; i < listaVentas.size(); i++) {
			datos[i][0] = listaVentas.get(i).getIdVenta() + "";
			datos[i][1] = listaVentas.get(i).getCocheVenta().getMarca();
			datos[i][2] = listaVentas.get(i).getClienteVenta().getNombre();
			datos[i][3] = listaVentas.get(i).getModalidadVenta().getTipoModalidad();
			datos[i][4] = listaVentas.get(i).getPrecioVenta() + "";
		}
	}

	/**
	 * Create the dialog.
	 */
	public VistaVentas(List<Venta> listaVentas) {
		setTitle("Vista Ventas");
		this.listaVentas = listaVentas;

		setBounds(100, 100, 825, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		ingresarDatos();
		DefaultTableModel modelo = new DefaultTableModel(datos, nombreColumna);
		JTable tabla = new JTable(modelo);
		variables.put("tabla", tabla);
		JScrollPane scroll = new JScrollPane(tabla);
		// scroll.add(tabla);
		contentPanel.add(scroll);
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("GUARDAR");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("CANCELAR");
				cancelButton.setActionCommand("cancelar");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new GridLayout(1, 0, 0, 0));
			{
				panel.add(lblBuscar);
			}
			{
				txtBusca.setHorizontalAlignment(SwingConstants.RIGHT);
				panel.add(txtBusca);
				txtBusca.setColumns(10);
				txtBusca.setActionCommand("tecla");
				variables.put("txtBusqueda", txtBusca);
				txtBusca.addKeyListener(new VentaControl(variables));
			}
		}
	}

}
