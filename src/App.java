import java.time.LocalDate;
import java.util.regex.Pattern;

import controller.InputController;
import entity.Aluguel;
import entity.Usuario;

public class App {
    public static void main(String[] args) throws Exception {

        InputController input = InputController.getInstance();
        String cpf;

        do {
            System.out.println("Informe o CPF:");
            cpf = input.next();
        } while (!Pattern.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", cpf));
        /*
         * Cadastro de usuario
         * Cadastro de Livro
         * Emprestimo de Livro
         * Consultar Livro
        */
    }
}
