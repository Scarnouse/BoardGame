package com.boreas.modelo;

import java.util.ArrayList;
import java.util.List;

public class ListaJuegos {
	private List<Juego> lista = new ArrayList<Juego>();
	
	public boolean addLista(Juego juego){
		return lista.add(juego);
	}
	
	public List<Juego> getLista(){
		return this.lista;
	}

}	

