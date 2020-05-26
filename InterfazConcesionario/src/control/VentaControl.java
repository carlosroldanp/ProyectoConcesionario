package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.VentaDAO;
import modelo.Cliente;
import modelo.Coche;
import modelo.Modalidad;
import modelo.Venta;

public class VentaControl implements ActionListener, KeyListener {
	String[] nombreColumna = { "ID", "MARCA COCHE", "NOMBRE CLIENTE", "MODALIDAD", "PRECIO" };
	private JTextField txtPrecio;
	private JComboBox<Coche> cmbCoche;
	private JComboBox<Cliente> cmbCliente;
	private JComboBox<Modalidad> cmbModalidad;
	private JDialog ventanaV;
	private Map<String, Object> variables;

	public VentaControl(Map<String, Object> variables) {
		this.variables = variables;
	}

	public VentaControl(JDialog ventanaV, JTextField txtPrecio, JComboBox<Coche> cmbCoche,
			JComboBox<Cliente> cmbCliente, JComboBox<Modalidad> cmbModalidad) {
		this.ventanaV = ventanaV;
		this.txtPrecio = txtPrecio;
		this.cmbCoche = cmbCoche;
		this.cmbCliente = cmbCliente;
		this.cmbModalidad = cmbModalidad;
	}

	@Override
	public void actionPerformed(ActionEvent eventoVenta) {

		String opcion = eventoVenta.getActionCommand();
		if (opcion.equals("guardarVenta")) {
			Venta venta = new Venta();
			venta.setPrecioVenta(Float.valueOf(txtPrecio.getText().toString()));
			venta.setCocheVenta((Coche) cmbCoche.getSelectedItem());
			venta.setClienteVenta((Cliente) cmbCliente.getSelectedItem());
			venta.setModalidadVenta((Modalidad) cmbModalidad.getSelectedItem());
			try {
				VentaDAO.insertarUnaVentaAN(venta);
				JOptionPane.showMessageDialog(null, "Se ha guardado correctamente");
				ventanaV.dispose();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public String[][] rellenarTabla(List<Venta> listaVentas) {
		String[][] datos = new String[listaVentas.size()][5];
		for (int i = 0; i < listaVentas.size(); i++) {
			datos[i][0] = listaVentas.get(i).getIdVenta() + "";
			datos[i][1] = listaVentas.get(i).getCocheVenta().getMarca();
			datos[i][2] = listaVentas.get(i).getClienteVenta().getNombre();
			datos[i][3] = listaVentas.get(i).getModalidadVenta().getTipoModalidad();
			datos[i][4] = listaVentas.get(i).getPrecioVenta() + "";
		}
		return datos;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		String texto = ((JTextField) variables.get("txtBusqueda")).getText();
		List<Venta> listaVentas = VentaDAO.listadoVentasBuscar(texto);
		DefaultTableModel modelo = new DefaultTableModel(rellenarTabla(listaVentas), nombreColumna);
		((JTable) variables.get("tabla")).setModel(modelo);
	}

}
