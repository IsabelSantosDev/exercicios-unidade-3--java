public class BuscaLinear {
    public int buscar(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        BuscaLinear bl = new BuscaLinear();
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("Posição do 30: " + bl.buscar(arr, 30));
    }
}
