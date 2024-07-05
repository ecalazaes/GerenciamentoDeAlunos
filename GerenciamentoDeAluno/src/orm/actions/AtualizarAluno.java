package orm.actions;

import orm.model.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

import static orm.actions.MainApp.retornarMenuPrincipal;

public class AtualizarAluno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();

        Aluno aluno = new Aluno();

        System.out.println("Escolhida opção 4 - Atualizar aluno(s).");
        System.out.print("Informe o ID a ser atualizado: ");
        Long id = Long.parseLong(sc.nextLine());


        aluno = manager.find(Aluno.class, id);

        if (aluno == null){
            System.out.println("Aluno não encontrado com o ID: " + id);
        } else {
            System.out.println("Informe os dados a serem atualizados");
            System.out.print("Nome: ");
            aluno.setNome(sc.nextLine());

            System.out.print("Email: ");
            aluno.setEmail(sc.nextLine());

            System.out.print("CPF: ");
            aluno.setCPF(sc.nextLine());

            System.out.print("dataNascimento (dd/MM/yyyy): ");
            aluno.setDataNascimento(sc.nextLine());

            System.out.print("Naturalidade: ");
            aluno.setNaturalidade(sc.nextLine());

            System.out.print("Endereco: ");
            aluno.setEndereco(sc.nextLine());

            manager.getTransaction().begin();
            manager.merge(aluno);
            manager.getTransaction().commit();

            System.out.println("Aluno Atualizado");
        }
        manager.close();
        factory.close();
        retornarMenuPrincipal();
        sc.close();
    }
}
