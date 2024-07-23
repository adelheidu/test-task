package org.example.core.service;

import org.example.core.entity.Letter;
import org.example.core.mapper.LetterMapper;
import org.example.core.repository.LetterRepository;
import org.example.core.validation.ValidationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class LetterServiceTest {
    @InjectMocks
    private LetterService letterService;
    @Spy
    private ValidationService validationService;
    @Mock
    private LetterMapper letterMapper;
    @Mock
    private LetterRepository letterRepository;

    @Test
    void mergeTest() {
        List<List<Object>> testList = new ArrayList<>();
        testList.add(new ArrayList<>(List.of(new Object[]{"a", "b"})));
        testList.add(new ArrayList<>(List.of(new Object[]{"b", "c"})));

        List<Letter> letterList = new ArrayList<>();
        letterList.add(new Letter(0, 'a', 'b'));
        letterList.add(new Letter(0, 'b', 'c'));

        List<Letter> resultList = new ArrayList<>();
        resultList.add(new Letter(0, 'a', 'c'));

        when(letterMapper.map(testList)).thenReturn(letterList);
        when(letterRepository.saveAll(resultList)).thenReturn(resultList);

        letterService.merge(testList);

        verify(letterMapper).map(testList);
        verify(letterRepository).saveAll(resultList);
    }

    @Test
    void minTest() {
        Letter letter = new Letter(1, 'a', 'b');
        List<Character> result = new ArrayList<>();
        result.add('a');
        result.add('b');

        when(letterRepository.findFirstByOrderByStartingAscEnding()).thenReturn(Optional.of(letter));
        when(letterMapper.map(letter)).thenReturn(result);

        Assertions.assertEquals(result, letterService.min());

        verify(letterRepository).findFirstByOrderByStartingAscEnding();
        verify(letterMapper).map(letter);
    }

}