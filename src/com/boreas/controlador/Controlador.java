package com.boreas.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.boreas.modelo.Coleccion;
import com.boreas.modelo.Juego;
import com.boreas.vista.VistaPrincipal;

/**
 * 
 * @author Manuel Quesada Segura
 * @vesion 0.0
 *
 */

public class Controlador {
	
	private VistaPrincipal vista;
	private File fichero;
	private Coleccion coleccion;
	private LecturaFichero lFichero = new LecturaFichero();
	private int indice = 0;
	private boolean modificar = true;
	private Connection conexion;
	
	/**
	 * 
	 * @param vista de la aplicación
	 */
	
	public Controlador(VistaPrincipal vista){
		this.vista = vista;
		conexion = ConectarBD.getConexion();
		inicializar();
	}

	public void inicializar(){
		
		if (new File("database.db").exists() && ConsultarBD.obtenerFilas(conexion)>0){
			vista.getMntmAbrir().setEnabled(false);
			vista.getTabla().setModel(new TablaModelo(ConsultarBD.obtenerTodos(conexion)));
		}
		
		//Evento carga de datos a la tabla

		vista.getMntmAbrir().addActionListener(l->{
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos JSON", "json");
			JFileChooser fC = new JFileChooser();
			fC.setFileFilter(filter);
			int seleccion = fC.showOpenDialog(vista.getMntmAbrir());
			if (seleccion == JFileChooser.APPROVE_OPTION){
				fichero = fC.getSelectedFile();
				//coleccion = new Coleccion();
				lFichero.leerFichero(fichero);
				vista.getTabla().setModel(new TablaModelo(coleccion.getLista()));
				CrearTablasBD.crearTablaJuego(conexion);
				InsertarJuegos.insertarListaJuegos(conexion, coleccion.getLista());
				vista.getMntmAbrir().setEnabled(false);
			}			
			if (seleccion == JFileChooser.CANCEL_OPTION){
				vista.getLblBarraTitulo().setText("No hay fichero cargado");
			}
			
		});
		
		//Evento de carga de datos al formulario haciendo click en una fila
		
		vista.getTabla().addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent e) {
				indice = vista.getTabla().getSelectedRow();
				rellenarFormulario(indice);
			}
		});
		
		//Evento para retroceder en la tabla
		
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
		
		//Evento para avanzar en la tabla
		
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
		
		//Evento de cierre desde el menú
		vista.getMntmCerrar().addActionListener(l->{
			//lógica para guardar la base de datos
			System.exit(0);
		});
		
		//Evento que borra el formulario en espera de que el usuario lo rellene
		vista.getBtnNuevo().addActionListener(l->{
			vista.getTextNombre().setText("");
			vista.getTextAnyo().setText("");
			vista.getTextMin().setText("");
			vista.getTextMax().setText("");
			vista.getTextRanking().setText("");
			vista.getTextRating().setText("");
			vista.getTextTiempo().setText("");
			modificar = false;
		});
		
		//Evento para guardar
		vista.getBtnGuardar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (esJuegoValido()){
					Juego juego = new Juego(vista.getTextNombre().getText(), "resources/dado.png", Integer.parseInt(vista.getTextMin().getText()), Integer.parseInt(vista.getTextMax().getText()), Integer.parseInt(vista.getTextTiempo().getText()), Integer.parseInt(vista.getTextRanking().getText()), Double.parseDouble(vista.getTextRating().getText()), Integer.parseInt(vista.getTextAnyo().getText()));
					if (esJuegoIgual(juego)){
						JOptionPane.showMessageDialog(vista.getFrame(), "Juego repetido", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						if(modificar){
							coleccion.getLista().get(indice).setMaximoJugadores(Integer.parseInt(vista.getTextMax().getText()));
							coleccion.getLista().get(indice).setMinimoJugadores(Integer.parseInt(vista.getTextMin().getText()));
							coleccion.getLista().get(indice).setNombre(vista.getTextNombre().getText());
							coleccion.getLista().get(indice).setAnyoPublicacion(Integer.parseInt(vista.getTextAnyo().getText()));
							coleccion.getLista().get(indice).setRanking(Integer.parseInt(vista.getTextRanking().getText()));
							coleccion.getLista().get(indice).setRating(Double.parseDouble(vista.getTextRating().getText()));
							coleccion.getLista().get(indice).setTiempoJuego(Integer.parseInt(vista.getTextTiempo().getText()));
							vista.getTabla().setModel(new TablaModelo(coleccion.getLista()));
						} else {
							coleccion.getLista().add(juego);
							InsertarJuegos.insertarJuego(conexion, juego);
							vista.getTabla().setModel(new TablaModelo(coleccion.getLista()));
						}
					}
				}
			}
		});
		
		//Evento de eliminación de elementos de la tabla
		
		vista.getBtnEliminar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = "¿Desea borrar "+ coleccion.getLista().get(indice).getNombre() + "?";
				if(lFichero!=null){
					if (confirmar(texto)==0){
						coleccion.getLista().remove(coleccion.getLista().get(indice));
						vista.getTabla().setModel(new TablaModelo(coleccion.getLista()));
					}
				} else if (lFichero == null) {
					vista.getLblBarraTitulo().setText("No tiene cargado ningún archivo");
				}
			}
		});
		
		//Evento para generar PDF
		
		vista.getMntmGenerarPdf().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = "¿Desea generar informe con los elementos seleccionados?";
				if (lFichero!=null){
					if (confirmar(texto)==0){
						//lógica que crea el archivo PDF
						FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos PDF", "pdf");
						JFileChooser jFPDF = new JFileChooser();
						jFPDF.setFileFilter(filtro);
						int seleccionSave = jFPDF.showSaveDialog(null);
						if (seleccionSave == JFileChooser.APPROVE_OPTION){
							List<Juego> lista = new ArrayList<Juego>();
							int[] arraySeleccion = vista.getTabla().getSelectedRows();
							for (int i = 0; i < arraySeleccion.length; i++ ){
								lista.add(coleccion.getLista().get(arraySeleccion[i]));
							}
							CreadorPDF.crearPDF(lista, Extension.obtenerExtension(jFPDF));
						}
					} 
				} else vista.getLblBarraTitulo().setText("No tiene cargado ningún archivo");
			}
		});
		
		//Acceso a Créditos
		
		vista.getMntmCreditos().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(vista.getFrame(),"GameBoardDB\nManuel Quesada Segura\n26/05/2016","Créditos",JOptionPane.PLAIN_MESSAGE);
				AcercaDe ad = new AcercaDe();
				ad.setLocationRelativeTo(vista.getFrame());
				ad.setVisible(true);
			}
		});
		
		//método incompleto. La idea es que si el usuario realiza cualquier cambio el programa le alerte de si desea
		//guardar los cambios. El problema es almacenar la fila anterior modificada
		
		vista.getTabla().getSelectionModel().addListSelectionListener(l->{
			
		});
		
	}
	
	/**
	 * Método que permite la carga del formulario y rellenado de la barra de título
	 * He considerado oportuno hacerlo dentro del controlador ya que ninguna otra clase
	 * va a poder usarla
	 * @param indice del elemento que debe de ser mostrado en pantalla
	 */
	private void rellenarFormulario(int indice){
		
		for (Juego juego : coleccion.getLista()) {
			System.out.println(juego);
		}
		
		
		modificar = true;
		vista.getTextNombre().setText(coleccion.getLista().get(indice).getNombre());
		vista.getTextAnyo().setText(coleccion.getLista().get(indice).getAnyoPublicacion()+"");
		vista.getTextMax().setText(coleccion.getLista().get(indice).getMaximoJugadores()+"");
		vista.getTextMin().setText(coleccion.getLista().get(indice).getMinimoJugadores()+"");
		vista.getTextRanking().setText(coleccion.getLista().get(indice).getRanking()+"");
		vista.getTextRating().setText(coleccion.getLista().get(indice).getRating()+"");
		vista.getTextTiempo().setText(coleccion.getLista().get(indice).getTiempoJuego()+"");
		String cadena = "Juego "+(indice+1)+" de "+coleccion.getLista().size();
		vista.getLblBarraTitulo().setText(cadena);
		//El siguiente código introduce una imagen del juego seleccionado en el programa
		//En defecto de imagen muestra una imagen de un dado que se conserva en /resources
		Image imagen = null;
		if (coleccion.getLista().get(indice).getImagen().equals("resources/dado.png")){
			vista.getImagen().setText("");
			vista.getImagen().setIcon(new ImageIcon("resources/dado.png"));
		} else {
			try {
				URL url = new URL("http:"+coleccion.getLista().get(indice).getImagen());
				imagen = ImageIO.read(url);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			vista.getImagen().setText("");
			vista.getImagen().setIcon(new ImageIcon(imagen));
		}
	}

	/**
	 * Método que valida si los campos introducidos por el usuario son correctos.
	 * Hago notar que hay campos que se introducen desde el archivo que son incorrectos
	 * @return true si el objeto Juego cumple todos las restrigciones expuestas
	 */
	private boolean esJuegoValido(){
		boolean valido = false;
		if (vista.getTextNombre().getText().isEmpty() || vista.getTextAnyo().getText().isEmpty() || vista.getTextMax().getText().isEmpty() || vista.getTextMin().getText().isEmpty() || vista.getTextTiempo().getText().isEmpty() || vista.getTextRanking().getText().isEmpty() || vista.getTextRating().getText().isEmpty()){
			JOptionPane.showMessageDialog(vista.getFrame(), "Comprueba que todos los campos estén rellenos.","Error", JOptionPane.ERROR_MESSAGE);
		} else if (!vista.getTextRating().getText().matches("[-+]?[0-9]*\\.?[0-9]*")){
			JOptionPane.showMessageDialog(vista.getFrame(), "Formato de rating incorrecto","Error", JOptionPane.ERROR_MESSAGE);
		} else if (Double.parseDouble(vista.getTextRating().getText())>10.0 || Double.valueOf(vista.getTextRating().getText())<0){
			JOptionPane.showMessageDialog(vista.getFrame(), "El rating será un valor entre 0 y 10.","Error", JOptionPane.ERROR_MESSAGE);
		} else if (!vista.getTextTiempo().getText().matches("[0-9]*")){
			JOptionPane.showMessageDialog(vista.getFrame(), "Formato de tiempo incorrecto","Error", JOptionPane.ERROR_MESSAGE);
		} else if (Integer.parseInt(vista.getTextTiempo().getText())<=0){
			JOptionPane.showMessageDialog(vista.getFrame(), "El tiempo de juego no puede ser menor o igual a 0.","Error", JOptionPane.ERROR_MESSAGE);
		} else if (!vista.getTextMin().getText().matches("[0-9]*")){
			JOptionPane.showMessageDialog(vista.getFrame(), "Formato de numero de jugadores mínimo incorrecto","Error", JOptionPane.ERROR_MESSAGE);
		} else if(Integer.parseInt(vista.getTextMin().getText())<=0){
			JOptionPane.showMessageDialog(vista.getFrame(), "El número mínimo de jugadores debe de ser mayor que 0.","Error", JOptionPane.ERROR_MESSAGE);
		} else if (!vista.getTextMax().getText().matches("[0-9]*")){
			JOptionPane.showMessageDialog(vista.getFrame(), "Formato de numero de jugadores máximo incorrecto","Error", JOptionPane.ERROR_MESSAGE);
		} else if (Integer.parseInt(vista.getTextMax().getText())<Integer.parseInt(vista.getTextMin().getText())){
			JOptionPane.showMessageDialog(vista.getFrame(), "El número de máximo de jugadores no puede ser inferior al mínimo.","Error", JOptionPane.ERROR_MESSAGE);
		} else if (!vista.getTextAnyo().getText().matches("(\\d){4}")||vista.getTextAnyo().getText().matches("/D")){
			JOptionPane.showMessageDialog(vista.getFrame(), "Formato de año incorrecto","Error", JOptionPane.ERROR_MESSAGE);
		} else if (LocalDate.now().getYear()<Integer.parseInt(vista.getTextAnyo().getText())){
			JOptionPane.showMessageDialog(vista.getFrame(), "¿Tienes una máquina del tiempo? No puedes insertar juegos de año superior al actual","Error", JOptionPane.ERROR_MESSAGE);
		} else if (!vista.getTextRanking().getText().matches("-?[0-9]*")){
			JOptionPane.showMessageDialog(vista.getFrame(), "Formato de ranking máximo incorrecto","Error", JOptionPane.ERROR_MESSAGE);
		} else {
			valido = true;
		}
		return valido;
	}
	/**
	 * El método .equals está sobre escrito pero me ha parecido razonable extraer el método aquí
	 * para no sobrecargar el evento que controla la modificación de datos en el fomulario.
	 * @param juego que ha introducido el usuario y será comparado con la lista de juegos.
	 * @return true si el usuario está tratando de introducir un juego que ya está en la lista.
	 */
	private boolean esJuegoIgual(Juego juego){
		boolean igual = false;
		for (Juego j : coleccion.getLista()) {
			if(j.equals(juego)) igual = true;
		}
		return igual;
	}
	/**
	 * Se utiliza en varios lugares del código un elemento JOptionPane que permite la selección entre sí y no.
	 * Me ha parecido oportuno crear un método que gestione dicha selección en la cual sólo se le introduce un texto
	 * que aparecerá en el cuerpo de la ventana.
	 * @param texto cadena de texto que aparecerá en el cuerpo de la ventana
	 * @return la selección del usuario en forma de valor numérico.
	 */
	private int confirmar(String texto){
		int seleccion = JOptionPane.showOptionDialog(vista.getFrame(), texto , "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Si", "No"}, "No");
		return seleccion;
	}
	
}
