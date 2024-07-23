package org.example.core.mapper;

import org.example.core.entity.Digit;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class DigitMapper {

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

    public List<Integer> map(Digit digit){
        List<Integer> result = new ArrayList<>();
        result.add(digit.getStarting());
        result.add(digit.getEnding());
        return result;
    }

}
