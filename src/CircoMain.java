
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import Animales.Animal;
import Animales.AnimalDAO;
import AnimalesSolucion.AnimalesDAOSolu;
import Artistas.Artista;
import Artistas.ArtistaDAO;
import ArtistasSolucion.ArtistasDAOSolu;

public class CircoMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Animal> animalMas20 = null;
		ArrayList<Artista> nombreContengaA = null;
		String nifArtista;
		String nifJefe;
		String nombre = null;
		String apellidos = null;
		String tipo = null;
		int anios = 0;
		float peso = 0;
		float estatura = 0;
		String nombreAtraccion = null;
		String nombrePista = null;
		String nombrePista2 = null;
		int opcion = 0;

		do {
			System.out.println("┌─────────────────────────────────┐");
			System.out.println("│  1 Modificar la tabla Animales. │");
			System.out.println("│  2 Modificar la tabla Artistas. │");
			System.out.println("│  0 Salir.                       │");
			System.out.println("└─────────────────────────────────┘");
			System.out.print("Elige una opcion: ");
			opcion = scan.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("┌───────────────────────────────────┐");
				System.out.println("│  1 Mostrar datos del animal.      │");
				System.out.println("│  2 Insertar un nuevo animal.      │");
				System.out.println("│  3 Modificar un animal existente. │");
				System.out.println("│  4 Borrar un animal existente.    │");
				System.out.println("│  5 Mostrar animales de mas 20kg.  │");
				System.out.println("│  0 Salir.                         │");
				System.out.println("└───────────────────────────────────┘");
				System.out.print("Elige una opcion: ");
				opcion = scan.nextInt();

				switch (opcion) {
				case 1:
					System.out.println("Mostrar datos de un animal.");
					System.out.println("---------------------------");
					System.out.print("Introduzca nombre del animal para mostrar sus datos:");
					nombre = scan.next();
					AnimalDAO.read(nombre);
					break;
				case 2:
					// Pedimos los datos del nuevo animal
					System.out.println("Registar nuevo animal.");
					System.out.println("----------------------");
					System.out.print("Introduzca el nombre del animal: ");
					nombre = scan.next();
					System.out.print("Introduzca el tipo del animal: ");
					tipo = scan.next();
					System.out.print("Introduzca los años del animal: ");
					anios = scan.nextInt();
					System.out.print("Introduzca el peso del animal: ");
					peso = scan.nextFloat();
					System.out.print("Introduzca la estatura del animal: ");
					estatura = scan.nextFloat();
					scan.nextLine();// Limpiamos el buffer del scanner
					System.out.print("Introduzca el nombre de la atraccion: ");
					nombreAtraccion = scan.nextLine();
					System.out.print("Introduzca nombre de la pista: ");
					nombrePista = scan.next();
					System.out.println();

					// Creamos el objeto animal con los datos introducidos
					Animal a1 = new Animal(nombre, tipo, anios, peso, estatura, nombreAtraccion, nombrePista);

					// LLamamos al metodo create para insertar el animal a la BD
					AnimalDAO.create(a1);
					break;
				case 3:
					// Pedimos los datos del nuevo animal
					System.out.println("Registar nuevo animal.");
					System.out.println("----------------------");
					System.out.print("Introduzca el nombre del animal a modificar: ");
					nombre = scan.next();
					System.out.print("Introduzca el tipo del animal: ");
					tipo = scan.next();
					System.out.print("Introduzca los años del animal : ");
					anios = scan.nextInt();
					System.out.print("Introduzca el peso del animal: ");
					peso = scan.nextFloat();
					System.out.print("Introduzca la estatura del animal: ");
					estatura = scan.nextFloat();
					scan.nextLine();// Limpiamos el buffer del scanner
					System.out.print("Introduzca el nombre de la atraccion: ");
					nombreAtraccion = scan.nextLine();
					System.out.print("Introduzca nombre de la pista: ");
					nombrePista = scan.next();
					System.out.println();

					// Creamos el objeto animal con los datos introducidos
					Animal actualizar = new Animal(nombre, tipo, anios, peso, estatura, nombreAtraccion, nombrePista);

					// LLamamos al metodo create para insertar el animal a la BD
					AnimalDAO.update(actualizar);
					break;
				case 4:
					System.out.println("Borrar un animal.");
					System.out.println("----------------------");
					System.out.print("Introduzca el nombre del animal: ");
					nombre = scan.next();
					try {
						AnimalDAO.delete(nombre);
					} catch (SQLException e) {
						System.out.println("No se ha podido borrar el animal");
						e.printStackTrace();
					}
					break;// Fin caso 4
				case 5: 
					animalMas20 = AnimalDAO.mas20();
					for (Animal masDe20 : animalMas20) {
						System.out.println("Nombre: " + masDe20.getNombre() + "\t\tPeso: " + masDe20.getPeso());
					}
					break; //Fin caso5
				default:
					System.out.println("Fin del programa");
					break;
				}
				break;// Fin caso1
			case 2:

				System.out.println("┌────────────────────────────────────┐");
				System.out.println("│  1 Mostrar datos del artista.      │");
				System.out.println("│  2 Insertar un nuevo artista.      │");
				System.out.println("│  3 Modificar un artista existente. │");
				System.out.println("│  4 Borrar un artista existente.    │");
				System.out.println("│  5 Mostrar nombres que contenga A. │");
				System.out.println("│  0 Salir.                          │");
				System.out.println("└────────────────────────────────────┘");
				System.out.print("Elige una opcion: ");
				opcion = scan.nextInt();

				switch (opcion) {
				case 1:
					System.out.println("Mostrar datos de un artista.");
					System.out.println("---------------------------");
					System.out.print("Introduzca el ID del artista: ");
					nifArtista = scan.next();
					ArtistaDAO.read(nifArtista);
					break;
				case 2:
					// Pedimos los datos del nuevo del artista
					System.out.println("Registar nuevo artista.");
					System.out.println("----------------------");
					System.out.print("Introduzca el nif del artista: ");
					nifArtista = scan.next();
					System.out.print("Introduzca el nombre del artista: ");
					nombre = scan.next();
					System.out.print("Introduzca el apellido del artista: ");
					apellidos = scan.next();
					System.out.print("Introduzca el nif del jefe del artista: ");
					nifJefe = scan.next();
					
					System.out.println();

					// Creamos el objeto animal con los datos introducidos
					Artista crear = new Artista(nifArtista, apellidos, nombre, nifJefe);

					// LLamamos al metodo create para insertar el animal a la BD
					ArtistaDAO.create(crear);
					break;
				case 3:
					// Pedimos los datos del nuevo del artista
					System.out.println("Actualizar datos del artista.");
					System.out.println("----------------------");
					System.out.print("Introduzca el nif del artista: ");
					nifArtista = scan.next();
					System.out.print("Introduzca el nombre del artista: ");
					nombre = scan.next();
					System.out.print("Introduzca los apellidos del artista: ");
					apellidos = scan.next();
					System.out.print("Introduzca el nif del jefe del artista: ");
					nifJefe = scan.next();
					
					System.out.println();

					// Creamos el objeto animal con los datos introducidos
					Artista actualizar = new Artista(nifArtista, apellidos, nombre, nifJefe);

					// LLamamos al metodo create para insertar el animal a la BD
					ArtistaDAO.update(actualizar);
					break;
				case 4:
					System.out.println("Borrar un artista.");
					System.out.println("----------------------");
					System.out.print("Introduzca el nif del artista: ");
					nifArtista = scan.next();
					try {
						ArtistaDAO.delete(nifArtista);
					} catch (SQLException e) {
						System.out.println("No se ha podido borrar el animal");
						e.printStackTrace();
					}
					break;
				case 5: 
					nombreContengaA = ArtistaDAO.nombreConA();
					for (Artista nomConA : nombreContengaA) {
						System.out.println("DNI: " + nomConA.getNif() + "\tNombre: " + nomConA.getNombre() + "\tApellidos: " + nomConA.getApellidos());
					}
					break; //Fin caso5
				default:
					System.out.println("Fin del programa");
					break;
				}
				break;
			default:
				System.out.println("Fin del programa");
				break;
			}

		} while (opcion != 0);
		scan.close();
	}

}
