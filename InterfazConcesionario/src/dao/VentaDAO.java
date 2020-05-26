package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.Coche;
import modelo.Modalidad;
import modelo.Venta;

public class VentaDAO {

	public static void insertarUnaVenta(Venta v) throws SQLException {
		EnlaceJDBC enlace;

		enlace = new EnlaceJDBC();

		String sqlInsert = "INSERT INTO ventas (id_venta,precio_venta,id_coche,id_cliente,id_modalidad)" + "VALUES ("
				+ v.getIdVenta() + "," + v.getPrecioVenta() + "," + v.getCocheVenta().getIdCoche() + ","
				+ v.getClienteVenta().getIdCliente() + "," + v.getModalidadVenta().getIdModalidad() + ")";
		if (enlace.insertar(sqlInsert)) {
			System.out.println("La venta se ha insertado correctamente");
		}
	}

	public static void insertarUnaVentaAN(Venta v) throws SQLException {
		EnlaceJDBC enlace;

		enlace = new EnlaceJDBC();

		String sqlInsert = "INSERT INTO ventas (precio_venta,id_coche,id_cliente,id_modalidad) " + "VALUES ("
				+ v.getPrecioVenta() + "," + v.getCocheVenta().getIdCoche() + "," + v.getClienteVenta().getIdCliente()
				+ "," + v.getModalidadVenta().getIdModalidad() + ")";

		System.out.println(sqlInsert);

		if (enlace.insertar(sqlInsert)) {
			System.out.println("Se ha insertado la venta correctamente");
		}
		v.setIdVenta(idVenta());
	}

	public static boolean borrarVenta(Venta venta) throws SQLException {

		EnlaceJDBC enlace = new EnlaceJDBC();

		String sqlDelete = "DELETE FROM ventas WHERE id_venta=" + venta.getIdVenta() + "";
		return enlace.insertar(sqlDelete);
	}

	public static void modificarIdVentas() {

		String updateQuery = "UPDATE ventas SET id_venta=1 where id_venta=4000";
		EnlaceJDBC enlace;
		try {
			enlace = new EnlaceJDBC();
			if (enlace.insertar(updateQuery)) {
				System.out.println("Se ha actualizado la venta correctamente");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Venta> listadoVentas() {

		List<Venta> listaVentas = new ArrayList<>();

		String sqlQuery = "SELECT ventas.id_venta, ventas.precio_venta, coches.id_coche, coches.marca, coches.modelo, coches.tipo, clientes.id_cliente, clientes.nombre_cliente, clientes.apellido1, clientes.apellido2, clientes.telefono, modalidades.id_modalidad, modalidades.tipo_modalidad "
				+ "FROM ventas " + "INNER JOIN coches ON ventas.id_coche = coches.id_coche "
				+ "INNER JOIN clientes ON ventas.id_cliente = clientes.id_cliente "
				+ "INNER JOIN modalidades ON ventas.id_modalidad = modalidades.id_modalidad "
				+ "ORDER BY ventas.id_venta";

		EnlaceJDBC enlace;
		ResultSet rs = null;
		Venta venta = null;
		try {
			enlace = new EnlaceJDBC();
			rs = enlace.seleccionRegistros(sqlQuery);
			while (rs.next()) {
				venta = new Venta();
				venta.setIdVenta(rs.getInt(1));
				venta.setPrecioVenta(rs.getFloat(2));
				venta.setCocheVenta(new Coche(rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6)));
				venta.setClienteVenta(new Cliente(rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11)));
				venta.setModalidadVenta(new Modalidad(rs.getInt(12), rs.getString(13)));
				listaVentas.add(venta);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaVentas;
	}

	public static List<Venta> listadoVentasBuscar(String texto) {

		List<Venta> listaVentas = new ArrayList<>();

		String sqlQuery = "SELECT ventas.id_venta, ventas.precio_venta, coches.id_coche, coches.marca, coches.modelo, coches.tipo, clientes.id_cliente, clientes.nombre_cliente, clientes.apellido1, clientes.apellido2, clientes.telefono, modalidades.id_modalidad, modalidades.tipo_modalidad "
				+ "FROM ventas " + "INNER JOIN coches ON ventas.id_coche = coches.id_coche "
				+ "INNER JOIN clientes ON ventas.id_cliente = clientes.id_cliente "
				+ "INNER JOIN modalidades ON ventas.id_modalidad = modalidades.id_modalidad "
				+ "WHERE coches.marca LIKE '%" + texto + "%'";

		EnlaceJDBC enlace;
		ResultSet rs = null;
		Venta venta = null;
		try {
			enlace = new EnlaceJDBC();
			rs = enlace.seleccionRegistros(sqlQuery);
			while (rs.next()) {
				venta = new Venta();
				venta.setIdVenta(rs.getInt(1));
				venta.setPrecioVenta(rs.getFloat(2));
				venta.setCocheVenta(new Coche(rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6)));
				venta.setClienteVenta(new Cliente(rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11)));
				venta.setModalidadVenta(new Modalidad(rs.getInt(12), rs.getString(13)));
				listaVentas.add(venta);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaVentas;
	}

	public static int idVenta() {
		int id = 0;
		String sqlQuery = "SELECT MAX(id_venta) FROM ventas";

		EnlaceJDBC enlace;
		ResultSet rs = null;

		try {
			enlace = new EnlaceJDBC();
			rs = enlace.seleccionRegistros(sqlQuery);
			rs.next();
			id = rs.getInt(1);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return id;
	}
}
