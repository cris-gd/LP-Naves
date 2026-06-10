package Principal;

import java.util.ArrayList;

public class AyudantePuntuacion extends Thread{

	int anchura;
	Lienzo l;
	int puntuacion;
	String puntos;
	int nivel;
	boolean colisionenemy;
	boolean colisionnave;
	
	int vidas;
	int porcentajevida;
	
	int vida_enemy;
	
	Enemigo e=null;
	
	ArrayList<Explosion> colisiones;
	int xcolision;
	int ycolision;


	public AyudantePuntuacion(int anchura, Lienzo l, int puntuacion, String puntos, int nivel, boolean colisionenemy,
			boolean colisionnave, int vidas, int porcentajevida) {
		super();
		this.anchura = anchura;
		this.l = l;
		this.puntuacion = puntuacion;
		this.puntos = puntos;
		this.nivel = nivel;
		this.colisionenemy = colisionenemy;
		this.colisionnave = colisionnave;
		this.vidas = vidas;
		this.porcentajevida = porcentajevida;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(true) {
			
			//print puntuacion
			if(puntuacion<10) {
				puntos="000000"+puntuacion;
				l.setPuntos(puntos);
			} else if(puntuacion<100) {
				puntos="00000"+puntuacion;
				l.setPuntos(puntos);
			}
			else if(puntuacion<1000) {
				puntos="0000"+puntuacion;
				l.setPuntos(puntos);
			}
			else if(puntuacion<10000) {
				puntos="000"+puntuacion;
				l.setPuntos(puntos);
			}
			else if(puntuacion<100000) {
				puntos="00"+puntuacion;
				l.setPuntos(puntos);
			}
			else if(puntuacion<1000000) {
				puntos="0"+puntuacion;
				l.setPuntos(puntos);
			}
			else if(puntuacion<10000000) {
				puntos=String.valueOf(puntuacion);
				l.setPuntos(puntos);
			}

			//pasar de nivel
			if ((puntuacion-(2000*nivel))>=2000) {
				nivel+=1;
				if (nivel>=4) {
					nivel=4;
				}
				l.setNivel(nivel);
			}
			
			//la nave dispara a enemigos
			if(l.isColisionenemy()==true) {
			switch(nivel){
				case 0:
					puntuacion+=20;
					l.setPuntuacion(puntuacion);
					l.setColisionenemy(false);
					switch(l.getFila_enemy()) {
					case 1:
						vida_enemy=l.getFila1().get(l.getPosicion_enemy()).getVidaenemy();
						vida_enemy-=5;
						l.getFila1().get(l.getPosicion_enemy()).setVidaenemy(vida_enemy);
						if (vida_enemy<=0) {
							xcolision=l.getFila1().get(l.getPosicion_enemy()).getX();
							ycolision=l.getFila1().get(l.getPosicion_enemy()).getY();
							Explosion exp=new Explosion(xcolision,ycolision);
							colisiones=l.getColisiones();
							colisiones.add(exp);
							l.setColisiones(colisiones);
							l.getFila1().set(l.getPosicion_enemy(),e);
						}
						break;
					case 2:
						vida_enemy=l.getFila2().get(l.getPosicion_enemy()).getVidaenemy();
						vida_enemy-=5;
						l.getFila2().get(l.getPosicion_enemy()).setVidaenemy(vida_enemy);
						if (vida_enemy<=0) {
							
							xcolision=l.getFila2().get(l.getPosicion_enemy()).getX();
							ycolision=l.getFila2().get(l.getPosicion_enemy()).getY();
							Explosion exp=new Explosion(xcolision,ycolision);
							colisiones=l.getColisiones();
							colisiones.add(exp);
							l.setColisiones(colisiones);
							l.getFila2().set(l.getPosicion_enemy(),e);
						}
						break;
					case 3:
						vida_enemy=l.getFila3().get(l.getPosicion_enemy()).getVidaenemy();
						vida_enemy-=5;
						l.getFila3().get(l.getPosicion_enemy()).setVidaenemy(vida_enemy);
						if (vida_enemy<=0) {
							
							xcolision=l.getFila3().get(l.getPosicion_enemy()).getX();
							ycolision=l.getFila3().get(l.getPosicion_enemy()).getY();
							Explosion exp=new Explosion(xcolision,ycolision);
							colisiones=l.getColisiones();
							colisiones.add(exp);
							l.setColisiones(colisiones);
							l.getFila3().set(l.getPosicion_enemy(),e);
						}
						break;
					case 4:
						vida_enemy=l.getFila4().get(l.getPosicion_enemy()).getVidaenemy();
						vida_enemy-=5;
						l.getFila4().get(l.getPosicion_enemy()).setVidaenemy(vida_enemy);
						if (vida_enemy<=0) {
							
							xcolision=l.getFila4().get(l.getPosicion_enemy()).getX();
							ycolision=l.getFila4().get(l.getPosicion_enemy()).getY();
							Explosion exp=new Explosion(xcolision,ycolision);
							colisiones=l.getColisiones();
							colisiones.add(exp);
							l.setColisiones(colisiones);
							l.getFila4().set(l.getPosicion_enemy(),e);
						}
						break;
					}
					l.setColisionenemy(false);
					break;
				case 1:
					puntuacion+=30;
					l.setPuntuacion(puntuacion);
					l.setColisionenemy(false);
					switch(l.getFila_enemy()) {
					case 1:
						vida_enemy=l.getFila1().get(l.getPosicion_enemy()).getVidaenemy();
						vida_enemy-=10;
						l.getFila1().get(l.getPosicion_enemy()).setVidaenemy(vida_enemy);
						if (vida_enemy<=0) {
							
							xcolision=l.getFila1().get(l.getPosicion_enemy()).getX();
							ycolision=l.getFila1().get(l.getPosicion_enemy()).getY();
							Explosion exp=new Explosion(xcolision,ycolision);
							colisiones=l.getColisiones();
							colisiones.add(exp);
							l.setColisiones(colisiones);
							l.getFila1().set(l.getPosicion_enemy(),e);
						}
						break;
					case 2:
						vida_enemy=l.getFila2().get(l.getPosicion_enemy()).getVidaenemy();
						vida_enemy-=10;
						l.getFila2().get(l.getPosicion_enemy()).setVidaenemy(vida_enemy);
						if (vida_enemy<=0) {
							
							xcolision=l.getFila2().get(l.getPosicion_enemy()).getX();
							ycolision=l.getFila2().get(l.getPosicion_enemy()).getY();
							Explosion exp=new Explosion(xcolision,ycolision);
							colisiones=l.getColisiones();
							colisiones.add(exp);
							l.setColisiones(colisiones);
							l.getFila2().set(l.getPosicion_enemy(),e);
						}
						break;
					case 3:
						vida_enemy=l.getFila3().get(l.getPosicion_enemy()).getVidaenemy();
						vida_enemy-=10;
						l.getFila3().get(l.getPosicion_enemy()).setVidaenemy(vida_enemy);
						if (vida_enemy<=0) {
							
							xcolision=l.getFila3().get(l.getPosicion_enemy()).getX();
							ycolision=l.getFila3().get(l.getPosicion_enemy()).getY();
							Explosion exp=new Explosion(xcolision,ycolision);
							colisiones=l.getColisiones();
							colisiones.add(exp);
							l.setColisiones(colisiones);
							l.getFila3().set(l.getPosicion_enemy(),e);
						}
						break;
					case 4:
						vida_enemy=l.getFila4().get(l.getPosicion_enemy()).getVidaenemy();
						vida_enemy-=10;
						l.getFila4().get(l.getPosicion_enemy()).setVidaenemy(vida_enemy);
						if (vida_enemy<=0) {
							
							xcolision=l.getFila4().get(l.getPosicion_enemy()).getX();
							ycolision=l.getFila4().get(l.getPosicion_enemy()).getY();
							Explosion exp=new Explosion(xcolision,ycolision);
							colisiones=l.getColisiones();
							colisiones.add(exp);
							l.setColisiones(colisiones);
							l.getFila4().set(l.getPosicion_enemy(),e);
						}
						break;
					}
					l.setColisionenemy(false);
					break;
				case 2:
					puntuacion+=40;
					l.setPuntuacion(puntuacion);
					l.setColisionenemy(false);
					switch(l.getFila_enemy()) {
					case 1:
						vida_enemy=l.getFila1().get(l.getPosicion_enemy()).getVidaenemy();
						vida_enemy-=15;
						l.getFila1().get(l.getPosicion_enemy()).setVidaenemy(vida_enemy);
						if (vida_enemy<=0) {
							
							xcolision=l.getFila1().get(l.getPosicion_enemy()).getX();
							ycolision=l.getFila1().get(l.getPosicion_enemy()).getY();
							Explosion exp=new Explosion(xcolision,ycolision);
							colisiones=l.getColisiones();
							colisiones.add(exp);
							l.setColisiones(colisiones);
							l.getFila1().set(l.getPosicion_enemy(),e);
						}
						break;
					case 2:
						vida_enemy=l.getFila2().get(l.getPosicion_enemy()).getVidaenemy();
						vida_enemy-=15;
						l.getFila2().get(l.getPosicion_enemy()).setVidaenemy(vida_enemy);
						if (vida_enemy<=0) {
							
							xcolision=l.getFila2().get(l.getPosicion_enemy()).getX();
							ycolision=l.getFila2().get(l.getPosicion_enemy()).getY();
							Explosion exp=new Explosion(xcolision,ycolision);
							colisiones=l.getColisiones();
							colisiones.add(exp);
							l.setColisiones(colisiones);
							l.getFila2().set(l.getPosicion_enemy(),e);
						}
						break;
					case 3:
						vida_enemy=l.getFila3().get(l.getPosicion_enemy()).getVidaenemy();
						vida_enemy-=15;
						l.getFila3().get(l.getPosicion_enemy()).setVidaenemy(vida_enemy);
						if (vida_enemy<=0) {
							
							xcolision=l.getFila3().get(l.getPosicion_enemy()).getX();
							ycolision=l.getFila3().get(l.getPosicion_enemy()).getY();
							Explosion exp=new Explosion(xcolision,ycolision);
							colisiones=l.getColisiones();
							colisiones.add(exp);
							l.setColisiones(colisiones);
							l.getFila3().set(l.getPosicion_enemy(),e);
						}
						break;
					case 4:
						vida_enemy=l.getFila4().get(l.getPosicion_enemy()).getVidaenemy();
						vida_enemy-=15;
						l.getFila4().get(l.getPosicion_enemy()).setVidaenemy(vida_enemy);
						if (vida_enemy<=0) {
							
							xcolision=l.getFila4().get(l.getPosicion_enemy()).getX();
							ycolision=l.getFila4().get(l.getPosicion_enemy()).getY();
							Explosion exp=new Explosion(xcolision,ycolision);
							colisiones=l.getColisiones();
							colisiones.add(exp);
							l.setColisiones(colisiones);
							l.getFila4().set(l.getPosicion_enemy(),e);
						}
						break;
					}
					l.setColisionenemy(false);
					break;
				case 3:
					puntuacion+=50;
					l.setPuntuacion(puntuacion);
					l.setColisionenemy(false);
					switch(l.getFila_enemy()) {
					case 1:
						vida_enemy=l.getFila1().get(l.getPosicion_enemy()).getVidaenemy();
						vida_enemy-=20;
						l.getFila1().get(l.getPosicion_enemy()).setVidaenemy(vida_enemy);
						if (vida_enemy<=0) {
							
							xcolision=l.getFila1().get(l.getPosicion_enemy()).getX();
							ycolision=l.getFila1().get(l.getPosicion_enemy()).getY();
							Explosion exp=new Explosion(xcolision,ycolision);
							colisiones=l.getColisiones();
							colisiones.add(exp);
							l.setColisiones(colisiones);
							l.getFila1().set(l.getPosicion_enemy(),e);
						}
						break;
					case 2:
						vida_enemy=l.getFila2().get(l.getPosicion_enemy()).getVidaenemy();
						vida_enemy-=20;
						l.getFila2().get(l.getPosicion_enemy()).setVidaenemy(vida_enemy);
						if (vida_enemy<=0) {
							
							xcolision=l.getFila2().get(l.getPosicion_enemy()).getX();
							ycolision=l.getFila2().get(l.getPosicion_enemy()).getY();
							Explosion exp=new Explosion(xcolision,ycolision);
							colisiones=l.getColisiones();
							colisiones.add(exp);
							l.setColisiones(colisiones);
							l.getFila2().set(l.getPosicion_enemy(),e);
						}
						break;
					case 3:
						vida_enemy=l.getFila3().get(l.getPosicion_enemy()).getVidaenemy();
						vida_enemy-=20;
						l.getFila3().get(l.getPosicion_enemy()).setVidaenemy(vida_enemy);
						if (vida_enemy<=0) {
							
							xcolision=l.getFila3().get(l.getPosicion_enemy()).getX();
							ycolision=l.getFila3().get(l.getPosicion_enemy()).getY();
							Explosion exp=new Explosion(xcolision,ycolision);
							colisiones=l.getColisiones();
							colisiones.add(exp);
							l.setColisiones(colisiones);
							l.getFila3().set(l.getPosicion_enemy(),e);
						}
						break;
					case 4:
						vida_enemy=l.getFila4().get(l.getPosicion_enemy()).getVidaenemy();
						vida_enemy-=20;
						l.getFila4().get(l.getPosicion_enemy()).setVidaenemy(vida_enemy);
						if (vida_enemy<=0) {
							
							xcolision=l.getFila4().get(l.getPosicion_enemy()).getX();
							ycolision=l.getFila4().get(l.getPosicion_enemy()).getY();
							Explosion exp=new Explosion(xcolision,ycolision);
							colisiones=l.getColisiones();
							colisiones.add(exp);
							l.setColisiones(colisiones);
							l.getFila4().set(l.getPosicion_enemy(),e);
						}
						break;
					}
					l.setColisionenemy(false);
					break;
				case 4:
					puntuacion+=60;
					l.setPuntuacion(puntuacion);
					l.setColisionenemy(false);
					switch(l.getFila_enemy()) {
					case 1:
						vida_enemy=l.getFila1().get(l.getPosicion_enemy()).getVidaenemy();
						vida_enemy-=25;
						l.getFila1().get(l.getPosicion_enemy()).setVidaenemy(vida_enemy);
						if (vida_enemy<=0) {
							
							xcolision=l.getFila1().get(l.getPosicion_enemy()).getX();
							ycolision=l.getFila1().get(l.getPosicion_enemy()).getY();
							Explosion exp=new Explosion(xcolision,ycolision);
							colisiones=l.getColisiones();
							colisiones.add(exp);
							l.setColisiones(colisiones);
							l.getFila1().set(l.getPosicion_enemy(),e);
						}
						break;
					case 2:
						vida_enemy=l.getFila2().get(l.getPosicion_enemy()).getVidaenemy();
						vida_enemy-=25;
						l.getFila2().get(l.getPosicion_enemy()).setVidaenemy(vida_enemy);
						if (vida_enemy<=0) {
							
							xcolision=l.getFila2().get(l.getPosicion_enemy()).getX();
							ycolision=l.getFila2().get(l.getPosicion_enemy()).getY();
							Explosion exp=new Explosion(xcolision,ycolision);
							colisiones=l.getColisiones();
							colisiones.add(exp);
							l.setColisiones(colisiones);
							l.getFila2().set(l.getPosicion_enemy(),e);
						}
						break;
					case 3:
						vida_enemy=l.getFila3().get(l.getPosicion_enemy()).getVidaenemy();
						vida_enemy-=25;
						l.getFila3().get(l.getPosicion_enemy()).setVidaenemy(vida_enemy);
						if (vida_enemy<=0) {
							
							xcolision=l.getFila3().get(l.getPosicion_enemy()).getX();
							ycolision=l.getFila3().get(l.getPosicion_enemy()).getY();
							Explosion exp=new Explosion(xcolision,ycolision);
							colisiones=l.getColisiones();
							colisiones.add(exp);
							l.setColisiones(colisiones);
							l.getFila3().set(l.getPosicion_enemy(),e);
						}
						break;
					case 4:
						vida_enemy=l.getFila4().get(l.getPosicion_enemy()).getVidaenemy();
						vida_enemy-=25;
						l.getFila4().get(l.getPosicion_enemy()).setVidaenemy(vida_enemy);
						if (vida_enemy<=0) {
							
							xcolision=l.getFila4().get(l.getPosicion_enemy()).getX();
							ycolision=l.getFila4().get(l.getPosicion_enemy()).getY();
							Explosion exp=new Explosion(xcolision,ycolision);
							colisiones=l.getColisiones();
							colisiones.add(exp);
							l.setColisiones(colisiones);
							l.getFila4().set(l.getPosicion_enemy(),e);
						}
						break;
					}
					break;
			}
			}
			
			porcentajevida=l.getPorcentajevida();
			//los enemigos dan a la nave
			if(l.isColisionnave()==true) {
				switch(l.getNum_laser()){
					case 0:
						porcentajevida-=5;
						anchura-=anchura*0.05;
						l.setAnchura(anchura);
						l.setPorcentajevida(porcentajevida);
						l.setColisionnave(false);
						break;
					case 1:
						porcentajevida-=10;
						anchura-=anchura*0.10;
						l.setAnchura(anchura);
						l.setPorcentajevida(porcentajevida);
						l.setColisionnave(false);
						break;
					case 2:
						porcentajevida-=15;
						anchura-=anchura*0.15;
						l.setAnchura(anchura);
						l.setPorcentajevida(porcentajevida);
						l.setColisionnave(false);
						break;
					case 3:
						porcentajevida-=20;
						anchura-=anchura*0.20;
						l.setAnchura(anchura);
						l.setPorcentajevida(porcentajevida);
						l.setColisionnave(false);
						break;
					case 4:
						porcentajevida-=25;
						anchura-=anchura*0.25;
						l.setAnchura(anchura);
						l.setPorcentajevida(porcentajevida);
						l.setColisionnave(false);
						break;
				}
			}
			
			if (porcentajevida<0) {
				l.setPorcentajevida(100);
				vidas=l.getVidas();
				vidas-=1;
				l.setPorcentajevida(100);
				l.setVidas(vidas);
				l.setAnchura(550);
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

	public int getAnchura() {
		return anchura;
	}

	public void setAnchura(int anchura) {
		this.anchura = anchura;
	}


}
