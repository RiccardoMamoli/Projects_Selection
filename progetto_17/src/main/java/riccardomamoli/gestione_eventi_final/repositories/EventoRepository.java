package riccardomamoli.gestione_eventi_final.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import riccardomamoli.gestione_eventi_final.entities.Evento;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByLuogoEvento(String luogoEvento);
}
