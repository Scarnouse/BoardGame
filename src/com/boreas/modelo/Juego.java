package com.boreas.modelo;

import java.time.Year;

public class Juego {
	private String nombre, imagen;
	private int minimoJugadores, maximoJugadores, tiempoJuego, ranking, anyoPublicacion;
	private double rating;
	/**
	 * Costructor de la clase juego. No pude encotrar un modelo adecaudo a herencia en los datos que extraía del JSON
	 * @param nombre nombre del juego
	 * @param imagen dirección url que tiene una imagen en miniatura del juego
	 * @param minimoJugadores numero mínimo de jugadores
	 * @param maximoJugadores numero máximo de jugadores
	 * @param tiempoJuego tiempo medio estimado de partida.
	 * @param ranking ranking en la BGG (página de juegos de tablero)
	 * @param rating valoración hecha por el usuario
	 * @param anyoPublicacion año de publicación
	 */
	public Juego(String nombre, String imagen, int minimoJugadores, int maximoJugadores, int tiempoJuego, int ranking,
			double rating, int anyoPublicacion) {
		this.nombre = nombre;
		this.imagen = imagen;
		this.minimoJugadores = minimoJugadores;
		this.maximoJugadores = maximoJugadores;
		this.tiempoJuego = tiempoJuego;
		this.ranking = ranking;
		this.rating = rating;
		this.anyoPublicacion = anyoPublicacion;
	}
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	//el setter de imagen lo dejo para una posible ampliación del programa que permita al usuario
	//a incluir sus propias miniaturas de los juegos.
	/*public void setImagen(String imagen) {
		this.imagen = imagen;
	}*/

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

	public int getAnyoPublicacion() {
		return anyoPublicacion;
	}

	public void setAnyoPublicacion(int anyoPublicacion) {
		this.anyoPublicacion = anyoPublicacion;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anyoPublicacion;
		result = prime * result + maximoJugadores;
		result = prime * result + minimoJugadores;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + tiempoJuego;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Juego other = (Juego) obj;
		if (anyoPublicacion != other.anyoPublicacion)
			return false;
		if (maximoJugadores != other.maximoJugadores)
			return false;
		if (minimoJugadores != other.minimoJugadores)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tiempoJuego != other.tiempoJuego)
			return false;
		return true;
	}

	//Este método toString fue usado al principio para poder ver que leía correctamente los datos del JSON
	@Override
	public String toString() {
		return "Juego [nombre=" + nombre + ", imagen=" + imagen + ", identificador=" 
				+ ", minimoJugadores=" + minimoJugadores + ", maximoJugadores=" + maximoJugadores + ", tiempoJuego="
				+ tiempoJuego + ", ranking=" + ranking + ", rating=" + rating + ", anyoPublicacion=" + anyoPublicacion
				+ "]";
	};
	
	
	
}
