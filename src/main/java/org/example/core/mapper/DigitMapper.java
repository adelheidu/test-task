package org.example.core.mapper;

import org.example.core.entity.Digit;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class DigitMapper {
//    public Digit map(List<Integer> interval) {
//        return Digit.builder()
//                .starting(interval.get(0))
//                .ending(interval.get(1))
//                .build();
//    }

    public List<Integer> map(Digit digit) {
        List<Integer> result = new ArrayList<>();
        result.set(0, digit.getStarting());
        result.set(1, digit.getEnding());
        return result;
    }

    public List<Digit> map(List<List<Object>> list) {
        List<Digit> result = new ArrayList<>();
        for (List<Object> interval : list) {
            result.add(
                    Digit.builder()
                    .starting((Integer) interval.get(0))
                    .ending((Integer) interval.get(1))
                    .build()
            );
        }
        return result;
    }

}
