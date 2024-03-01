import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import entity.Estado;
import entity.Livro;

public class RegistroLivro {

  private static RegistroLivro instance = null;

  private final Set<Livro> todosLivros = new HashSet<>();

  private RegistroLivro() {
  }

  public void cadastrarLivro(String nome, String autor, LocalDate dataDePublicacao) {
    todosLivros.add(new Livro(nome, autor, dataDePublicacao));
  }

  public Set<Livro> ListaDeTodosOsLivros() {
    return Collections.unmodifiableSet(todosLivros);
  }

  public static RegistroLivro getInstance() {
    if (instance == null) {
      instance = new RegistroLivro();
    }
    return instance;
  }

  public Optional<Livro> procurarPorLivroDisponivel(String titulo) {
    return todosLivros.stream()
        .filter(livro -> livro.getNome().equalsIgnoreCase(titulo) && livro.getEstado().equals(Estado.DISPONIVEL))
        .findFirst();
  }
}
