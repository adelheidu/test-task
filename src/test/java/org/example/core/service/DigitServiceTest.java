package org.example.core.service;

import org.example.core.entity.Digit;
import org.example.core.mapper.DigitMapper;
import org.example.core.repository.DigitRepository;
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
class DigitServiceTest {
    @InjectMocks
    private DigitService digitService;
    @Spy
    private ValidationService validationService;
    @Mock
    private DigitMapper digitMapper;
    @Mock
    private DigitRepository digitRepository;

    @Test
    void mergeTest() {
        List<List<Object>> testList = new ArrayList<>();
        testList.add(new ArrayList<>(List.of(new Object[]{1, 3})));
        testList.add(new ArrayList<>(List.of(new Object[]{2, 5})));

        List<Digit> digitList = new ArrayList<>();
        digitList.add(new Digit(0, 1, 3));
        digitList.add(new Digit(0, 2, 5));

        List<Digit> resultList = new ArrayList<>();
        resultList.add(new Digit(0, 1, 5));

        when(digitMapper.map(testList)).thenReturn(digitList);
        when(digitRepository.saveAll(resultList)).thenReturn(resultList);

        digitService.merge(testList);

        verify(digitMapper).map(testList);
        verify(digitRepository).saveAll(resultList);
    }

    @Test
    void minTest() {
        Digit digit = new Digit(1, 1, 5);

        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(5);

        when(digitRepository.findFirstByOrderByStartingAscEnding()).thenReturn(Optional.of(digit));
        when(digitMapper.map(digit)).thenReturn(result);

        Assertions.assertEquals(result, digitService.min());

        verify(digitRepository).findFirstByOrderByStartingAscEnding();
        verify(digitMapper).map(digit);
    }

}