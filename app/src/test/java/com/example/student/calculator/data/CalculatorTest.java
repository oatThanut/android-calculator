package com.example.student.calculator.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by jittat on 30/3/2560.
 */

public class CalculatorTest {
    Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void shouldReturnZeroAfterReset() {
        calculator.reset();
        assertEquals(0, calculator.getResult());
    }

    @Test
    public void shouldReturnValueAfterSet() {
        calculator.reset();
        calculator.setResult(1234);
        assertEquals(1234, calculator.getResult());
    }

    @Test
    public void shouldAddTwoNumbers() {
        calculator.reset();
        calculator.setResult(1234);
        assertEquals(1334, calculator.operate(calculator.OPERATOR_ADD,100));
    }

    @Test
    public void shouldAddThreeNumbers() {
        calculator.reset();
        calculator.setResult(1234);
        calculator.operate(calculator.OPERATOR_ADD,100);
        assertEquals(1834, calculator.operate(calculator.OPERATOR_ADD,500));
    }

    @Test
    public void shouldDivTwoNumber() {
        calculator.reset();
        calculator.setResult(2222);
        assertEquals(1111, calculator.operate(Calculator.OPERATOR_DIV, 2));
    }

    @Test
    public void shouldDivThreeNumber() {
        calculator.reset();
        calculator.setResult(2000);
        calculator.operate(calculator.OPERATOR_DIV,2);
        assertEquals(500, calculator.operate(Calculator.OPERATOR_DIV, 2));
    }

    @Test
    public void shouldMulTwoNumber() {
        calculator.reset();
        calculator.setResult(2222);
        assertEquals(4444, calculator.operate(Calculator.OPERATOR_MUL, 2));
    }

    @Test
    public void shouldMulThreeNumber() {
        calculator.reset();
        calculator.setResult(2000);
        calculator.operate(calculator.OPERATOR_MUL,2);
        assertEquals(8000, calculator.operate(Calculator.OPERATOR_MUL, 2));
    }

    @Test
    public void shouldReturnErrorWhenDivideByZerro(){
        calculator.reset();
        calculator.setResult(1);
        calculator.operate(calculator.OPERATOR_DIV, 0);
        assertTrue(calculator.isError());
    }
}
