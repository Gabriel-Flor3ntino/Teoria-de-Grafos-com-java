package main.java.aplicacao;

import main.java.grafo.core.Digrafo;
import main.java.grafo.core.Grafo;
public class Aplicacao {
	
	public static void main(String[] args) {
		Aplicacao app = new Aplicacao();
		Grafo grafo = null;
		
		app.menu();
		
		while(true) {
			System.out.println("Digite a opção desejada: ");
			String opcao = app.ler().toUpperCase();			
			switch (opcao) {
				case "G":
					grafo = app.novoGrafo();
					break;
				case "D":
					grafo = app.novoGrafo();
					break;
				case "V":
					app.novoVertice(grafo);
					break;
				case "A":
					app.novaAresta(grafo);
					break;
				case "PE":
					app.novaArestaPonderada(grafo);
					break;
				case "P":
					
					break;
				case "L":
					break;
				case "AG":
					break;
				case "PR":
					break;
				case "DIJ":
					break;
				case "FL":
					break;
				case "VIZ":
					break;
				case "S":
				default:
			}
		}
	}
	
	
	private void menu() {
		StringBuilder texto = new StringBuilder();
		texto
			.append("********** Bem vindo *********************\n")
			.append("* Escolha uma das opções abaixo:		  *\n")
			.append("* [G]rafo								  *\n")
			.append("* [D]igrafo                              *\n")
			.append("* [V]értice                              *\n")
			.append("* [A]resta                               *\n")
			.append("* Aresta com [Pe]so                      *\n")
			.append("* Busca por [P]rofundidade               *\n")
			.append("* Busca por [L]argura 				      *\n")
			.append("* [AG] - Árvore Geradora                 *\n")
			.append("* Árvore Geradora Mínima por [Pr]im      *\n")
			.append("* Algoritmo de [Dij]kstra                *\n")
			.append("* Algoritmo de [Fl]oydWarshall           *\n")
			.append("* Gerar representação Graph[Viz]         *\n")
			.append("* [S]air                                 *\n")
			.append("******************************************\n");
		System.out.print(texto);
	}
	
	private String ler() {
		return input.next();
	}
	
	private Grafo novoGrafo() {
		Grafo grafo = new Grafo();
		System.out.println("Novo grafo criado.");
		return grafo;
	}
	
	private Digrafo novoDigrafo() {
		Digrafo digrafo = new Digrafo();
		System.out.println("novo dígrafo criado.");
		return digrafo;
	}
	
	private void novoVertice(Grafo grafo) throws Exception {
		System.out.println("Defina o nome do vértice ? ");
		String nome = ler();
		grafo.adicionarVertice(nome);
		System.out.println("Novo vértice " + nome + " criado.");
	}
	
	private void novaAresta(Grafo grafo) throws Exception {
		System.out.print("Qual o vértice de origem ? ");
		String vOrigem = ler();
		System.out.print("Qual o vértice de destino ? ");
		String vDestino = ler();
		grafo.conectarVertices(vOrigem, vDestino, null);
		System.out.println("Nova aresta criada.");
	}
	
	private void novaArestaPonderada(Grafo grafo) throws Exception {
		System.out.print("Qual o vértice de origem ? ");
		String vOrigem = ler();
		System.out.print("Qual o vértice de destino ? ");
		String vDestino = ler();
		System.out.print("Qual o peso da aresta ? ");
		String peso = ler();
		grafo.conectarVertices(vOrigem, vDestino, Integer.valueOf(peso));
		System.out.println("Nova aresta ponderada criada.");
	}
	
}
