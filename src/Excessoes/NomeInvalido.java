package Excessoes;

import java.util.regex.Pattern;

public class NomeInvalido extends Exception {
    public NomeInvalido() {
    }

    public NomeInvalido(String message) {
        super(message);
    }

    public void verificaNome(String nome) throws NomeInvalido {
        String regex = "^[A-Za-z][a-z]{2,}( [A-Za-z][a-z]{2,})?$";
        if (!Pattern.matches(regex, nome)) {
            throw new NomeInvalido(
                    "O nome inserido é inválido! Para ser válido, o nome deve conter apenas letras e no máximo um espaço.");
        }
    }
}
