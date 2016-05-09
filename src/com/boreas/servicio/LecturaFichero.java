package com.boreas.servicio;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import com.boreas.modelo.Juego;
import com.google.gson.stream.JsonReader;

public class LecturaFichero {
	
	private List<Juego> listaJuegos = new ArrayList<Juego>();
	public static final String[] CABECERA = {"Identificador","Nombre","Ranking","Rating"};
	
	public LecturaFichero(File file){
		try (JsonReader jReader = new JsonReader(new FileReader(file));){
			jReader.beginArray();
			int identificador = 0, minimoJugadores = 0, maximoJugadores = 0, tiempoJuego = 0, ranking = 0;
			double rating = 0;
			String nombre = "", imagen = "";
			Year anyoPublicacion = null;
			while (jReader.hasNext()){
				jReader.beginObject();
				if (jReader.nextName().equals("gameId")) identificador = jReader.nextInt();
				if (jReader.nextName().equals("name")) nombre = jReader.nextString();
				if (jReader.nextName().equals("image")) jReader.skipValue();
				if (jReader.nextName().equals("thumbnail")) imagen = jReader.nextString();
				if (jReader.nextName().equals("minPlayers")) minimoJugadores = jReader.nextInt();
				if (jReader.nextName().equals("maxPlayers")) maximoJugadores = jReader.nextInt();
				if (jReader.nextName().equals("playingTime")) tiempoJuego = jReader.nextInt();
				if (jReader.nextName().equals("isExpansion")) jReader.skipValue();
				if (jReader.nextName().equals("yearPublished")) anyoPublicacion = Year.of(jReader.nextInt());
				if (jReader.nextName().equals("bggRating")) jReader.skipValue();
				if (jReader.nextName().equals("averageRating")) jReader.skipValue();
				if (jReader.nextName().equals("rank")) ranking = jReader.nextInt();
				if (jReader.nextName().equals("numPlays")) jReader.skipValue();
				if (jReader.nextName().equals("rating")) rating = jReader.nextDouble();
				if (jReader.nextName().equals("owned")) jReader.skipValue();
				if (jReader.nextName().equals("preOrdered")) jReader.skipValue();
				if (jReader.nextName().equals("forTrade")) jReader.skipValue();
				if (jReader.nextName().equals("previousOwned")) jReader.skipValue();
				if (jReader.nextName().equals("want")) jReader.skipValue();
				if (jReader.nextName().equals("wantToPlay")) jReader.skipValue();
				if (jReader.nextName().equals("wantToBuy")) jReader.skipValue();
				if (jReader.nextName().equals("wishList")) jReader.skipValue();
				if (jReader.nextName().equals("userComment")) jReader.skipValue();
				listaJuegos.add(new Juego(nombre, imagen, identificador, minimoJugadores, maximoJugadores, tiempoJuego, ranking, rating, anyoPublicacion));
				jReader.endObject();
			}
			jReader.endArray();
			
			
			/* Comprueba que la lista está llena.
			 * for (Juego juego : listaJuegos) {
				System.out.println(juego);
			}*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Juego> getListaJuegos() {
		return listaJuegos;
	}
	
}

