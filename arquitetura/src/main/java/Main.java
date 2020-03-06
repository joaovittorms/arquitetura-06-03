import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

  private static List<String> usuarios;
  private static Scanner scanner;
  private static boolean aberto;

  public static void main(String[] args) {
    scanner = new Scanner(System.in);
    usuarios = new ArrayList<String>();
    aberto = true;
    carregarMenu();
  }

  private static void exibeMenu() {
    System.out.println("1 - Criar usuário");
    System.out.println("2 - Exibir usuário");
    System.out.println("0 - Sair");
  }

  private static void carregarMenu() {
    while (aberto) {
      exibeMenu();
      String opcao = scanner.nextLine();
      if (opcao.equals("1")) {
        criarUsuario();
        System.out.println("Aluno Criado");
      } else if (opcao.equals("2")) {
        exibirUsuarios();
      } else if (opcao.equals("0")) {
        aberto = false;
      } else {
        System.out.println("Opção inválida!");
        exibeMenu();
        opcao = scanner.nextLine();
      }
    }
  }

  private static void criarUsuario() {
    System.out.println("Digite o nome completo do aluno: ");
    String nome = scanner.nextLine();
    Optional<String> found = usuarios.stream().filter(e -> e.trim().toLowerCase().equals(nome.toLowerCase().trim() )).findAny();
    if (!found.isPresent()) {
      usuarios.add(nome);
    } else {
      System.out.println("Este aluno já está cadastrado!");
      criarUsuario();
    }
  }

  private static void exibirUsuarios() {
    System.out.println("LISTA DE USUÁRIOS");
    usuarios.forEach(e -> System.out.println("NOME: " + e));
    System.out.println("");
  }

}
