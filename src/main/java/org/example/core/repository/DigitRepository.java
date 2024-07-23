package org.example.core.repository;

import org.example.core.entity.Digit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DigitRepository extends JpaRepository<Digit, String> {
    Optional<Digit> findFirstByOrderByStartingAscEnding();
}
