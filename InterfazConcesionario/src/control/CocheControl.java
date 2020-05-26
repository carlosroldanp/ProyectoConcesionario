package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.CocheDAO;
import modelo.Coche;
import vista.Escritura;

public class CocheControl implements ActionListener {

	private JTextField txtMarca, txtModelo, txtTipo;
	private JDialog ventanaCoche;

	public CocheControl(JDialog ventanaCoche, JTextField txtMarca, JTextField txtModelo, JTextField txtTipo) {
		this.ventanaCoche = ventanaCoche;
		this.txtMarca = txtMarca;
		this.txtModelo = txtModelo;
		this.txtTipo = txtTipo;
	}

	@Override
	public void actionPerformed(ActionEvent eventoCoche) {
		String opcion = eventoCoche.getActionCommand();
		if (opcion.equals("guardarCoche")) {
			try {

				if (CocheDAO.insertarCoche(new Coche(0, txtMarca.getText(), txtModelo.getText(), txtTipo.getText()))) {
					JOptionPane.showMessageDialog(null, "Se ha guardado correctamente");
					ventanaCoche.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Tiene algún error en los datos");
				}
				Escritura.mostrarCoches(CocheDAO.listadoCoches());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
