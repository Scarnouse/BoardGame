import java.awt.EventQueue;

import com.boreas.controlador.Controlador;
import com.boreas.vista.VistaPrincipal;

public class Test {
	
	public static void main(String[] args) {
		
		Controlador controlador = new Controlador(new VistaPrincipal());

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
