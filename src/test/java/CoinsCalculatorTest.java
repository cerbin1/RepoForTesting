package test.java;

import main.java.CoinsCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CoinsCalculatorTest {

    @Test
    public void shouldGetCorrectValueForCommonPrice() {
        // given
        CoinsCalculator coinsCalculator = new CoinsCalculator(500, 200, 100, 50, 25, 20, 10, 5, 2, 1);
        int price = 330;

        // when
        Integer[] result = coinsCalculator.count(price);

        // then
        Assert.assertEquals(new Integer[]{200, 100, 25, 5}, result);
    }

    @Test
    public void shouldReturnNoCoinsForZeroPrice() {
        // given
        CoinsCalculator coinsCalculator = new CoinsCalculator(500, 200, 100, 50, 25, 20, 10, 5, 2, 1);
        int price = 0;

        // when
        Integer[] result = coinsCalculator.count(price);

        // then
        Assert.assertEquals(new Integer[]{}, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenPriceIsNegative() {
        // given
        CoinsCalculator coinsCalculator = new CoinsCalculator(500, 200, 100, 50, 25, 20, 10, 5, 2, 1);

        // when
        coinsCalculator.count(-1);
    }

    @Test
    public void shouldReturnCorrectCoinsWhenCoinIsRetarded1() {
        // given
        int price = 40;
        CoinsCalculator coinsCalculator = new CoinsCalculator(500, 200, 100, 50, 25, 20, 10, 5, 2, 1);

        // when
        Integer[] result = coinsCalculator.count(price);

        // then
        Assert.assertEquals(new Integer[]{20, 20}, result);
    }

    @Test
    public void shouldReturnCorrectCoinsWhenCoinIsRetarded2() {
        // given

        // when
//        Integer[] result1 = new CoinsCalculator(25, 10, 1).count(31);
        Integer[] result2 = new CoinsCalculator(50, 20, 1).count(60);
        Integer[] result3 = new CoinsCalculator(50, 20, 1).count(80);
//        Integer[] result4 = new CoinsCalculator(25, 10, 1).count(31);
//        Integer[] result5 = new CoinsCalculator(25, 10, 1).count(31);

        // then
//        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
//        System.out.println(Arrays.toString(result4));
//        System.out.println(Arrays.toString(result5));
//        Assert.assertEquals(new Integer[]{1, 10, 10, 10}, result1);
        Assert.assertEquals(new Integer[]{20, 20, 20}, result2);
        Assert.assertEquals(new Integer[]{20, 20, 20, 20}, result3);
//        Assert.assertEquals(new Integer[]{10, 10, 10, 1}, result4);
//        Assert.assertEquals(new Integer[]{10, 10, 10, 1}, result5);
    }

}