package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import modelo.Modalidad;

public class ModalidadDAO {

	public static void insertarUnaModalidad(Modalidad m) throws SQLException {

		EnlaceJDBC enlace = new EnlaceJDBC();

		String sqlInsert = "INSERT INTO modalidades (tipo_modalidad) VALUES ('" + m.getTipoModalidad() + "')";

		if (enlace.insertar(sqlInsert)) {
			System.out.println("Se ha insertado la modalidad correctamente");
		}
	}

	public static boolean borrarModalidad(Modalidad m) throws SQLException {

		EnlaceJDBC enlace = new EnlaceJDBC();

		String sqlDelete = "DELETE FROM modalidades WHERE id_modalidad=" + m.getIdModalidad() + "";
		return enlace.insertar(sqlDelete);
	}

	public static boolean modificarModalidad(Modalidad m) throws SQLException {

		EnlaceJDBC enlace = new EnlaceJDBC();
		String sqlUpdate = "UPDATE modalidades SET tipo_modalidad='" + m.getTipoModalidad() + "' WHERE id_modalidad="
				+ m.getIdModalidad() + "";
		return enlace.insertar(sqlUpdate);

	}

	public static void insertarModalidadesFichero(Set<String> listaModalidades) throws SQLException {

		EnlaceJDBC enlace;

		enlace = new EnlaceJDBC();

		for (String m : listaModalidades) {

			String sqlInsert = "INSERT INTO modalidades (tipo_modalidad) VALUES ('" + m + "')";
			enlace.insertar(sqlInsert);
		}
	}

	public static List<Modalidad> listadoModalidades() throws SQLException {

		List<Modalidad> listaModalidades = new ArrayList<>();

		String sqlQuery = "SELECT id_modalidad, tipo_modalidad FROM modalidades";

		EnlaceJDBC enlace;
		ResultSet rs = null;

		try {

			enlace = new EnlaceJDBC();

			rs = enlace.seleccionRegistros(sqlQuery);

			while (rs.next()) {

				listaModalidades.add(new Modalidad(rs.getInt(1), rs.getString("tipo_modalidad")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaModalidades;
	}
}
