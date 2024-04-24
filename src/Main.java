import java.io.*;
import java.util.*;

/**
 * Clase Main que sera la encargada de hacer todas las tareas como pedir a los
 * usuarios que personaje quieren y simulara un combate con estos personajes
 * 
 * @author Javier
 * @version 3/02/2024
 */
public class Main {
//	Campos que se han utilizado para el codigo
	static Scanner sn = new Scanner(System.in);
	static Scanner sc = new Scanner(System.in);
	/*
	 * Ruta del archivo de datos de los luchadores
	 */

	/*
	 * Eliminar campos estaticos obsoletos
	 */
//	static String rutaDatosPersona = "DatosPersonales.txt";
//	static String rutaDatosFisico = "AspectoFisico.txt";
//	static String rutaDatosLucha = "DatosLucha.txt";

	/*
	 * Objetos File con la ruta de las rutas de los luchadores
	 */
	static File dataP = new File("DatosPersonales.txt");
	static File dataF = new File("AspectoFisico.txt");
	static File dataL = new File("DatosLucha.txt");

	/*
	 * ArrayList de los datos fisicos, lucha y personaje. Y un ArrayList de
	 * personajes que tendran todos los datos de los arrayList anteriores
	 */
	static ArrayList<Aspecto> fisic = new ArrayList<Aspecto>();
	static ArrayList<Lucha> figth = new ArrayList<Lucha>();
	static ArrayList<Datos> data = new ArrayList<Datos>();
	static ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	static int characterSelection = 1;

	/**
	 * Metodo main que inicia el programa, llamara a los metodos de
	 * InicializarPersonajes, seleccion (de los personajes) y la simulacion del
	 * combate
	 * 
	 * @param args Argumentos necesarios para iniciar el programa
	 */
	public static void main(String[] args) {
		InicializarPersonajes(); // Mete los datos de los personajes en ArrayLists
		Personaje J1 = new Personaje();
		Personaje J2 = new Personaje();
		J1 = seleccion(J1);
		J2 = seleccion(J2);
		SimulaCombate(J1, J2);

	}

	/**
	 * Metodo menu, utilizado para mostrar a los jugadores los personajes que se
	 * pueden llegar a seleccionar. De los cuales escribiran un numero
	 * correspondiente del menu mostrado.
	 * 
	 * @return selected, Variable que corresponde a una de las opciones que se han
	 *         mostrado en el menu de personajes.
	 */
	public static int menu() {
		int selected = 0;
		do {
			for (int i = 0; i < personajes.size(); i++) {
				System.out.println(i + 1 + ".- " + personajes.get(i).getDatos().getNombre());
			}
			System.out.println("Selecciona un personaje");
			selected = sn.nextInt();
			if (selected < 1 && selected > 8) {
				System.out.println("Opcion incorrecta");
			}
		} while (selected < 1 && selected > 8);
		return selected - 1;
	}

	/**
	 * Metodo seleccion, utilizado para asignar uno de los personajes al jugador que
	 * haya hecho la seleccion de personaje. Este llamara al menu y dira el luchador
	 * que ha elegido el jugador
	 * 
	 * @param player, Parametro correspondiente al jugador que esta seleccionando el
	 *                personaje del menu
	 * @return player, Devuelve el parametro pasado anteriormente con el personaje
	 *         asignado correspondiente a la opcion que eligio el jugador
	 */
	public static Personaje seleccion(Personaje player) {
		System.out.println("Jugador " + characterSelection + " ha elegido a: ");
		switch (menu()) {
		case 0:
			System.out.println("RYU!!");
			player = personajes.get(0);
			break;
		case 1:
			System.out.println("E. HONDA!!");
			player = personajes.get(1);
			break;
		case 2:
			System.out.println("BLANKA!!");
			player = personajes.get(2);
			break;
		case 3:
			System.out.println("GUILE!!");
			player = personajes.get(3);
			break;
		case 4:
			System.out.println("KEN!!");
			player = personajes.get(4);
			break;
		case 5:
			System.out.println("CHUN-LI!!");
			player = personajes.get(5);
			break;
		case 6:
			System.out.println("ZANGIEF!!");
			player = personajes.get(6);
			break;
		case 7:
			System.out.println("DHALSIM!!");
			player = personajes.get(7);
			break;

		}
		characterSelection++;
		return player;
	}

	/**
	 * Metodo utilizado para verificar si los archivos de los datos necesarios para
	 * los personajes existen.En caso de que existan se añadiran los datos al
	 * ArrayList correspondiente y se añadiran todos los datos para crear a los
	 * personajes.
	 */
	public static void InicializarPersonajes() {

		boolean datos = true;
		if (!dataF.exists()) {
			System.out.println(
					"El archivo de los datos fisicos de los personajes no existe, mirar si el archivo existe o esta en el directorio correspondiente");
			datos = false;
		} else {
			meterDatosFisico();
		}
		if (!dataP.exists()) {
			System.out.println(
					"El archivo de los datos personales de los personajes no existe, mirar si el archivo existe o si esta en el archivo correspondiente");
			datos = false;
		} else {
			meterDatosPersonales();
		}
		if (!dataL.exists()) {
			System.out.println(
					"El archivo de los datos de lucha de los personajes no existe, mirar si el archivo existe o si esta en el archivo correspondiente");
			datos = false;
		} else {
			meterDatosLucha();
		}
		if (datos) {
			for (int i = 0; i < data.size(); i++) {
				personajes.add(new Personaje(data.get(i), fisic.get(i), figth.get(i)));
			}

		}

	}

	/**
	 * Metodo SimulaCombate, pide los personajes escogidos por los jugadores y
	 * simula un combate segun los datos de los personajes. Cuando uno de los
	 * personajes llegue a 0 de vida se declara ganador al jugador que todavia tenga
	 * puntos de vida. El combate se hara por turnos en los que ambos personajes
	 * pueden inflingir daño al otro.
	 * 
	 * @param P1, Personaje del primer jugador
	 * @param P2, Personaje del segundo jugador
	 */
	public static void SimulaCombate(Personaje P1, Personaje P2) {
		System.out.println("El combate se disputara en :" + P1.getAspecto().getEscenario());
		double pj1 = P1.getLucha().getVida();
		double pj2 = P2.getLucha().getVida();
		int turno = 1;
		int opcion;
		double ataque1;
		double ataque2;
		do {
			System.out.println(turno + "º TURNO");
			/*
			 * Los personajes tienen 4 ataques diferentes, los cuales pueden hacer
			 * cualquiera de esos ataques. Estos ataques se deciden con un numero aleatorio
			 * que se utilizara en la clase de Lucha en el metodo Ataque. Estos ataques
			 * inflingen un daño que lo devolvera el metodo Ataque y se le restara la vida
			 * al contrincante con el valor devuelto.
			 */
			System.out.println("----------------------------");
//			Ataque de personaje 1		
			opcion = (int) (Math.random() * 4) + 1;
			System.out.print(P1.getDatos().getNombre() + " efectua un ");
			ataque1 = P1.getLucha().Ataque(opcion);
			System.out.println("Inflinge : " + ataque1 + " de daño a " + P2.getDatos().getNombre());
			System.out.println("----------------------------");
//			Ataque de personaje 2
			opcion = (int) (Math.random() * 4) + 1;
			System.out.print(P2.getDatos().getNombre() + " efectua un ");
			ataque2 = P2.getLucha().Ataque(opcion);
			System.out.println("Inflinge : " + ataque2 + " de daño a " + P1.getDatos().getNombre());
//			Se le resta la vida a los personajes con el ataque que hizo el contrincante
			pj1 -= ataque2;
			pj2 -= ataque1;
			System.out.println("\n\n-------------ESTADISTICAS---------------");
//			Se les muestra a los jugadores quien tiene mas vida
			System.out.println(P1.getDatos().getNombre() + " HP: " + pj1);
			System.out.println(P2.getDatos().getNombre() + " HP: " + pj2);
			System.out.println("---------------------------------------------\n");
			turno++;
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (pj1 >= 1 && pj2 >= 1);
		/*
		 * Cuando uno de estos no tenga puntos de vida se nombrara ganador al jugador
		 * correspondiente, en caso de que ambos esten a menos de 1 de vida se hara
		 * empate
		 */
		System.out.println("FIN DEL COMBATE!!!");
		if (pj1 <= 0) {
			System.out.println(P2.getDatos().getNombre() + " ES EL GANADOR");
		} else if (pj2 <= 0) {
			System.out.println(P1.getDatos().getNombre() + " ES EL GANADOR");
		} else {
			System.out.println("EMPATE");
		}
	}

	/**
	 * Metodo para meter los datos personales de los personajes en un ArrayList
	 * leyendo el archivo correspondiente
	 */
	public static void meterDatosPersonales() {
		String l = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(dataP));
			try {
				l = br.readLine();
				while (l != null) {
					data.add(new Datos(l.split("\\|")[0].trim(), l.split("\\|")[1].trim(), l.split("\\|")[2].trim()));
					l = br.readLine();
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo utilizado para meter los datos fisicos de los personajes en un
	 * ArrayList leyendo el archivo correspondiente
	 */
	public static void meterDatosFisico() {
		String l = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(dataF));
			try {
				l = br.readLine();
				while (l != null) {
					fisic.add(new Aspecto(Double.valueOf(l.split("\\|")[0].trim()),
							Double.valueOf(l.split("\\|")[1].trim()), l.split("\\|")[2].trim(),
							l.split("\\|")[3].trim(), l.split("\\|")[4].trim()));
					l = br.readLine();
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo utilizado para meter los datos de lucha de los personajes en un
	 * ArrayList leyendo el archivo correspondiente
	 */
	public static void meterDatosLucha() {
		String l = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(dataL));
			try {
				l = br.readLine();
				while (l != null) {
					figth.add(new Lucha(Double.valueOf(l.split("\\|")[0].trim()),
							Double.valueOf(l.split("\\|")[1].trim()), Integer.valueOf(l.split("\\|")[2].trim()),
							Boolean.valueOf(l.split("\\|")[3].trim()), Boolean.valueOf(l.split("\\|")[4].trim()),
							Boolean.valueOf(l.split("\\|")[5].trim()), Integer.valueOf(l.split("\\|")[6].trim())));
					l = br.readLine();
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
