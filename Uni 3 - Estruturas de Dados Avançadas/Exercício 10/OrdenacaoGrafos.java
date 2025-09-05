import java.util.*;

class GrafoTopologico {
    private int vertices;
    private LinkedList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public GrafoTopologico(int vertices) {
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) adj[i] = new LinkedList<>();
    }

    public void adicionarAresta(int origem, int destino) {
        adj[origem].add(destino);
    }

    public void ordenacaoTopologica() {
        boolean[] visitado = new boolean[vertices];
        Stack<Integer> pilha = new Stack<>();

        for (int i = 0; i < vertices; i++)
            if (!visitado[i])
                dfs(i, visitado, pilha);

        System.out.print("Ordenação topológica: ");
        while (!pilha.isEmpty())
            System.out.print(pilha.pop() + " ");
        System.out.println();
    }

    private void dfs(int v, boolean[] visitado, Stack<Integer> pilha) {
        visitado[v] = true;
        for (int vizinho : adj[v])
            if (!visitado[vizinho])
                dfs(vizinho, visitado, pilha);
        pilha.push(v);
    }
}

public class OrdenacaoGrafos {
    public static void main(String[] args) {
        GrafoTopologico grafo = new GrafoTopologico(6);
        grafo.adicionarAresta(5, 2);
        grafo.adicionarAresta(5, 0);
        grafo.adicionarAresta(4, 0);
        grafo.adicionarAresta(4, 1);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 1);

        grafo.ordenacaoTopologica();
    }
}
