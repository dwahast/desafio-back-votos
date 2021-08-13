package com.example.demo.agenda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//import java.util.Optional;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    @Modifying
    @Query("UPDATE Agenda a set a.yes_votes = a.yes_votes + 1 WHERE a.id = :id")
    void incrementYesVotes(Long id);

    @Modifying
    @Query("UPDATE Agenda a set a.no_votes = a.no_votes + 1 WHERE a.id = :id")
    void incrementNoVotes(Long id);
}
