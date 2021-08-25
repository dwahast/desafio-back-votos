package com.example.demo.agenda;

import com.example.demo.Partner.Partner;
import com.example.demo.Partner.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AgendaService {

    private final AgendaRepository agendaRepository;
    private final PartnerRepository partnerRepository;

    @Autowired
    public AgendaService(AgendaRepository agendaRepository, PartnerRepository partnerRepository) {
        this.agendaRepository = agendaRepository;
        this.partnerRepository = partnerRepository;
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
    public void addNewYesVote(Long agendaId, Partner partner) {
        Agenda agenda = agendaRepository.findById(agendaId)
                .orElseThrow(() -> new IllegalStateException("agenda with id " + agendaId + " not exists"));

        Partner partnerObj = partnerRepository.findById(partner.getId())
                .orElseThrow(() -> new IllegalStateException("partner with id " + partner.getId() + " not exists"));

        System.out.println("Req:" + partner);
        System.out.println("Res:" + partnerObj);

        if (!partner.equals(partnerObj)) {
            throw new IllegalStateException("partner input with id " + agendaId + " not valid");
        }

        agendaRepository.incrementYesVotes(agendaId);
    }

    @Transactional
    public void addNewNoVote(Long agendaId, Partner partner) {
        Agenda agenda = agendaRepository.findById(agendaId)
                .orElseThrow(() -> new IllegalStateException("agenda with id " + agendaId + " not exists"));

        Partner partnerObj = partnerRepository.findById(partner.getId())
                .orElseThrow(() -> new IllegalStateException("partner with id " + partner.getId() + " not exists"));

        System.out.println("Req:" + partner);
        System.out.println("Res:" + partnerObj);

        if (!partner.equals(partnerObj)) {
            throw new IllegalStateException("partner input with id " + agendaId + " not valid");
        }

        agendaRepository.incrementNoVotes(agendaId);
    }
}
