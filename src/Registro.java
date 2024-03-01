import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import entity.Estado;
import entity.Livro;
import entity.Usuario;

public class Registro {

  private static Registro instance = null;

  private Registro(){}

  private final Set<Livro> todosLivros = new HashSet<>();
  private final Map<String, Usuario> usuarios = new HashMap<>();

  private final Map<Usuario, List<Livro>> usuarioParaLivros = new HashMap<>();
  private final Map<Livro, Usuario> livroParaUsuario = new HashMap<>();

  public void cadastrarLivro(String nome, String autor, LocalDate dataDePublicacao){
    todosLivros.add(new Livro(nome, autor, dataDePublicacao));
  }
  public void cadastrarUsuario(String nome, String cpf, String email, String telefone){
    Usuario usuario = new Usuario(nome, cpf, email, telefone);
    usuarios.put(cpf, usuario);
  }

  public Optional<Usuario> consultarUsuario(String cpf){
    return Optional.ofNullable(usuarios.get(cpf));
  }

  public Set<Livro> ListaDeTodosOsLivros(){
    return Collections.unmodifiableSet(todosLivros);
  }
  
  public void alugar(Usuario usuario, Livro livro){
    if (Objects.isNull(usuario)) {
      throw new IllegalUserException();
    }
    usuarioParaLivros.get(usuario).add(livro);
    livroParaUsuario.put(livro, usuario);
    livro.setEstado(Estado.ALUGADO);
  }

  public void devolver(Livro livro){
    if(livro.getEstado().equals(Estado.NAO_ALUGADO)){
      throw new IllegalBookException();
    }

    Usuario usuario = livroParaUsuario.get(livro);

    livroParaUsuario.remove(livro);
    usuarioParaLivros.get(usuario).remove(livro);

    livro.setEstado(Estado.NAO_ALUGADO);

  }

  public static Registro getInstance(){
    if (instance == null) {
      instance = new Registro();
    }
    return instance;
  }
}
