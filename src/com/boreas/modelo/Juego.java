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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public int getMinimoJugadores() {
		return minimoJugadores;
	}

	public void setMinimoJugadores(int minimoJugadores) {
		this.minimoJugadores = minimoJugadores;
	}

	public int getMaximoJugadores() {
		return maximoJugadores;
	}

	public void setMaximoJugadores(int maximoJugadores) {
		this.maximoJugadores = maximoJugadores;
	}

	public int getTiempoJuego() {
		return tiempoJuego;
	}

	public void setTiempoJuego(int tiempoJuego) {
		this.tiempoJuego = tiempoJuego;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public Year getAnyoPublicacion() {
		return anyoPublicacion;
	}

	public void setAnyoPublicacion(Year anyoPublicacion) {
		this.anyoPublicacion = anyoPublicacion;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	
	
	@Override
	public String toString() {
		return "Juego [nombre=" + nombre + ", imagen=" + imagen + ", identificador=" + identificador
				+ ", minimoJugadores=" + minimoJugadores + ", maximoJugadores=" + maximoJugadores + ", tiempoJuego="
				+ tiempoJuego + ", ranking=" + ranking + ", rating=" + rating + ", anyoPublicacion=" + anyoPublicacion
				+ "]";
	};
	
	
	
}
