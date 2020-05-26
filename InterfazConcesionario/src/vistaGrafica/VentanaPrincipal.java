package vistaGrafica;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import control.Controlador;
import modelo.Coche;
import java.awt.Font;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(List<Coche> listaCoches) {

		setTitle("Concesionario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 450, 490);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenu mnNuevo = new JMenu("Nuevo");
		menuBar.add(mnNuevo);

		JMenuItem mntmCoche = new JMenuItem("Coche");
		mntmCoche.setActionCommand("abrirNuevoCoche");
		mntmCoche.addActionListener(new Controlador());
		mnNuevo.add(mntmCoche);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.setActionCommand("abrirNuevoCliente");
		mntmCliente.addActionListener(new Controlador());
		mnNuevo.add(mntmCliente);

		JMenuItem mntmVenta = new JMenuItem("Venta");
		mntmVenta.setActionCommand("abrirNuevaVenta");
		mntmVenta.addActionListener(new Controlador());
		mnNuevo.add(mntmVenta);

		JMenu mnEdicion = new JMenu("Edicion");
		menuBar.add(mnEdicion);

		JMenuItem mntmVentas = new JMenuItem("Ventas");
		mntmVentas.setActionCommand("editarVentas");
		mntmVentas.addActionListener(new Controlador());
		mnEdicion.add(mntmVentas);

		JMenu mnSalir = new JMenu("Salir");
		menuBar.add(mnSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new BoxLayout(panelNorte, BoxLayout.X_AXIS));

		JPanel panel1 = new JPanel();
		panelNorte.add(panel1);

		JButton btnCoche = new JButton("COCHE");
		btnCoche.setActionCommand("abrirNuevoCoche");
		btnCoche.addActionListener(new Controlador());
		panel1.add(btnCoche);

		JButton btnCliente = new JButton("CLIENTE");
		btnCliente.setActionCommand("abrirNuevoCliente");
		btnCliente.addActionListener(new Controlador());
		panel1.add(btnCliente);

		JButton btnVenta = new JButton("VENTA");
		btnVenta.setActionCommand("abrirNuevaVenta");
		btnVenta.addActionListener(new Controlador());
		panel1.add(btnVenta);

		JPanel panel2 = new JPanel();
		panelNorte.add(panel2);

		JPanel panel3 = new JPanel();
		panelNorte.add(panel3);

		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.X_AXIS));

		JTextArea textACoches = new JTextArea();
		textACoches.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));

		StringBuilder bld = new StringBuilder();
		bld.append("LISTADO DE COCHES ACTUAL:");
		for (Coche c : listaCoches) {

			bld.append("\n" + c.getIdCoche() + "-> " + c.getMarca() + " | " + c.getModelo() + " | " + c.getTipoCoche()
					+ " |");
		}
		textACoches.setText(bld.toString());
		JScrollPane scroll = new JScrollPane(textACoches);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		textACoches.setEditable(false);
		panelCentral.add(scroll);

		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);

		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);

		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);

		this.addWindowListener(new Controlador(textACoches));
	}

}
