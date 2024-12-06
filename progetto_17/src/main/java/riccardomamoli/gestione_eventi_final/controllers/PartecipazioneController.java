package riccardomamoli.gestione_eventi_final.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import riccardomamoli.gestione_eventi_final.entities.Partecipazione;
import riccardomamoli.gestione_eventi_final.exceptions.BadRequestException;
import riccardomamoli.gestione_eventi_final.payloads.NewPartecipazioneDTO;
import riccardomamoli.gestione_eventi_final.services.PartecipazioneService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/partecipazioni")
public class PartecipazioneController {

    @Autowired
    private PartecipazioneService partecipazioneService;

    @GetMapping
    public Page<Partecipazione> getAllPartecipazioni(Pageable pageable) {
        return partecipazioneService.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Partecipazione savePartecipazione(@RequestBody @Validated NewPartecipazioneDTO body, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            String message = validationResult.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.joining(". "));
            throw new BadRequestException("Errori nel payload: " + message);
        }
        return this.partecipazioneService.savePartecipazione(body);
    }

    @GetMapping("/{partecipazioneId}")
    public Partecipazione getPartecipazioneById(@PathVariable Long prenotazioneId) {
        return partecipazioneService.findById(prenotazioneId);
    }

    @DeleteMapping("/{partecipazioneId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePrenotazione(@PathVariable Long prenotazioneId) {
        partecipazioneService.findByIdAndDelete(prenotazioneId);
    }

    @GetMapping("/data/{dataEvento}")
    public List<Partecipazione> getPartecipazioniByData(@PathVariable LocalDate dataEvento) {
        return partecipazioneService.getPartecipazioniByData(dataEvento);
    }
}