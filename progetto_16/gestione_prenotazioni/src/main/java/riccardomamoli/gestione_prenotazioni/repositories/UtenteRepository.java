package riccardomamoli.gestione_prenotazioni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import riccardomamoli.gestione_prenotazioni.entities.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
}
