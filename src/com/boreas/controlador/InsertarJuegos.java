package com.boreas.controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.boreas.modelo.Juego;
/**
 * Clase para la inserción de juegos en la BD en una primera vez
 * @author Manuel Quesada Segura
 * @version 0.0
 *
 */
public class InsertarJuegos {
	
	private static Statement sentencia;
	/**
	 * Método que inserta Juegos en la BD en el arranque de la aplicación
	 * @param c Conexión a la BD 
	 * @param lista Lista que va a introducirse en la BD
	 */
	public static void insertarListaJuegos(Connection c, List<Juego> lista){
		
		String sql = "";
		
		for (Juego juego : lista) {
			sql = "INSERT INTO JUEGO VALUES (null,'"+juego.getNombre()+"','"+juego.getAnyoPublicacion()+"','"+juego.getMinimoJugadores()+"','"+juego.getMaximoJugadores()+"','"+juego.getTiempoJuego()+"','"+juego.getRanking()+"','"+juego.getRating()+"')";
			try {
				sentencia = c.createStatement();
				sentencia.executeUpdate(sql);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Método para la inserción de un campo nuevo en la BD
	 * El parámetro juego.getNombre está filtrado para que el usuario no introduzca el caracter ' y este dé conflicto
	 * @param c Conexión a la BD
	 * @param juego El juego que inserta el usuario
	 */
	public static void insertarJuego(Connection c, Juego juego){
		
		String sql = "INSERT INTO JUEGO VALUES (null,'"+juego.getNombre().replace("'","")+"','"+juego.getAnyoPublicacion()+"','"+juego.getMinimoJugadores()+"','"+juego.getMaximoJugadores()+"','"+juego.getTiempoJuego()+"','"+juego.getRanking()+"','"+juego.getRating()+"')";
		
		try {
			sentencia = c.createStatement();
			sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
