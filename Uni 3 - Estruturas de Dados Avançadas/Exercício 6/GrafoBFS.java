import java.util.*;

class Grafo {
    private int vertices; // número de vértices
    private LinkedList<Integer>[] listaAdj; // lista de adjacências

    @SuppressWarnings("unchecked")
    public Grafo(int vertices) {
        this.vertices = vertices;
        listaAdj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            listaAdj[i] = new LinkedList<>();
        }
    }

    // Adiciona uma aresta (não direcionada)
    public void adicionarAresta(int origem, int destino) {
        listaAdj[origem].add(destino);
        listaAdj[destino].add(origem);
    }

    // BFS - Busca em Largura
    public void bfs(int inicio) {
        boolean[] visitado = new boolean[vertices];
        Queue<Integer> fila = new LinkedList<>();

        visitado[inicio] = true;
        fila.add(inicio);

        System.out.print("BFS a partir do vértice " + inicio + ": ");

        while (!fila.isEmpty()) {
            int vertice = fila.poll();
            System.out.print(vertice + " ");

            for (int vizinho : listaAdj[vertice]) {
                if (!visitado[vizinho]) {
                    visitado[vizinho] = true;
                    fila.add(vizinho);
                }
            }
        }
        System.out.println();
    }
}

public class GrafoBFS {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(6); // cria grafo com 6 vértices

        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(2, 4);
        grafo.adicionarAresta(3, 5);

        System.out.println("Executando BFS:");
        grafo.bfs(0); // inicia BFS no vértice 0
    }
}
