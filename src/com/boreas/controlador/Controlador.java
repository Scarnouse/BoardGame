package com.boreas.controlador;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

import com.boreas.modelo.Juego;
import com.boreas.modelo.ListaJuegos;
import com.boreas.servicio.LecturaFichero;
import com.boreas.vista.VistaPrincipal;

public class Controlador {
	
	private VistaPrincipal vista;
	private File fichero;
	private LecturaFichero lFichero;
	
	public Controlador(VistaPrincipal vista){
		this.vista = vista;
		inicializar();
	}

	public void inicializar(){
		vista.getMntmAbrir().addActionListener(l->{
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos JSON", "json");
			JFileChooser fC = new JFileChooser();
			fC.setFileFilter(filter);
			int seleccion = fC.showOpenDialog(vista.getMntmAbrir());
			if (seleccion == JFileChooser.APPROVE_OPTION){
				fichero = fC.getSelectedFile();
			}
			lFichero = new LecturaFichero();
			lFichero.leerFichero(fichero);
			vista.getTabla().setModel(new TablaModelo(lFichero.getLista().getLista()));
			
		});
	}
	
}
