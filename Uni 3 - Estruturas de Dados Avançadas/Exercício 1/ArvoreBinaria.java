class Livro {
    String titulo;
    String autor;

    Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor;
    }
}

class No {
    Livro livro;
    No esquerda, direita;

    No(Livro livro) {
        this.livro = livro;
        this.esquerda = null;
        this.direita = null;
    }
}

class Arvore {
    No raiz;

    // Inserção de livros (baseada no título para manter BST)
    public void inserir(Livro livro) {
        raiz = inserirRec(raiz, livro);
    }

    private No inserirRec(No raiz, Livro livro) {
        if (raiz == null) {
            return new No(livro);
        }

        if (livro.titulo.compareToIgnoreCase(raiz.livro.titulo) < 0) {
            raiz.esquerda = inserirRec(raiz.esquerda, livro);
        } else if (livro.titulo.compareToIgnoreCase(raiz.livro.titulo) > 0) {
            raiz.direita = inserirRec(raiz.direita, livro);
        }

        return raiz;
    }

    // Percurso em ordem
    public void emOrdem(No raiz) {
        if (raiz != null) {
            emOrdem(raiz.esquerda);
            System.out.println(raiz.livro);
            emOrdem(raiz.direita);
        }
    }

    // Pré-ordem
    public void preOrdem(No raiz) {
        if (raiz != null) {
            System.out.println(raiz.livro);
            preOrdem(raiz.esquerda);
            preOrdem(raiz.direita);
        }
    }

    // Pós-ordem
    public void posOrdem(No raiz) {
        if (raiz != null) {
            posOrdem(raiz.esquerda);
            posOrdem(raiz.direita);
            System.out.println(raiz.livro);
        }
    }

    // Validação de BST (baseada no título dos livros)
    public boolean validarBST() {
        return validarRec(raiz, null, null);
    }

    private boolean validarRec(No no, String min, String max) {
        if (no == null) {
            return true;
        }

        if ((min != null && no.livro.titulo.compareToIgnoreCase(min) <= 0) ||
            (max != null && no.livro.titulo.compareToIgnoreCase(max) >= 0)) {
            return false;
        }

        return validarRec(no.esquerda, min, no.livro.titulo) &&
               validarRec(no.direita, no.livro.titulo, max);
    }
}

public class ArvoreBinaria {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();

        arvore.inserir(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien"));
        arvore.inserir(new Livro("Dom Casmurro", "Machado de Assis"));
        arvore.inserir(new Livro("Harry Potter", "J.K. Rowling"));
        arvore.inserir(new Livro("A Revolução dos Bichos", "George Orwell"));

        System.out.println("Percurso EM ORDEM:");
        arvore.emOrdem(arvore.raiz);

        System.out.println("\nPercurso PRÉ-ORDEM:");
        arvore.preOrdem(arvore.raiz);

        System.out.println("\nPercurso PÓS-ORDEM:");
        arvore.posOrdem(arvore.raiz);

        System.out.println("\nA árvore é uma BST válida? " + arvore.validarBST());
    }
}
