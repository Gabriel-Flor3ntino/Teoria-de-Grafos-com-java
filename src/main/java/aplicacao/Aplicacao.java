package main.java.aplicacao;

import java.util.Scanner;
public class Aplicacao {
	
	public static void main(String[] args) {
		
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
}
