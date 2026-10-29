package org.example;

import java.util.BitSet;

public class DublicateDetector {

    public boolean detect(int[] numbersList) {

        int numbersLength = numbersList.length;
        int[] hashTable = new int[(int) Math.pow(2, 10)];
        System.out.println(hashTable.length);

        //For simple set of numbers (without 0 and collisions)
        for (int i = 0; i < numbersLength; i++) {
            int xorHash = numbersList[i] ^ (numbersList[i] >>> 16);
            int index = (hashTable.length - 1) & xorHash;
            System.out.println("[" + i + "]" + index);
            if (numbersList[i] == 0) {
                System.out.println("number=0, call BitSet=");
                //Виклик метода, що почне заповнювати BitSet для пошуку дубліката
                if (detectByBitSet(numbersList)) {
                    return true;
                }
            }
            int currentNumber = numbersList[i];
            if (hashTable[index] == 0) {
                hashTable[index] = currentNumber;
            } else if (hashTable[index] == currentNumber) {
                System.out.println("First dublicate value=" + currentNumber);
                return true;
            } else {
                System.out.println("First index with collisium for index=" + index);
                if (detectByBitSet(numbersList)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean detectByBitSet(int[] numbersList) {
        System.out.println("Start BitSet method");
        BitSet positives = new BitSet();
        BitSet negatives = new BitSet();

        for (int i = 0; i < numbersList.length; i++) {
            int currentNumber = numbersList[i];
            if (currentNumber > 0) {
                if (positives.get(numbersList[i])) {
                    System.out.println("Dublicate: " + numbersList[i]);
                    return true;
                }
                positives.set(numbersList[i]);
            } else {
                int positiveNumber = -currentNumber;
                if (negatives.get(positiveNumber)) {
                    System.out.println("Dublicate: " + numbersList[i]);
                    return true;
                }
                negatives.set(positiveNumber);
            }
        }
        return false;
    }
}
