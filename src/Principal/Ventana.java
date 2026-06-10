package Principal;

import javax.swing.JFrame;

public class Ventana extends JFrame{

	public Ventana() {
		setSize(1000,700); 
		setDefaultCloseOperation(3); 
		setLocationRelativeTo(null);
		
		
		Lienzo l= new Lienzo(); 
		add(l);
		
		//coger de teclado
		l.addKeyListener(l);
		l.setFocusable(true);
		
		//coger raton
		l.addMouseListener(l);
		l.addMouseMotionListener(l);
		
	}
}
