package Principal;

import java.util.ArrayList;

public class AyudanteEnemigos extends Thread{
		
	Lienzo l;
	ArrayList<Enemigo> fila1=null;
	ArrayList<Enemigo> fila2=null;
	ArrayList<Enemigo> fila3= null;
	ArrayList<Enemigo> fila4= null;
	
	ArrayList<Laser> lasers1= null;
	ArrayList<Laser> lasers2= null;
	ArrayList<Laser> lasers3= null;
	ArrayList<Laser> lasers4= null;
	
	Enemigo enemy;
	int t;

	public AyudanteEnemigos(Lienzo l, ArrayList<Enemigo> fila1, ArrayList<Enemigo> fila2, ArrayList<Enemigo> fila3,
			ArrayList<Enemigo> fila4, ArrayList<Laser> lasers1, ArrayList<Laser> lasers2, ArrayList<Laser> lasers3,
			ArrayList<Laser> lasers4) {
		super();
		this.l = l;
		this.fila1 = fila1;
		this.fila2 = fila2;
		this.fila3 = fila3;
		this.fila4 = fila4;
		this.lasers1 = lasers1;
		this.lasers2 = lasers2;
		this.lasers3 = lasers3;
		this.lasers4 = lasers4;
	}




		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			
			while(true) {
				
				int nivel=l.getNivel();
				t++;
				
				for (int i=0; i<fila1.size();i++) {
					if (fila1.get(i)!=null) {
						int y=fila1.get(i).getY();
						int x=fila1.get(i).getX();

							
						y=y+1;
						x=x-2;
						
						fila1.get(i).setY(y);
						fila1.get(i).setX(x);
					}
					
				}
				
				for (int i=0; i<fila2.size();i++) {
					if (fila2.get(i)!=null) {

					int y=fila2.get(i).getY();
					int x=fila2.get(i).getX();
						
					y=y+1;
					x=x-2;
					
					fila2.get(i).setY(y);
					fila2.get(i).setX(x);
					}
					
				}
				
				for (int i=0; i<fila3.size();i++) {
					if (fila3.get(i)!=null) {

					int y=fila3.get(i).getY();
					int x=fila3.get(i).getX();
						
					y=y+1;
					x=x-2;
					
					fila3.get(i).setY(y);
					fila3.get(i).setX(x);
					}
				}
				
				for (int i=0; i<fila4.size();i++) {
					if (fila4.get(i)!=null) {

					int y=fila4.get(i).getY();
					int x=fila4.get(i).getX();
						
					y=y+1;
					x=x-2;
					
					fila4.get(i).setY(y);
					fila4.get(i).setX(x);
					}
				}
				
				if (t==400) {
				
					for (int i=0; i<10; i++) {
						int x =900-60*i;
						
						switch(i) {
						case 0:
							enemy=new Enemigo(x,70, 32, nivel);
							fila1.set(i,enemy);
							break;
						case 1:
							enemy=new Enemigo(x,70,34, nivel);
							fila1.set(i,enemy);
							break;
						case 2:
							enemy=new Enemigo(x,70,36,nivel);
							fila1.set(i,enemy);
							break;
						case 3:
							enemy=new Enemigo(x,70,38,nivel);
							fila1.set(i,enemy);
							break;
						case 4:
							enemy=new Enemigo(x,70,40,nivel);
							fila1.set(i,enemy);
							break;
						case 5:
							enemy=new Enemigo(x,70,42,nivel);
							fila1.set(i,enemy);
							break;
						case 6:
							enemy=new Enemigo(x,70,44,nivel);
							fila1.set(i,enemy);
							break;
						case 7:
							enemy=new Enemigo(x,70,36,nivel);
							fila1.set(i,enemy);
							break;
						case 8:
							enemy=new Enemigo(x,70,34,nivel);
							fila1.set(i,enemy);
							break;
						case 9:
							enemy=new Enemigo(x,70,32,nivel);
							fila1.set(i,enemy);
							break;
						}
						if (fila1.get(i).lanzarLaser()) {
							Laser laser=new Laser(fila1.get(i).getX(),fila1.get(i).getY());
							lasers1.add(laser);
						}
					}
					
						for (int i=0; i<10; i++) {
							int x =900-60*i;
							switch(i) {
							case 0:
								enemy=new Enemigo(x,100, 18,nivel);
								fila2.set(i,enemy);
								break;
							case 1:
								enemy=new Enemigo(x,100,20,nivel);
								fila2.set(i,enemy);
								break;
							case 2:
								enemy=new Enemigo(x,100,22,nivel);
								fila2.set(i,enemy);
								break;
							case 3:
								enemy=new Enemigo(x,100,24,nivel);
								fila2.set(i,enemy);
								break;
							case 4:
								enemy=new Enemigo(x,100,26,nivel);
								fila2.set(i,enemy);
								break;
							case 5:
								enemy=new Enemigo(x,100,28,nivel);
								fila2.set(i,enemy);
								break;
							case 6:
								enemy=new Enemigo(x,100,30,nivel);
								fila2.set(i,enemy);
								break;
							case 7:
								enemy=new Enemigo(x,100,22,nivel);
								fila2.set(i,enemy);
								break;
							case 8:
								enemy=new Enemigo(x,100,20,nivel);
								fila2.set(i,enemy);
								break;
							case 9:
								enemy=new Enemigo(x,100,18,nivel);
								fila2.set(i,enemy);
								break;
							}
							
							if (fila2.get(i).lanzarLaser()) {
							Laser laser=new Laser(fila2.get(i).getX(),fila2.get(i).getY());
							lasers2.add(laser);
							}
						}
					
	
						for (int i=0; i<10; i++) {
							int x =900-60*i;
							
							switch(i) {
							case 0:
								enemy=new Enemigo(x,130, 2,nivel);
								fila3.set(i,enemy);
								break;
							case 1:
								enemy=new Enemigo(x,130,4,nivel);
								fila3.set(i,enemy);
								break;
							case 2:
								enemy=new Enemigo(x,130,8,nivel);
								fila3.set(i,enemy);
								break;
							case 3:
								enemy=new Enemigo(x,130,10,nivel);
								fila3.set(i,enemy);
								break;
							case 4:
								enemy=new Enemigo(x,130,12,nivel);
								fila3.set(i,enemy);
								break;
							case 5:
								enemy=new Enemigo(x,130,14,nivel);
								fila3.set(i,enemy);
								break;
							case 6:
								enemy=new Enemigo(x,130,16,nivel);
								fila3.set(i,enemy);
								break;
							case 7:
								enemy=new Enemigo(x,130,8,nivel);
								fila3.set(i,enemy);
								break;
							case 8:
								enemy=new Enemigo(x,130,4,nivel);
								fila3.set(i,enemy);
								break;
							case 9:
								enemy=new Enemigo(x,130,2,nivel);
								fila3.set(i,enemy);
								break;
							}
							
							if (fila3.get(i).lanzarLaser()) {
							Laser laser=new Laser(fila3.get(i).getX(),fila3.get(i).getY());
							lasers3.add(laser);
							}
						}
					
						for (int i=0; i<10; i++) {
							int x =900-60*i;
							switch(i) {
							case 0:
								enemy=new Enemigo(x,160, 2,nivel);
								fila4.set(i,enemy);
								break;
							case 1:
								enemy=new Enemigo(x,160,4,nivel);
								fila4.set(i,enemy);
								break;
							case 2:
								enemy=new Enemigo(x,160,8,nivel);
								fila4.set(i,enemy);
								break;
							case 3:
								enemy=new Enemigo(x,160,10,nivel);
								fila4.set(i,enemy);
								break;
							case 4:
								enemy=new Enemigo(x,160,12,nivel);
								fila4.set(i,enemy);
								break;
							case 5:
								enemy=new Enemigo(x,160,14,nivel);
								fila4.set(i,enemy);
								break;
							case 6:
								enemy=new Enemigo(x,160,16,nivel);
								fila4.set(i,enemy);
								break;
							case 7:
								enemy=new Enemigo(x,160,8,nivel);
								fila4.set(i,enemy);
								break;
							case 8:
								enemy=new Enemigo(x,160,4,nivel);
								fila4.set(i,enemy);
								break;
							case 9:
								enemy=new Enemigo(x,160,2,nivel);
								fila4.set(i,enemy);
								break;
							}
							
							if (fila4.get(i).lanzarLaser()) {
							Laser laser=new Laser(fila4.get(i).getX(),fila4.get(i).getY());
							lasers4.add(laser);
							}
						}
					t=0;
				}
				
				try {
					Thread.sleep(60);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				l.repaint();
				
			}
			
		}
		
		

}
