import java.awt.EventQueue;
//import java.io.File;

import com.boreas.controlador.Controlador;
//import com.boreas.servicio.LecturaFichero;
import com.boreas.vista.VistaPrincipal;

public class Test {
	
	public static void main(String[] args) {
		
		Controlador controlador = new Controlador(new VistaPrincipal());
		//LecturaFichero lFichero = new LecturaFichero(new File("recursos/edwater.json"));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal window = new VistaPrincipal();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
