package main.java.grafo.core;

import java.util.ArrayList;
import java.util.Collections;
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

	/*	O método adicionarAresta passou por modificações
		para o recebimento de pesos de arestas como parâmetro
	 */
	public void adicionarAresta(int indiceVerticeInicial, int indiceVerticeFinal, Integer peso) {
		peso = peso == null ? 1 : peso;
		Vertice verticeInicial = vertices.get(indiceVerticeInicial);
		Vertice verticeFinal = vertices.get(indiceVerticeFinal);
		if (indiceVerticeInicial == indiceVerticeFinal) {
			matriz[indiceVerticeInicial][indiceVerticeInicial] = peso;
			verticeInicial.addGrau();
		} else {
			matriz[indiceVerticeInicial][indiceVerticeFinal] = peso;
			verticeInicial.addGrau();
			matriz[indiceVerticeFinal][indiceVerticeInicial] = peso;
			verticeFinal.addGrau();
		}
	}
	
	/*	O método getAdjacencias teve que ser modificado para que dê
		suporte à diversidade de valores que podem existir nas células de
		uma matriz
	 */

	public List<Vertice> getAdjacencias(int indiceVertice) {
		int linha = indiceVertice;
		List<Vertice> adjacencias = new ArrayList<>();
		for (int j = 0; j < vertices.size(); j++) {
			if (matriz[linha][j] != 0) {
				Vertice vertice = vertices.get(j);
				adjacencias.add(vertice);
			}
		}
		return adjacencias;
	}
	
	/*	O método adicionarArestaDirecionada dá suporte à criação de arestas
		direcionadas entre vértices, estas podendo possuir pesos ou não
	 */
	
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
	
	/*	O método getPeso retorna o valor da célula da matriz dado os
		índices dos vértices iniciais e finais*/
	
	int getPeso(int indiceVerticeInicial, int indiceVerticeFinal) {
		return this.matriz[indiceVerticeInicial][indiceVerticeFinal];
	}
	
	
	/* 	O método getQtdVertices
		simplesmente retorna a quantidade de vértices presentes na matriz
	 */
	public int getQtdVertices() {
		return qtdVertices;
		}
	
	/*	O método copiaValoresPara
	 é usado para copiar valores de uma 
	 matriz de origem para outra de destino.
	 */
	void copiaValoresPara(MatrizAdjacencia matrizDestino) throws Exception {
		if (matrizDestino.getQtdVertices() < this.qtdVertices) {
			throw new Exception("Somnte é possível executar cópias em matrizes com dimensões iguais " +
							"ou a matriz de destino deve ter dimensões maiores que a matriz de origem.");
		}
		
		for (int i=0; i<matriz.length; i++) {
			for (int j=0; j<matriz[i].length; j++) {
				matrizDestino.escreveNaCelula(i, j, matriz[i][j]);
			}
		}
	}
	/* O método escreveNaCelula
	recebe como parâmetro uma combinação de linha e coluna 
	junto com o valor que deve ser adicionado na célula
	correspondente*/
	
	private void escreveNaCelula(int linha, int coluna, int valor) {
		this.matriz[linha][coluna] = valor;
	}
	
	/*	Os métodos adicionarAncestral , getAncestrais e hasAncestrais
	 	apoiam a construção de árvores geradoras a partir de dígrafos
	 */

	private void adicionarAncestral(int indiceVertice, Vertice ancestral) {
		if (this.ancestrais.get(indiceVertice) == null) {
			List<Vertice> ancestrais = new ArrayList<>();
			ancestrais.add(ancestral);
			this.ancestrais.put(indiceVertice, ancestrais);
		} else {
			this.ancestrais.get(indiceVertice).add(ancestral);
		}
	}
	
	
	List<Vertice> getAncestrais(int indiceVertice) {
		if (this.ancestrais.get(indiceVertice) == null) {
			return Collections.emptyList();
		}
		return this.ancestrais.get(indiceVertice);
	}
	
	boolean hasAncestrais(int indiceVertice) {
		return this.ancestrais.containsKey(indiceVertice);	
	}
	
	
}
