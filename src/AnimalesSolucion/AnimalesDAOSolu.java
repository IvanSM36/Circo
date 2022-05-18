package AnimalesSolucion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AnimalesDAOSolu {

	private Connection con;
	private final String user = "root";
	private final String pass = "admin";
	private final String url = "jdbc:mysql://127.0.0.1:3306/circo";

	/**
	 * Constructor que establece directamente la conexion
	 */
	public AnimalesDAOSolu() {
		this.con = conectar();
		System.out.println("Conexion realizada.\n");
	}

	/**
	 * Metodo que se llama en el constructor y establece la conexion
	 * 
	 * @return
	 */
	private Connection conectar() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

	/**
	 * metodo que cierra la conexion
	 */
	public void cerrarConexion() {
		try {
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * metodo para insertar en la base de datos un animal pasando por parametro un
	 * objeto animal
	 * 
	 * @param nuevo
	 * @throws SQLException
	 */
	public void create(AnimalesSolu nuevo) throws SQLException {

		PreparedStatement stmt = null;
		AnimalesSolu x = nuevo;

		if (nuevo != null) {
			String sql = "INSERT INTO Animales VALUES (?,?,?,?,?,?,?)";

			try {
				con.setAutoCommit(false);
				stmt = con.prepareStatement(sql);
				stmt.setString(1, x.getNombrePK());
				stmt.setString(2, x.getTipo());
				stmt.setInt(3, x.getAnhos());
				stmt.setFloat(4, x.getPeso());
				stmt.setFloat(5, x.getEstatura());
				stmt.setString(6, x.getNombre_atraccion());
				stmt.setString(7, x.getNombre_pista());
				stmt.executeUpdate();
				con.commit();
				con.setAutoCommit(true);
				System.out.println("Animal insertado.");
			} catch (SQLException e) {
				con.rollback();
			} finally {
				stmt.close();
			}
		}
	}

	/**
	 * metodo que lee los datos de un animal pasando su primary key y los vuelca en
	 * un objeto animal nuevo y lo devuelve
	 * 
	 * @param nPK
	 * @return animales
	 * @throws SQLException
	 */
	public AnimalesSolu read(String nPK) throws SQLException {

		AnimalesSolu nuevo = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM Animales WHERE nombre = ?";

		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nPK);
			rs = stmt.executeQuery();
			con.commit();
			con.setAutoCommit(true);

			if (rs.next()) {
				String nombrePK = rs.getString(1);
				String tipo = rs.getString(2);
				int anhos = rs.getInt(3);
				float peso = rs.getFloat(4);
				float estatura = rs.getFloat(5);
				String nombre_atraccion = rs.getString(6);
				String nombre_pista = rs.getString(7);
				nuevo = new AnimalesSolu(nombrePK, tipo, anhos, peso, estatura, nombre_atraccion, nombre_pista);
				System.out.println("Animal volcado");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			con.rollback();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return nuevo;
	}

	/**
	 * metodo al que se le pasa un animal con los nuevos datos para hacer un update
	 * OJO el nombre ya debe existir puesto que es un update
	 * 
	 * @param nuevo
	 * @throws SQLException
	 */
	public void update(AnimalesSolu nuevo) throws SQLException {

		PreparedStatement stmt = null;
		AnimalesSolu x = nuevo;

		if (nuevo != null) {
			String sql = "UPDATE Animales SET tipo = ?, anhos = ?, peso = ?, estatura = ?, nombre_atraccion = ?, nombre_pista = ? WHERE nombre = ?";

			try {
				stmt = con.prepareStatement(sql);
				con.setAutoCommit(false);
				stmt.setString(1, x.getTipo());
				stmt.setInt(2, x.getAnhos());
				stmt.setFloat(3, x.getPeso());
				stmt.setFloat(4, x.getEstatura());
				stmt.setString(5, x.getNombre_atraccion());
				stmt.setString(6, x.getNombre_pista());
				stmt.setString(7, x.getNombrePK());
				stmt.executeUpdate();
				con.commit();
				con.setAutoCommit(true);
				System.out.println("Animal modificado.");
			} catch (SQLException e) {
				con.rollback();
			} finally {
				stmt.close();
			}
		}
	}

	/**
	 * metodo para borrar animal pasando por parametro la pk que en este caso es el
	 * nombre
	 * 
	 * @param nombrePK
	 * @throws SQLException
	 */
	public void delete(String nombrePK) throws SQLException {

		String sql = "DELETE FROM Animales WHERE nombre = ?";
		PreparedStatement stmt = null;

		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nombrePK);
			stmt.executeUpdate();
			stmt.executeUpdate();
			con.commit();
			con.setAutoCommit(true);
			System.out.println("Animal borrado.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error al borrar animal.");
			con.rollback();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * metodo que devuelve un arraylist con los animales de mas de 20 kilos de peso
	 * 
	 * @return arraylist<Animales>
	 */
	public ArrayList<AnimalesSolu> mas20() {

		ArrayList<AnimalesSolu> pesoMas20 = new ArrayList<>();
		AnimalesSolu a = null;
		String sql = "SELECT * FROM animales WHERE peso > 20";
		Statement sent = null;
		ResultSet rs = null;

		try {
			sent = con.createStatement();
			rs = sent.executeQuery(sql);

			while (rs.next()) {
				String nombrePK = rs.getString(1);
				String tipo = rs.getString(2);
				int anhos = rs.getInt(3);
				float peso = rs.getFloat(4);
				float estatura = rs.getFloat(5);
				String nombre_atraccion = rs.getString(6);
				String nombre_pista = rs.getString(7);
				a = new AnimalesSolu(nombrePK, tipo, anhos, peso, estatura, nombre_atraccion, nombre_pista);
				pesoMas20.add(a);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				sent.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return pesoMas20;

	}

}
