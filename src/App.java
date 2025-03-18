import ABB.ABB;
 import java.util.Scanner;


 public class App {
 public static void main(String[] args) {
 Scanner input = new Scanner(System.in);
 ABB<Integer> arv = new ABB<>();
 int ans;

 do {
 System.out.println("-- Menu --");
 System.out.println("(1) Adicionar");
 System.out.println("(2) Exibir em ordem");
 System.out.println("(3) Buscar");
 System.out.println("(4) Exibir menor");
 System.out.println("(5) Exibir maior");
 System.out.println("(6) Exibir por nivel");
 System.out.println("(7) Exibir quantidade de nós na árvore");
 System.out.println("(8) Exibir quantidade de folhas na árvore");
 System.out.println("(0) Sair");
 System.out.print("Escolha: ");
 ans = input.nextInt();
 input.nextLine();

 switch (ans) {
 case 1:
 System.out.print("Digite o valor a ser inserido: ");
 int valor = input.nextInt();
 arv.inserir(valor);
 break;

 case 2:
 System.out.print("Árvore em ordem: ");
 arv.inOrderNR();
 break;

 case 3:
 System.out.print("Digite o valor a buscar: ");
 int busca = input.nextInt();
 Integer resultado = arv.buscar(busca);

 if (resultado != null) {
 System.out.println("Valor encontrado: " + resultado);
 } else {
 System.out.println("Valor não encontrado.");
 }
 break;

 case 4:
 int menor = arv.exibirMenor();
 System.out.println("Menor elemento: " + menor);
 break;


 case 5:
 int maior = arv.exibirMaior();
 System.out.println("Maior elemento: " + maior);
 break;

 case 6:
 arv.porNivel();
 break;

 case 7:
 int cont = arv.contarNosNR();
 System.out.println(cont);
 break;

 case 8:
 int folhas = arv.contarFolhasNR();
 System.out.println(folhas);
 break;

 case 0:
 System.out.println("Encerrando...");
 break;
 default:
 System.out.println("Opção Inválida");
 }
 } while (ans != 0);

 input.close();
 }
 }

