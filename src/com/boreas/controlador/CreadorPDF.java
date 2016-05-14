package com.boreas.controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import com.boreas.modelo.Juego;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Clase que elabora los pdf con la selección de campos del usuario.
 * @author Manuel Quesada Segura
 * @version 0.0
 *
 */

public class CreadorPDF {
	/**
	 * método para crear los pdf
	 * @param lista selección de juegos del usuario
	 * @param archivo donde se va a guardar el archivo
	 */
	public static void crearPDF(List<Juego> lista, File archivo){
		try {
			Document documento = new Document();
			PdfWriter.getInstance(documento, new FileOutputStream(archivo));
			Phrase texto = new Phrase();
			documento.open();
			texto.add("Nombre");
			PdfPCell celdaCabeceraNombre = new PdfPCell();
			celdaCabeceraNombre.addElement(texto);
			texto.clear();
			texto.add("Año");
			PdfPCell celdaCabeceraAnyo = new PdfPCell();
			celdaCabeceraAnyo.addElement(texto);
			texto.clear();
			texto.add("Minimo");
			PdfPCell celdaCabeceraMin = new PdfPCell();
			celdaCabeceraMin.addElement(texto);
			texto.clear();
			texto.add("Maximo");
			PdfPCell celdaCabeceraMax = new PdfPCell();
			celdaCabeceraMax.addElement(texto);
			texto.clear();
			texto.add("Ranking");
			PdfPCell celdaCabeceraRanking = new PdfPCell();
			celdaCabeceraRanking.addElement(texto);
			texto.clear();
			texto.add("Rating");
			PdfPCell celdaCabeceraRating = new PdfPCell();
			celdaCabeceraRating.addElement(texto);
			texto.clear();
			PdfPTable filaCabecera = new PdfPTable(6);
			filaCabecera.setSpacingAfter(5);
			filaCabecera.addCell(celdaCabeceraNombre);
			filaCabecera.addCell(celdaCabeceraAnyo);
			filaCabecera.addCell(celdaCabeceraMin);
			filaCabecera.addCell(celdaCabeceraMax);
			filaCabecera.addCell(celdaCabeceraRanking);
			filaCabecera.addCell(celdaCabeceraRating);
			Phrase envolturaFilaCabecera = new Phrase();
			envolturaFilaCabecera.add(filaCabecera);
			documento.add(new Paragraph(envolturaFilaCabecera));
			
			for (Juego juego : lista) {				
				texto.add(juego.getNombre());
				PdfPCell celdaNombre = new PdfPCell();
				celdaNombre.addElement(texto);
				texto.clear();
				texto.add(juego.getAnyoPublicacion()+"");
				PdfPCell celdaAnyo = new PdfPCell();
				celdaAnyo.addElement(texto);
				texto.clear();
				texto.add(juego.getMinimoJugadores()+"");
				PdfPCell celdaMin = new PdfPCell();
				celdaMin.addElement(texto);
				texto.clear();
				texto.add(juego.getMaximoJugadores()+"");
				PdfPCell celdaMax = new PdfPCell();
				celdaMax.addElement(texto);
				texto.clear();
				texto.add(juego.getRanking()+"");
				PdfPCell celdaRanking = new PdfPCell();
				celdaRanking.addElement(texto);
				texto.clear();
				texto.add(juego.getRating()+"");
				PdfPCell celdaRating = new PdfPCell();
				celdaRating.addElement(texto);
				texto.clear();
				PdfPTable fila = new PdfPTable(6);
				fila.setSpacingAfter(5);
				fila.addCell(celdaNombre);
				fila.addCell(celdaAnyo);
				fila.addCell(celdaMin);
				fila.addCell(celdaMax);
				fila.addCell(celdaRanking);
				fila.addCell(celdaRating);
				Phrase envolturaFila = new Phrase();
				envolturaFila.add(fila);
				documento.add(new Paragraph(envolturaFila));
			}
			documento.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}
	
}
