package com.boreas.controlador;

import java.util.ArrayList;
import java.util.List;

import com.boreas.modelo.Juego;

public class ListaComplejaAStringBidimensional {
	
	protected static String[][] getListaReducida(List<Juego> lista){
		String[][] array = new String[lista.size()][lista.size()*4];
		List<String> cadenas = new ArrayList<String>();
		for (int i=0; i<lista.size(); i++){
			Juego juego = (Juego) lista.get(i);
			for (int j=0; j<4; j++){
				switch (j){
				case 0:
					cadenas.add(juego.getIdentificador()+"");
					break;
				case 1:
					cadenas.add(juego.getNombre());
					break;
				case 2:
					cadenas.add(juego.getRanking()+"");
					break;
				case 3:
					cadenas.add(juego.getRating()+"");
					break;
				}
				array[i][j] = cadenas.get(j);
			}
			cadenas.clear();
		}
		
		return array;

	}
	
}
