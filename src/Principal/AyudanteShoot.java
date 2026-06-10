package Principal;

import java.util.ArrayList;

public class AyudanteShoot extends Thread{

	Lienzo l;
	ArrayList <Shoot> misilesActivos;
	int nivel;
	


	public AyudanteShoot(Lienzo l, ArrayList<Shoot> misilesActivos, int nivel) {
		super();
		this.l = l;
		this.misilesActivos = misilesActivos;
		this.nivel = nivel;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(true) {
		
			for (int i=0; i<misilesActivos.size();i++) {
				int y=misilesActivos.get(i).getY();
				y=y-3;
				misilesActivos.get(i).setY(y);
				
				if (nivel==4 && misilesActivos.get(i).getY()<400) {
					l.setNum_misil(1);
				}
				if (nivel==4 && misilesActivos.get(i).getY()<200) {
					l.setNum_misil(2);
				}
			}
		
		
		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l.repaint();
		}
	}
	
	
}
