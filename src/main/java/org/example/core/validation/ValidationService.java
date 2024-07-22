package org.example.core.validation;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidationService {
    public void validator(List<List<Object>> list){
        for (List<Object> interval : list){
            if (interval.size() != 2){
                throw new RuntimeException("Интервал указан неверно");
            }
        }
    }

    public void validDigits(List<List<Object>> list){
        for (List<Object> interval : list){
            if (!(interval.get(0) instanceof Integer) || !(interval.get(1) instanceof Integer)){
                throw new RuntimeException("Введите только целые числа.");
            }
            if ((Integer)interval.get(0) >= (Integer) interval.get(1)){
                throw new RuntimeException("Интервал указан неверно.");
            }
        }
    }

    public void validLetters(List<List<Object>> list) {
        for (List<Object> interval : list) {
            Pattern pattern = Pattern.compile("^[a-z]$");
            if (!(pattern.matcher(interval.get(0).toString().toLowerCase()).matches()) ||
                    !(pattern.matcher(interval.get(1).toString().toLowerCase()).matches())) {
                throw new RuntimeException("Допускается только один символ");
            }
            if (interval.get(0).toString().compareTo(interval.get(1).toString()) >= 0){
                throw new RuntimeException("Интервал указан неверно.");
            }
        }
    }
}
