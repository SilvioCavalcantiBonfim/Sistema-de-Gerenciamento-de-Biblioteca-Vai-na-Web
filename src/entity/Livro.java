package entity;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Livro {

  private static AtomicInteger count = new AtomicInteger();

  private Integer id;
  private final String nome;
  private final String Autor;
  private final LocalDate dataDePublicacao;
  private Estado estado;

  public Livro(String nome, String autor, LocalDate dataDePublicacao, Estado estado) {
    this.id = count.getAndIncrement();
    this.nome = nome;
    Autor = autor;
    this.dataDePublicacao = dataDePublicacao;
    this.estado = estado;
  }

  public Livro(String nome, String autor, LocalDate dataDePublicacao) {
    this(nome, autor, dataDePublicacao, Estado.DISPONIVEL);
  }

  public String getNome() {
    return nome;
  }

  public String getAutor() {
    return Autor;
  }

  public LocalDate getDataDePublicacao() {
    return dataDePublicacao;
  }

  public Estado getEstado() {
    return estado;
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
  }

  @Override
  public String toString() {
    return "Livro [id=" + id + ", nome=" + nome + ", Autor=" + Autor + ", dataDePublicacao=" + dataDePublicacao + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + ((Autor == null) ? 0 : Autor.hashCode());
    result = prime * result + ((dataDePublicacao == null) ? 0 : dataDePublicacao.hashCode());
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
    Livro other = (Livro) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (Autor == null) {
      if (other.Autor != null)
        return false;
    } else if (!Autor.equals(other.Autor))
      return false;
    if (dataDePublicacao == null) {
      if (other.dataDePublicacao != null)
        return false;
    } else if (!dataDePublicacao.equals(other.dataDePublicacao))
      return false;
    return true;
  }

}
