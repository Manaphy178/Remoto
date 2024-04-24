
/**
 * Clase Aspecto, esta clase se asignara a un objeto personaje segun el
 * correspondiente de los datos. Contiene los datos fisicos y caracteristicos
 * como el escenario del personaje que se esta evaluando.
 * 
 * @author Javier
 * @version 03/02/2024
 */
public class Aspecto {
//	Campos de la clase
	private double altura;
	private double peso;
	private String color_pelo;
	private String vestimenta;
	private String escenario;

	/**
	 * Constructor del objeto Aspecto, correspondiente a un personaje y utilizado
	 * para crear los personajes
	 * 
	 * @param altura     Altura en cm de los personajes
	 * @param peso       Peso en Kg de los personajes
	 * @param color_pelo El tipo de color de pelo que puede tener el personaje
	 * @param vestimenta El tipo de ropa caracteristica que lleva el personaje
	 * @param escenario  El tipo de escenario caracteristico del personaje, este
	 *                   escenario solo puede ser de un personaje
	 */
	public Aspecto(double altura, double peso, String color_pelo, String vestimenta, String escenario) {
		super();
		this.altura = altura;
		this.peso = peso;
		this.color_pelo = color_pelo;
		this.vestimenta = vestimenta;
		this.escenario = escenario;
	}

	/**
	 * @return La altura del personaje evaluado
	 */
	public double getAltura() {
		return altura;
	}

	/**
	 * @param altura La altura del personaje evaluado
	 */
	public void setAltura(double altura) {
		this.altura = altura;
	}

	/**
	 * @return El peso del personaje evaluado
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * @param peso El peso del personaje evaluado
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * @return El color de pelo del personaje que es evaluado
	 */
	public String getColor_pelo() {
		return color_pelo;
	}

	/**
	 * @param color_pelo El color de pelo del personaje que es evaluado
	 */
	public void setColor_pelo(String color_pelo) {
		this.color_pelo = color_pelo;
	}

	/**
	 * @return La vestimenta del personaje que se esta evaluando
	 */
	public String getVestimenta() {
		return vestimenta;
	}

	/**
	 * @param vestimenta La vestimenta del personaje que se esta evaluando
	 */
	public void setVestimenta(String vestimenta) {
		this.vestimenta = vestimenta;
	}

	/**
	 * @return El escenario caracteristico del personaje
	 */
	public String getEscenario() {
		return escenario;
	}

	/**
	 * @param escenario El escenario caracteristico del personaje
	 */
	public void setEscenario(String escenario) {
		this.escenario = escenario;
	}

}
