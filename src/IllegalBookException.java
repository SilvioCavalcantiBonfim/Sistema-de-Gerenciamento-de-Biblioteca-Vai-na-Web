
public class IllegalBookException extends RuntimeException {
  public IllegalBookException(){
    super("O livro não pode ser emprestado.");
  }
}
