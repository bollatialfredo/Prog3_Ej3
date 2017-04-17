import java.util.ArrayList;
import java.util.Stack;

public class BusquedaCiclos {
	
	public static boolean tieneCicloRecursivo(GrafoDirigido grafo){
		
		Estado [] estados;
		
		estados = new Estado[grafo.tamanio()];
		
		for (int i = 0; i < estados.length; i++) {
			estados[i] = new Estado();
		}
		
		for(int i = 0; i < grafo.tamanio(); i++){
			if (cicloRecursivo(grafo, estados, i)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean tieneCicloPila(GrafoDirigido grafo){
		Estado estadoVisitado [] = new Estado[grafo.tamanio()];
		for (int i = 0; i < estadoVisitado.length; i++) {
			estadoVisitado[i] = new Estado();
			estadoVisitado[i].setVisitado(false);
			estadoVisitado[i].setVisitandose(false);
		}
		
		Stack<Integer> pila = new Stack<Integer>();
		if(grafo.tamanio()>0){
			pila.push(0);	
			estadoVisitado[0].setVisitandose(true);
		}				
			
			while(!pila.isEmpty()){
				ArrayList<Integer> adyacentes = grafo.adyacentes(pila.peek());
				if(adyacentes.size()>0){
					for (int j = 0; j < adyacentes.size(); j++) {
						
						if (estadoVisitado[adyacentes.get(j)].isVisitandose() && !estadoVisitado[adyacentes.get(j)].isVisitado()) {
							return true;
						}else{
							if(!estadoVisitado[adyacentes.get(j)].isVisitado()){
								pila.push(adyacentes.get(j));
								estadoVisitado[adyacentes.get(j)].setVisitandose(true);								
							}
						}
					}
					
				}else{
					estadoVisitado[pila.pop()].setVisitado(true);
				}				
			}		
			
		return false;
	}
	
	private static boolean cicloRecursivo(GrafoDirigido grafo, Estado[] estados, int vertice){
		
		if (estados[vertice].isVisitandose()) {
			return true;
		}
		estados[vertice].setVisitandose(true);
		
		ArrayList<Integer> lista = grafo.adyacentes(vertice);
		for (int i = 0; i < lista.size(); i++) {
			if(cicloRecursivo(grafo, estados, lista.get(i))){
				return true;
			}
		}
		estados[vertice].setVisitado(true);
		estados[vertice].setVisitandose(false);
		
		return false;
	}
	
	

}
