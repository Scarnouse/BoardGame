package com.boreas.controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que crea las tablas de la BD
 * @author Manuel Quesada Segura
 * @version 0.0
 *
 */
public class CrearTablas {
	private static Statement sentencia;
	/**
	 * Métod para crear las tablas de la BD
	 * @param con conexión abierta a la BD SQLite
	 */
	public static  void crearTablaJuego(Connection con){
		
		String sql1 = "CREATE TABLE IF NOT EXISTS JUEGO ("
				+ "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "NOMBRE TEXT,"
				+ "ANYO INTEGER,"
				+ "MINIMO INTEGER,"
				+ "MAXIMO INTEGER,"
				+ "TIEMPO INTEGER,"
				+ "RANKING INTEGER,"
				+ "RATING REAL)";
		try {
			sentencia = con.createStatement();
			sentencia.executeUpdate(sql1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

