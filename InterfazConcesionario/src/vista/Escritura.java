package vista;

import java.util.List;

import modelo.Cliente;
import modelo.Coche;
import modelo.Modalidad;
import modelo.Venta;

public class Escritura {

	public static void mostrarCoches(List<Coche> listaC) {

		for (Coche coche : listaC) {

			System.out.println(coche);
		}
	}

	public static void mostrarClientes(List<Cliente> listaCli) {

		for (Cliente cliente : listaCli) {

			System.out.println(cliente);
		}
	}

	public static void mostrarModalidades(List<Modalidad> listaM) {

		for (Modalidad modalidad : listaM) {

			System.out.println(modalidad);
		}
	}

	public static void mostrarVentas(List<Venta> listaV) {

		for (Venta venta : listaV) {

			System.out.println(venta.toString());
		}
	}

}
