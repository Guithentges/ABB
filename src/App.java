import java.util.Scanner;
import Dados.Cadastro;
import Dados.Produto;
import ABB.ABB;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Cadastro cadastro = new Cadastro();
        int ans;

        do {
            System.out.println("-- Menu --");
            System.out.println("(1) Adicionar Produto");
            System.out.println("(2) Exibir Produtos em ordem crescente de código");
            System.out.println("(3) Buscar Produto");
            System.out.println("(4) Exibir Produto com o menor código");
            System.out.println("(5) Exibir Produto com o maior código");
            System.out.println("(6) Exibir Produtos por nível");
            System.out.println("(7) Contar total de produtos na árvore");
            System.out.println("(8) Contar produtos sem filhos (folhas)");
            System.out.println("(0) Sair");
            System.out.print("Escolha: ");
            ans = input.nextInt();
            input.nextLine();

            switch (ans) {
                case 1:
                    System.out.print("Código: ");
                    String codigo = input.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = input.nextLine();
                    System.out.print("Fornecedor: ");
                    String fornecedor = input.nextLine();
                    System.out.print("Preço: ");
                    double preco = input.nextDouble();
                    System.out.print("Quantidade em estoque: ");
                    int quantidade = input.nextInt();

                    cadastro.cadastrarProduto(codigo, descricao, fornecedor, preco, quantidade);
                    break;

                case 2:
                    System.out.println("Produtos em ordem de código:");
                    cadastro.exibirProdutos();
                    break;

                case 3:
                    System.out.print("Digite o código do produto a buscar: ");
                    codigo = input.nextLine();
                    Produto produtoEncontrado = cadastro.buscarProduto(codigo);
                    if (produtoEncontrado != null) {
                        System.out.println("Produto encontrado: " + produtoEncontrado);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 4:
                    Produto produtoMenor = cadastro.exibirMenorProduto();
                    if (produtoMenor != null) {
                        System.out.println("Produto com menor código: " + produtoMenor);
                    } else {
                        System.out.println("Nenhum produto cadastrado.");
                    }
                    break;

                case 5:
                    Produto produtoMaior = cadastro.exibirMaiorProduto();
                    if (produtoMaior != null) {
                        System.out.println("Produto com maior código: " + produtoMaior);
                    } else {
                        System.out.println("Nenhum produto cadastrado.");
                    }
                    break;

                case 6:
                    cadastro.exibirPorNivel();
                    break;

                case 7:
                    int totalProdutos = cadastro.contarProdutos();
                    System.out.println("Total de produtos cadastrados: " + totalProdutos);
                    break;

                case 8:
                    int totalFolhas = cadastro.contarFolhas();
                    System.out.println("Total de produtos sem filhos (folhas): " + totalFolhas);
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (ans != 0);

        input.close();
    }
}
