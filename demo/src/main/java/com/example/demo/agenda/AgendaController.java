package com.example.demo.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/agenda")
public class AgendaController {

    private final AgendaService agendaService;

    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping
    public List<Agenda> getAgenda() {
        return agendaService.getAgenda();
    }

    @PostMapping
    public Agenda registerNewAgenda(@RequestBody Agenda agenda){
        return agendaService.addNewAgenda(agenda.getDescription());
    }

    // TODO: adicionar voto em uma pauta
    @PutMapping(path = "{agendaId}/yes")
    public void registerNewYesVote(@PathVariable("agendaId") Long agendaId){
        agendaService.addNewYesVote(agendaId);
        // TODO: Retornar agenda.
    }

    // TODO: adicionar voto em uma pauta @RequestBody Partner partner
    @PutMapping(path = "{agendaId}/no")
    public void registerNewNoVote(@PathVariable("agendaId") Long agendaId){
        agendaService.addNewNoVote(agendaId);
        // TODO: Retornar agenda.
    }

//
//    // TODO: Preciso de um serviço rodando para fechar as pautas
//    public void closeAgenda() {
//
//    }
}
