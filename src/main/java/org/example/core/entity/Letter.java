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
@Table(name = "letters")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data
public class Letter implements Interval<Character, Letter> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Character starting;
    private Character ending;

    @Override
    public Character max(Character ending) {
        if (this.ending >= ending) {
            return this.ending;
        } else return ending;
    }

    @Override
    public int compareToMerge(Letter interval) {
        if (this.getEnding() >= interval.getStarting()) {
            return 1;
        } else return 0;
    }

    @Override
    public int compareTo(Letter letter) {
        if (this.getStarting() > letter.getStarting()) {
            return 1;
        } else if (this.getStarting() < letter.getStarting()) {
            return -1;
        } else {
            return this.getEnding().compareTo(letter.getEnding());
        }
    }
}
