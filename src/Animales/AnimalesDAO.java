package Animales;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnimalesDAO {
	private Connection conexion;
	private final static String url = "jdbc:mysql://localhost:3306/circoivan";
	private final static String usuario = "root";
	private final static String pass = "carlos";

	// Constructores
	// Creamos la conexion. que se mantendra abierta todo el tiempo.
	public AnimalesDAO() {
		conexion = conectar();
	}

	// Metodos
	// Crea una conexion con el SGBD y la devuelve
	private static Connection conectar() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, usuario, pass);
		} catch (SQLException ex) {
			System.out.println("Error al conectar al SGBD");
		}
		return con;
	}

	// Creamos el metodo create() para poder insertar datos en la base de datos.
	public static void create(Animales animales) {
		// Si el animal pasado es nulo no haremos nada
		if (animales != null){
			Connection conexion = conectar();
			String sql = "INSERT INTO Alumnos (nombre, tipo, anhos, peso, estatura, nombre_atraccion, nombre_pista)"
					+ "				   VALUES (   ?,     ?,    ?,     ?,     ?,            ?,               ?    )";
			try {
				PreparedStatement sentencia = conexion.prepareStatement(sql);
				sentencia.setString(1, animales.getNombre());
				sentencia.setString(2, animales.getTipo());
				sentencia.setInt(3, animales.getAnios());
				sentencia.setFloat(4, animales.getPeso());
				sentencia.setFloat(5, animales.getEstatura());
				sentencia.setString(6, animales.getNombreAtraccion());
				sentencia.setString(7, animales.getNombrePista());
				sentencia.executeUpdate();
				conexion.close(); //Cerramos la conexion
			}catch (SQLException ex) {
				System.out.println("Error al insertar.");			
			}
		}
	}
	
	// Lee los datos con la clave primaria construye un objetocon sus datos y lo devuelve.
	public static Animales read(String nombre) {
		Animales animal = null;
		String sql = "SELECT * FROM Animales WHERE nombre = ?";
		try {
			Connection conexion = conectar();
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, nombre); // Asignamos la clave primaria a buscar
			ResultSet rs = sentencia.executeQuery();
			// Al estar buscando por la clave primaria. solo existen dos alternativas:
			//1. La encuentra: el resulSet tendrá un unico registro.
			//2. No la encuentra: el resulSet estará vacio.
			if (rs.next()){	// Si hay un registro
				String nombre1 = rs.getString("nombre");
			}
		} catch (SQLException ex) {
			System.out.println("Error al consultar un animal.");
		}
		return null;
		
	}

}
