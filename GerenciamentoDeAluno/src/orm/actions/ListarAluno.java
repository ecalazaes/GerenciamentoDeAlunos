package orm.actions;

import orm.model.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

import static orm.actions.MainApp.retornarMenuPrincipal;

public class ListarAluno {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();

        String sql = "select a from Aluno a";
        Query query = manager.createQuery(sql);

        List<Aluno> listaAlunos = query.getResultList();

        if (!listaAlunos.isEmpty()){
            System.out.println("Escolhida opção 2 - Listar de contato(s).");
            System.out.println("A lista de contatos possui " + listaAlunos.size() + " contato(s).");
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
            System.out.println("Nenhum aluno encontrado");
        }
        retornarMenuPrincipal();
    }
}
