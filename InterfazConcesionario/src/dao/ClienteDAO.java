package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public class ClienteDAO {

	public static boolean insertarCliente(Cliente cliente) throws SQLException {

		EnlaceJDBC enlace = new EnlaceJDBC();

		String sqlInsert = "INSERT INTO clientes (nombre_cliente,apellido1,apellido2,telefono) VALUES ('"
				+ cliente.getNombre() + "','" + cliente.getApellido1() + "','" + cliente.getApellido2() + "','"
				+ cliente.getTelefono() + "')";
		return enlace.insertar(sqlInsert);
	}

	public static boolean borrarCliente(Cliente cliente) throws SQLException {

		EnlaceJDBC enlace = new EnlaceJDBC();

		String sqlDelete = "DELETE FROM clientes WHERE id_cliente=" + cliente.getIdCliente() + "";
		return enlace.insertar(sqlDelete);
	}

	public static boolean modificarCliente(Cliente cliente) throws SQLException {

		EnlaceJDBC enlace = new EnlaceJDBC();
		String sqlUpdate = "UPDATE clientes SET nombre_cliente='" + cliente.getNombre() + "', apellido1='"
				+ cliente.getApellido1() + "', apellido2='" + cliente.getApellido2() + "', telefono='"
				+ cliente.getTelefono() + "' WHERE id_cliente=" + cliente.getIdCliente() + "";
		return enlace.insertar(sqlUpdate);

	}

	/*
	 * A partir de un fichero con todos los clientes, creamos una lista y los
	 * insertamos en la BBDD.
	 */
	public static void insertarClientesFichero(List<Cliente> listaClientes) throws SQLException {

		EnlaceJDBC enlace;

		enlace = new EnlaceJDBC();

		for (Cliente cliente : listaClientes) {

			String sqlInsert = "INSERT INTO clientes (nombre_cliente,apellido1,apellido2,telefono) VALUES ('"
					+ cliente.getNombre() + "','" + cliente.getApellido1() + "','" + cliente.getApellido2() + "','"
					+ cliente.getTelefono() + "')";
			enlace.insertar(sqlInsert);
		}
	}

	public static List<Cliente> listadoClientes() throws SQLException {

		List<Cliente> listaClientes = new ArrayList<>();

		String sqlQuery = "SELECT id_cliente, nombre_cliente, apellido1, apellido2, telefono FROM clientes";

		EnlaceJDBC enlace;
		ResultSet rs = null;

		try {

			enlace = new EnlaceJDBC();

			rs = enlace.seleccionRegistros(sqlQuery);

			while (rs.next()) {

				listaClientes.add(new Cliente(rs.getInt("id_cliente"), rs.getString("nombre_cliente"),
						rs.getString("apellido1"), rs.getString("apellido2"), rs.getString("telefono")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaClientes;
	}
}
