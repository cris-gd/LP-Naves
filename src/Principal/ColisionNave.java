package Principal;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

public class ColisionNave extends Thread{
	//los láseres de las naves enemigas se lanzan a nuestra nave

	ArrayList<Laser> lasers1= null;
	ArrayList<Laser> lasers2= null;
	ArrayList<Laser> lasers3= null;
	ArrayList<Laser> lasers4= null;
	Nave nave;
	
	Toolkit t;
	Image[] naves=new Image[5];
	int nivel;
	
	//consideramos que los laseres todos tienen igual tamaño;
	Image laser;

	boolean colisionnave = false;
	
	Lienzo l;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(true) {
		
		t=Toolkit.getDefaultToolkit();
		laser=t.getImage(getClass().getResource("laser1.png"));
		naves[0]=t.getImage(getClass().getResource("nave01.png"));
		naves[1]=t.getImage(getClass().getResource("nave02.png"));
		naves[2]=t.getImage(getClass().getResource("nave03.png"));
		naves[3]=t.getImage(getClass().getResource("nave04.png"));
		naves[4]=t.getImage(getClass().getResource("nave05.png"));
		
		for(int i = 0; i<lasers4.size(); i++) {
			int x1min = lasers4.get(i).getX();
			int y1min = lasers4.get(i).getY();
			int x1max = x1min+laser.getWidth(null);
			int y1max = y1min + laser.getHeight(null);
			
			int x2min = nave.getX();
			int y2min = nave.getY();
			int x2max =x2min+naves[nivel].getWidth(null);
			int y2max = y2min + naves[nivel].getHeight(null);
			
			boolean superposicionX = x1min < x2max && x1max > x2min;
			boolean superposicionY = y1min < y2max && y1max > y2min;
			
			if( superposicionX && superposicionY) {
				colisionnave = true;
				l.setColisionnave(colisionnave);
				l.setNum_laser(lasers4.get(i).getNum_laser());
				l.getLasers4().remove(i);
			}
		}
		
		for(int i = 0; i<lasers3.size(); i++) {
			int x1min = lasers3.get(i).getX();
			int y1min = lasers3.get(i).getY();
			int x1max = x1min+laser.getWidth(null);
			int y1max = y1min + laser.getHeight(null);
			
			int x2min = nave.getX();
			int y2min = nave.getY();
			int x2max =x2min+naves[nivel].getWidth(null);
			int y2max = y2min + naves[nivel].getHeight(null);
			
			boolean superposicionX = x1min < x2max && x1max > x2min;
			boolean superposicionY = y1min < y2max && y1max > y2min;
			
			if( superposicionX && superposicionY) {
				colisionnave = true;
				l.setColisionnave(colisionnave);
				l.setNum_laser(lasers3.get(i).getNum_laser());
				l.getLasers3().remove(i);
				
			}
		}
		
		for(int i = 0; i<lasers2.size(); i++) {
			int x1min = lasers2.get(i).getX();
			int y1min = lasers2.get(i).getY();
			int x1max = x1min+laser.getWidth(null);
			int y1max = y1min + laser.getHeight(null);
			
			int x2min = nave.getX();
			int y2min = nave.getY();
			int x2max =x2min+naves[nivel].getWidth(null);
			int y2max = y2min + naves[nivel].getHeight(null);
			
			boolean superposicionX = x1min < x2max && x1max > x2min;
			boolean superposicionY = y1min < y2max && y1max > y2min;
			
			if( superposicionX && superposicionY) {
				colisionnave = true;
				l.setColisionnave(colisionnave);
				l.setNum_laser(lasers2.get(i).getNum_laser());
				l.getLasers2().remove(i);
			}
		}
		
		for(int i = 0; i<lasers1.size(); i++) {
				int x1min = lasers1.get(i).getX();
				int y1min = lasers1.get(i).getY();
				int x1max = x1min+laser.getWidth(null);
				int y1max = y1min + laser.getHeight(null);
				
				int x2min = nave.getX();
				int y2min = nave.getY();
				int x2max =x2min+naves[nivel].getWidth(null);
				int y2max = y2min + naves[nivel].getHeight(null);
				
				boolean superposicionX = x1min < x2max && x1max > x2min;
				boolean superposicionY = y1min < y2max && y1max > y2min;
				
				if( superposicionX && superposicionY) {
					colisionnave = true;
					l.setColisionnave(colisionnave);
					l.setNum_laser(lasers1.get(i).getNum_laser());
					l.getLasers1().remove(i);
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

	public ColisionNave(ArrayList<Laser> lasers1, ArrayList<Laser> lasers2, ArrayList<Laser> lasers3,
			ArrayList<Laser> lasers4, Nave nave, int nivel, Lienzo l) {
		super();
		this.lasers1 = lasers1;
		this.lasers2 = lasers2;
		this.lasers3 = lasers3;
		this.lasers4 = lasers4;
		this.nave = nave;
		this.nivel = nivel;
		this.l = l;
	}

	public boolean isColisionnave() {
		return colisionnave;
	}

	public void setColisionnave(boolean colisionnave) {
		this.colisionnave = colisionnave;
	}
	
	
}


