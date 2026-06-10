package Principal;

public class Explosion {

	int x;
	int y;
	int num_colision;
	
	
	public Explosion(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.num_colision=0;
	}
	
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

	public int getNum_colision() {
		return num_colision;
	}

	public void setNum_colision(int num_colision) {
		this.num_colision = num_colision;
	}
	
	
}
