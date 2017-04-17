
public class Main {

	public static void main(String[] args) {
		GrafoDirigido grafo = new GrafoDirigido();
		for (int i = 0; i < 2000; i++) {
			grafo.agregarVertice();			
		}
		grafo.agregarArco(0, 1);
		grafo.agregarArco(1, 2);
		grafo.agregarArco(2, 3);
		grafo.agregarArco(3, 0);
		
		grafo.imprimirVertice(3);
		/**
		 * en el metodo recursivo podemos encontrar la presencia un ciclo de una manera relativamente rapida.
		 * 
		 * en el caso del metodo de busqueda por medio de la utilizacion de una pila, no logre hacer que funcione.
		 * 
		 */
		System.out.println(BusquedaCiclos.tieneCicloRecursivo(grafo));
		
//		System.out.println(BusquedaCiclos.tieneCicloPila(grafo));
		
	}

}
