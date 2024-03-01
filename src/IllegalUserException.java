
public class IllegalUserException extends RuntimeException {
  public IllegalUserException(){
    super("Usuario não pode ser nulo.");
  }
}
