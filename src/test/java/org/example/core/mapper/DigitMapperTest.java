package org.example.core.mapper;

import org.example.core.entity.Digit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DigitMapperTest {
    @InjectMocks
    private DigitMapper digitMapper;

    @Test
    void mapTest1() {
        List<List<Object>> testList = new ArrayList<>();
        testList.add(new ArrayList<>(List.of(new Object[]{1, 2})));
        testList.add(new ArrayList<>(List.of(new Object[]{3, 4})));
        List<Digit> resultList = new ArrayList<>();
        resultList.add(new Digit(0, 1, 2));
        resultList.add(new Digit(0, 3, 4));
        Assertions.assertEquals(digitMapper.map(testList), resultList);
    }

    @Test
    void mapTest2() {
        Digit digit = new Digit(0, 1, 2);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Assertions.assertEquals(digitMapper.map(digit), list);
    }
}