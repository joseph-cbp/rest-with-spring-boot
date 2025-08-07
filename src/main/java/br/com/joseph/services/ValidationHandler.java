package br.com.joseph.services;

import br.com.joseph.exceptions.UnsupportedMathOperationException;

public class ValidationHandler {
public static Boolean isNumber(String number) throws Exception {
        if (number == null || number.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric Value");

        String srtNumber = number.replace(",", ".");

        return srtNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public static Double convertToDouble(String number) {
        return Double.parseDouble(number);
    }
}
