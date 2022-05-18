
import java.util.ArrayList;

import AnimalesSolucion.AnimalesDAOSolu;
import AnimalesSolucion.AnimalesSolu;
import ArtistasSolucion.ArtistasDAOSolu;
import ArtistasSolucion.ArtistasSolu;

public class Usos {

	public static void main(String[] args) {
		
		AnimalesDAOSolu a = null;
		ArtistasDAOSolu ar = null;
		ArrayList<AnimalesSolu> x = null;
		ArrayList<ArtistasSolu> y = null;
		
		try {
			
			a = new AnimalesDAOSolu();
			
			// uso mas20()
			x = a.mas20();
			
			//recorro y muestro nombre y peso
			for (AnimalesSolu nuevo1 : x) {
				System.out.println(nuevo1.getNombrePK()+"  "+nuevo1.getPeso());
			}
		

			// uso create()
			AnimalesSolu insert = new AnimalesSolu("Mayte", "Mono", 10, 35, 16, "Juego", "Mio");
			a.create(insert);
			
			// uso read()
			AnimalesSolu volcado = a.read("Berni");
			System.out.println(volcado);
			
			// uso update() 
			AnimalesSolu cambio = new AnimalesSolu("Mayte", "Mono", 1, 1, 1, null, null);
			a.update(cambio);
			
			// uso delete() 
			a.delete("Mayte");
			
			
			
			///////////////////////////////////////////////////////////////////////////////////
			System.out.println();
			System.out.println();
			System.out.println();
			///////////////////////////////////////////////////////////////////////////////////
			
			ar = new ArtistasDAOSolu();
			
			//uso nombreConA
			y = ar.nombreConA();
			
			//recorro y muestro nif, nombre y apellido
			for (ArtistasSolu nuevo2: y) {
				System.out.println(nuevo2.getNifPK()+" "+nuevo2.getNombre()+" "+nuevo2.getApellidos());	
			}
			
			// uso create()
			ArtistasSolu insert2 = new ArtistasSolu("12345678A","PEREZ","MAYTE","11111111A");
			ar.create(insert2);
						
			//uso read()
			ArtistasSolu volcado2 = ar.read("00000000A");
			System.out.println(volcado2);
			
			// uso update()
			ArtistasSolu cambio2 = new ArtistasSolu ("00000000A","SANCHEZ","DRAGO","88888888F");
			ar.update(cambio2);
						
			// uso delete()
			ar.delete("12345678A");
			
			
			
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			a.cerrarConexion();
			ar.cerrarConexion();
			System.out.println("\nCierre de conexiones realizado con éxito.");
		}
				
	}
}
