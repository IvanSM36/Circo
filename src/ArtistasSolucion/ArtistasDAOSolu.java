package ArtistasSolucion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ArtistasDAOSolu {

	private Connection con;
	private final String user = "root";
	private final String pass = "admin";
	private final String url = "jdbc:mysql://127.0.0.1:3306/circo";

	public ArtistasDAOSolu() {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * metodo para insertar en la base de datos un artista pasando por parametro un
	 * objeto artista
	 * 
	 * @param nuevo
	 * @throws SQLException
	 */
	public void create(ArtistasSolu nuevo) throws SQLException {

		PreparedStatement stmt = null;
		ArtistasSolu x = nuevo;

		if (nuevo != null) {
			String sql = "INSERT INTO Artistas VALUES (?,?,?,?)";

			try {
				con.setAutoCommit(false);
				stmt = con.prepareStatement(sql);
				stmt.setString(1, x.getNifPK());
				stmt.setString(2, x.getApellidos());
				stmt.setString(3, x.getNombre());
				stmt.setString(4, x.getNif_jefe());
				stmt.executeUpdate();
				System.out.println("Artista insertado.");
				con.commit();
				con.setAutoCommit(true);
			} catch (SQLException e) {
				System.out.println("Error al insertar artista");
				con.rollback();
			} finally {
				stmt.close();

			}
		}
	}

	/**
	 * metodo que lee los datos de un artista pasando su primary key y los vuelca en
	 * un objeto artista nuevo y lo devuelve
	 * 
	 * @param nPK
	 * @return artista
	 * @throws SQLException
	 */
	public ArtistasSolu read(String nifPK) throws SQLException {

		ArtistasSolu nuevo = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM Artistas WHERE nif = ?";

		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nifPK);
			rs = stmt.executeQuery();
			con.commit();
			con.setAutoCommit(true);

			if (rs.next()) {
				String nif = rs.getString(1);
				String apellidos = rs.getString(2);
				String nombre = rs.getString(3);
				String nif_jefe = rs.getString(4);
				nuevo = new ArtistasSolu(nif, apellidos, nombre, nif_jefe);
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
	 * metodo al que se le pasa un artista con los nuevos datos para hacer un update
	 * OJO el nif ya debe existir puesto que es un update
	 * 
	 * @param nuevo
	 * @throws SQLException
	 */
	public void update(ArtistasSolu nuevo) throws SQLException {

		PreparedStatement stmt = null;
		ArtistasSolu x = nuevo;

		if (nuevo != null) {
			String sql = "UPDATE Artistas SET apellidos = ?, nombre = ?, nif_jefe = ? WHERE nif = ?";

			try {
				con.setAutoCommit(false);
				stmt = con.prepareStatement(sql);
				stmt.setString(1, x.getApellidos());
				stmt.setString(2, x.getNombre());
				stmt.setString(3, x.getNif_jefe());
				stmt.setString(4, x.getNifPK());
				stmt.executeUpdate();
				System.out.println("Artista actualizado");
				con.commit();
				con.setAutoCommit(true);
			} catch (SQLException e) {
				System.out.println("Error al actualizar artista");
				con.rollback();
			} finally {
				stmt.close();
			}
		}
	}

	/**
	 * metodo para borrar artista pasando por parametro la pk que en este caso es el
	 * nif
	 * 
	 * @param nifPK
	 * @throws SQLException
	 */
	public void delete(String nifPK) throws SQLException {

		String sql = "DELETE FROM Artistas WHERE nif = ?";
		PreparedStatement stmt = null;

		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nifPK);
			stmt.executeUpdate();
			System.out.println("Artista borrado.");
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			con.rollback();
		} finally {
			stmt.close();
		}
	}

	/**
	 * metodo que devuelve un arraylist con los artistas con a en su nombre
	 * 
	 * @return arraylist<Artistas>
	 */
	public ArrayList<ArtistasSolu> nombreConA() {

		ArrayList<ArtistasSolu> nombreConA = new ArrayList<>();
		ArtistasSolu a = null;
		String sql = "SELECT * FROM Artistas WHERE ucase(nombre) like '%a%'";
		Statement sent = null;
		ResultSet rs = null;

		try {
			sent = con.createStatement();
			rs = sent.executeQuery(sql);

			while (rs.next()) {
				String nifPK = rs.getString(1);
				String apellidos = rs.getString(2);
				String nombre = rs.getString(3);
				String nif_jefe = rs.getString(4);
				a = new ArtistasSolu(nifPK, apellidos, nombre, nif_jefe);
				nombreConA.add(a);
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
		return nombreConA;
	}

}
