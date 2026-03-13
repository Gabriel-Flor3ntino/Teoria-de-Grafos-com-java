package main;

import main.java.grafo.core.Grafo;
import main.java.grafo.core.Vertice;

public class TesteGrafo {
    public static void main(String[] args) throws Exception {
        // Criando um novo grafo
        Grafo grafo = new Grafo();
        
        // Adicionando vértices
        grafo.adicionarVertice("RJ");
        grafo.adicionarVertice("SP");
        grafo.adicionarVertice("BH");
        grafo.adicionarVertice("PT");
        grafo.adicionarVertice("OS");
        grafo.adicionarVertice("SV");
        grafo.adicionarVertice("CR");
        grafo.adicionarVertice("PA");
        
        // Exibindo a quantidade de vértices
        System.out.println("O grafo G possui os seguintes vértices:");
        System.out.println("Total de vértices: " + grafo.getVertices().size());
        System.out.println();
        
        // Listando todos os vértices
        for (Vertice vertice : grafo.getVertices()) {
            System.out.println("- Vértice " + vertice.getRotulo());
        }
    }
}