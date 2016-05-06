package com.boreas.modelo;

import java.time.Year;

public class Juego {
	private String nombre, imagen;
	private int identificador, minimoJugadores, maximoJugadores, tiempoJuego, ranking, rating;
	private Year anyoPublicacion;
	
	public Juego(){};

	public Juego(String nombre, String imagen, int identificador, int minimoJugadores, int maximoJugadores, int tiempoJuego, int ranking,
			int rating, Year anyoPublicacion) {
		this.nombre = nombre;
		this.imagen = imagen;
		this.identificador = identificador;
		this.minimoJugadores = minimoJugadores;
		this.maximoJugadores = maximoJugadores;
		this.tiempoJuego = tiempoJuego;
		this.ranking = ranking;
		this.rating = rating;
		this.anyoPublicacion = anyoPublicacion;
	}

	/*@Override
	public String toString() {
		return "Juego [nombre=" + nombre + ", imagen=" + imagen + ", identificador=" + identificador
				+ ", minimoJugadores=" + minimoJugadores + ", maximoJugadores=" + maximoJugadores + ", tiempoJuego="
				+ tiempoJuego + ", ranking=" + ranking + ", rating=" + rating + ", anyoPublicacion=" + anyoPublicacion
				+ "]";
	};*/
	
	
	
}
