package com.boreas.controlador;

import java.util.List;

import com.boreas.modelo.Juego;

public interface JuegoDAO {
	public void insertarJuego(Juego juego);
	public int actualizarJuego(Juego juego,int indice);
	public int borrarJuego(String nombre);
	public List<Juego> leerTodosJuegos();
	public int obtenerID(Juego juego);
}
