import java.io.File;

import com.boreas.servicio.LecturaFichero;

public class Test {

	public static void main(String[] args) {
		
		File file = new File("recursos/edwater.json");
		
		LecturaFichero lFichero = new LecturaFichero(file);

	}

}
