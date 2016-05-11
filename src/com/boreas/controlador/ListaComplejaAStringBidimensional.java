package com.boreas.controlador;

import java.util.ArrayList;
import java.util.List;

import com.boreas.modelo.Juego;
import com.boreas.modelo.ListaJuegos;

public class ListaComplejaAStringBidimensional {
	
	protected static String[][] getListaReducida(List<Juego> lista){
		String[][] array = new String[lista.size()][lista.size()*4];
		List<String> cadenas = new ArrayList<String>();
		System.out.println("Antes del For");
		for (int i=0; i<lista.size(); i++){
			Juego juego = (Juego) lista.get(i);
			System.out.println("Dentro del For1");
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
				System.out.println("Dentro del For2");
			}
			cadenas.clear();
		}
		System.out.println("Despues del For");
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.println(array[i][j]);
			}
		}
		
		return array;

	}
	
}
