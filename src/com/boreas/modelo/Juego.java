package com.boreas.modelo;

import java.time.Year;

public class Juego {
	private String nombre, imagen;
	private int identificador, minimoJugadores, maximoJugadores, tiempoJuego, ranking;
	private Year anyoPublicacion;
	private double rating;
	
	public Juego(){};
	
	public Juego(int identificador, String nombre, int ranking, double rating){
		this.identificador = identificador;
		this.nombre = nombre;
		this.ranking = ranking;
		this.rating = rating;
	};

	public Juego(String nombre, String imagen, int identificador, int minimoJugadores, int maximoJugadores, int tiempoJuego, int ranking,
			double rating, Year anyoPublicacion) {
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

	/* To String para comprobaciones de las listas.
	 * @Override
	public String toString() {
		return "Juego [nombre=" + nombre + ", imagen=" + imagen + ", identificador=" + identificador
				+ ", minimoJugadores=" + minimoJugadores + ", maximoJugadores=" + maximoJugadores + ", tiempoJuego="
				+ tiempoJuego + ", ranking=" + ranking + ", rating=" + rating + ", anyoPublicacion=" + anyoPublicacion
				+ "]";
	};*/
	
	
	
}
