import java.util.*;

public class Grafo {
    Map<Integer, List<Integer>> adj = new HashMap<>();

    public void adicionarAresta(int origem, int destino) {
        adj.putIfAbsent(origem, new ArrayList<>());
        adj.get(origem).add(destino);
    }

    public void imprimir() {
        for (int v : adj.keySet()) {
            System.out.println(v + " -> " + adj.get(v));
        }
    }

    public static void main(String[] args) {
        Grafo g = new Grafo();
        g.adicionarAresta(1, 2);
        g.adicionarAresta(1, 3);
        g.adicionarAresta(2, 4);
        g.imprimir();
    }
}
