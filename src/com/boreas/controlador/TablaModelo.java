package com.boreas.controlador;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.boreas.modelo.Juego;


public class TablaModelo extends AbstractTableModel{
	
	public static final String[] CABECERA = {"Identificador","Nombre","Ranking","Rating"};
	String[][] array;
	
	public TablaModelo(List<Juego> lista) {
		 array = List2Array.getListaReducida(lista);
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
	
	@Override
	public String getColumnName(int column) {
		return CABECERA[column];
	}
	
}
