package test.java.calc;

import main.java.coins.Calculator;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void shouldReturnZeroWhenEmptyStringPassed() {
        // given
        String emptyString = "";

        // when
        int result = Calculator.add(emptyString);

        // then
        assertEquals(0, result);
    }

    @Test
    public void shouldReturnNumberWhenSingleNumberPassed() {
        // given
        String singleNumber = "5";

        // when
        int result = Calculator.add(singleNumber);

        // then
        assertEquals(5, result);
    }

    @Test
    public void shouldAddTwoNumbers() {
        // given
        String numbers = "1,2";

        // when
        int result = Calculator.add(numbers);

        // then
        Assert.assertEquals(3, result);
    }

    @Test
    public void shouldAddMultipleNumbers() {
        // given
        String numbers = "1,2,3,4,5";

        // when
        int result = Calculator.add(numbers);

        // then
        Assert.assertEquals(1 + 2 + 3 + 4 + 5, result);
    }

    @Test(expected = NumberFormatException.class)
    public void shouldThrowExceptionWhenNotNumberIsPassed() {
        // given
        String notNumbers = "1, X";

        // when
        Calculator.add(notNumbers);
    }

    @Test
    public void shouldHandleNewLinesBetweenNumbersInsteadOfComma() {
        // given
        String numbers = "1,2\n3";

        // when
        int result = Calculator.add(numbers);

        // then
        Assert.assertEquals(1 + 2 + 3, result);
    }

    @Test
    public void shouldThrowExceptionWhenNegativeNumberIsPassed() {
        // given
        String numbers = "-1,-2";
        RuntimeException exception = null;

        // when
        try {
            Calculator.add(numbers);
        } catch (RuntimeException ex) {
            exception = ex;
        }

        // then
        Assert.assertNotNull(exception);
        Assert.assertEquals("Negatives not allowed: [-1, -2]", exception.getMessage());
    }

    @Test
    public void shouldIgnoreNumbersLargerThan1000() {
        // given
        String numbers = "1,2,1000,1001";

        // when
        int result = Calculator.add(numbers);

        // then
        Assert.assertEquals(1 + 2 + 1000, result);
    }
}