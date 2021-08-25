package com.example.demo.agenda;

import com.example.demo.Partner.Partner;
import com.example.demo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/agenda", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @PutMapping(path = "{agendaId}/yes")
    public Response registerNewYesVote(@PathVariable("agendaId") Long agendaId, @RequestBody Partner partner){
        agendaService.addNewYesVote(agendaId, partner);
        return new Response("Voto registrado com sucesso", 0);
    }

    @PutMapping(path = "{agendaId}/no")
    public Response registerNewNoVote(@PathVariable("agendaId") Long agendaId, @RequestBody Partner partner){
        agendaService.addNewNoVote(agendaId, partner);
        return new Response("Voto registrado com sucesso", 0);

    }

//
//    // TODO: Preciso de um serviço rodando para fechar as pautas
//    public void closeAgenda() {
//
//    }
}
