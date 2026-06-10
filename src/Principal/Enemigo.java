package Principal;

import java.util.Random;

public class Enemigo {
	int x;
	int y;
	int vidaenemy;

	int nivel;
	
	public Enemigo(int x, int y, int vidaenemy, int nivel) {
		super();
		this.x = x;
		this.y = y;
		this.vidaenemy = vidaenemy;
		this.nivel=nivel;
	}

	public boolean lanzarLaser() {
		Random rand= new Random();
		return rand.nextDouble()<0.1+0.05*nivel; //probabilidad lanzar de 10% y aumenta con cada nivel
		
	}
	
//setters y getters

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public int getVidaenemy() {
		return vidaenemy;
	}

	public void setVidaenemy(int vidaenemy) {
		this.vidaenemy = vidaenemy;
	}
	

}
