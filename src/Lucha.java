import java.util.Random;

/**
 * Clase Lucha, tendra los datos de ataques y estadisticas, esta clase sera
 * asignada a la clase Personaje para hacer referencia a un personaje en
 * especifico. Los datos de lucha seran extraidos de un archivo que contiene los
 * datos en orden segun el luchador.
 * 
 * @author Javier
 * @version 3/02/2024
 */
public class Lucha {
//	Campos de la clase
	private double vida; // 100 de vida predeterminado al inicio para todos los luchadores
	private double velocidad;
	private int fuerza;
	/*
	 * Para los ataques al pedir ataque necesito pedir que quiere dependiendo de lo
	 * que quiera hago un switch y hago el calculo con la fuerza
	 */
	private boolean patada; // false: lenta | true: rapida
	private boolean punnetazo; // false: lenta | true: rapida
	private boolean agarre; // false: lenta | true: rapida
	private int especial; // con un switch se hara, con 3 opciones

	/**
	 * Constructor para crear los datos Lucha que seran asignados a un luchador
	 * correspondiente
	 * 
	 * @param vida      Puntos de vida que tiene el luchador
	 * @param velocidad La velocidad que tiene el luchador
	 * @param fuerza    La fuerza que tiene el luchador, utilizado para los ataques
	 * @param patada    El tipo de patada que tiene, rapido o lento
	 * @param punnetazo El tipo de puñetazo que tiene, rapido o lento
	 * @param agarre    El tipo de agarre que tiene, rapido o lento
	 * @param especial  El tipo de especiales que tiene, tiene 3 especiales cada uno
	 *                  con un daño especifico
	 */
	public Lucha(double vida, double velocidad, int fuerza, boolean patada, boolean punnetazo, boolean agarre,
			int especial) {
		super();
		this.vida = vida;
		this.velocidad = velocidad;
		this.fuerza = fuerza;
		this.patada = patada;
		this.punnetazo = punnetazo;
		this.agarre = agarre;
		this.especial = especial;
	}

	/**
	 * @return the vida La vida actual del personaje
	 */
	public double getVida() {
		return vida;
	}

	/**
	 * @param vida La vida que tiene el personaje en el combate
	 */
	public void setVida(double vida) {
		this.vida = vida;
	}

	/**
	 * @return the velocidad la velocidad del personaje
	 */
	public double getVelocidad() {
		return velocidad;
	}

	/**
	 * @param velocidad la velocidad que tiene el personaje a la hora de pelear
	 */
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	/**
	 * @return the fuerza la fuerza que tiene el personaje
	 */
	public int getFuerza() {
		return fuerza;
	}

	/**
	 * @param fuerza que tiene el personaje por predeterminado
	 */
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	/**
	 * @return El tipo de patada que esta haciendo, si lenta o rapida
	 */
	public boolean isPatada() {
		return patada;
	}

	/**
	 * @param patada, Un booleano que determina si es rapido o lento
	 */
	public void setPatada(boolean patada) {
		this.patada = patada;
	}

	/**
	 * @return El tipo de puñetazo que esta haciendo, si lento o rapido
	 */
	public boolean isPunnetazo() {
		return punnetazo;
	}

	/**
	 * @param punnetazo, Un booleano que determina si es rapido o lento
	 */
	public void setPunnetazo(boolean punnetazo) {
		this.punnetazo = punnetazo;
	}

	/**
	 * @return El tipo de agarre que esta haciendo, si lento o rapido
	 */
	public boolean isAgarre() {
		return agarre;
	}

	/**
	 * @param agarre, Un booleano que determina si es rapido o lento
	 */
	public void setAgarre(boolean agarre) {
		this.agarre = agarre;
	}

	/**
	 * @return El tipo de especial que va a utilizar el personaje cuando ataque
	 */
	public int getEspecial() {
		return especial;
	}

	/**
	 * @param especial, El tipo de especial que tiene o que ha utilizado en el
	 *                  personaje
	 */
	public void setEspecial(int especial) {
		this.especial = especial;
	}

	/**
	 * Metodo utilizado y llamado por simularCombate de Main. Este metodo es
	 * utilizado para devolver el daño que va a hacer segun el ataque que haya
	 * utilizado. El daño es evaluado segun la fuerza del personaje y un
	 * multiplicador segun el tipo que es.
	 * 
	 * @param opcion Utilizado para evaluar el ataque que esta utilizando el
	 *               personaje, es una variable aleatoria
	 * @return Daño que hara el personaje que haya hecho el ataque
	 */
	public double Ataque(int opcion) {
		Random ran = new Random();
		especial = ran.nextInt(3) + 1;
		double danno = 0;
		switch (opcion) {
		case 1: // Puñetazo
			this.punnetazo = ran.nextBoolean();
			if (this.punnetazo) {
				System.out.println("Puñetazo rapido");
				danno = this.fuerza * 0.3;
			} else {
				System.out.println("Puñetazo lento");
				danno = this.fuerza * 0.7;
			}
			break;
		case 2:// Patada
			this.patada = ran.nextBoolean();
			if (this.patada) {
				System.out.println("Patada rapido");
				danno = this.fuerza * 0.5;
			} else {
				System.out.println("Patada lento");
				danno = this.fuerza * 1;
			}
			break;
		case 3:// Agarre
			this.agarre = ran.nextBoolean();
			if (this.agarre) {
				System.out.println("Agarre rapido");
				danno = this.fuerza * 3;
			} else {
				System.out.println("Agarre lento");
				danno = this.fuerza * 5;
			}
			break;
		case 4: // Especial
			switch (especial) {
			case 1:
				System.out.println("Especial 1");
				danno = this.fuerza * 1.5;
				break;
			case 2:
				System.out.println("Especial 2");
				danno = this.fuerza * 2;
				break;
			case 3:
				System.out.println("Especial 3");
				danno = this.fuerza * 3;
				break;
			}
			break;
		}
		return danno;
	}
}
