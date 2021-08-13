package com.example.demo.agenda;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Agenda {
    @Id
    @SequenceGenerator(
            name = "agenda_sequence",
            sequenceName = "agenda_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "agenda_sequence"
    )
    private Long id;
    private String description;
    private Boolean closed;
    private LocalDateTime tob;
    private Long yes_votes;
    private Long no_votes;

    public Agenda() {
    }

//    public Agenda(Long id, String description) {
//        this.id = id;
//        this.description = description;
//        this.tob = LocalDateTime.now();
//        this.yes_votes = 0L;
//        this.no_votes = 0L;
//        this.closed = false;
//    }

//    public Agenda(String description, LocalDateTime tob, Long yes_votes, Long no_votes) {
//        this.description = description;
//        this.tob = tob;
//        this.yes_votes = yes_votes;
//        this.no_votes = no_votes;
//        this.closed = false;
//    }

    public Agenda(String description) {
        this.description = description;
        this.tob = LocalDateTime.now();
        this.yes_votes = 0L;
        this.no_votes = 0L;
        this.closed = false;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getClosed() {
        return closed;
    }

    public LocalDateTime getDob() {
        return tob;
    }

    public Long getYesVotes() {
        return yes_votes;
    }

    public Long getNoVotes() {
        return no_votes;
    }

    public void setYes_votes(Long yes_votes) {
        this.yes_votes = yes_votes;
    }

    public void setNo_votes(Long no_votes) {
        this.no_votes = no_votes;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", closed=" + closed +
                ", tob=" + tob +
                ", yes_votes=" + yes_votes +
                ", no_votes=" + no_votes +
                '}';
    }
}
