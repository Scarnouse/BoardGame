package com.boreas.controlador;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.boreas.modelo.Juego;
/**
 * 
 * @author Manuel Quesada Segura
 * @version 0.0
 *
 */

public class TablaModelo extends AbstractTableModel{
	
	private static final String[] CABECERA = {"Nombre","Ranking","Rating"};
	private String[][] array;
	/**
	 * Constructor de la clase
	 * @param lista Lista de la que va a obtener los datos para posteriormente mostrarlos en la tabla
	 */
	public TablaModelo(List<Juego> lista) {
		 array = List2Array.getListaReducida(lista);
	}

	@Override
	public int getRowCount() {
		return array.length;
	}
	@Override
	public int getColumnCount() {
		return 3;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return array[rowIndex][columnIndex];
	}
	//La sobreescritura de este método permite la inserción de una cabecera en la tabla
	@Override
	public String getColumnName(int column) {
		return CABECERA[column];
	}

	/* Método para cambiar una fila de la tabla
	 * No implantado
	public void setValorTabla(Juego juego, int fila) {
		for (int i = 0; i < 3; i++) {
			switch (i) {
			case 0:
				array [fila][i] = juego.getNombre();
				break;
			case 1:
				array [fila][i] = Integer.toString(juego.getRanking());
				break;
			case 2:
				array [fila][i] = Double.toString(juego.getRating());
				break;
			default:
				break;
			}
		}
	}*/
	
}
