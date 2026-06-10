package Principal;

public class Laser {
	int x;
	int y;
	int num_laser;
	
	public Laser(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.num_laser = (int)(Math.random()*5);
	}
	public int getNum_laser() {
		return num_laser;
	}
	public void setNum_laser(int num_laser) {
		this.num_laser = num_laser;
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
	
	
}
