package vista;

import java.util.Scanner;

import dao.ClienteDAO;
import dao.CocheDAO;
import dao.ModalidadDAO;
import dao.VentaDAO;
import modelo.Cliente;
import modelo.Coche;
import modelo.Modalidad;
import modelo.Venta;

public class Lectura {

	static Scanner scan = new Scanner(System.in);

	public static int leerCocheI() {
		System.out.println("Seleccione uno de los coches, (id):");
		return scan.nextInt();
	}

	public static int leerClienteI() {
		System.out.println("Seleccione el cliente que adquiera el coche, (id):");
		return scan.nextInt();
	}

	public static int leerModalidadI() {
		System.out.println("Seleccione la modalidad para el coche, (id):");
		return scan.nextInt();
	}

	public static void insertarVenta() {
		try {
			Venta venta1 = new Venta();

			venta1.setPrecioVenta(20500f);

			Escritura.mostrarCoches(CocheDAO.listadoCoches());
			venta1.setCocheVenta(new Coche(Lectura.leerCocheI(), null, null, null));

			Escritura.mostrarClientes(ClienteDAO.listadoClientes());
			venta1.setClienteVenta(new Cliente(Lectura.leerClienteI(), null, null, null, null));

			Escritura.mostrarModalidades(ModalidadDAO.listadoModalidades());
			venta1.setModalidadVenta(new Modalidad(Lectura.leerModalidadI(), null));

			VentaDAO.insertarUnaVentaAN(venta1);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
