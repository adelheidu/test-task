package org.example.core.repository;

import org.example.core.entity.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LetterRepository extends JpaRepository<Letter, String> {
    Optional<Letter> findFirstByOrderByStartingAscEnding();
}
