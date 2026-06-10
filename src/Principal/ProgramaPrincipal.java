package Principal;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ventana v=new Ventana(); //crear ventana
		v.setVisible(true);//hacerla visible
	}
}

/*
 * Hemos interpretado para las naves enemigas 
 * que en la fila de arriba se encuentran las naves que dan más puntos (enemigo3)
 * y en la siguiente fila las de enemigo2
 * y en las dos más cercanas a la nave las de menos puntos (enemigo 1)
 * 
 * En cuanto a los colores de la nave,
 * las que dan menos puntos están en los extremos
 * y la que da más puntos en el medio
 * 
 * Teniendo esto en cuento, hemos cambiado la puntuación de los disparos
 * para mejorar la jugabilidad del juego y que sea más fácil subir de nivel,
 * así que en lugar de 5,10,15,20 y 25 puntos por disparo certero
 * hemos decidido que sean 20,30,40,50,60
 * 
 * Además, para aumentar la dificultad del juego dependiendo del nivel,
 * aumenta la probabilidad de que las naves enemigas disparen laseres un 5% por cada nivel,
 * siendo 10% inicialmente.
 */
