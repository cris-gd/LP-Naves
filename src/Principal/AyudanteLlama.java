package Principal;

import java.awt.Image;
import java.awt.Toolkit;

public class AyudanteLlama extends Thread{

	int num_llama;
	int xllama;
	int yllama;
	
	Nave nave;
	
	Lienzo l;
	
	Toolkit t;
	Image nave1;
	Image nave2;
	Image nave3;
	Image nave4;
	Image nave5;
	

	public AyudanteLlama(int num_llama, Nave nave, Lienzo l) {
		super();
		this.num_llama = num_llama;
		this.nave = nave;
		this.l = l;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(true) {
			
			t=Toolkit.getDefaultToolkit();
			nave1=t.getImage(getClass().getResource("nave01.png"));
			nave2=t.getImage(getClass().getResource("nave02.png"));
			nave3=t.getImage(getClass().getResource("nave03.png"));
			nave4=t.getImage(getClass().getResource("nave04.png"));
			nave5=t.getImage(getClass().getResource("nave05.png"));
			
			switch (l.getNivel()) {
			case 0:
				xllama=nave.getX()+(nave1.getWidth(null)/2)-7;
				yllama=nave.getY()+(nave1.getHeight(null)/2+5);
				break;
			case 1:
				xllama=nave.getX()+(nave2.getWidth(null)/2)-7;
				yllama=nave.getY()+(nave2.getHeight(null)/2)+20;
				break;
			case 2:
				xllama=nave.getX()+(nave3.getWidth(null)/2)-7;
				yllama=nave.getY()+(nave3.getHeight(null)/2)+20;
				break;
			case 3:
				xllama=nave.getX()+(nave4.getWidth(null)/2)-7;
				yllama=nave.getY()+(nave4.getHeight(null)/2)+25;
				break;
			case 4:
				xllama=nave.getX()+(nave5.getWidth(null)/2)-7;
				yllama=nave.getY()+(nave5.getHeight(null)/2)+40;
				break;
			}
	
			l.setXllama(xllama);
			l.setYllama(yllama);
			
			num_llama=l.getNum_llama()+1;
			if (num_llama>3) {
				num_llama=0;
			}
			
			l.setNum_llama(num_llama);
			
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
