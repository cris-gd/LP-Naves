package Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Lienzo extends JPanel implements KeyListener, MouseListener, MouseMotionListener{
	
	//barra vidas
	int anchura=550; //barra vidas
	int vidas=3;
	int porcentajevida=100;
	int puntuacion=0;
	String puntos;
	
	//fondo
	int y_estrella=0;
	ArrayList<Estrella> estrellas= new ArrayList<Estrella>();
	
	
	//ayudantes
	AyudantePuntuacion ap=null;
	AyudanteEstrella ae=null;
	AyudanteShoot as=null;
	AyudanteEnemigos aeny=null;
	AyudanteLaser al=null;
	AyudanteExplosion aexp=null;
	AyudanteLlama all=null;
	
	//naves
	Image[] naves=new Image[5];
	Image[] misiles=new Image[3];
	Image[] disparos=new Image[4];
	Image[] enemigo1 = new Image [10];
	Image[] enemigo2 = new Image[10];
	Image[] enemigo3 = new Image[10];
	Image[] laser = new Image[5];
	Image[] explosiones = new Image[7];
	Image[] llama = new Image[4];
	
	Nave nave=null;
	int num_llama=0;
	int xllama;
	int yllama;
	
	Shoot shoot=null;
	ArrayList<Shoot> misilesActivos = new ArrayList<>();

	
	Toolkit t;
	
	int nivel;
	int num_misil;
	int num_laser;
	int num_colision;
	
	//colisiones
	boolean colisionenemy=false; //cuando se le da a una nave enemiga
	boolean colisionnave=false;
	
	int fila_enemy;
	int posicion_enemy;
	Enemigo enemy;
	
	//naves enemigas
	ArrayList<Enemigo> fila1= new ArrayList<Enemigo>();
	ArrayList<Enemigo> fila2= new ArrayList<Enemigo>();
	ArrayList<Enemigo> fila3= new ArrayList<Enemigo>();
	ArrayList<Enemigo> fila4= new ArrayList<Enemigo>();
	ArrayList<Laser> lasers1= new ArrayList<Laser>();
	ArrayList<Laser> lasers2= new ArrayList<Laser>();
	ArrayList<Laser> lasers3= new ArrayList<Laser>();
	ArrayList<Laser> lasers4= new ArrayList<Laser>();
	
	//detectores colisiones
	ColisionEnemigo ce=null;
	ColisionNave cn=null;
	
	ArrayList<Explosion> colisiones=new ArrayList<Explosion>();
	
	
	public Lienzo() {
		
		//estrellas
		for (int i=0; i<100; i++) {
			int y =(int)(Math.random()*700);;
			
			Estrella e=new Estrella(y);
			
			estrellas.add(e);
			
		}
		
		ae=new AyudanteEstrella(estrellas,this);
		ae.start();
		
				
		//naves
		t=Toolkit.getDefaultToolkit();
		//importar naves
		naves[0]=t.getImage(getClass().getResource("nave01.png"));
		naves[1]=t.getImage(getClass().getResource("nave02.png"));
		naves[2]=t.getImage(getClass().getResource("nave03.png"));
		naves[3]=t.getImage(getClass().getResource("nave04.png"));
		naves[4]=t.getImage(getClass().getResource("nave05.png"));
		
		//importar misiles
		misiles[0]=t.getImage(getClass().getResource("misil1.png"));
		misiles[1]=t.getImage(getClass().getResource("misil2.png"));
		misiles[2]=t.getImage(getClass().getResource("misil3.png"));
		
		//importar disparos
		disparos[0]=t.getImage(getClass().getResource("disparo01.png"));
		disparos[1]=t.getImage(getClass().getResource("disparo02.png"));
		disparos[2]=t.getImage(getClass().getResource("disparo03.png"));
		disparos[3]=t.getImage(getClass().getResource("disparo04.png"));
		
		nave=new Nave(400,500);//aparece en 300, 300 (cambiar)
		
		as=new AyudanteShoot(this,misilesActivos,nivel);
		as.start();
		
		//naves enemigas (menos puntos)
		enemigo1[0]=t.getImage(getClass().getResource("enemigo1-amarillo.png"));
		enemigo1[1]=t.getImage(getClass().getResource("enemigo1-azul.png"));
		enemigo1[2]=t.getImage(getClass().getResource("enemigo1-azulclaro.png"));
		enemigo1[3]=t.getImage(getClass().getResource("enemigo1-gris.png"));
		enemigo1[4]=t.getImage(getClass().getResource("enemigo1-naranja.png"));
		enemigo1[5]=t.getImage(getClass().getResource("enemigo1-rojo.png"));
		enemigo1[6]=t.getImage(getClass().getResource("enemigo1-verde.png"));
		enemigo1[7]=t.getImage(getClass().getResource("enemigo1-azulclaro.png"));
		enemigo1[8]=t.getImage(getClass().getResource("enemigo1-azul.png"));
		enemigo1[9]=t.getImage(getClass().getResource("enemigo1-amarillo.png"));
		
		//naves enemigas (puntos intermedios)
		enemigo2[0]=t.getImage(getClass().getResource("enemigo1-amarillo.png"));
		enemigo2[1]=t.getImage(getClass().getResource("enemigo1-azul.png"));
		enemigo2[2]=t.getImage(getClass().getResource("enemigo1-azulclaro.png"));
		enemigo2[3]=t.getImage(getClass().getResource("enemigo1-gris.png"));
		enemigo2[4]=t.getImage(getClass().getResource("enemigo1-naranja.png"));
		enemigo2[5]=t.getImage(getClass().getResource("enemigo1-rojo.png"));
		enemigo2[6]=t.getImage(getClass().getResource("enemigo1-verde.png"));
		enemigo2[7]=t.getImage(getClass().getResource("enemigo1-azulclaro.png"));
		enemigo2[8]=t.getImage(getClass().getResource("enemigo1-azul.png"));
		enemigo2[9]=t.getImage(getClass().getResource("enemigo1-amarillo.png"));
		
		//naves enemigas (más puntos)
		enemigo3[0]=t.getImage(getClass().getResource("enemigo1-amarillo.png"));
		enemigo3[1]=t.getImage(getClass().getResource("enemigo1-azul.png"));
		enemigo3[2]=t.getImage(getClass().getResource("enemigo1-azulclaro.png"));
		enemigo3[3]=t.getImage(getClass().getResource("enemigo1-gris.png"));
		enemigo3[4]=t.getImage(getClass().getResource("enemigo1-naranja.png"));
		enemigo3[5]=t.getImage(getClass().getResource("enemigo1-rojo.png"));
		enemigo3[6]=t.getImage(getClass().getResource("enemigo1-verde.png"));
		enemigo3[7]=t.getImage(getClass().getResource("enemigo1-azulclaro.png"));
		enemigo3[8]=t.getImage(getClass().getResource("enemigo1-azul.png"));
		enemigo3[9]=t.getImage(getClass().getResource("enemigo1-amarillo.png"));
		
		//láseres
		laser[0]=t.getImage(getClass().getResource("laser1.png"));
		laser[1]=t.getImage(getClass().getResource("laser2.png"));
		laser[2]=t.getImage(getClass().getResource("laser3.png"));
		laser[3]=t.getImage(getClass().getResource("laser4.png"));
		laser[4]=t.getImage(getClass().getResource("laser5.png"));
		
		//explosiones
		explosiones[0]=t.getImage(getClass().getResource("explosion01.png"));
		explosiones[1]=t.getImage(getClass().getResource("explosion02.png"));
		explosiones[2]=t.getImage(getClass().getResource("explosion03.png"));
		explosiones[3]=t.getImage(getClass().getResource("explosion04.png"));
		explosiones[4]=t.getImage(getClass().getResource("explosion05.png"));
		explosiones[5]=t.getImage(getClass().getResource("explosion06.png"));
		explosiones[6]=t.getImage(getClass().getResource("explosion07.png"));
		
		//llamas
		llama[0]=t.getImage(getClass().getResource("llama1.png"));
		llama[1]=t.getImage(getClass().getResource("llama2.png"));
		llama[2]=t.getImage(getClass().getResource("llama3.png"));
		llama[3]=t.getImage(getClass().getResource("llama4.png"));
		
		//crear filas enemigos
		for (int i=0; i<10; i++) {
			int x =900-60*i;
			
			switch(i) {
			case 0:
				enemy=new Enemigo(x,70, 32,nivel);
				fila1.add(enemy);
				break;
			case 1:
				enemy=new Enemigo(x,70,34,nivel);
				fila1.add(enemy);
				break;
			case 2:
				enemy=new Enemigo(x,70,36,nivel);
				fila1.add(enemy);
				break;
			case 3:
				enemy=new Enemigo(x,70,38,nivel);
				fila1.add(enemy);
				break;
			case 4:
				enemy=new Enemigo(x,70,40,nivel);
				fila1.add(enemy);
				break;
			case 5:
				enemy=new Enemigo(x,70,42,nivel);
				fila1.add(enemy);
				break;
			case 6:
				enemy=new Enemigo(x,70,44,nivel);
				fila1.add(enemy);
				break;
			case 7:
				enemy=new Enemigo(x,70,36,nivel);
				fila1.add(enemy);
				break;
			case 8:
				enemy=new Enemigo(x,70,34,nivel);
				fila1.add(enemy);
				break;
			case 9:
				enemy=new Enemigo(x,70,32,nivel);
				fila1.add(enemy);
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
				fila2.add(enemy);
				break;
			case 1:
				enemy=new Enemigo(x,100,20,nivel);
				fila2.add(enemy);
				break;
			case 2:
				enemy=new Enemigo(x,100,22,nivel);
				fila2.add(enemy);
				break;
			case 3:
				enemy=new Enemigo(x,100,24,nivel);
				fila2.add(enemy);
				break;
			case 4:
				enemy=new Enemigo(x,100,26,nivel);
				fila2.add(enemy);
				break;
			case 5:
				enemy=new Enemigo(x,100,28,nivel);
				fila2.add(enemy);
				break;
			case 6:
				enemy=new Enemigo(x,100,30,nivel);
				fila2.add(enemy);
				break;
			case 7:
				enemy=new Enemigo(x,100,22,nivel);
				fila2.add(enemy);
				break;
			case 8:
				enemy=new Enemigo(x,100,20,nivel);
				fila2.add(enemy);
				break;
			case 9:
				enemy=new Enemigo(x,100,18,nivel);
				fila2.add(enemy);
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
				fila3.add(enemy);
				break;
			case 1:
				enemy=new Enemigo(x,130,4,nivel);
				fila3.add(enemy);
				break;
			case 2:
				enemy=new Enemigo(x,130,8,nivel);
				fila3.add(enemy);
				break;
			case 3:
				enemy=new Enemigo(x,130,10,nivel);
				fila3.add(enemy);
				break;
			case 4:
				enemy=new Enemigo(x,130,12,nivel);
				fila3.add(enemy);
				break;
			case 5:
				enemy=new Enemigo(x,130,14,nivel);
				fila3.add(enemy);
				break;
			case 6:
				enemy=new Enemigo(x,130,16,nivel);
				fila3.add(enemy);
				break;
			case 7:
				enemy=new Enemigo(x,130,8,nivel);
				fila3.add(enemy);
				break;
			case 8:
				enemy=new Enemigo(x,130,4,nivel);
				fila3.add(enemy);
				break;
			case 9:
				enemy=new Enemigo(x,130,2,nivel);
				fila3.add(enemy);
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
				fila4.add(enemy);
				break;
			case 1:
				enemy=new Enemigo(x,160,4,nivel);
				fila4.add(enemy);
				break;
			case 2:
				enemy=new Enemigo(x,160,8,nivel);
				fila4.add(enemy);
				break;
			case 3:
				enemy=new Enemigo(x,160,10,nivel);
				fila4.add(enemy);
				break;
			case 4:
				enemy=new Enemigo(x,160,12,nivel);
				fila4.add(enemy);
				break;
			case 5:
				enemy=new Enemigo(x,160,14,nivel);
				fila4.add(enemy);
				break;
			case 6:
				enemy=new Enemigo(x,160,16,nivel);
				fila4.add(enemy);
				break;
			case 7:
				enemy=new Enemigo(x,160,8,nivel);
				fila4.add(enemy);
				break;
			case 8:
				enemy=new Enemigo(x,160,4,nivel);
				fila4.add(enemy);
				break;
			case 9:
				enemy=new Enemigo(x,160,2,nivel);
				fila4.add(enemy);
				break;
			}
			
			
			if (fila4.get(i).lanzarLaser()) {
			Laser laser=new Laser(fila4.get(i).getX(),fila4.get(i).getY());
			lasers4.add(laser);
			}
		}
		

		aeny=new AyudanteEnemigos(this,fila1,fila2,fila3,fila4, lasers1,lasers2,lasers3,lasers4);
		aeny.start();
		
		al= new AyudanteLaser(this, lasers1, lasers2, lasers3, lasers4, fila1, fila2, fila3, fila4);
		al.start();
		
		ce = new ColisionEnemigo(misilesActivos, fila1, fila2, fila3, fila4, this);
		ce.start();
		
		cn=new ColisionNave(lasers1, lasers2,lasers3,lasers4, nave,nivel, this);
		cn.start();
		
		//puntuacion
		nivel=0;
		ap= new AyudantePuntuacion(anchura, this, puntuacion, puntos, nivel, colisionenemy, colisionnave, vidas, porcentajevida);
		ap.start();
		
		aexp=new AyudanteExplosion(colisiones, this);
		aexp.start();
		
		all=new AyudanteLlama(num_llama, nave, this);
		all.start();
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		//fondo de pantalla
		g.setColor(Color.black);
		g.fillRect(0, 0, 1000, 700);
		
		
		//estrellas
		for (int i=0; i<estrellas.size();i++) {
			g.setColor(Color.white);
			g.fillOval(estrellas.get(i).getX(),estrellas.get(i).getY(),estrellas.get(i).getGrosor(),estrellas.get(i).getGrosor());
		}
		
		
		

		//pintar nave
		g.drawImage(naves[nivel], nave.getX(), nave.getY(), this);
		g.drawImage(llama[num_llama], xllama, yllama, this);
		
		if (vidas!=0) {
		//pintar disparos
		for (int i=0; i<misilesActivos.size();i++) {
			if(nivel==0) {
				g.drawImage(disparos[nivel], misilesActivos.get(i).getX(), misilesActivos.get(i).getY(),this);
			}
			if(nivel==1) {
				g.drawImage(disparos[nivel], misilesActivos.get(i).getX(), misilesActivos.get(i).getY(),this);
			}
			if(nivel==2) {
				g.drawImage(disparos[nivel], misilesActivos.get(i).getX(), misilesActivos.get(i).getY(),this);
			}
			if(nivel==3) {
				g.drawImage(disparos[nivel], misilesActivos.get(i).getX(), misilesActivos.get(i).getY(),this);
			}
			if(nivel==4) {
				g.drawImage(misiles[num_misil], misilesActivos.get(i).getX(), misilesActivos.get(i).getY(),this);
			}
		}
		
		//pintar enemigos
		for (int i=0; i<fila1.size();i++) {
			if (fila1.get(i)!=null) {
				g.drawImage(enemigo3[i],fila1.get(i).getX(), fila1.get(i).getY(), this);
			}

		}
		for (int i=0; i<fila2.size();i++) {
			if (fila2.get(i)!=null) {
			g.drawImage(enemigo2[i],fila2.get(i).getX(), fila2.get(i).getY(), this);
			}
			
		}
		for (int i=0; i<fila3.size();i++) {
			if (fila3.get(i)!=null) {
			g.drawImage(enemigo1[i],fila3.get(i).getX(), fila3.get(i).getY(), this);
			}
		}
		for (int i=0; i<fila4.size();i++) {
			if (fila4.get(i)!=null) {
			g.drawImage(enemigo1[i],fila4.get(i).getX(), fila4.get(i).getY(), this);
			}
		}
		//pintar laseres
		for( int i=0; i<lasers1.size(); i++){
			g.drawImage(laser[lasers1.get(i).getNum_laser()], lasers1.get(i).getX(), lasers1.get(i).getY(), this);
		}
		for( int i=0; i<lasers2.size(); i++){
			 g.drawImage(laser[lasers2.get(i).getNum_laser()], lasers2.get(i).getX(), lasers2.get(i).getY(), this);
		}
		for( int i=0; i<lasers3.size(); i++){
			 g.drawImage(laser[lasers3.get(i).getNum_laser()], lasers3.get(i).getX(), lasers3.get(i).getY(), this);
		}
		for( int i=0; i<lasers4.size(); i++){
			g.drawImage(laser[lasers4.get(i).getNum_laser()], lasers4.get(i).getX(), lasers4.get(i).getY(), this);
		}
		
		for( int i=0; i<colisiones.size(); i++){
			if (colisiones.get(i).getNum_colision()<6) {
				g.drawImage(explosiones[colisiones.get(i).getNum_colision()], colisiones.get(i).getX(), colisiones.get(i).getY(), this);
			}else {
				colisiones.remove(i);
			}
			
			
		}
		
		
		}
		if (vidas==0) {
			Font fuente2=new Font ("Arial", 1,70);
			g.setFont(fuente2);
			g.setColor(Color.white);
			g.drawString("GAME OVER", 270, 320);
		}
		
		//barra vidas
				Font fuente=new Font ("Arial", 1,30);
				g.setFont(fuente);
				g.setColor(Color.white);
				g.drawString("Vidas: "+vidas, 780, 50);
				g.drawString(puntos, 50, 50);
				
				g.setColor(Color.red);
				g.fillRect(200,30,550,30);
				
				g.setColor(Color.blue);
				g.fillRect(200,30,anchura,30);
	}
	
	//sttters y gettes
	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getPuntos() {
		return puntos;
	}

	public void setPuntos(String puntos) {
		this.puntos = puntos;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	
	public int getNum_misil() {
		return num_misil;
	}

	public void setNum_misil(int num_misil) {
		this.num_misil = num_misil;
	}
	
	

	public ArrayList<Laser> getLasers1() {
		return lasers1;
	}

	public void setLasers1(ArrayList<Laser> lasers1) {
		this.lasers1 = lasers1;
	}

	public ArrayList<Laser> getLasers2() {
		return lasers2;
	}

	public void setLasers2(ArrayList<Laser> lasers2) {
		this.lasers2 = lasers2;
	}

	public ArrayList<Laser> getLasers3() {
		return lasers3;
	}

	public void setLasers3(ArrayList<Laser> lasers3) {
		this.lasers3 = lasers3;
	}

	public ArrayList<Laser> getLasers4() {
		return lasers4;
	}

	public void setLasers4(ArrayList<Laser> lasers4) {
		this.lasers4 = lasers4;
	}

	public ArrayList<Shoot> getMisilesActivos() {
		return misilesActivos;
	}

	public void setMisilesActivos(ArrayList<Shoot> misilesActivos) {
		this.misilesActivos = misilesActivos;
	}

	public boolean isColisionenemy() {
		return colisionenemy;
	}

	public void setColisionenemy(boolean colisionenemy) {
		this.colisionenemy = colisionenemy;
	}
	

	public ArrayList<Explosion> getColisiones() {
		return colisiones;
	}

	public void setColisiones(ArrayList<Explosion> colisiones) {
		this.colisiones = colisiones;
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

	public int getFila_enemy() {
		return fila_enemy;
	}

	public void setFila_enemy(int fila_enemy) {
		this.fila_enemy = fila_enemy;
	}

	public int getPosicion_enemy() {
		return posicion_enemy;
	}

	public void setPosicion_enemy(int posicion_enemy) {
		this.posicion_enemy = posicion_enemy;
	}

	public int getAnchura() {
		return anchura;
	}

	public void setAnchura(int anchura) {
		this.anchura = anchura;
	}
	

	public int getNum_llama() {
		return num_llama;
	}

	public void setNum_llama(int num_llama) {
		this.num_llama = num_llama;
	}

	public int getXllama() {
		return xllama;
	}

	public void setXllama(int xllama) {
		this.xllama = xllama;
	}

	public int getYllama() {
		return yllama;
	}

	public void setYllama(int yllama) {
		this.yllama = yllama;
	}

	public int getNum_colision() {
		return num_colision;
	}

	public void setNum_colision(int num_colision) {
		this.num_colision = num_colision;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public int getPorcentajevida() {
		return porcentajevida;
	}

	public void setPorcentajevida(int porcentajevida) {
		this.porcentajevida = porcentajevida;
	}

	public int getNum_laser() {
		return num_laser;
	}

	public void setNum_laser(int num_laser) {
		this.num_laser = num_laser;
	}

	public boolean isColisionnave() {
		return colisionnave;
	}

	public void setColisionnave(boolean colisionnave) {
		this.colisionnave = colisionnave;
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//si se pulsa barra espaciadora
				if (e.getKeyCode()==32) {
					switch (nivel) {
					case 0:
						Shoot sh=new Shoot(nave.getX()+30,nave.getY());
						misilesActivos.add(sh);
						break;
					case 1:
						sh=new Shoot(nave.getX()+10,nave.getY());
						misilesActivos.add(sh);
						sh=new Shoot(nave.getX()+85,nave.getY());
						misilesActivos.add(sh);
						break;
					case 2:
						sh=new Shoot(nave.getX()+10,nave.getY());
						misilesActivos.add(sh);
						sh=new Shoot(nave.getX()+45,nave.getY());
						misilesActivos.add(sh);
						sh=new Shoot(nave.getX()+75,nave.getY());
						misilesActivos.add(sh);
						break;
					case 3:
						sh=new Shoot(nave.getX()+15,nave.getY());
						misilesActivos.add(sh);
						sh=new Shoot(nave.getX()+50,nave.getY());
						misilesActivos.add(sh);
						sh=new Shoot(nave.getX()+80,nave.getY());
						misilesActivos.add(sh);
						break;
					case 4:
						sh=new Shoot(nave.getX()+20,nave.getY());
						misilesActivos.add(sh);
						sh=new Shoot(nave.getX()+80,nave.getY());
						misilesActivos.add(sh);
						sh=new Shoot(nave.getX()+140,nave.getY());
						misilesActivos.add(sh);
						break;
					}
				}
			repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
		Point raton=e.getLocationOnScreen();
		
		nave.setX(raton.x);
		nave.setY(raton.y);
		
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
