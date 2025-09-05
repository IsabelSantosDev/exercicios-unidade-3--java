import java.util.*;

class GrafoPonderado {
    private int vertices;
    private LinkedList<int[]>[] adj;

    @SuppressWarnings("unchecked")
    public GrafoPonderado(int vertices) {
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) adj[i] = new LinkedList<>();
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        adj[origem].add(new int[]{destino, peso});
    }

    public void dijkstra(int inicio) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[inicio] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{inicio, 0});

        while (!pq.isEmpty()) {
            int[] atual = pq.poll();
            int v = atual[0];
            int d = atual[1];

            if (d > dist[v]) continue;

            for (int[] vizinho : adj[v]) {
                int u = vizinho[0], peso = vizinho[1];
                if (dist[v] + peso < dist[u]) {
                    dist[u] = dist[v] + peso;
                    pq.add(new int[]{u, dist[u]});
                }
            }
        }

        System.out.println("Distâncias a partir do vértice " + inicio + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vértice " + i + ": " + dist[i]);
        }
    }
}

public class CaminhoMaisCurto {
    public static void main(String[] args) {
        GrafoPonderado grafo = new GrafoPonderado(5);

        grafo.adicionarAresta(0, 1, 10);
        grafo.adicionarAresta(0, 4, 5);
        grafo.adicionarAresta(1, 2, 1);
        grafo.adicionarAresta(4, 1, 3);
        grafo.adicionarAresta(4, 2, 9);
        grafo.adicionarAresta(2, 3, 4);
        grafo.adicionarAresta(3, 0, 7);

        grafo.dijkstra(0);
    }
}
