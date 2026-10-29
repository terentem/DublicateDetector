package org.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AppTest
        extends TestCase {

    private DublicateDetector detector;

    @BeforeEach
    void createInstanseOfDublicateDetectorClass() {
        detector = new DublicateDetector();
    }

    @Test
    //Має повертати false, якщо масив порожній або містить один елемент
    void shouldReturnFalseForEmptyOrSingleElementArray() {
        assertFalse(detector.detect(new int[]{}));
        assertFalse(detector.detect(new int[]{42}));
    }

    @Test
    //Має успішно знаходити очевидний дублікат у масиві
    void shouldReturnTrueForDetectSimpleDuplicate() {
        int[] numbers = {10, 20, 30, 20, 40};
        assertTrue(detector.detect(numbers));
    }

    @Test
    //Має успішно обробляти колізію
    void shouldReturnFalseForCollisions() {
        int[] numbers = {200, 5000, 3, 1224};
        assertFalse(detector.detectByBitSet(numbers));
    }

    @Test
    //Не має сприйняти перший 0 в масиві чисел за дублікат
    void shouldReturnFalseForFirstZero() {
        int[] numbers = {2001,0, 5000, 10, 1224};
        assertFalse(detector.detectByBitSet(numbers));
    }

    @Test
    //Має знаходити дублікат, при наявності колізії
    void shoulReturnTrueAfterDitectCollision() {
        int[] numbers = {200, 5000, 3, 1224, 3};
        assertTrue(detector.detectByBitSet(numbers));
    }

    @Test
    //Має має розрізняти протилежні числі, -1 та 1
    void shouldReturnFalseForOpositeNumbers() {
        int[] numbers = {200, -1, 3, 1224, 1};
        assertFalse(detector.detectByBitSet(numbers));
    }
}
