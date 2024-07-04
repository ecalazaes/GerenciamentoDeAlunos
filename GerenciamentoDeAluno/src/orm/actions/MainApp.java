package orm.actions;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;

        while (true) {

            exibirMenu();

            if (sc.hasNextInt()) {
                op = sc.nextInt();
                if (op >= 1 && op <= 6) {
                    sc.nextLine();
                    break;
                } else {
                    System.out.println("Por favor, digite um número entre 1 a 6.");
                    sc.nextLine();
                }
            } else {
                System.out.println("Entrada incorreta, digite um número entre 1 a 6.");
                sc.nextLine();
            }
        }

        switch (op) {
            case 1:
                InserirAluno.main(new String[]{});
                break;
            case 2:
                ListarAluno.main(new String[]{});
                break;
            case 3:
                ListarAlunoLetraInicial.main(new String[]{});
                break;
            case 4:
                AtualizarAluno.main(new String[]{});
                break;
            case 5:
                RemoverAluno.main(new String[]{});
                break;
            case 6:
                System.out.println("Saindo...");
                sc.close();
                break;
        }
    }

    private static void exibirMenu() {
        System.out.println();
        System.out.println("Menu:");
        System.out.println("1. Inserir Aluno");
        System.out.println("2. Buscar todos alunos");
        System.out.println("3. Buscar alunos por inicial");
        System.out.println("4. Atualizar alunos");
        System.out.println("5. Deletar alunos");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção:  ");
    }

    public static void retornarMenuPrincipal(){
        Scanner sc = new Scanner(System.in);
        char op;
        do {
            System.out.print("Deseja voltar ao menu principal (S/N)?  ");
            op = sc.next().toUpperCase().charAt(0);

            if (op == 'S') {
                MainApp.main(new String[]{});
            } else if (op == 'N') {
                System.out.println("Saindo....");
                break;
            } else {
                System.out.println("Opção inválida. Tente Novamente.");
            }
        } while (op != 'S' && op != 'N');
        sc.close();
    }
}
