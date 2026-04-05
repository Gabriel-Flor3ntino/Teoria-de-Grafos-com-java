 Grafo - Graph Library in Java

A Java library for working with graphs (directed and undirected) with implementations of common graph algorithms.

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── grafo/
│   │       ├── core/           # Core graph classes
│   │       │   ├── Grafo.java              # Undirected graph implementation
│   │       │   ├── Digrafo.java            # Directed graph implementation
│   │       │   ├── Vertice.java            # Vertex representation
│   │       │   └── MatrizAdjacencia.java   # Adjacency matrix for graph storage
│   │       ├── search/         # Graph traversal algorithms
│   │       │   ├── BuscaEmLargura.java     # Breadth-First Search (BFS)
│   │       │   ├── BuscaEmProfundidade.java # Depth-First Search (DFS)
│   │       │   └── Caminho.java            # Path tracking utility
│   │       └── util/           # Graph algorithms
│   │           ├── AlgoritmoDijkstra.java      # Dijkstra's shortest path
│   │           ├── AlgoritmoFloydWarshall.java # Floyd-Warshall all-pairs shortest path
│   │           └── AlgoritmoPrim.java          # Prim's Minimum Spanning Tree
│   └── TesteGrafo.java         # Example usage and tests
└── aplicacao/
    └── Aplicacao.java          # Application entry point
```

## Features

### Core Functionality
- **Grafo**: Undirected graph with support for weighted edges
- **Digrafo**: Directed graph (extends Grafo) with support for weighted edges
- **Vertice**: Vertex representation with labels
- **MatrizAdjacencia**: Adjacency matrix-based graph storage

### Search Algorithms
- **Breadth-First Search (BFS)**: Find shortest paths in unweighted graphs
- **Depth-First Search (DFS)**: Generate spanning trees and traverse graphs

### Graph Algorithms
- **Dijkstra's Algorithm**: Find shortest paths from a source vertex to all other vertices
- **Floyd-Warshall Algorithm**: Find shortest paths between all pairs of vertices
- **Prim's Algorithm**: Find Minimum Spanning Tree (MST) of a weighted graph

## Usage Examples

### Creating a Graph

```java
// Create an undirected graph
Grafo grafo = new Grafo();
grafo.adicionarVertice("A");
grafo.adicionarVertice("B");
grafo.adicionarVertice("C");

// Connect vertices with weights
grafo.conectarVertices("A", "B", 5);
grafo.conectarVertices("B", "C", 3);
grafo.conectarVertices("A", "C", 10);
```

### Creating a Directed Graph

```java
Digrafo digrafo = new Digrafo();
digrafo.adicionarVertice("X");
digrafo.adicionarVertice("Y");
digrafo.conectarVertices("X", "Y", 7);
```

### Breadth-First Search

```java
BuscaEmLargura bfs = BuscaEmLargura.getInstance();
List<String> caminho = bfs.buscar(grafo, "A", "C");
```

### Depth-First Search

```java
BuscaEmProfundidade dfs = BuscaEmProfundidade.getInstance();
List<String> caminho = dfs.buscar(grafo, "A", "C");
```

### Dijkstra's Shortest Path

```java
Map<String, AlgoritmoDijkstra.Info> menoresCaminhos =
    AlgoritmoDijkstra.getInstance().processar("A", "C", grafo);
```

### Floyd-Warshall All-Pairs Shortest Path

```java
Map<String, Map<String, AlgoritmoFloydWarshall.Info>> matriz =
    AlgoritmoFloydWarshall.getInstance().processar(digrafo);
```

### Prim's Minimum Spanning Tree

```java
String raiz = "A";
Digrafo mst = AlgoritmoPrim.getInstance().processar(raiz, grafo);
```

### Generating a Spanning Tree

```java
// Using DFS to generate a spanning tree with a specific root
Grafo arvore = digrafo.arvoreGeradoraPorProfundidade("RJ");
```

## Building the Project

This is an Eclipse Java project. To build:

### Using Eclipse
1. Import the project into Eclipse
2. The project will automatically compile

### Using Command Line
```bash
# Compile all Java files
javac -d bin src/main/java/grafo/core/*.java \
         src/main/java/grafo/search/*.java \
         src/main/java/grafo/util/*.java \
         src/main/java/aplicacao/*.java \
         src/main/TesteGrafo.java

# Run the test class
java -cp bin main.TesteGrafo
```

## Running Tests

Run the test class to see examples of all features:

```bash
java -cp bin main.TesteGrafo
```

## API Reference

### Grafo Class

| Method | Description |
|--------|-------------|
| `adicionarVertice(String rotulo)` | Add a vertex with the given label |
| `conectarVertices(String v1, String v2, Integer peso)` | Connect two vertices with an optional weight |
| `getVertices()` | Get all vertices in the graph |
| `getVertice(String rotulo)` | Get a vertex by its label |
| `getAdjacencias(String vertice)` | Get all adjacent vertices |
| `getPeso(String v1, String v2)` | Get the weight of an edge |
| `arvoreGeradoraPorProfundidade(String raiz)` | Generate a spanning tree using DFS |

### AlgoritmoDijkstra

Returns a map with distance and predecessor information for each vertex reachable from the source.

### AlgoritmoFloydWarshall

Returns a matrix with distance and intermediate vertex information for all pairs of vertices.

### AlgoritmoPrim

Returns a Minimum Spanning Tree as a `Digrafo` containing the MST edges.

## License

This project is provided as-is for educational purposes.

## Author

Graph library implementation in Java for learning and demonstration of graph algorithms.
