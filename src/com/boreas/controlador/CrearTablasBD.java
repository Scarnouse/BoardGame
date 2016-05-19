package com.boreas.controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.boreas.modelo.Juego;

/**
 * Clase que crea las tablas de la BD
 * @author Manuel Quesada Segura
 * @version 0.0
 *
 */
public class CrearTablasBD {
	private static Statement sentencia;
	/**
	 * Métod para crear las tablas de la BD
	 * @param con conexión abierta a la BD SQLite
	 */
	public static  void crearTablaJuego(Connection con){
		
		String sql1 = "CREATE TABLE IF NOT EXISTS JUEGO ("
				+ "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "NOMBRE TEXT,"
				+ "IMAGEN TEXT,"
				+ "MINIMO INTEGER,"
				+ "MAXIMO INTEGER,"
				+ "TIEMPO INTEGER,"
				+ "RANKING INTEGER,"
				+ "RATING REAL,"
				+ "ANYO TEXT)";
		
		try {
			sentencia = con.createStatement();
			sentencia.executeUpdate(sql1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertarListaJuegos(Connection c, List<Juego> lista){
		
		String sql = "";
		
		for (Juego juego : lista) {
			sql = "INSERT INTO JUEGO VALUES (null,'"+juego.getNombre()+"','"+juego.getImagen()+"','"+juego.getMinimoJugadores()+"','"+juego.getMaximoJugadores()+"','"+juego.getTiempoJuego()+"','"+juego.getRanking()+"','"+juego.getRating()+"','"+juego.getAnyoPublicacion()+"')";
			try {
				sentencia = c.createStatement();
				sentencia.executeUpdate(sql);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

