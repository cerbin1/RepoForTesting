package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    public static int add(String numbersAsString) {
        if (numbersAsString.isEmpty()) {
            return 0;
        }

        List<Integer> numbersFromString = getNumbersFromString(numbersAsString);
        List<Integer> negativeNumbers = filterNegativeNumbers(numbersFromString);

        if (negativeNumbers.size() > 0) {
            throw new RuntimeException("Negatives not allowed: " + negativeNumbers);
        }

        int numbersCount = numbersFromString.size();
        if (numbersCount == 1) {
            return numbersFromString.get(0);
        } else {
            int sum = 0;
            for (int nextNumber : numbersFromString) {
                if (nextNumber <= 1000) {
                    sum += nextNumber;
                }
            }
            return sum;
        }
    }

    private static List<Integer> filterNegativeNumbers(List<Integer> numbersFromString) {
        return numbersFromString.stream().filter(number -> number < 0).collect(Collectors.toList());
    }

    private static List<Integer> getNumbersFromString(String numbersAsString) {
        List<Integer> numbers = new ArrayList<>();
        for (String numberFromString : numbersAsString.split("[,\n]")) {
            numbers.add(Integer.parseInt(numberFromString));
        }
        return numbers;
    }
}
