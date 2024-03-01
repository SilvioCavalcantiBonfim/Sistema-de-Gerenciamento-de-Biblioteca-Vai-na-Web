package registro;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import entity.Usuario;

public class RegistroUsuario {
  private final Map<String, Usuario> todosOsUsuarios = new HashMap<>();
  private static RegistroUsuario instance = null;

  private RegistroUsuario() {
  }

  public void cadastrarUsuario(String nome, String cpf, String email, String telefone) {
    Usuario usuario = new Usuario(nome, cpf, email, telefone);
    todosOsUsuarios.put(cpf, usuario);
  }

  public Optional<Usuario> buscarUsuario(String cpf){
    return Optional.ofNullable(todosOsUsuarios.get(cpf));
  }

  public static RegistroUsuario getInstance() {
    if (instance == null) {
      instance = new RegistroUsuario();
    }
    return instance;
  }

}