package com.example;

import org.junit.jupiter.api.Test;
import junit.framework.Assert;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

public class CalculatorTest {
    @Disabled
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result, "2 + 3 should equal 5");
        Assert.assertEquals(5, calculator.add(2, 3));

        Assert.assertEquals(5, calculator.add(3, 2));
        Assert.assertEquals(1, calculator.sub(3, 2));
        Assert.assertEquals(6, calculator.multiply(3, 2));

        // Assert.assertSame(1, calculator.div(5, 5));
        // assertThrows(0, calculator.div(5, 0));

        assertThrows(ArithmeticException.class, () -> {
            // Code that should throw the exception
            Calculator cal = new Calculator();
            cal.div(10, 0); // Example division by zero
        });
    }
}
