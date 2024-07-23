package org.example.core.service;

import lombok.RequiredArgsConstructor;
import org.example.api.Kinds;
import org.example.core.entity.Digit;
import org.example.core.entity.Letter;
import org.example.core.exception.IntervalNotFoundException;
import org.example.core.mapper.LetterMapper;
import org.example.core.repository.LetterRepository;
import org.example.core.validation.ValidationService;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.api.Kinds.letters;

@Service
@RequiredArgsConstructor
public class LetterService extends IntervalService<Letter>{
    private final ValidationService validationService;
    private final LetterMapper letterMapper;
    private final LetterRepository letterRepository;

    @Override
    public void merge(List<List<Object>> list) {
        validationService.validLetters(list);
        validationService.validator(list);
        List<Letter> letterList = letterMapper.map(list);
        List<Letter> resultList = mergeIntervals(letterList);
        for (Letter letter : resultList){
            letterRepository.save(letter);
        }

    }

    @Override
    public List min() {
        Letter letter = letterRepository.findFirstByOrderByStartingAscEnding().orElse(null);
        if (letter == null){
            throw new IntervalNotFoundException("Интервал не найден.");
        }
        return letterMapper.map(letter);
    }

    @Override
    public Kinds getKind() {
        return letters;
    }
}
