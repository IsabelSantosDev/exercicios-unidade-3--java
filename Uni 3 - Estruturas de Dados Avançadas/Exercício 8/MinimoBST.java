class Produto {
    String nome;
    double preco;

    Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nome + " - R$" + preco;
    }
}

class NoProduto {
    Produto produto;
    NoProduto esquerda, direita;

    NoProduto(Produto produto) {
        this.produto = produto;
        esquerda = direita = null;
    }
}

class BST {
    NoProduto raiz;

    // Inserção baseada no preço
    public void inserir(Produto produto) {
        raiz = inserirRec(raiz, produto);
    }

    private NoProduto inserirRec(NoProduto no, Produto produto) {
        if (no == null) return new NoProduto(produto);
        if (produto.preco < no.produto.preco) no.esquerda = inserirRec(no.esquerda, produto);
        else no.direita = inserirRec(no.direita, produto);
        return no;
    }

    // Encontrar o menor preço
    public Produto minimo() {
        if (raiz == null) return null;
        NoProduto atual = raiz;
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual.produto;
    }
}

public class MinimoBST {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.inserir(new Produto("Notebook", 4500));
        bst.inserir(new Produto("Mouse", 50));
        bst.inserir(new Produto("Teclado", 150));
        bst.inserir(new Produto("Monitor", 900));

        System.out.println("Produto mais barato: " + bst.minimo());
    }
}
