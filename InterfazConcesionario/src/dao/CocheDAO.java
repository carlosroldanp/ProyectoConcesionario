package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Coche;

public class CocheDAO {

	public static boolean insertarCoche(Coche c) throws SQLException {

		EnlaceJDBC enlace = new EnlaceJDBC();

		String sqlInsert = "INSERT INTO coches (marca,modelo,tipo) VALUES ('" + c.getMarca() + "','" + c.getModelo()
				+ "','" + c.getTipoCoche() + "')";
		return enlace.insertar(sqlInsert);
	}

	public static boolean borrarCoche(Coche c) throws SQLException {

		EnlaceJDBC enlace = new EnlaceJDBC();

		String sqlDelete = "DELETE FROM coches WHERE id_coche=" + c.getIdCoche() + "";
		return enlace.insertar(sqlDelete);
	}

	public static boolean modificarCoche(Coche c) throws SQLException {

		EnlaceJDBC enlace = new EnlaceJDBC();
		String sqlUpdate = "UPDATE coches SET marca='" + c.getMarca() + "', modelo='" + c.getModelo() + "', tipo='"
				+ c.getTipoCoche() + "' WHERE id_coche=" + c.getIdCoche() + "";
		return enlace.insertar(sqlUpdate);

	}

	public static void insertarCochesFichero(List<Coche> listaCoches) throws SQLException {

		EnlaceJDBC enlace;

		enlace = new EnlaceJDBC();

		for (Coche c : listaCoches) {

			String sqlInsert = "INSERT INTO coches (marca,modelo,tipo) VALUES ('" + c.getMarca() + "','" + c.getModelo()
					+ "','" + c.getTipoCoche() + "')";
			enlace.insertar(sqlInsert);
		}
	}

	public static List<Coche> listadoCoches() throws SQLException {

		List<Coche> listaCoches = new ArrayList<>();

		String sqlQuery = "SELECT id_coche, marca, modelo, tipo FROM coches";

		EnlaceJDBC enlace;
		ResultSet rs = null;

		try {

			enlace = new EnlaceJDBC();

			rs = enlace.seleccionRegistros(sqlQuery);

			while (rs.next()) {

				listaCoches.add(new Coche(rs.getInt("id_coche"), rs.getString("marca"), rs.getString("modelo"),
						rs.getString("tipo")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaCoches;
	}
}
