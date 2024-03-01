package entity;

import java.time.LocalDate;

public record Aluguel(
  Livro livro,
  Usuario usuario,
  LocalDate dataAluguel
) {
  public LocalDate dataRetorno(){
    return dataAluguel.plusWeeks(2);
  }
}
