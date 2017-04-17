import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GrafoDirigido {
	List<LinkedList<Integer>> vertices;
	
	public GrafoDirigido () {
		vertices = new ArrayList<LinkedList<Integer>>();
	}
	
	public ArrayList<Integer> vertices(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		for (int i = 0; i < vertices.size(); i++) {
			lista.add(i);
		}
		return lista;
	}
	
	public void agregarVertice () {		
			vertices.add(new LinkedList<Integer>());
	}
	
	public void agregarArco (int origen, int destino) {
		if(origen < vertices.size() && destino < vertices.size()){
			vertices.get(origen).add(destino);
		}
	}
	public int tamanio(){
		return vertices.size();
	}
	
	public ArrayList<Integer> adyacentes(int vertice){
		ArrayList<Integer> aux = new ArrayList<Integer>();
		for (int i = 0; i < vertices.get(vertice).size(); i++) {
			aux.add(vertices.get(vertice).get(i));
		}
		return aux;
	}
	
	public void imprimirVertice (int vertice) {
		for (int i = 0; i < vertices.get(vertice).size(); i++) {
			System.out.println(vertices.get(vertice).get(i));
		}
	}
}