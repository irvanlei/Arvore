public class ArvoreBinaria {
    private Node raiz;
    private int valorRemovido;
    private Node novoNoRaiz;
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

        if (valor >= raiz.getValor()) {
            raiz.setDireita(inserirRec(raiz.getDireita(), valor));
        } else {
            raiz.setEsquerda(inserirRec(raiz.getEsquerda(), valor));
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
            valorRemovido = valor;
            novoNoRaiz = raiz;
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
            if (raiz.getEsquerda() != null && raiz.getDireita() != null) {
                raiz.setValor(encontrarMaximo(raiz.getEsquerda()));
                raiz.setEsquerda(removerRec(raiz.getEsquerda(), raiz.getValor()));
            } else {
                if (raiz.getEsquerda() != null) {
                    raiz = raiz.getEsquerda();
                } else {
                    raiz = raiz.getDireita();
                }
            }
        }

        return raiz;
    }

    private int encontrarMaximo(Node raiz) {
        while (raiz.getDireita() != null) {
            raiz = raiz.getDireita();
        }
        return raiz.getValor();
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
    public int getValorRemovido() {
        return valorRemovido;
    }
    public Node getNovoNoRaiz() {
        return novoNoRaiz;
    }
}
