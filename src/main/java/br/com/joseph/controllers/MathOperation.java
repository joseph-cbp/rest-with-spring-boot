package br.com.joseph.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joseph.exceptions.UnsupportedMathOperationException;
import br.com.joseph.services.ValidationHandler;



@RestController
@RequestMapping("/math")
public class MathOperation {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double[] sum(
        @PathVariable("numberOne") String numberOne, 
        @PathVariable("numberTwo") String numberTwo
        ) throws Exception {
            if (!ValidationHandler.isNumber(numberOne) || !ValidationHandler.isNumber(numberTwo)) throw new UnsupportedMathOperationException("is not a Number");

            Double firstNumber = ValidationHandler.convertToDouble(numberOne);
            Double secondNumber = ValidationHandler.convertToDouble(numberOne);
            Double[] arrDoubles = {firstNumber, secondNumber, (firstNumber + secondNumber)};
            return arrDoubles;
    }

    @RequestMapping("/subtract/{numberOne}/{numberTwo}")
    public Double subtract(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
        
    ) throws Exception {
        if (!ValidationHandler.isNumber(numberOne) || !ValidationHandler.isNumber(numberTwo)) throw new UnsupportedMathOperationException("Is not a Number");

        Double firstNumber = ValidationHandler.convertToDouble(numberOne);
        Double secondNumber = ValidationHandler.convertToDouble(numberTwo);

        return firstNumber - secondNumber;
    };
}
