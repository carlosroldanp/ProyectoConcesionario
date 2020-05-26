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

import control.CocheControl;
import control.Controlador;

public class NuevoCoche extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtTipo;

	public NuevoCoche() {
		setTitle("Insertar Nuevo Coche");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblMarca = new JLabel("MARCA:");
			lblMarca.setFont(new Font("Tahoma", Font.BOLD, 15));
			GridBagConstraints gbc_lblMarca = new GridBagConstraints();
			gbc_lblMarca.insets = new Insets(0, 0, 5, 5);
			gbc_lblMarca.gridx = 4;
			gbc_lblMarca.gridy = 1;
			contentPanel.add(lblMarca, gbc_lblMarca);
		}
		{
			txtMarca = new JTextField();
			txtMarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_txtMarca = new GridBagConstraints();
			gbc_txtMarca.insets = new Insets(0, 0, 5, 0);
			gbc_txtMarca.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtMarca.gridx = 6;
			gbc_txtMarca.gridy = 1;
			contentPanel.add(txtMarca, gbc_txtMarca);
			txtMarca.setColumns(10);
		}
		{
			JLabel lblModelo = new JLabel("MODELO:");
			lblModelo.setFont(new Font("Tahoma", Font.BOLD, 15));
			GridBagConstraints gbc_lblModelo = new GridBagConstraints();
			gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
			gbc_lblModelo.gridx = 4;
			gbc_lblModelo.gridy = 2;
			contentPanel.add(lblModelo, gbc_lblModelo);
		}
		{
			txtModelo = new JTextField();
			txtModelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_txtModelo = new GridBagConstraints();
			gbc_txtModelo.insets = new Insets(0, 0, 5, 0);
			gbc_txtModelo.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtModelo.gridx = 6;
			gbc_txtModelo.gridy = 2;
			contentPanel.add(txtModelo, gbc_txtModelo);
			txtModelo.setColumns(10);
		}
		{
			JLabel lblTipo = new JLabel("TIPO:");
			lblTipo.setFont(new Font("Tahoma", Font.BOLD, 15));
			GridBagConstraints gbc_lblTipo = new GridBagConstraints();
			gbc_lblTipo.insets = new Insets(0, 0, 0, 5);
			gbc_lblTipo.gridx = 4;
			gbc_lblTipo.gridy = 3;
			contentPanel.add(lblTipo, gbc_lblTipo);
		}
		{
			txtTipo = new JTextField();
			txtTipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_txtTipo = new GridBagConstraints();
			gbc_txtTipo.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtTipo.gridx = 6;
			gbc_txtTipo.gridy = 3;
			contentPanel.add(txtTipo, gbc_txtTipo);
			txtTipo.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("GUARDAR");
				okButton.setFont(new Font("Verdana Pro", Font.PLAIN, 13));
				okButton.setActionCommand("guardarCoche");
				okButton.addActionListener(new CocheControl(this, txtMarca, txtModelo, txtTipo));
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
