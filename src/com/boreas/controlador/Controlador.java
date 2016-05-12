package com.boreas.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.boreas.servicio.LecturaFichero;
import com.boreas.vista.VistaPrincipal;

public class Controlador {
	
	private VistaPrincipal vista;
	private File fichero;
	private LecturaFichero lFichero = null;
	int indice = 0;
	
	public Controlador(VistaPrincipal vista){
		this.vista = vista;
		inicializar();
	}

	public void inicializar(){
		//carga de datos a la tabla
		vista.getMntmAbrir().addActionListener(l->{
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos JSON", "json");
			JFileChooser fC = new JFileChooser();
			fC.setFileFilter(filter);
			int seleccion = fC.showOpenDialog(vista.getMntmAbrir());
			if (seleccion == JFileChooser.APPROVE_OPTION){
				fichero = fC.getSelectedFile();
				lFichero = new LecturaFichero();
				lFichero.leerFichero(fichero);
				vista.getTabla().setModel(new TablaModelo(lFichero.getLista()));
			}
			if (seleccion == JFileChooser.CANCEL_OPTION){
				vista.getLblBarraTitulo().setText("No hay fichero cargado");
			}
			
		});
		//carga de datos al formulario haciendo click en una fila
		vista.getTabla().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				indice = vista.getTabla().getSelectedRow();
				rellenarFormulario(indice);				
			}
		});
		//retroceder en la tabla
		vista.getAtras().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (indice!=0){
					indice -= 1;
					rellenarFormulario(indice);
				} else {
					vista.getLblBarraTitulo().setText("No tiene cargado ningún archivo");
				}
			}
		});
		//avanzar en la tabla
		vista.getAdelante().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(indice == 0 && lFichero!=null){
					rellenarFormulario(indice);
				} else if (indice == 0 && lFichero == null) {
					vista.getLblBarraTitulo().setText("No tiene cargado ningún archivo");
				} else {
					indice += 1;
					rellenarFormulario(indice);
				}
			}
		});
		//cierre desde el menú
		vista.getMntmCerrar().addActionListener(l->{
			//lógica para guardar la base de datos
			System.exit(0);
		});
		//Borra el formulario en espera de que el usuario lo rellene
		vista.getBtnNuevo().addActionListener(l->{
			vista.getTextNombre().setText("");
			vista.getTextAnyo().setText("");
			vista.getTextMin().setText("");
			vista.getTextMax().setText("");
			vista.getTextRanking().setText("");
			vista.getTextRating().setText("");
			vista.getTextTiempo().setText("");
			//lógica para controlar que el usuario no introduce campos erróneos y complete todos los campos
		});
		//Posible método que permita desplazarse con los cursores por la tabla cargando el formulario
		vista.getTabla().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
			}
		});
		
	}
	//método que permite la carga del formulario y rellenado de la barra de titulo
	public void rellenarFormulario(int indice){
		vista.getTextNombre().setText(lFichero.getLista().get(indice).getNombre());
		vista.getTextAnyo().setText(lFichero.getLista().get(indice).getAnyoPublicacion()+"");
		vista.getTextMax().setText(lFichero.getLista().get(indice).getMaximoJugadores()+"");
		vista.getTextMin().setText(lFichero.getLista().get(indice).getMinimoJugadores()+"");
		vista.getTextRanking().setText(lFichero.getLista().get(indice).getRanking()+"");
		vista.getTextRating().setText(lFichero.getLista().get(indice).getRating()+"");
		vista.getTextTiempo().setText(lFichero.getLista().get(indice).getTiempoJuego()+"");
		String cadena = "Juego "+indice+" de "+lFichero.getLista().size();
		vista.getLblBarraTitulo().setText(cadena);
		//El siguiente código trataba de introducir una imágen del juego seleccionado en el programa
		Image imagen = null;
		try {
			URL url = new URL("http:"+lFichero.getLista().get(indice).getImagen());
			imagen = ImageIO.read(url);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		vista.getImagen().setText("");
		vista.getImagen().setIcon(new ImageIcon(imagen));
	}
}
