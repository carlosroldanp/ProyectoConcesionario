package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.ClienteDAO;
import dao.CocheDAO;
import dao.ModalidadDAO;
import dao.VentaDAO;
import modelo.Cliente;
import modelo.Coche;
import modelo.Modalidad;
import modelo.Venta;
import vistaGrafica.NuevaVenta;
import vistaGrafica.NuevoCliente;
import vistaGrafica.NuevoCoche;
import vistaGrafica.VistaVentas;

public class Controlador implements ActionListener, WindowListener {

	List<Coche> listaCoches = new ArrayList<>();
	public JDialog ventana;
	private JTextArea txtListaCoches;
	public JTable tablaEdicion;

	public Controlador() {
	}

	public Controlador(JDialog ventana) {
		this.ventana = ventana;

	}

	public Controlador(JTextArea txtListaCoches) {
		this.setTxtListaCoches(txtListaCoches);
	}

	public Controlador(JTable tablaEdicion) {
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		String evento = ev.getActionCommand();

		if (evento.equals("abrirNuevoCoche")) {
			try {
				NuevoCoche wCoche = new NuevoCoche();
				wCoche.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				wCoche.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (evento.equals("abrirNuevoCliente")) {
			try {
				NuevoCliente wCliente = new NuevoCliente();
				wCliente.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				wCliente.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (evento.equals("abrirNuevaVenta")) {
			try {
				JTextField txtPrecio = new JTextField();
				List<Coche> listaCoches = CocheDAO.listadoCoches();
				Collections.sort(listaCoches);
				List<Cliente> listaClientes = ClienteDAO.listadoClientes();
				Collections.sort(listaClientes);
				List<Modalidad> listaModalidades = ModalidadDAO.listadoModalidades();
				NuevaVenta wVenta = new NuevaVenta(txtPrecio, listaCoches, listaClientes, listaModalidades);
				wVenta.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				wVenta.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (evento.equals("abrirVistaVentas")) {
			List<Venta> listaVentas = VentaDAO.listadoVentas();
			VistaVentas dialog = new VistaVentas(listaVentas);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}

		if (evento.equals("cancelar")) {
			ventana.dispose();
		}

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public JTextArea getTxtListaCoches() {
		return txtListaCoches;
	}

	public void setTxtListaCoches(JTextArea txtListaCoches) {
		this.txtListaCoches = txtListaCoches;
	}
}
