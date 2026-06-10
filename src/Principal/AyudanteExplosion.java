package Principal;

import java.util.ArrayList;

public class AyudanteExplosion extends Thread{

	ArrayList<Explosion> colisiones;
	int num_colision;
	
	Lienzo l;

	




	public AyudanteExplosion(ArrayList<Explosion> colisiones, Lienzo l) {
		super();
		this.colisiones = colisiones;
		this.l = l;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true) {
			for(int i=0; i<colisiones.size();i++) {
				num_colision=colisiones.get(i).getNum_colision()+1;
				colisiones.get(i).setNum_colision(num_colision);
			}
			
			
			l.repaint();
			
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
}
