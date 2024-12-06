package riccardomamoli.gestione_eventi_final.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import riccardomamoli.gestione_eventi_final.entities.Evento;
import riccardomamoli.gestione_eventi_final.exceptions.BadRequestException;
import riccardomamoli.gestione_eventi_final.exceptions.NotFoundException;
import riccardomamoli.gestione_eventi_final.payloads.NewEventoDTO;
import riccardomamoli.gestione_eventi_final.repositories.EventoRepository;

import java.time.LocalDate;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;



    public Evento findEventoById(Long id){
        return eventoRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Evento saveEvento(NewEventoDTO body) {
        Evento evento = new Evento(body.nomeEvento(), body.descrizioneEvento(), body.dataEvento(), body.luogoEvento(), body.postiDisponibili());
        return this.eventoRepository.save(evento);
    }

    public Page<Evento> findAll(int page, int size, String sortBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return eventoRepository.findAll(pageable);
    }

    public void findByIdAndDelete(Long id) {
        Evento found = this.findEventoById(id);
        eventoRepository.delete(found);
    }

    public Evento findByIdAndUpdate(Long id, NewEventoDTO body) {
        Evento found = this.findEventoById(id);

        if(body.dataEvento().isBefore(LocalDate.now())){
            throw new BadRequestException("La data dell evento non può essere passata!");
        }

        if(!body.nomeEvento().equals(found.getNomeEvento())) {
            found.setNomeEvento(body.nomeEvento());
        }

        if(!body.descrizioneEvento().equals(found.getDescrizioneEvento())) {
            found.setDescrizioneEvento(body.descrizioneEvento());
        }

        if(!body.dataEvento().equals(found.getDataEvento())) {
            found.setDataEvento(body.dataEvento());
        }

        if(!body.luogoEvento().equals(found.getLuogoEvento())) {
            found.setLuogoEvento(body.luogoEvento());
        }

        if(!body.postiDisponibili().equals(found.getPostiDisponibili())) {
            found.setPostiDisponibili(body.postiDisponibili());
        }

        return eventoRepository.save(found);
    }


}
