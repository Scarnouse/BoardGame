package com.boreas.modelo;

import java.util.ArrayList;
import java.util.List;


public class Coleccion {
	
	private static List<Juego> lista = new ArrayList<Juego>();
	
	public boolean addLista(Juego juego){
		return lista.add(juego);
	}
	
	public static List<Juego> getLista() {
		return lista;
	}
	
}
