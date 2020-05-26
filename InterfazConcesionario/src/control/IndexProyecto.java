package control;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dao.ClienteDAO;
import dao.CocheDAO;
import dao.ModalidadDAO;
import dao.VentaDAO;
import modelo.Cliente;
import modelo.Coche;
import vista.Escritura;
import vista.Lectura;

public class IndexProyecto {

	static List<Coche> listaCoches = new ArrayList<>();

	static List<Cliente> listaClientes = new ArrayList<>();

	static Set<String> listaModalidades = new HashSet<>();

	static boolean salir = false;

	public static void main(String[] args) {

		// initDatos();

		while (!salir) {
			Menu.verMenu();
			opcionesMenu(Menu.leerMenu());
		}

	}

	private static void initDatos() {

		try {
			cargarCoches();
			CocheDAO.insertarCochesFichero(listaCoches);
			cargarClientes();
			ClienteDAO.insertarClientesFichero(listaClientes);
			cargarModalidades();
			ModalidadDAO.insertarModalidadesFichero(listaModalidades);

			System.out.println("-----TABLAS CARGADAS CORRECTAMENTE-----");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void opcionesMenu(int opcion) {

		try {
			switch (opcion) {
			case 1:
				Escritura.mostrarCoches(CocheDAO.listadoCoches());
				break;
			case 2:
				Escritura.mostrarClientes(ClienteDAO.listadoClientes());
				break;
			case 3:
				Escritura.mostrarModalidades(ModalidadDAO.listadoModalidades());
				break;
			case 4:
				Lectura.insertarVenta();
				break;
			case 5:
				Escritura.mostrarVentas(VentaDAO.listadoVentas());
			case 6:
				System.out.println("FIN DEL PROGRAMA");
				salir = true;
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void cargarCoches() {

		List<String> lineasFichero;

		lineasFichero = LecturaDoc.lectura("Ficheros/concesionario.csv");
		lineasFichero.remove(0);

		for (String s : lineasFichero) {

			String[] campo = s.split(",");

			listaCoches.add(new Coche(0, campo[1], campo[2], campo[3]));
		}
	}

	private static void cargarClientes() {

		List<String> lineasFichero;

		lineasFichero = LecturaDoc.lectura("Ficheros/clientes.csv");
		lineasFichero.remove(0);

		for (String s : lineasFichero) {

			String[] campo = s.split(",");

			listaClientes.add(new Cliente(0, campo[1], campo[2], campo[3], campo[4]));
		}
	}

	private static void cargarModalidades() {

		List<String> lineasFichero;

		lineasFichero = LecturaDoc.lectura("Ficheros/clientes.csv");
		lineasFichero.remove(0);

		for (String s : lineasFichero) {

			String[] campo = s.split(",");

			listaModalidades.add(campo[5]);
		}
	}

}
