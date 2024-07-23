package org.example.core.validation;

import org.example.core.exception.WrongIntervalException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ValidationServiceTest {
    @InjectMocks
    private ValidationService validationService;

    @Test
    void validatorTest1() {
        List<List<Object>> testList = new ArrayList<>();
        testList.add(new ArrayList<>(List.of(new Object[]{1, 2})));
        testList.add(new ArrayList<>(List.of(new Object[]{3, 4})));
        validationService.validator(testList);
    }

    @Test
    void validatorTest2() {
        List<List<Object>> testList = new ArrayList<>();
        testList.add(new ArrayList<>(List.of(new Object[]{1, 2, 3})));
        testList.add(new ArrayList<>(List.of(new Object[]{1, 2})));
        Assertions.assertThrows(WrongIntervalException.class,
                () -> validationService.validator(testList),
                "Интервал указан неверно (должно быть два числа в интервале).");

    }

    @Test
    void validatorTest3() {
        List<List<Object>> testList = new ArrayList<>();
        testList.add(new ArrayList<>(List.of(new Object[]{})));
        testList.add(new ArrayList<>(List.of(new Object[]{1, 2})));
        Assertions.assertThrows(WrongIntervalException.class,
                () -> validationService.validator(testList),
                "Интервал указан неверно (должно быть два числа в интервале).");
    }

    @Test
    void validDigitsTest1() {
        List<List<Object>> testList = new ArrayList<>();
        testList.add(new ArrayList<>(List.of(new Object[]{2, 4})));
        testList.add(new ArrayList<>(List.of(new Object[]{1, 2})));
        validationService.validDigits(testList);
    }

    @Test
    void validDigitsTest2() {
        List<List<Object>> testList = new ArrayList<>();
        testList.add(new ArrayList<>(List.of(new Object[]{"a", 4})));
        testList.add(new ArrayList<>(List.of(new Object[]{1, 2})));
        Assertions.assertThrows(WrongIntervalException.class,
                () -> validationService.validDigits(testList),
                "Введите только целые числа.");
    }

    @Test
    void validDigitsTest3() {
        List<List<Object>> testList = new ArrayList<>();
        testList.add(new ArrayList<>(List.of(new Object[]{7, 4})));
        testList.add(new ArrayList<>(List.of(new Object[]{1, 2})));
        Assertions.assertThrows(WrongIntervalException.class,
                () -> validationService.validDigits(testList),
                "Введите только целые числа.");
    }

    @Test
    void validLettersTest1() {
        List<List<Object>> testList = new ArrayList<>();
        testList.add(new ArrayList<>(List.of(new Object[]{"a", "b"})));
        testList.add(new ArrayList<>(List.of(new Object[]{"c", "d"})));
        validationService.validLetters(testList);
    }

    @Test
    void validLettersTest2() {
        List<List<Object>> testList = new ArrayList<>();
        testList.add(new ArrayList<>(List.of(new Object[]{"A", "b"})));
        testList.add(new ArrayList<>(List.of(new Object[]{"c", "d"})));
        validationService.validLetters(testList);
    }

    @Test
    void validLettersTest3() {
        List<List<Object>> testList = new ArrayList<>();
        testList.add(new ArrayList<>(List.of(new Object[]{1, "b"})));
        testList.add(new ArrayList<>(List.of(new Object[]{"c", "d"})));
        Assertions.assertThrows(WrongIntervalException.class,
                () -> validationService.validLetters(testList),
                "Допускается только один символ (a-z).");
    }

    @Test
    void validLettersTest4() {
        List<List<Object>> testList = new ArrayList<>();
        testList.add(new ArrayList<>(List.of(new Object[]{"b", "a"})));
        testList.add(new ArrayList<>(List.of(new Object[]{"c", "d"})));
        Assertions.assertThrows(WrongIntervalException.class,
                () -> validationService.validLetters(testList),
                "Интервал указан неверно (левая граница должна быть меньше правой).");
    }
}