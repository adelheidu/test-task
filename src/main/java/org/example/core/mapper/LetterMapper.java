package org.example.core.mapper;

import org.example.core.entity.Digit;
import org.example.core.entity.Letter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LetterMapper {
    public List<Letter> map(List<List<Object>> list) {
        List<Letter> result = new ArrayList<>();
        for (List<Object> interval : list) {
            result.add(
                    Letter.builder()
                            .starting(interval.get(0).toString().toLowerCase().charAt(0))
                            .ending(interval.get(1).toString().toLowerCase().charAt(0))
                            .build()
            );
        }
        return result;
    }

    public List<Character> map(Letter letter){
        List<Character> result = new ArrayList<>();
        result.add(letter.getStarting());
        result.add(letter.getEnding());
        return result;
    }
}
