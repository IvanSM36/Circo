package ArtistasSolucion;

public class ArtistasSolu {

	private String nifPK;
	private String apellidos;
	private String nombre;
	private String nif_jefe;
	
	
	
	/**
	 * constructor solo con atributo pk en bada
	 * @param nifPK
	 */
	public ArtistasSolu(String nifPK) {
		this.nifPK = nifPK;
	}



	/**
	 * Constructor con todos los parametros
	 * @param nifPK
	 * @param apellidos
	 * @param nombre
	 * @param nif_jefe
	 */
	public ArtistasSolu(String nifPK, String apellidos, String nombre, String nif_jefe) {
		super();
		this.nifPK = nifPK;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.nif_jefe = nif_jefe;
	}



	/**
	 * @return the nifPK
	 */
	public String getNifPK() {
		return nifPK;
	}



	/**
	 * @param nifPK the nifPK to set
	 */
	public void setNifPK(String nifPK) {
		this.nifPK = nifPK;
	}



	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}



	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}



	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	/**
	 * @return the nif_jefe
	 */
	public String getNif_jefe() {
		return nif_jefe;
	}



	/**
	 * @param nif_jefe the nif_jefe to set
	 */
	public void setNif_jefe(String nif_jefe) {
		this.nif_jefe = nif_jefe;
	}



	@Override
	public String toString() {
		return "Artistas [nifPK=" + nifPK + ", apellidos=" + apellidos + ", nombre=" + nombre + ", nif_jefe=" + nif_jefe
				+ "]";
	}


	
	
	
	
}
