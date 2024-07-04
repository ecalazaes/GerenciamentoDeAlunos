package orm.actions;

import orm.model.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

import static orm.actions.MainApp.retornarMenuPrincipal;

public class ListarAlunoLetraInicial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escolhida opção 3 - Lista de contato(s).");
        System.out.print("Digite uma letra para buscar alunos iniciados por: ");
        String inicial = sc.nextLine();

        List<Aluno> listaAlunos = ListarAlunoLetraInicial.buscaLetra(inicial);

        if (!listaAlunos.isEmpty()) {
            System.out.println("A lista de contatos com inicial " + inicial.toUpperCase() + " possui " + listaAlunos.size() + " aluno(s).");
            System.out.println("===============================");
            for (Aluno aluno : listaAlunos) {
                System.out.println(aluno.getNome());
                System.out.println(aluno.getEmail());
                System.out.println(aluno.getCPF());
                System.out.println(aluno.getDataNascimento());
                System.out.println(aluno.getNatualidade());
                System.out.println(aluno.getEndereco());
                System.out.println("===============================");
            }
        } else {
            System.out.println("Aluno não encontrado com a inicial: " + inicial);
        }
        retornarMenuPrincipal();
    }

    public static List<Aluno> buscaLetra(String letra) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("select a from Aluno as a where a.nome like :parametro");
        query.setParameter("parametro", letra + "%");

        @SuppressWarnings("unchecked")
        List<Aluno> alunos = query.getResultList();

        manager.close();
        factory.close();

        return alunos;
    }


}
