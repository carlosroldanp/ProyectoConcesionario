package vistaGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.ClienteControl;
import control.Controlador;

public class NuevoCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido1;
	private JTextField txtApellido2;
	private JTextField txtTelef;

	public NuevoCliente() {

		setTitle("Insertar Nuevo Cliente");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNombre = new JLabel("NOMBRE:");
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 4;
			gbc_lblNombre.gridy = 1;
			contentPanel.add(lblNombre, gbc_lblNombre);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_txtNombre = new GridBagConstraints();
			gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
			gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtNombre.gridx = 6;
			gbc_txtNombre.gridy = 1;
			contentPanel.add(txtNombre, gbc_txtNombre);
			txtNombre.setColumns(10);
		}
		{
			JLabel lblApellido = new JLabel("APELLIDO1:");
			lblApellido.setFont(new Font("Tahoma", Font.BOLD, 15));
			GridBagConstraints gbc_lblApellido = new GridBagConstraints();
			gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
			gbc_lblApellido.gridx = 4;
			gbc_lblApellido.gridy = 2;
			contentPanel.add(lblApellido, gbc_lblApellido);
		}
		{
			txtApellido1 = new JTextField();
			txtApellido1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_txtApellido1 = new GridBagConstraints();
			gbc_txtApellido1.insets = new Insets(0, 0, 5, 0);
			gbc_txtApellido1.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtApellido1.gridx = 6;
			gbc_txtApellido1.gridy = 2;
			contentPanel.add(txtApellido1, gbc_txtApellido1);
			txtApellido1.setColumns(10);
		}
		{
			JLabel lblApellido2 = new JLabel("APELLIDO2:");
			lblApellido2.setFont(new Font("Tahoma", Font.BOLD, 15));
			GridBagConstraints gbc_lblApellido2 = new GridBagConstraints();
			gbc_lblApellido2.insets = new Insets(0, 0, 5, 5);
			gbc_lblApellido2.gridx = 4;
			gbc_lblApellido2.gridy = 3;
			contentPanel.add(lblApellido2, gbc_lblApellido2);
		}
		{
			txtApellido2 = new JTextField();
			txtApellido2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_txtApellido2 = new GridBagConstraints();
			gbc_txtApellido2.insets = new Insets(0, 0, 5, 0);
			gbc_txtApellido2.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtApellido2.gridx = 6;
			gbc_txtApellido2.gridy = 3;
			contentPanel.add(txtApellido2, gbc_txtApellido2);
			txtApellido2.setColumns(10);
		}
		{
			JLabel lblTelefono = new JLabel("TELEFONO:");
			lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 15));
			GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
			gbc_lblTelefono.insets = new Insets(0, 0, 0, 5);
			gbc_lblTelefono.gridx = 4;
			gbc_lblTelefono.gridy = 4;
			contentPanel.add(lblTelefono, gbc_lblTelefono);
		}
		{
			txtTelef = new JTextField();
			txtTelef.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_txtTelef = new GridBagConstraints();
			gbc_txtTelef.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtTelef.gridx = 6;
			gbc_txtTelef.gridy = 4;
			contentPanel.add(txtTelef, gbc_txtTelef);
			txtTelef.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("GUARDAR");
				okButton.setFont(new Font("Verdana Pro", Font.PLAIN, 13));
				okButton.setActionCommand("guardarCliente");
				okButton.addActionListener(new ClienteControl(this, txtNombre, txtApellido1, txtApellido2, txtTelef));
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("CANCELAR");
				cancelButton.setFont(new Font("Verdana Pro", Font.PLAIN, 13));
				cancelButton.setActionCommand("cancelar");
				cancelButton.addActionListener(new Controlador(this));
				buttonPane.add(cancelButton);
			}
		}
	}
}
