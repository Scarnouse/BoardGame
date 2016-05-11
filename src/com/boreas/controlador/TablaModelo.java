package com.boreas.controlador;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.boreas.modelo.Juego;
//import com.boreas.modelo.ListaJuegos;

public class TablaModelo extends AbstractTableModel{
	
	//ListaJuegos l = new ListaJuegos();
	//private List<Juego> lista = l.getLista();
	//public static final String[] CABECERA = {"Identificador","Nombre","Ranking","Rating"};
	String[][] array;
	
	public TablaModelo(List<Juego> lista) {
		 array = ListaComplejaAStringBidimensional.getListaReducida(lista);
	}

	
	@Override
	public int getRowCount() {
		return array.length;
	}
	@Override
	public int getColumnCount() {
		return 4;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return array[rowIndex][columnIndex];
	}
	
	
	
}
