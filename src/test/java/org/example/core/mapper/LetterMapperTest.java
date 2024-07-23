package org.example.core.mapper;

import org.example.core.entity.Letter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class LetterMapperTest {
    @InjectMocks
    private LetterMapper letterMapper;

    @Test
    void mapTest1() {
        List<List<Object>> testList = new ArrayList<>();
        testList.add(new ArrayList<>(List.of(new Object[]{"a", "b"})));
        testList.add(new ArrayList<>(List.of(new Object[]{"c", "d"})));
        List<Letter> resultList = new ArrayList<>();
        resultList.add(new Letter(0, 'a', 'b'));
        resultList.add(new Letter(0, 'c', 'd'));
        Assertions.assertEquals(letterMapper.map(testList), resultList);
    }

    @Test
    void mapTest2() {
        Letter letter = new Letter(0, 'a', 'z');
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('z');
        Assertions.assertEquals(letterMapper.map(letter), list);
    }
}