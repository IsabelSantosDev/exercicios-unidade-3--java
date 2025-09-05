class NoBST {
    int valor;
    NoBST esquerda, direita;

    NoBST(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
}

class ArvoreBST {
    NoBST raiz;

    // Inserir elemento seguindo as regras da BST
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private NoBST inserirRec(NoBST raiz, int valor) {
        if (raiz == null) {
            return new NoBST(valor);
        }
        if (valor < raiz.valor) {
            raiz.esquerda = inserirRec(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = inserirRec(raiz.direita, valor);
        }
        return raiz;
    }

    public boolean validarBST() {
        return validarRec(raiz, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validarRec(NoBST no, int min, int max) {
        if (no == null) {
            return true;
        }
        if (no.valor <= min || no.valor >= max) {
            return false;
        }
        return validarRec(no.esquerda, min, no.valor) &&
               validarRec(no.direita, no.valor, max);
    }
}

public class ValidacaoBST {
    public static void main(String[] args) {
        ArvoreBST arvore = new ArvoreBST();

        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);

        System.out.println("A árvore é uma BST válida? " + arvore.validarBST());
    }
}
