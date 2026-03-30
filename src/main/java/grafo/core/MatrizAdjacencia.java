package main.java.grafo.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrizAdjacencia {

	private int[][] matriz;
	private List<Vertice> vertices;
	private int qtdVertices;
	private Map<Integer, List<Vertice>> ancestrais;
	
	public MatrizAdjacencia(List<Vertice> vertices) {
		this.vertices = vertices;
		this.qtdVertices = vertices.size();
		matriz = new int[qtdVertices][qtdVertices];
		this.ancestrais = new HashMap<>();
		inicializarMatriz();
	}

	private void inicializarMatriz() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = 0;
			}
		}
	}

	public void adicionarAresta(int indiceVerticeInicial, int indiceVerticeFinal) {
		Vertice verticeInicial = vertices.get(indiceVerticeInicial);
		Vertice verticeFinal = vertices.get(indiceVerticeFinal);
		if (indiceVerticeInicial == indiceVerticeFinal) {
			matriz[indiceVerticeInicial][indiceVerticeInicial] = 1;
			verticeInicial.addGrau();
		} else {
			matriz[indiceVerticeInicial][indiceVerticeFinal] = 1;
			verticeInicial.addGrau();
			matriz[indiceVerticeFinal][indiceVerticeInicial] = 1;
			verticeFinal.addGrau();
		}
	}

	public List<Vertice> getAdjacencias(int indiceVertice) {
		int linha = indiceVertice;
		List<Vertice> adjacencias = new ArrayList<>();
		for (int j = 0; j < vertices.size(); j++) {
			if (matriz[linha][j] == 1) {
				Vertice vertice = vertices.get(j);
				adjacencias.add(vertice);
			}
		}
		return adjacencias;
	}
	
	public void adicionarArestaDirecionada(int indiceVerticeInicial, int indiceVerticeFinal, Integer peso) {
		peso = peso == null ? 1 : peso;
		Vertice verticeInicial = vertices.get(indiceVerticeInicial);
		if (indiceVerticeInicial == indiceVerticeFinal) {
			matriz[indiceVerticeInicial][indiceVerticeInicial] = peso;
			verticeInicial.addGrau();
		} else {
			matriz[indiceVerticeInicial][indiceVerticeFinal] = peso;
			Vertice verticeFinal = vertices.get(indiceVerticeFinal);
			verticeFinal.addGrau();
		}
		this.adicionarAncestral(indiceVerticeFinal, verticeInicial);
		
	}
	
	int getPeso(int indiceVerticeInicial, int indiceVerticeFinal) {
		return this.matriz[indiceVerticeInicial][indiceVerticeFinal];
	}
	
	public int getQtdVertices() {
		return qtdvertices;
	}
}
