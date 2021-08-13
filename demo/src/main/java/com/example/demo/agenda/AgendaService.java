package com.example.demo.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AgendaService {

    private final AgendaRepository agendaRepository;

    @Autowired
    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public List<Agenda> getAgenda() {
        return agendaRepository.findAll();
    }

    public Agenda addNewAgenda(String description) {
        Agenda agenda = new Agenda(description);
        System.out.println(agenda);
        agendaRepository.save(agenda);
        return agenda;
    }

    @Transactional
    public void addNewYesVote(Long agendaId) {
        Agenda agenda = agendaRepository.findById(agendaId)
                .orElseThrow(() -> new IllegalStateException("agenda with id " + agendaId + " not exists"));

        agendaRepository.incrementYesVotes(agendaId);
    }

    @Transactional
    public void addNewNoVote(Long agendaId) {
        Agenda agenda = agendaRepository.findById(agendaId)
                .orElseThrow(() -> new IllegalStateException("agenda with id " + agendaId + " not exists"));

        agendaRepository.incrementNoVotes(agendaId);
    }
}
