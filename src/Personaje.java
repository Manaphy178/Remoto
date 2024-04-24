
/**
 * Clase Personaje, utilizada para poder contener todos los diferentes datos de
 * los personajes que hay en el juego. Estos personajes van a ser utilizados por
 * los jugadores y con los podran luchar contra otros.
 * 
 * @author Javier
 * @version 03/02/2023
 */
public class Personaje {
//	Campos de la clase Personaje
	private Datos datos;
	private Aspecto aspecto;
	private Lucha lucha;

	/**
	 * Constructor vacio para la creacion de objetos Personaje vacio. Utilizado para
	 * poder asignarle un objeto Personaje posteriormente
	 */
	public Personaje() {
		super();
	}

	/**
	 * Constructor de Personaje, este tendra los datos de los diferentes luchadores
	 * del juego y seran utilizados para que los jugadores pueden luchar contra
	 * ellos
	 * 
	 * @param datos   Datos caracteristicos que tiene el personaje. Como nombre,
	 *                procedencia e historia personal
	 * @param aspecto Aspecto caracteristico que tiene el personaje. Como peso,
	 *                altura, vestimenta, etc.
	 * @param lucha   Datos de lucha que tiene el personaje. Como fuerza, velocidad,
	 *                vida, etc.
	 */
	public Personaje(Datos datos, Aspecto aspecto, Lucha lucha) {
		super();
		this.datos = datos;
		this.aspecto = aspecto;
		this.lucha = lucha;
	}

	/**
	 * @return Objeto Datos que contiene los datos personales del personaje evaluado
	 */
	public Datos getDatos() {
		return datos;
	}

	/**
	 * @param datos Objeto Datos que contiene los datos personales del personaje
	 *              evaluado
	 */
	public void setDatos(Datos datos) {
		this.datos = datos;
	}

	/**
	 * @return Objeto Aspecto que contiene los datos sobre el aspecto del personaje
	 *         evaluado
	 */
	public Aspecto getAspecto() {
		return aspecto;
	}

	/**
	 * @param aspecto Objeto Aspecto que contiene los datos sobre el aspecto del
	 *                personaje evaluado
	 */
	public void setAspecto(Aspecto aspecto) {
		this.aspecto = aspecto;
	}

	/**
	 * @return Objeto Lucha que contiene los datos de lucha que tiene el personaje,
	 *         este es utilizado para poder simular una pelea entre personajes
	 */
	public Lucha getLucha() {
		return lucha;
	}

	/**
	 * @param lucha Objeto Lucha que contiene los datos de lucha que tiene el
	 *              personaje
	 */
	public void setLucha(Lucha lucha) {
		this.lucha = lucha;
	}

}
