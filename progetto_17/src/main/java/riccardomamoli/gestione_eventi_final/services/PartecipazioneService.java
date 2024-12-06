package riccardomamoli.gestione_eventi_final.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import riccardomamoli.gestione_eventi_final.entities.Evento;
import riccardomamoli.gestione_eventi_final.entities.Partecipazione;
import riccardomamoli.gestione_eventi_final.entities.Utente;
import riccardomamoli.gestione_eventi_final.exceptions.NotFoundException;
import riccardomamoli.gestione_eventi_final.payloads.NewPartecipazioneDTO;
import riccardomamoli.gestione_eventi_final.repositories.EventoRepository;
import riccardomamoli.gestione_eventi_final.repositories.PartecipazioneRepository;
import riccardomamoli.gestione_eventi_final.repositories.UtenteRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PartecipazioneService {

    @Autowired
    private PartecipazioneRepository partecipazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private EventoRepository eventoRepository;

    public Page<Partecipazione> findAll(Pageable pageable) {
        return partecipazioneRepository.findAll(pageable);
    }

    public Partecipazione findById(Long id) {
        return partecipazioneRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Partecipazione savePartecipazione(NewPartecipazioneDTO body) {
        Utente utente = utenteRepository.findById(body.idUtente()).orElseThrow(() -> new NotFoundException(body.idUtente()));
        Evento evento = eventoRepository.findById(body.idEvento()).orElseThrow(() -> new NotFoundException(body.idEvento()));

        if (partecipazioneRepository.existsByUtenteIdAndEventoDataEvento(utente.getId(), evento.getDataEvento())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Il dipendente ha già una prenotazione per questa data.");
        }

        Partecipazione partecipazione = new Partecipazione(utente, evento);
        return partecipazioneRepository.save(partecipazione);
    }

    public void deleteById(Long id) {
        partecipazioneRepository.deleteById(id);
    }

    public Page<Partecipazione> getPartecipazioniById(Long id, Pageable pageable) {
        return partecipazioneRepository.findByUtenteId(id, pageable);
    }

    public List<Partecipazione> getPartecipazioniByData(LocalDate dataEvento) {
        return partecipazioneRepository.findByEventoDataEvento(dataEvento);
    }

    public void findByIdAndDelete(Long id) {
        Partecipazione prenotazione = this.findById(id);
        partecipazioneRepository.delete(prenotazione);
    }
}