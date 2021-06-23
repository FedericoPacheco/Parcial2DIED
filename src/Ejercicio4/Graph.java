package Ejercicio4;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Graph <T> {
	private List<Edge<T>> edges;
	private List<Vertex<T>> vertexs;

	public Graph(){
		this.edges = new ArrayList<Edge<T>>();
		this.vertexs = new ArrayList<Vertex<T>>();
	}

	public Graph<T> addNodo(T nodo){
		 this.addNodo(new Vertex<T>(nodo));
		 return this;
	}

	private void addNodo(Vertex<T> nodo){
		this.vertexs.add(nodo);
	}
	
	public Graph<T> conectar(T n1,T n2){
		this.conectar(getNodo(n1), getNodo(n2), 1.0);
		return this;
	}

	public Graph<T> conectar(T n1,T n2,Number valor){
		this.conectar(getNodo(n1), getNodo(n2), valor);
		return this;
	}

	private void conectar(Vertex<T> nodo1,Vertex<T> nodo2,Number valor){
		this.edges.add(new Edge<T>(nodo1,nodo2,valor));
	}
	
	public Vertex<T> getNodo(T valor){
		return this.vertexs.get(this.vertexs.indexOf(new Vertex<T>(valor)));
	}

	public List<T> getNeighbourhood(T valor){ 
		Vertex<T> unNodo = this.getNodo(valor);
		List<T> salida = new ArrayList<T>();
		for(Edge<T> enlace : this.edges){
			if( enlace.getOrigin().equals(unNodo)){
				salida.add(enlace.getEnd().getValue());
			}
		}
		return salida;
	}
	

	private List<Vertex<T>> getNeighbourhood(Vertex<T> unNodo){ 
		List<Vertex<T>> salida = new ArrayList<Vertex<T>>();
		for(Edge<T> enlace : this.edges){
			if( enlace.getOrigin().equals(unNodo)){
				salida.add(enlace.getEnd());
			}
		}
		return salida;
	}
	
	public void printEdges(){
		System.out.println(this.edges.toString());
	}

	public Integer gradoEntrada(Vertex<T> vertice){
		Integer res =0;
		for(Edge<T> arista : this.edges){
			if(arista.getEnd().equals(vertice)) ++res;
		}
		return res;
	}

	public Integer gradoSalida(Vertex<T> vertice){
		Integer res =0;
		for(Edge<T> arista : this.edges){
			if(arista.getOrigin().equals(vertice)) ++res;
		}
		return res;
	}
	
    protected Edge<T> findEdge(T v1, T v2){
    	return this.findEdge(new Vertex<T>(v1), new Vertex<T>(v2));
    }

    private boolean isAdjacent(Vertex<T> v1,Vertex<T> v2){
    	List<Vertex<T>> ady = this.getNeighbourhood(v1);
        for(Vertex<T> unAdy : ady){
        	if(unAdy.equals(v2)) return true;
        }
        return false;
    }
   
    protected Edge<T> findEdge(Vertex<T> v1, Vertex<T> v2){
    	for(Edge<T> unaArista : this.edges) {
    		
    		if(unaArista.getOrigin().equals(v1) && unaArista.getEnd().equals(v2)) return unaArista;
    	}
    	return null;
    }

	// ------------------------------------------------------------------------------------------------------
    // Ejercicio 4 (se escribio en ingles por como esta hecha el resto de la clase):
    
    public LinkedList<LinkedList<Vertex<T>>> pathsOfLengthNOrLess(Vertex<T> v, Integer n)
    {
    	LinkedList<LinkedList<Vertex<T>>> paths = new LinkedList<LinkedList<Vertex<T>>>();
    	LinkedList<Vertex<T>> visitedVertices = new LinkedList<Vertex<T>>();
    	
    	visitedVertices.add(v);
    	this.pathsOfLengthNOrLess(v, n, paths, visitedVertices);
    	
    	return paths;
    }
    
    @SuppressWarnings("unchecked")
	private void pathsOfLengthNOrLess(Vertex<T> v, Integer n, LinkedList<LinkedList<Vertex<T>>> paths, LinkedList<Vertex<T>> visitedVertices)
    {
    	LinkedList<Vertex<T>> visitedVerticesCopy;
    	
    	paths.add(visitedVertices);
    		
    	if (n > 0)
    		for(Vertex<T> w : this.getNeighbourhood(v))
    		{
    			visitedVerticesCopy = (LinkedList<Vertex<T>>) visitedVertices.clone();
    			visitedVerticesCopy.add(w);
    			this.pathsOfLengthNOrLess(w, n - 1, paths, visitedVerticesCopy); // No cycles
    		}	
    }
}
