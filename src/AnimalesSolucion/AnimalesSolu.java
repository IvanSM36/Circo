package AnimalesSolucion;

public class AnimalesSolu {

	private String nombrePK;
	private String tipo;
	private int anhos;
	private float peso;
	private float estatura;
	private String nombre_atraccion;
	private String nombre_pista;
	
	
	
	
	
	/**
	 * @param nombrePK
	 */
	public AnimalesSolu(String nombrePK) {
		this.nombrePK = nombrePK;
	}


	/**
	 * @param nombrePK
	 * @param tipo
	 * @param anhos
	 * @param peso
	 * @param estatura
	 * @param nombre_atraccion
	 * @param nombre_pista
	 */
	public AnimalesSolu(String nombrePK, String tipo, int anhos, float peso, float estatura, String nombre_atraccion,
			String nombre_pista) {
		this.nombrePK = nombrePK;
		this.tipo = tipo;
		this.anhos = anhos;
		this.peso = peso;
		this.estatura = estatura;
		this.nombre_atraccion = nombre_atraccion;
		this.nombre_pista = nombre_pista;
	}


	/**
	 * @return the nombrePK
	 */
	public String getNombrePK() {
		return nombrePK;
	}


	/**
	 * @param nombrePK the nombrePK to set
	 */
	public void setNombrePK(String nombrePK) {
		this.nombrePK = nombrePK;
	}


	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}


	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	/**
	 * @return the anhos
	 */
	public int getAnhos() {
		return anhos;
	}


	/**
	 * @param anhos the anhos to set
	 */
	public void setAnhos(int anhos) {
		this.anhos = anhos;
	}


	/**
	 * @return the peso
	 */
	public float getPeso() {
		return peso;
	}


	/**
	 * @param peso the peso to set
	 */
	public void setPeso(float peso) {
		this.peso = peso;
	}


	/**
	 * @return the estatura
	 */
	public float getEstatura() {
		return estatura;
	}


	/**
	 * @param estatura the estatura to set
	 */
	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}


	/**
	 * @return the nombre_atraccion
	 */
	public String getNombre_atraccion() {
		return nombre_atraccion;
	}


	/**
	 * @param nombre_atraccion the nombre_atraccion to set
	 */
	public void setNombre_atraccion(String nombre_atraccion) {
		this.nombre_atraccion = nombre_atraccion;
	}


	/**
	 * @return the nombre_pista
	 */
	public String getNombre_pista() {
		return nombre_pista;
	}


	/**
	 * @param nombre_pista the nombre_pista to set
	 */
	public void setNombre_pista(String nombre_pista) {
		this.nombre_pista = nombre_pista;
	}


	@Override
	public String toString() {
		return "Animales [nombrePK=" + nombrePK + ", tipo=" + tipo + ", anhos=" + anhos + ", peso=" + peso
				+ ", estatura=" + estatura + ", nombre_atraccion=" + nombre_atraccion + ", nombre_pista=" + nombre_pista
				+ "]";
	}
	
	
	
	
	
	
	
}
