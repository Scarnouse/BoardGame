package com.boreas.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.boreas.modelo.Coleccion;
import com.boreas.modelo.Juego;

public class JuegoDAOImpSQLite implements JuegoDAO{
	
	private Connection conexion = ConectarBD.getConexion();
	private static Statement sentencia;
	private static PreparedStatement sentenciaPreparada;
	private static Coleccion coleccion = new Coleccion();
	
	public JuegoDAOImpSQLite() {};
	
	@Override
	public void insertarJuego(Juego juego) {
		
		try {
			sentencia = conexion.createStatement();
			String sql = "INSERT INTO JUEGO VALUES (null,'"+juego.getNombre().replace("'","")+"','resources/dado.png','"+juego.getAnyoPublicacion()+"','"+juego.getMinimoJugadores()+"','"+juego.getMaximoJugadores()+"','"+juego.getTiempoJuego()+"','"+juego.getRanking()+"','"+juego.getRating()+"')";
			sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sentencia.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//UPDATE JUEGO SET NOMBRE=?, MINIMO =?, MAXIMO=?, TIEMPO=?, RANKING=?, RATING=?, ANYO=? WHERE NOMBRE=?
	
	@Override
	public int actualizarJuego(Juego juego,int indice) {
		String sql = "UPDATE JUEGO SET NOMBRE=?, MINIMO=?, MAXIMO=?, TIEMPO=?, RANKING=?, RATING=?, ANYO=? WHERE ID=?";
		int valor = 0;
		try {
			sentenciaPreparada = conexion.prepareStatement(sql);
			sentenciaPreparada.setString(1, juego.getNombre());
			sentenciaPreparada.setInt(2, juego.getMinimoJugadores());
			sentenciaPreparada.setInt(3, juego.getMaximoJugadores());
			sentenciaPreparada.setInt(4, juego.getTiempoJuego());
			sentenciaPreparada.setInt(5, juego.getRanking());
			sentenciaPreparada.setDouble(6, juego.getRating());
			sentenciaPreparada.setString(7, Integer.toString(juego.getAnyoPublicacion()));
			sentenciaPreparada.setInt(8, indice);
			valor = sentenciaPreparada.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sentenciaPreparada.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//System.out.println(valor + " - " + juego);
		return valor;
	}

	@Override
	public int borrarJuego(String nombre) {
		String sql = "DELETE FROM JUEGO WHERE nombre=?";
		int valor = 0;
		try {
			sentenciaPreparada = conexion.prepareStatement(sql);
			sentenciaPreparada.setString(1, nombre);
			valor = sentenciaPreparada.executeUpdate();
			sentenciaPreparada.closeOnCompletion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(valor);
		return valor;
	}

	@Override
	public List<Juego> leerTodosJuegos() {
		Coleccion.getLista().clear();
		try {
			sentencia = conexion.createStatement();
			String sql = "SELECT * FROM juego";
			ResultSet resultado = sentencia.executeQuery(sql);
			while(resultado.next()){
					coleccion.addLista(new Juego(resultado.getString("nombre"),resultado.getString("imagen"),resultado.getInt("minimo"),resultado.getInt("maximo"),resultado.getInt("tiempo"),resultado.getInt("ranking"),resultado.getDouble("rating"), resultado.getInt("anyo")));
			}
			sentencia.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Coleccion.getLista();
	}
	
	public int obtenerFilas (){
		
		int filas = 0;
		
		try {
			sentencia = conexion.createStatement();
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

	@Override
	public int obtenerID(Juego juego) {
		
		String sql = "SELECT ID FROM JUEGO WHERE NOMBRE=?;";
		int id = -1;
		try {
		
			sentenciaPreparada = conexion.prepareStatement(sql);
			sentenciaPreparada.setString(1, juego.getNombre());
			ResultSet resultado = sentenciaPreparada.executeQuery();

			while(resultado.next())
				id = resultado.getInt("ID");
			resultado.close();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(id);
		
		return id;
	}
	
	

}
