package riccardomamoli.gestione_eventi_final.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import riccardomamoli.gestione_eventi_final.entities.Partecipazione;

import java.time.LocalDate;
import java.util.List;

public interface PartecipazioneRepository extends JpaRepository<Partecipazione, Long> {
    List<Partecipazione> findByUtenteId(Long utenteId);
    List<Partecipazione> findByEventoId(Long eventoId);
    boolean existsByUtenteIdAndEventoDataEvento(Long idDipendente, LocalDate dataEvento);
    Page<Partecipazione> findByUtenteId(Long id, Pageable pageable);
    List<Partecipazione> findByEventoDataEvento(LocalDate dataEvento);


}
