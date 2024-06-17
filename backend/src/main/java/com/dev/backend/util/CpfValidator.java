package com.dev.backend.util;

public class CpfValidator {

    public static boolean isValidCPF(String cpf) {
        // Remover caracteres não numéricos
        cpf = cpf.replaceAll("\\D", "");

        // Verificar se possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verificar se todos os dígitos são iguais (ex: 111.111.111-11)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Cálculo do primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int firstCheckDigit = 11 - (sum % 11);
        firstCheckDigit = (firstCheckDigit > 9) ? 0 : firstCheckDigit;

        // Verificação do primeiro dígito verificador
        if (firstCheckDigit != Character.getNumericValue(cpf.charAt(9))) {
            return false;
        }

        // Cálculo do segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int secondCheckDigit = 11 - (sum % 11);
        secondCheckDigit = (secondCheckDigit > 9) ? 0 : secondCheckDigit;

        // Verificação do segundo dígito verificador
        return secondCheckDigit == Character.getNumericValue(cpf.charAt(10));
    }
}
