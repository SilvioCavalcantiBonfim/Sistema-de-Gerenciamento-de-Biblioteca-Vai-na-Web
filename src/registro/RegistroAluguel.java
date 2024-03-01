package registro;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import entity.Aluguel;
import static entity.Estado.DISPONIVEL;
import static entity.Estado.ALUGADO;
import entity.Livro;
import entity.Usuario;
import exception.IllegalBookException;

public class RegistroAluguel {

    private static RegistroAluguel instance = null;

    private Set<Aluguel> todosOsAlugueis = new HashSet<>();

    private RegistroAluguel() {
    }

    public void alugar(Usuario usuario, Livro livro) {
        if (livro.getEstado().equals(ALUGADO)) {
            throw new IllegalBookException();
        }

        Aluguel aluguel = new Aluguel(livro, usuario);
        todosOsAlugueis.add(aluguel);
        livro.setEstado(ALUGADO);
    }

    public void devolver(Usuario usuario, Livro livro) {
        todosOsAlugueis.remove(new Aluguel(livro, usuario));
        livro.setEstado(DISPONIVEL);
    }

    public Set<Aluguel> ListaDeAtrasos() {
        return todosOsAlugueis.stream().filter(aluguel -> aluguel.dataRetorno().isAfter(LocalDate.now()))
                .collect(Collectors.toSet());
    }

    public RegistroAluguel getInstance() {
        if (Objects.isNull(instance)) {
            instance = new RegistroAluguel();
        }
        return instance;
    }
}
