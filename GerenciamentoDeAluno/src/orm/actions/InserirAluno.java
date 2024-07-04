package orm.actions;

import orm.model.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

import static orm.actions.MainApp.retornarMenuPrincipal;

public class InserirAluno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int qtdAddContato;

        while (true) {
            System.out.println();
            System.out.println("Escolhida opção 1 - Inserir contato(s).");
            System.out.print("Deseja adicionar quantos contatos? ");

            if (sc.hasNextInt()) {
                qtdAddContato = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                System.out.println("Por favor, digite um número válido.");
                sc.nextLine();
            }
        }

        for (int i = 0; i < qtdAddContato; i++) {
            System.out.print("Insira o nome do Aluno [" + (i + 1) + "]: ");
            String nome = sc.nextLine();

            System.out.print("Insira o Email do Aluno [" + (i + 1) + "]: ");
            String email = sc.nextLine();

            System.out.print("Insira o CPF do Aluno [" + (i + 1) + "]: ");
            String cpf = sc.nextLine();

            System.out.print("dataNascimento (dd/MM/yyyy) do Aluno [" + (i + 1) + "]: ");
            String dataNascimento = sc.nextLine();

            System.out.print("Naturalidade do Aluno [" + (i + 1) + "]: ");
            String naturalidade = sc.nextLine();

            System.out.print("Insira o Endereço do contato [" + (i + 1) + "]: ");
            String endereco = sc.nextLine();

            System.out.println();

            Aluno aluno = new Aluno(nome, email, cpf, dataNascimento, naturalidade, endereco);

            EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
            EntityManager manager = factory.createEntityManager();

            manager.getTransaction().begin();
            manager.persist(aluno);
            manager.getTransaction().commit();

            System.out.println("Aluno Inserido, ID: " + aluno.getId());

            manager.close();

        }
        retornarMenuPrincipal();
        sc.close();
    }
}
