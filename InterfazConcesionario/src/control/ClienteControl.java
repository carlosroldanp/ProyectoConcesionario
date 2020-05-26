package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.ClienteDAO;
import modelo.Cliente;
import vista.Escritura;

public class ClienteControl implements ActionListener {

	private JTextField txtNombre, txtApellido1, txtApellido2, txtTelef;
	private JDialog ventanaCliente;

	public ClienteControl(JDialog ventanaCliente, JTextField txtNombre, JTextField txtApellido1,
			JTextField txtApellido2, JTextField txtTelef) {
		this.ventanaCliente = ventanaCliente;
		this.txtNombre = txtNombre;
		this.txtApellido1 = txtApellido1;
		this.txtApellido2 = txtApellido2;
		this.txtTelef = txtTelef;
	}

	@Override
	public void actionPerformed(ActionEvent eventoCliente) {
		String opcion = eventoCliente.getActionCommand();
		if (opcion.equals("guardarCliente")) {
			try {

				if (ClienteDAO.insertarCliente(new Cliente(0, txtNombre.getText(), txtApellido1.getText(),
						txtApellido2.getText(), txtTelef.getText()))) {
					JOptionPane.showMessageDialog(null, "Se ha guardado correctamente");
					ventanaCliente.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Hay errores en los datos");
				}
				Escritura.mostrarClientes(ClienteDAO.listadoClientes());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
