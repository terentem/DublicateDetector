package org.example;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        DublicateDetector d = new DublicateDetector();
        int[] numbers = {-10, 2, 3, 2000, 4, 3};
        boolean detectResult = numbers.length > 1000 ? d.detectByBitSet(numbers) : d.detect(numbers);
        System.out.println("Result of detection on dublicates= "+detectResult);
    }
}
