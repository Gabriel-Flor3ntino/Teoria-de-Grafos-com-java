package main;

import java.util.List;
import java.util.Map;
import java.util.Set;

import main.java.grafo.core.Digrafo;
import main.java.grafo.core.Grafo;
import main.java.grafo.core.Vertice;
import main.java.grafo.util.AlgoritmoDijkstra;
import main.java.grafo.util.AlgoritmoFloydWarshall;
import main.java.grafo.util.AlgoritmoPrim;

public class TesteGrafo {
	public static void main(String[] args) throws Exception {

		// Criando um novo grafo
		Digrafo digrafo = new Digrafo();
		digrafo.adicionarVertice("RJ");
		digrafo.adicionarVertice("SP");
		digrafo.adicionarVertice("BH");
		digrafo.adicionarVertice("PT");
		digrafo.adicionarVertice("OS");
		digrafo.adicionarVertice("SV");
		digrafo.adicionarVertice("CR");
		digrafo.adicionarVertice("PA");
		digrafo.conectarVertices("RJ", "SP", null);
		digrafo.conectarVertices("RJ", "BH", null);
		digrafo.conectarVertices("RJ", "PT", null);
		digrafo.conectarVertices("RJ", "PA", null);
		digrafo.conectarVertices("SP", "BH", null);
		digrafo.conectarVertices("SP", "OS", null);
		digrafo.conectarVertices("SP", "SV", null);
		digrafo.conectarVertices("SP", "CR", null);
		digrafo.conectarVertices("SP", "PA", null);
		digrafo.conectarVertices("SV", "PA", null);
		digrafo.conectarVertices("CR", "PA", null);

		Grafo arvore = digrafo.arvoreGeradoraPorProfundidade("PT");

		System.out.println("--- Árvore geradora via busca por profundidade usando raiz ---");
		System.out.println();

		for (Vertice v : arvore.getVertices()) {
			System.out.print("Vértice " + v.getRotulo() + " conectado a: ");
			List<Vertice> adjacencias = arvore.getAdjacencias(v.getRotulo());
			if (!adjacencias.isEmpty()) {
				for (Vertice adj : adjacencias) {
					System.out.print(adj.getRotulo() + " ");
				}
			} else {
				System.out.print("-");
			}
			System.out.println();
		}
		
		/*
		Grafo grafoPonderado = new Grafo();
		grafoPonderado.adicionarVertice("A");
		grafoPonderado.adicionarVertice("B");
		grafoPonderado.adicionarVertice("C");
		grafoPonderado.adicionarVertice("D");
		grafoPonderado.adicionarVertice("E");
		grafoPonderado.conectarVertices("A", "B", 12);
		grafoPonderado.conectarVertices("C", "E", 10);
		grafoPonderado.conectarVertices("B", "D", 5);
		grafoPonderado.conectarVertices("D", "A", 2);
		grafoPonderado.conectarVertices("B", "E", 1);
		grafoPonderado.conectarVertices("A", "C", 7);

		System.out.println("Grafo Ponderado");

		int peso = grafoPonderado.getPeso("A", "C");

		System.out.println("Peso da aresta AC: " + peso);

		peso = grafoPonderado.getPeso("B", "E");

		System.out.println("Peso da aresta BE: " + peso);*/

		Digrafo digrafoPonderado = new Digrafo();
		digrafoPonderado.adicionarVertice("X");
		digrafoPonderado.adicionarVertice("Y");
		digrafoPonderado.adicionarVertice("Z");
		digrafoPonderado.adicionarVertice("W");
		digrafoPonderado.adicionarVertice("V");
		digrafoPonderado.conectarVertices("X", "V", 44);
		digrafoPonderado.conectarVertices("Y", "W", 37);
		digrafoPonderado.conectarVertices("W", "Z", 38);
		digrafoPonderado.conectarVertices("X", "V", 16);
		digrafoPonderado.conectarVertices("V", "X", 22);
		digrafoPonderado.conectarVertices("V", "Y", 57);

		System.out.println("Dígrafo Ponderado");
		System.out.println("Vértices:");

		for (Vertice v : digrafoPonderado.getVertices()) {
			System.out.println("\t" + v.getRotulo());
		}

		System.out.println();
		System.out.println("Arestas:");

		for (Vertice v : digrafoPonderado.getVertices()) {
			for (Vertice adj : digrafoPonderado.getAdjacencias(v.getRotulo())) {
				System.out.println("\t" + v.getRotulo() + adj.getRotulo() + " : "
						+ digrafoPonderado.getPeso(v.getRotulo(), adj.getRotulo()));
			}
		}

		Grafo grafoPonderado = new Grafo();
		grafoPonderado.adicionarVertice("A");
		grafoPonderado.adicionarVertice("B");
		grafoPonderado.adicionarVertice("C");
		grafoPonderado.adicionarVertice("D");
		grafoPonderado.adicionarVertice("E");
		grafoPonderado.adicionarVertice("F");
		grafoPonderado.conectarVertices("A", "C", 8);
		grafoPonderado.conectarVertices("A", "D", 14);
		grafoPonderado.conectarVertices("A", "F", 14);
		grafoPonderado.conectarVertices("B", "C", 8);
		grafoPonderado.conectarVertices("B", "D", 15);
		grafoPonderado.conectarVertices("B", "E", 4);
		grafoPonderado.conectarVertices("B", "F", 2);
		grafoPonderado.conectarVertices("C", "E", 3);
		grafoPonderado.conectarVertices("C", "D", 7);
		grafoPonderado.conectarVertices("E", "F", 12);
		
		Map<String, AlgoritmoDijkstra.Info> menoresCaminhos = AlgoritmoDijkstra.getInstance().processar("X", "Y",
				grafoPonderado);
		Set<String> keys = menoresCaminhos.keySet();
		for (String key : keys) {
			AlgoritmoDijkstra.Info info = menoresCaminhos.get(key);
			String predecessor = info.predecessor == null ? "" : info.predecessor.getRotulo();
			System.out.println(key + " : " + info.distancia + " - " + predecessor);
		}
		
		Map<String, Map<String, AlgoritmoFloydWarshall.Info>> matriz = AlgoritmoFloydWarshall.getInstance()
				.processar(digrafo);
		for (String v : matriz.keySet()) {
			System.out.println("Vértice " + v);
			Map<String, AlgoritmoFloydWarshall.Info> linha = matriz.get(v);
			for (String u : linha.keySet()) {
				AlgoritmoFloydWarshall.Info info = linha.get(u);
				System.out.println(u + " com distância " + info.distancia + " por" + info.porQualVertice.getRotulo());
			}
			System.out.println();
		}


		

		String raiz = "RJ"; // pode ser qualquer raiz
		Digrafo mst = AlgoritmoPrim.getInstance().processar(raiz, grafoPonderado);
		for (Vertice v : mst.getVertices()) {
		    System.out.println("O vértice " + v.getRotulo() + " é adjacente aos vértices:");

		    for (Vertice adj : mst.getAdjacencias(v.getRotulo())) {
		        System.out.println(adj.getRotulo() + " com peso " + 
		            mst.getPeso(v.getRotulo(), adj.getRotulo()));
		    }
		}

		System.out.println();
		System.out.println();

	}

}