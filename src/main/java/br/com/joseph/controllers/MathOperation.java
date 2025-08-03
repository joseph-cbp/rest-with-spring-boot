package br.com.joseph.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joseph.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/math")
public class MathOperation {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double[] sum(
        @PathVariable("numberOne") String numberOne, 
        @PathVariable("numberTwo") String numberTwo
        ) throws Exception {
            if (!isNumber(numberOne) || !isNumber(numberTwo)) throw new UnsupportedMathOperationException("is not a Number");

            Double number1 = convertToDouble(numberOne);
            Double number2 = convertToDouble(numberTwo);
            Double[] arrDoubles = {number1, number2, (number1 + number2)};
            return arrDoubles;
    }

    @RequestMapping("/subtract/{numberOne}/{numberTwo}")
    public Double subtract(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
        
    ) throws Exception {
        if (!isNumber(numberOne) || !isNumber(numberTwo)) throw new UnsupportedMathOperationException("Is not a Number");

        Double firstNumber = convertToDouble(numberOne);
        Double secondNumber = convertToDouble(numberTwo);

        return firstNumber - secondNumber;
    };

    public Boolean isNumber(String number) throws Exception {
        if (number == null || number.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric Value");

        String srtNumber = number.replace(",", ".");

        return srtNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public Double convertToDouble(String number) {
        return Double.parseDouble(number);
    }
}
