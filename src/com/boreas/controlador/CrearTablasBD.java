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
	 * Método para crear las tablas de la BD
	 * 
	 * @param con conexión abierta a la BD SQLite
	 */
	// Este método está en desusdo dado que se ha creado un disparador que aglutina este método y el de insertar.
	public static  void crearTablaJuego(Connection con){
		
		String sql = "CREATE TABLE IF NOT EXISTS JUEGO ("
				+ "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "NOMBRE TEXT,"
				+ "IMAGEN TEXT,"
				+ "MINIMO INTEGER,"
				+ "MAXIMO INTEGER,"
				+ "TIEMPO INTEGER,"
				+ "RANKING INTEGER,"
				+ "RATING REAL,"
				+ "ANYO TEXT"
				+ ");";
		
		try {
			sentencia = con.createStatement();
			sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Método para insertar los juegos dada una lista
	 * @param c Conexión
	 * @param lista Lista a cargar
	 */
	// Este método está en desusdo dado que se ha creado un disparador que aglutina este método y el de crear
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
	
	/**
	 * Métod disparador que carga e inserta los juegos
	 * @param c Conexión
	 * @param lista lista de la que extrae los juegos
	 */
	public static void triggerCarga(Connection c, List<Juego> lista){
		String sqlCreaTabla = "CREATE TABLE IF NOT EXISTS JUEGO ("
				+ "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "NOMBRE TEXT,"
				+ "IMAGEN TEXT,"
				+ "MINIMO INTEGER,"
				+ "MAXIMO INTEGER,"
				+ "TIEMPO INTEGER,"
				+ "RANKING INTEGER,"
				+ "RATING REAL,"
				+ "ANYO TEXT"
				+ ");";
		try {
			sentencia = c.createStatement();
			sentencia.addBatch(sqlCreaTabla);
			for (Juego juego:lista){
				String inserta = "INSERT INTO JUEGO VALUES (null,'"+juego.getNombre()+"','"+juego.getImagen()+"','"+juego.getMinimoJugadores()+"','"+juego.getMaximoJugadores()+"','"+juego.getTiempoJuego()+"','"+juego.getRanking()+"','"+juego.getRating()+"','"+juego.getAnyoPublicacion()+"')";
				sentencia.addBatch(inserta);
			}
			sentencia.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sentencia.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}

