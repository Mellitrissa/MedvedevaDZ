package org.example;

import org.junit.Test;

import java.math.BigInteger;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestFactorial {

    @Test
    public void factorial (){
        assertEquals(BigInteger.ONE,FactorialNumber.factorial(0));
        assertEquals(BigInteger.ONE,FactorialNumber.factorial(1));
        assertEquals(new BigInteger("479001600"), FactorialNumber.factorial(12));
        assertEquals(new BigInteger("2432902008176640000"), FactorialNumber.factorial(20));
    }
    @Test
    public void factorialNegative(){
        try {
            FactorialNumber.factorial(-1);
        } catch (IllegalArgumentException e) {
            assertEquals("Факториал отрицательного числа не определен.", e.getMessage());
        }
    }




}
