package control;

import java.util.Scanner;

public class Menu {

	static Scanner teclado = new Scanner(System.in);

	public static int leerMenu() {

		int opcion;
		opcion = teclado.nextInt();

		return opcion;
	}

	public static void verMenu() {

		System.out.println("**MENÚ CONCESIONARIO**");
		System.out.println("1-MOSTRAR COCHES");
		System.out.println("2-MOSTRAR CLIENTES");
		System.out.println("3-MOSTRAR MODALIDADES");
		System.out.println("4-INSERTAR VENTA");
		System.out.println("5-MOSTRAR VENTAS");
		System.out.println("6-SALIR");
		System.out.println("Selecciona la opción que quieras visualizar:");
	}
}
