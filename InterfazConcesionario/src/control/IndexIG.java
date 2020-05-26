package control;

import java.awt.EventQueue;

import dao.CocheDAO;
import vistaGrafica.VentanaPrincipal;

public class IndexIG {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal(CocheDAO.listadoCoches());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
