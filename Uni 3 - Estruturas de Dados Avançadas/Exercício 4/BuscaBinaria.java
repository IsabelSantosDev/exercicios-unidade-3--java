public class BuscaBinaria {
    public int buscar(int[] arr, int x) {
        int inicio = 0, fim = arr.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (arr[meio] == x) return meio;
            if (arr[meio] < x) inicio = meio + 1;
            else fim = meio - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BuscaBinaria bb = new BuscaBinaria();
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("Posição do 40: " + bb.buscar(arr, 40));
    }
}
