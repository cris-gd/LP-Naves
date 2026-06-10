package Principal;

import java.util.ArrayList;

public class AyudanteEstrella extends Thread{
	
	ArrayList<Estrella> estrellas =null;
	Lienzo l;

	public AyudanteEstrella(ArrayList<Estrella> estrellas, Lienzo l) {
		super();
		this.estrellas = estrellas;
		this.l = l;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(true) {
			
			for (int i=0; i<estrellas.size();i++) {
				int y=estrellas.get(i).getY();
				int direccion=estrellas.get(i).getDireccion();
				
				if(direccion==1) {
					y=y+3;
				}else {
					y=(int)(Math.random()*700);
					direccion=1;
				}
				if(y>700) {
					direccion=0;
				}
				
				estrellas.get(i).setDireccion(direccion);
				estrellas.get(i).setY(y);
				
			}
			
			int velocidad = 6+4*(int)(Math.random()*3); //6,10,14,18
			try {
				Thread.sleep(velocidad);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			l.repaint();
			
		}
		
	}
	
	

}
