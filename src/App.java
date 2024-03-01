import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        Registro registro = Registro.getInstance();

        registro.cadastrarLivro("livro 1", "Author 1", LocalDate.now());
        registro.cadastrarLivro("livro 2", "Author 1", LocalDate.now());
        registro.cadastrarLivro("livro 3", "Author 1", LocalDate.now());

        System.out.println(registro.ListaDeTodosOsLivros());
    }
}
