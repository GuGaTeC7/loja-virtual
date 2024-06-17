package com.dev.backend.util;

import java.util.regex.Pattern;

public class EmailValidator {

    // Define uma expressão regular (regex) para validar emails
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
    );

    // Método para validar se o email segue o padrão definido pela regex
    public static boolean isValidEmail(String email) {
        // Se o email for nulo, retorna falso (email inválido)
        if (email == null) {
            return false;
        }
        // Verifica se o email corresponde ao padrão da regex
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
