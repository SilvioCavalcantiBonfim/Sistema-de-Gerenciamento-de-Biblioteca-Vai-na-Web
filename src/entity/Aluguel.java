package entity;

import java.time.LocalDate;

public class Aluguel {
  private final Livro livro;
  private final Usuario usuario;
  private final LocalDate dataAluguel;

  public Aluguel(Livro livro, Usuario usuario) {
    this.livro = livro;
    this.usuario = usuario;
    dataAluguel = LocalDate.now();
  }

  public LocalDate dataRetorno() {
    return dataAluguel.plusWeeks(2);
  }

  public Livro getLivro() {
    return livro;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public LocalDate getDataAluguel() {
    return dataAluguel;
  }

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((livro == null) ? 0 : livro.hashCode());
    result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Aluguel other = (Aluguel) obj;
    if (livro == null) {
        if (other.livro != null)
            return false;
    } else if (!livro.equals(other.livro))
        return false;
    if (usuario == null) {
        if (other.usuario != null)
            return false;
    } else if (!usuario.equals(other.usuario))
        return false;
    return true;
}

  
}
