package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EnlaceJDBC {

	private static final String URL = "jdbc:mysql://localhost:3306/proyecto_concesionario";
	private static final String USUARIO = "root";
	private static final String CLAVE = "";

	private Conexion unaConexion;
	private Connection connection;

	/*
	 * Enlace que conecta a nuestra bbdd y realiza operaciones SQL
	 */
	public EnlaceJDBC() throws SQLException {

		unaConexion = new Conexion(URL, USUARIO, CLAVE);
	}

	public boolean insertar(String sqlInsert) throws SQLException {

		unaConexion.conectar();
		connection = unaConexion.getJdbcConnection();
		Statement statement = connection.createStatement();

		// Ejecutamos la sentencia
		boolean rowInserted = statement.executeUpdate(sqlInsert) > 0;
		statement.close();
		unaConexion.desconectar();
		return rowInserted;
	}

	public ResultSet seleccionRegistros(String consultaSQL) {
		Statement sentencia = null;
		ResultSet filas = null;

		try {
			unaConexion.conectar();
			connection = unaConexion.getJdbcConnection();
			sentencia = connection.createStatement();
			filas = sentencia.executeQuery(consultaSQL);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filas;

	}
}
