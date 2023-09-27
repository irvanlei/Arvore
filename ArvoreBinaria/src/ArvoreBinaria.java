public class ArvoreBinaria {
    private Node raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private Node inserirRec(Node raiz, int valor) {
        if (raiz == null) {
            raiz = new Node(valor);
            return raiz;
        }

        if (valor < raiz.getValor()) {
            raiz.setEsquerda(inserirRec(raiz.getEsquerda(), valor));
        } else if (valor > raiz.getValor()) {
            raiz.setDireita(inserirRec(raiz.getDireita(), valor));
        }

        return raiz;
    }

    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(Node raiz, int valor) {
        if (raiz == null) {
            return false;
        }

        if (raiz.getValor() == valor) {
            return true;
        }

        if (valor < raiz.getValor()) {
            return buscarRec(raiz.getEsquerda(), valor);
        } else {
            return buscarRec(raiz.getDireita(), valor);
        }
    }

    public boolean remover(int valor) {
        if (buscar(valor)) {
            raiz = removerRec(raiz, valor);
            return true;
        } else {
            return false;
        }
    }


    private Node removerRec(Node raiz, int valor) {
        if (raiz == null) {
            return raiz;
        }

        if (valor < raiz.getValor()) {
            raiz.setEsquerda(removerRec(raiz.getEsquerda(), valor));
        } else if (valor > raiz.getValor()) {
            raiz.setDireita(removerRec(raiz.getDireita(), valor));
        } else {
            if (raiz.getEsquerda() == null) {
                return raiz.getDireita();
            } else if (raiz.getDireita() == null) {
                return raiz.getEsquerda();
            }

            raiz.setValor(valorMinimo(raiz.getDireita()));

            raiz.setDireita(removerRec(raiz.getDireita(), raiz.getValor()));
        }

        return raiz;
    }

    private int valorMinimo(Node raiz) {
        int valorMinimo = raiz.getValor();
        while (raiz.getEsquerda() != null) {
            valorMinimo = raiz.getEsquerda().getValor();
            raiz = raiz.getEsquerda();
        }
        return valorMinimo;
    }

    public void imprimirArvore() {
        imprimirArvore(raiz, "");
    }

    private void imprimirArvore(Node raiz, String prefixo) {
        if (raiz != null) {
            imprimirArvore(raiz.getDireita(), prefixo + "\t");
            System.out.println(prefixo + raiz.getValor());
            imprimirArvore(raiz.getEsquerda(), prefixo + "\t");
        }
    }
}







