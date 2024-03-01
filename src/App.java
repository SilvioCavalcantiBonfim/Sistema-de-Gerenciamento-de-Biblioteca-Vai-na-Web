import java.time.LocalDate;

import entity.Aluguel;
import entity.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        RegistroLivro registro = RegistroLivro.getInstance();

        registro.cadastrarLivro("livro 1", "Author 1", LocalDate.now());
        registro.cadastrarLivro("livro 2", "Author 1", LocalDate.now());
        registro.cadastrarLivro("livro 3", "Author 1", LocalDate.now());


        registro.ListaDeTodosOsLivros().stream().forEach(livro ->  System.out.println(livro.getNome()));

        Usuario user = new Usuario("Marlon", "123", "marlon@email.com", "123456789");

        Aluguel aluguel = new Aluguel(registro.procurarPorLivroDisponivel("livro 1").get(), user, LocalDate.now());

        System.out.println(aluguel.dataRetorno());
    }
}
