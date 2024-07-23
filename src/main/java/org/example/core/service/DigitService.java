package org.example.core.service;

import lombok.RequiredArgsConstructor;
import org.example.api.Kinds;
import org.example.core.entity.Digit;
import org.example.core.exception.IntervalNotFoundException;
import org.example.core.mapper.DigitMapper;
import org.example.core.repository.DigitRepository;
import org.example.core.validation.ValidationService;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.api.Kinds.digits;

@Service
@RequiredArgsConstructor
public class DigitService extends IntervalService<Digit> {
    private final ValidationService validationService;
    private final DigitMapper digitMapper;
    private final DigitRepository digitRepository;

    @Override
    public void merge(List<List<Object>> list) {
        validationService.validator(list);
        validationService.validDigits(list);
        List<Digit> digitList = digitMapper.map(list);
        List<Digit> resultList = mergeIntervals(digitList);
        digitRepository.saveAll(resultList);
    }

    @Override
    public List min() {
        Digit digit = digitRepository.findFirstByOrderByStartingAscEnding().orElse(null);
        if (digit == null) {
            throw new IntervalNotFoundException("Интервал не найден.");
        }
        return digitMapper.map(digit);
    }

    @Override
    public Kinds getKind() {
        return digits;
    }
}
