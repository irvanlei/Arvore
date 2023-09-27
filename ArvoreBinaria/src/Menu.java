import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private ArvoreBinaria abb;

    public Menu() {
        abb = new ArvoreBinaria();
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Inserir um valor");
            System.out.println("2. Buscar um valor");
            System.out.println("3. Remover um valor");
            System.out.println("4. Imprimir árvore");
            System.out.println("5. Sair");

            int escolha = 0;
            try {
                escolha = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Insira um número inteiro.");
                scanner.next();
                continue;
            }

            switch (escolha) {
                case 1 -> {
                    System.out.print("Digite o valor a ser inserido: ");
                    if (scanner.hasNextInt()) {
                        int valorInserir = scanner.nextInt();
                        abb.inserir(valorInserir);
                    } else {
                        System.out.println("Entrada inválida. Insira um número inteiro.");
                        scanner.next();
                    }
                }
                case 2 -> {
                    System.out.print("Digite o valor a ser buscado: ");
                    if (scanner.hasNextInt()) {
                        int valorBuscar = scanner.nextInt();
                        if (abb.buscar(valorBuscar)) {
                            System.out.println("O valor foi encontrado na árvore.");
                        } else {
                            System.out.println("O valor não foi encontrado na árvore.");
                        }
                    } else {
                        System.out.println("Entrada inválida. Insira um número inteiro.");
                        scanner.next();
                    }
                }
                case 3 -> {
                    System.out.print("Digite o valor a ser removido: ");
                    if (scanner.hasNextInt()) {
                        int valorRemover = scanner.nextInt();
                        boolean removido = abb.remover(valorRemover);
                        if (removido) {
                            System.out.println("Valor removido.");
                        } else {
                            System.out.println("O valor não está na árvore.");
                        }
                    } else {
                        System.out.println("Entrada inválida. Insira um número inteiro.");
                        scanner.next();
                    }
                }
                case 4 -> {
                    System.out.println("Árvore Binária de Busca:");
                    abb.imprimirArvore();
                }
                case 5 -> {
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
