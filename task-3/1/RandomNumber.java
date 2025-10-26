import java.util.Random;

import java.util.ArrayList;

public class RandomNumber {
    public static void main(String[] args) {
        int randomNumber = generateRangom();
        ArrayList<Integer> digets = parseNumber(randomNumber);
        int sum = sumDigets(digets);

        System.out.printf("Random number: %d\n", randomNumber);
        System.out.printf("Sum of digets: %d\n", sum);
    }

    public static ArrayList<Integer> parseNumber(int fullNumber) {
        int other = fullNumber / 10;
        int number = fullNumber % 10;

        if (other == 0) { 
            ArrayList<Integer> returnNumber = new ArrayList<Integer>(1);
            returnNumber.add(number);
            return returnNumber; 
        }

        ArrayList<Integer> parsedOther = parseNumber(other);
        ArrayList<Integer> numbers = new ArrayList<Integer>(parsedOther);
        numbers.add(number);

        return numbers;
    }

    public static int sumDigets(ArrayList<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static int generateRangom() {
        int randomMin = 100;
        int randomMax = 999;

        int randomNumber = new Random().nextInt(randomMax - randomMin + 1) + randomMin;
        return randomNumber;
    }
}

