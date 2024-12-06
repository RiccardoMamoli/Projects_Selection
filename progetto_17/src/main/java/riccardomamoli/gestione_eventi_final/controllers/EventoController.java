package riccardomamoli.gestione_eventi_final.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import riccardomamoli.gestione_eventi_final.entities.Evento;
import riccardomamoli.gestione_eventi_final.exceptions.BadRequestException;
import riccardomamoli.gestione_eventi_final.payloads.NewEventoDTO;
import riccardomamoli.gestione_eventi_final.services.EventoService;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/eventi")

public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping
    public Page<Evento> getEventi(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return this.eventoService.findAll(page, size, sortBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ORGANIZZATORE_EVENTI')")
    public Evento saveEvento(@RequestBody @Validated NewEventoDTO body, BindingResult validationResult){
        if(validationResult.hasErrors()){
            String message = validationResult.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.joining(". "));
            throw new BadRequestException("Payload error: " + message);
        }
        return this.eventoService.saveEvento(body);
    }

    @GetMapping("/{eventoId}")
    public Evento findByIdEvento(@PathVariable Long idViaggio) {
        return this.eventoService.findEventoById(idViaggio);
    }

    @PutMapping("/{eventoId}")
    @PreAuthorize("hasAuthority('ORGANIZZATORE_EVENTI')")
    public Evento findByIdAndUpdate(
            @PathVariable Long eventoId,
            @RequestBody @Validated NewEventoDTO body,
            BindingResult validationResult) {
        if (validationResult.hasErrors()) {String message = validationResult.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.joining(". "));
            throw new BadRequestException("Errori nel payload: " + message);
        }
        return this.eventoService.findByIdAndUpdate(eventoId, body);
    }

    @DeleteMapping("/{eventoId}")
    @PreAuthorize("hasAuthority('ORGANIZZATORE_EVENTI')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable Long eventoId) {
        this.eventoService.findByIdAndDelete(eventoId);
    }



}