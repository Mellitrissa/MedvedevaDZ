package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigInteger;

public class TestFactorial {
    @Test
    public void factorial(){
        Assert.assertEquals (BigInteger.ONE,FactorialNumber.factorial(0));
        Assert.assertEquals(BigInteger.ONE,FactorialNumber.factorial(1));
        Assert.assertEquals(new BigInteger("479001600"), FactorialNumber.factorial(12));
        Assert.assertEquals(new BigInteger("2432902008176640000"), FactorialNumber.factorial(20));
    }
    @Test
    public void negativeFactorial(){
        try {
            FactorialNumber.factorial(-1);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Факториал отрицательного числа не определен.", e.getMessage());
        }

    }

}
