package Animales;

import java.sql.SQLException;
import java.util.Scanner;
import Animales.Animal;
import Animales.AnimalDAO;

public class CircoMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String nombre;
		String tipo;
		int anios;
		float peso;
		float estatura;
		String nombreAtraccion;
		String nombrePista;
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
				System.out.println("│  0 Salir.                         │");
				System.out.println("└───────────────────────────────────┘");
				System.out.print("Elige una opcion: ");
				opcion = scan.nextInt();

				switch (opcion) {
				case 1:
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
					System.out.print("Introduzca el nombre de la atraccion: ");
					nombreAtraccion = scan.next();
					System.out.print("Introduzca el nombre de la pista: ");
					nombrePista = scan.nextLine();

					// Creamos el objeto animal con los datos introducidos
					Animal a1 = new Animal(nombre, tipo, anios, peso, estatura, nombreAtraccion, nombrePista);

					// LLamamos al metodo create para insertar el animal a la BD
					AnimalDAO.create(a1);
					break;
				case 3:
					System.out.println("Actualizar datos de un animal");
					System.out.println("-----------------------------");
					System.out.print("Introduzca el nombre del animal que vas actualizar: ");
					nombre = scan.next();
					System.out.print("Introduzca el nuevo tipo del animal: ");
					tipo = scan.next();
					System.out.println("Introduzca los años actualizado del animal: ");
					anios = scan.nextInt();
					System.out.print("Introduzca el peso actualizado del animal: ");
					peso = scan.nextFloat();
					System.out.print("Introduzca la estatura actualizada del animal: ");
					estatura = scan.nextFloat();
					System.out.print("Introduzca el nombre de la atraccion: ");
					nombreAtraccion = scan.next();
					System.out.print("Introduzca el nombre de la pista: ");
					nombrePista = scan.nextLine();
					//Creamos un objeto con los datos actualizados
					Animal update = new Animal(nombre, tipo, anios, peso, estatura, nombreAtraccion, nombrePista);
					//Actualizamos los datos con el metodo
					AnimalDAO.update(update);
					break;
				case 4:
					System.out.println("Borrar un animal existente");
					System.out.println("--------------------------");
					System.out.print("Introduzca el nombre del animal: ");
					nombre = scan.next();
					try {
						AnimalDAO.delete(nombre);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				default:
					System.out.println("Fin del programa");
					break;
				}
				break;// Fin caso 1 del primer menu
			case 2:

				break;
			default:
				System.out.println("Fin del programa");
				break;
			}

		} while (opcion != 0);

	}

}
