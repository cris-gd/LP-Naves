package Principal;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

public class ColisionEnemigo extends Thread {
	//consideramos que colisión enemigo es que la nave nuestra lanza disparos 
	//o misiles a las naves enemigas
	
	//hemos considerado que todos los disparos tienen el mismo tamaño de rectángulo 
	//al igual que todas las naves enemigas
	
	ArrayList<Shoot> misilesActivos = null;
	ArrayList<Enemigo> fila1= null;
	ArrayList<Enemigo> fila2= null;
	ArrayList<Enemigo> fila3= null;
	ArrayList<Enemigo> fila4= null;
	Toolkit t;
	Image misil;
	Image disparo;
	Image enemy;
	boolean colisionenemy = false;
	
	Lienzo l;
	

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(true) {
		
		t=Toolkit.getDefaultToolkit();
		misil=t.getImage(getClass().getResource("misil1.png"));
		disparo=t.getImage(getClass().getResource("disparo01.png"));
		enemy=t.getImage(getClass().getResource("enemigo1-amarillo.png"));
		
		
		if (l.getMisilesActivos().size()!=0) {
		
		for(int j = 0; j<fila4.size();j++) {
			for(int i = 0; i<l.getMisilesActivos().size(); i++) {
				if (fila4.get(j)!=null) {
				if (l.getMisilesActivos().size()!=0) {
				int x1min = misilesActivos.get(i).getX();
				int y1min = misilesActivos.get(i).getY();
				int x1max = x1min+misil.getWidth(null);
				int y1max = y1min + misil.getHeight(null);
				
				int x2min = fila4.get(j).getX();
				int y2min = fila4.get(j).getY();
				int x2max =x2min+enemy.getWidth(null);
				int y2max = y2min + enemy.getHeight(null);
				
				boolean superposicionX = x1min < x2max && x1max > x2min;
				boolean superposicionY = y1min < y2max && y1max > y2min;
				
				if( superposicionX && superposicionY) {
					colisionenemy = true;
					
					l.setColisionenemy(colisionenemy);
					l.setPosicion_enemy(j);
					l.setFila_enemy(4);
					l.getMisilesActivos().remove(i);
				}
				}
				}
			}
		}
		}

		if (l.getMisilesActivos().size()!=0) {
			
			for(int j = 0; j<fila3.size();j++) {
				for(int i = 0; i<l.getMisilesActivos().size(); i++) {
					if (fila3.get(j)!=null) {
					if (l.getMisilesActivos().size()!=0) {
					int x1min = misilesActivos.get(i).getX();
					int y1min = misilesActivos.get(i).getY();
					int x1max = x1min+misil.getWidth(null);
					int y1max = y1min + misil.getHeight(null);
					
					int x2min = fila3.get(j).getX();
					int y2min = fila3.get(j).getY();
					int x2max =x2min+enemy.getWidth(null);
					int y2max = y2min + enemy.getHeight(null);
					
					boolean superposicionX = x1min < x2max && x1max > x2min;
					boolean superposicionY = y1min < y2max && y1max > y2min;
					
					if( superposicionX && superposicionY) {
						colisionenemy = true;
						
						l.setColisionenemy(colisionenemy);
						l.setPosicion_enemy(j);
						l.setFila_enemy(3);
						l.getMisilesActivos().remove(i);
					}
					}
					}
				}
			}
			}
		if (l.getMisilesActivos().size()!=0) {
			
			for(int j = 0; j<fila2.size();j++) {
				for(int i = 0; i<l.getMisilesActivos().size(); i++) {
					if (fila2.get(j)!=null) {
					if (l.getMisilesActivos().size()!=0) {
					int x1min = misilesActivos.get(i).getX();
					int y1min = misilesActivos.get(i).getY();
					int x1max = x1min+misil.getWidth(null);
					int y1max = y1min + misil.getHeight(null);
					
					int x2min = fila2.get(j).getX();
					int y2min = fila2.get(j).getY();
					int x2max =x2min+enemy.getWidth(null);
					int y2max = y2min + enemy.getHeight(null);
					
					boolean superposicionX = x1min < x2max && x1max > x2min;
					boolean superposicionY = y1min < y2max && y1max > y2min;
					
					if( superposicionX && superposicionY) {
						colisionenemy = true;
					
						
						l.setColisionenemy(colisionenemy);
						l.setPosicion_enemy(j);
						l.setFila_enemy(2);
						l.getMisilesActivos().remove(i);
					}
					}
					}
				}
			}
			}
		
		if (l.getMisilesActivos().size()!=0) {
		
		for(int j = 0; j<fila1.size();j++) {
			for(int i = 0; i<l.getMisilesActivos().size(); i++) {
				if (fila1.get(j)!=null) {
				if (l.getMisilesActivos().size()!=0) {
				int x1min = misilesActivos.get(i).getX();
				int y1min = misilesActivos.get(i).getY();
				int x1max = x1min+misil.getWidth(null);
				int y1max = y1min + misil.getHeight(null);
				
				int x2min = fila1.get(j).getX();
				int y2min = fila1.get(j).getY();
				int x2max =x2min+enemy.getWidth(null);
				int y2max = y2min + enemy.getHeight(null);
				
				boolean superposicionX = x1min < x2max && x1max > x2min;
				boolean superposicionY = y1min < y2max && y1max > y2min;
				
				if( superposicionX && superposicionY) {
					colisionenemy = true;
					
					
					l.setColisionenemy(colisionenemy);
					l.setPosicion_enemy(j);
					l.setFila_enemy(1);
					l.getMisilesActivos().remove(i);
				}
				}
				}
			}
		}
		}

		l.repaint();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	}
		
	public ColisionEnemigo(ArrayList<Shoot> misilesActivos, ArrayList<Enemigo> fila1, ArrayList<Enemigo> fila2,
			ArrayList<Enemigo> fila3, ArrayList<Enemigo> fila4, Lienzo l) {
		super();
		this.misilesActivos = misilesActivos;
		this.fila1 = fila1;
		this.fila2 = fila2;
		this.fila3 = fila3;
		this.fila4 = fila4;
		this.l=l;
		
	}
	public ArrayList<Shoot> getMisilesActivos() {
		return misilesActivos;
	}
	public void setMisilesActivos(ArrayList<Shoot> misilesActivos) {
		this.misilesActivos = misilesActivos;
	}
	public ArrayList<Enemigo> getFila1() {
		return fila1;
	}
	public void setFila1(ArrayList<Enemigo> fila1) {
		this.fila1 = fila1;
	}
	public ArrayList<Enemigo> getFila2() {
		return fila2;
	}
	public void setFila2(ArrayList<Enemigo> fila2) {
		this.fila2 = fila2;
	}
	public ArrayList<Enemigo> getFila3() {
		return fila3;
	}
	public void setFila3(ArrayList<Enemigo> fila3) {
		this.fila3 = fila3;
	}
	public ArrayList<Enemigo> getFila4() {
		return fila4;
	}
	public void setFila4(ArrayList<Enemigo> fila4) {
		this.fila4 = fila4;
	}
	public boolean isColisionenemy() {
		return colisionenemy;
	}
	public void setColisionenemy(boolean colisionenemy) {
		this.colisionenemy = colisionenemy;
	}
	
	
	
	
	

}
