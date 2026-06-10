package Principal;

public class Estrella {
	
	int x;
	int y;
	int grosor;
	int direccion;
	
	public Estrella(int y) {
		super();
		this.x = (int)(Math.random()*1000);
		this.y = y;
		this.direccion=direccion;
		this.grosor = (int)(Math.random()*3)+2;//diametro entre 2 y 5
	}
	
	
	//getters y setters
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

	public int getGrosor() {
		return grosor;
	}
	public void setGrosor(int grosor) {
		this.grosor = grosor;
	}


	public int getDireccion() {
		return direccion;
	}


	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	
	
	
	

}
