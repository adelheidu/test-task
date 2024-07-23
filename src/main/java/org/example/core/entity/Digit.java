package org.example.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "digits")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data
public class Digit implements Interval<Integer, Digit> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer starting;
    private Integer ending;

    @Override
    public int compareToMerge(Digit interval) {
        if (this.getEnding() >= interval.getStarting()) {
            return 1;
        } else return 0;
    }

    @Override
    public Integer max(Integer ending) {
        return Math.max(this.getEnding(), ending);
    }

    @Override
    public int compareTo(Digit digit) {
        if (this.getStarting() > digit.getStarting()) {
            return 1;
        } else if (this.getStarting() < digit.getStarting()) {
            return -1;
        } else {
            return this.getEnding().compareTo(digit.getEnding());
        }
    }
}
