package vistaGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.Controlador;
import control.VentaControl;
import modelo.Cliente;
import modelo.Coche;
import modelo.Modalidad;

public class NuevaVenta extends JDialog {

	private JPanel contentPanel;
	private JPanel buttonPane;
	private JTextField txtPrecio;
	private List<Coche> listaCoches;
	private List<Cliente> listaClientes;
	private List<Modalidad> listaModalidades;
	private JComboBox<Coche> cmbCoche = new JComboBox<>();
	private JComboBox<Cliente> cmbCliente = new JComboBox<>();
	private JComboBox<Modalidad> cmbModalidad = new JComboBox<>();

	public NuevaVenta(JTextField txtPrecio, List<Coche> listaCoches, List<Cliente> listaClientes,
			List<Modalidad> listaModalidades) {
		this.txtPrecio = txtPrecio;
		this.listaCoches = listaCoches;
		this.listaClientes = listaClientes;
		this.listaModalidades = listaModalidades;

		setBounds(100, 100, 820, 300);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Insertar Nueva Venta");

		iniciarPanelCentral();
		iniciarPanelBotones();
	}

	private void iniciarPanelCentral() {

		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 35, 58, 35, 299, 0 };
		gbl_contentPanel.rowHeights = new int[] { 35, 22, 22, 0, 0, 0, 59, 16, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		for (Coche c : listaCoches) {

			cmbCoche.addItem(c);
		}
		for (Cliente cl : listaClientes) {

			cmbCliente.addItem(cl);
		}
		for (Modalidad m : listaModalidades) {

			cmbModalidad.addItem(m);
		}

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 1;
		gbc_lblPrecio.gridy = 2;
		contentPanel.add(lblPrecio, gbc_lblPrecio);

		txtPrecio.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
		gbc_txtPrecio.insets = new Insets(0, 0, 5, 0);
		gbc_txtPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecio.gridx = 3;
		gbc_txtPrecio.gridy = 2;
		contentPanel.add(txtPrecio, gbc_txtPrecio);
		txtPrecio.setColumns(10);

		JLabel lblCoche = new JLabel("Coche:");
		lblCoche.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblCoche = new GridBagConstraints();
		gbc_lblCoche.insets = new Insets(0, 0, 5, 5);
		gbc_lblCoche.gridx = 1;
		gbc_lblCoche.gridy = 3;
		contentPanel.add(lblCoche, gbc_lblCoche);

		cmbCoche.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_cmbCoche = new GridBagConstraints();
		gbc_cmbCoche.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbCoche.insets = new Insets(0, 0, 5, 0);
		gbc_cmbCoche.gridx = 3;
		gbc_cmbCoche.gridy = 3;
		contentPanel.add(cmbCoche, gbc_cmbCoche);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 1;
		gbc_lblCliente.gridy = 4;
		contentPanel.add(lblCliente, gbc_lblCliente);

		cmbCliente.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_cmbCliente = new GridBagConstraints();
		gbc_cmbCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbCliente.insets = new Insets(0, 0, 5, 0);
		gbc_cmbCliente.gridx = 3;
		gbc_cmbCliente.gridy = 4;
		contentPanel.add(cmbCliente, gbc_cmbCliente);

		JLabel lblModalidad = new JLabel("Modalidad:");
		lblModalidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblModalidad = new GridBagConstraints();
		gbc_lblModalidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblModalidad.gridx = 1;
		gbc_lblModalidad.gridy = 5;
		contentPanel.add(lblModalidad, gbc_lblModalidad);

		cmbModalidad.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 5;
		contentPanel.add(cmbModalidad, gbc_comboBox);

	}

	private void iniciarPanelBotones() {

		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("GUARDAR");
		okButton.setActionCommand("guardarVenta");
		okButton.addActionListener(new VentaControl(this, txtPrecio, cmbCoche, cmbCliente, cmbModalidad));
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("CANCELAR");
		cancelButton.setActionCommand("cancelar");
		cancelButton.addActionListener(new Controlador(this));
		buttonPane.add(cancelButton);
	}

}
