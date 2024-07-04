package orm.actions;

import orm.model.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

import static orm.actions.MainApp.retornarMenuPrincipal;

public class RemoverAluno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();

        Aluno aluno = new Aluno();

        System.out.println("Escolhida opção 5 - Remover aluno(s).");
        System.out.print("Informe o ID a ser removido: ");
        Long id = Long.parseLong(sc.nextLine());

        aluno = manager.find(Aluno.class, id);

        if (aluno == null){
            System.out.println("Esse aluno não existe!");
        } else {
            manager.getTransaction().begin();
            manager.remove(aluno);
            manager.getTransaction().commit();

            System.out.println("Aluno Excluído");
        }
        manager.close();
        factory.close();
        retornarMenuPrincipal();
        sc.close();
    }
}
