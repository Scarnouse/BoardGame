package com.boreas.controlador;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

import com.boreas.modelo.Juego;
import com.boreas.servicio.LecturaFichero;
import com.boreas.vista.VistaPrincipal;

public class Controlador {
	
	private Juego juego;
	private VistaPrincipal vista;
	private File fichero;
	private LecturaFichero lFichero;
	
	public Controlador(VistaPrincipal vista){
		juego = new Juego();
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
			lFichero = new LecturaFichero(fichero);
			
		});
	}
	
}
