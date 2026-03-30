package main.java.grafo.core;

import java.util.Map;

public class Digrafo extends Grafo{
	
	public void conectarVertices(String rotuloVerticeInicial, String rotuloVerticeFinal,
								 Integer Peso) throws Exception {
		if (!super.existeVertice(rotuloVerticeInicial) || !super.existeVertice(rotuloVerticeFinal)) {
			throw new Exception("Para adicionar uma aresta ambos os vértices devem existir.");
		}
		Map<String, Integer> rotulosEmIndices = super.getRotulosEmIndices();
		super.criarMatrizAdjacencia();
		MatrizAdjacencia matrizAdjacencia = getMatrizAdjacencia();
		int indiceVerticeInicial = rotulosEmIndices.get(rotuloVerticeInicial);
		int indiceVerticeFinal= rotulosEmIndices.get(rotuloVerticeFinal);
		matrizAdjacencia.adicionarArestaDirecionada(indiceVerticeInicial, indiceVerticeFinal, Peso);
	}
	
}
