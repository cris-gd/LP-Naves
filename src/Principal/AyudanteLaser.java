package Principal;

import java.util.ArrayList;
import java.util.Random;

public class AyudanteLaser extends Thread{

	Lienzo l;
	ArrayList<Laser> lasers1=null;
	ArrayList<Laser> lasers2=null;
	ArrayList<Laser> lasers3=null;
	ArrayList<Laser> lasers4=null;
	
	ArrayList<Enemigo> fila1=null;
	ArrayList<Enemigo> fila2=null;
	ArrayList<Enemigo> fila3= null;
	ArrayList<Enemigo> fila4= null;
	

	public AyudanteLaser(Lienzo l, ArrayList<Laser> lasers1, ArrayList<Laser> lasers2, ArrayList<Laser> lasers3,
			ArrayList<Laser> lasers4, ArrayList<Enemigo> fila1, ArrayList<Enemigo> fila2, ArrayList<Enemigo> fila3,
			ArrayList<Enemigo> fila4) {
		super();
		this.l = l;
		this.lasers1 = lasers1;
		this.lasers2 = lasers2;
		this.lasers3 = lasers3;
		this.lasers4 = lasers4;
		this.fila1 = fila1;
		this.fila2 = fila2;
		this.fila3 = fila3;
		this.fila4 = fila4;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while (true) {
			
			for (int i=0; i<lasers1.size();i++) {
				int y= lasers1.get(i).getY();
				y=y+1;
				
				lasers1.get(i).setY(y);
				
				if (y>700) {
					Random rand= new Random();
					int j=rand.nextInt(fila1.size());
					if (fila1.get(j)!=null){
						lasers1.get(i).setY(fila1.get(j).getY());
						lasers1.get(i).setX(fila1.get(j).getX());	
					}
				}
		
			}
			for (int i=0; i<lasers2.size();i++) {
				int y= lasers2.get(i).getY();
				y=y+1;
				lasers2.get(i).setY(y);
				
				if (y>700) {
					Random rand= new Random();
					int j=rand.nextInt(fila2.size());
					if (fila2.get(j)!=null){
						lasers2.get(i).setY(fila2.get(j).getY());
						lasers2.get(i).setX(fila2.get(j).getX());	
					}
				}
			}
			for (int i=0; i<lasers3.size();i++) {
				int y= lasers3.get(i).getY();
				y=y+1;
				lasers3.get(i).setY(y);
				
				if (y>700) {
					Random rand= new Random();
					int j=rand.nextInt(fila3.size());
					if (fila3.get(j)!=null){
						lasers3.get(i).setY(fila3.get(j).getY());
						lasers3.get(i).setX(fila3.get(j).getX());	
					}
				}
			}
			for (int i=0; i<lasers4.size();i++) {
				int y= lasers4.get(i).getY();
				y=y+1;
				lasers4.get(i).setY(y);
				
				if (y>700) {
					Random rand= new Random();
					int j=rand.nextInt(fila4.size());
					if (fila4.get(j)!=null){
						lasers4.get(i).setY(fila4.get(j).getY());
						lasers4.get(i).setX(fila4.get(j).getX());	
					}
				
				}
			}
			

			try {
				Thread.sleep(6);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			l.repaint();
		}
	}
	
	
}
