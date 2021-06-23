package Ejercicio4;

public class Main
{
	public static void main(String[] args) 
	{
		Graph<String> G1 = new Graph<String>();
		
		G1
			.addNodo("A")
			.addNodo("B")
			.addNodo("C")
			.addNodo("D")
			.addNodo("E")
			.addNodo("F")
			.addNodo("G")
			.addNodo("H");
		
		G1
			.conectar("A", "B")
			.conectar("A", "C")
			.conectar("B", "D")
			.conectar("B", "E")
			.conectar("C", "F")
			.conectar("C", "G");
		
		G1.pathsOfLengthNOrLess(G1.getNodo("A"), 2);
		System.out.println(G1.pathsOfLengthNOrLess(G1.getNodo("A"), 2));
	}
}
