package com.boreas.controlador;

import java.awt.EventQueue;

import javax.swing.JFileChooser;

import com.boreas.modelo.Juego;
import com.boreas.vista.VistaPrincipal;

public class Controlador {
	
	private Juego juego;
	private VistaPrincipal vista;
	
	public Controlador(VistaPrincipal vista){
		juego = new Juego();
		this.vista = vista;
		inicializar();
	}
	
	public void inicializar(){
		vista.getMntmAbrir().addActionListener(l->{
			JFileChooser fC = new JFileChooser();
			int seleccion = fC.showOpenDialog(vista.getMntmAbrir());
			if (seleccion == JFileChooser.APPROVE_OPTION){
				
			}
			
		});
	}
	
}
