package com.boreas.controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import com.boreas.modelo.Coleccion;
import com.boreas.modelo.Juego;

public class ConsultarBD {
	
	private static Statement sentencia;
	private static Coleccion coleccion = new Coleccion();
	
	public static int obtenerFilas (Connection c){
		
		int filas = 0;
		
		try {
			sentencia = c.createStatement();
			String sql = "SELECT COUNT(*) AS filas FROM juego";
			ResultSet resultado = sentencia.executeQuery(sql);
			resultado.next();
			filas = resultado.getInt("filas");
			resultado.close();

		} catch (SQLException e) {
			return 0;
		}
		return filas;
		
	}
	
	public static List<Juego> obtenerTodos (Connection c){
		
		try {
			sentencia = c.createStatement();
			String sql = "SELECT * FROM juego";
			ResultSet resultado = sentencia.executeQuery(sql);
			while(resultado.next()){
					coleccion.addLista(new Juego(resultado.getString("nombre"),resultado.getString("imagen"),resultado.getInt("minimo"),resultado.getInt("maximo"),resultado.getInt("tiempo"),resultado.getInt("ranking"),resultado.getDouble("rating"), resultado.getInt("anyo")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coleccion.getLista();
		
	}
}
