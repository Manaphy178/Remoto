
/**
 * Clase Datos, este tendra los datos personales de un personaje. Esta misma
 * clase sera utilizada para crear los personajes. Los datos de esta clase seran
 * extraidos de un archivo.
 * 
 * @author Javier
 * @version 03/02/2023
 */
public class Datos {
//	Campos de la clase
	private String nombre;
	private String pais;
	private String historia;

	/**
	 * Constructor del objeto Datos, contiene los datos personales del personaje y
	 * sera utilizado para crear un objeto personaje
	 * 
	 * @param nombre   Nombre del personaje que se esta evaluando
	 * @param pais     Pais del que proviene el personaje que se esta evaluando
	 * @param historia Historia personal del personaje que se esta evaluando
	 */
	public Datos(String nombre, String pais, String historia) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.historia = historia;
	}

	/**
	 * @return Nombre del personaje que se esta evaluando
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre Nombre del personaje que se esta evaluando
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return Pais del que proviene el personaje que se esta evaluando
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais Pais del que proviene el personaje que se esta evaluando
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return Historia personal sobre el personaje que se esta evaluando
	 */
	public String getHistoria() {
		return historia;
	}

	/**
	 * @param historia Historia personal sobre el personaje que se esta evaluando
	 */
	public void setHistoria(String historia) {
		this.historia = historia;
	}

}
