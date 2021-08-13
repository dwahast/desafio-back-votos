package com.example.demo.agenda;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class AgendaConfig {

    @Bean
    CommandLineRunner commandLineRunner(AgendaRepository repository) {
        return args -> {
            Agenda nome = new Agenda("Mudar nome da empresa");

//            Agenda predio = new Agenda("Escolher um predio");

            repository.saveAll(List.of(nome));
        };
    }
}
