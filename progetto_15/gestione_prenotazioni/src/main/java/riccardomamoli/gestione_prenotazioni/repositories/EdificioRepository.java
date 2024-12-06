package riccardomamoli.gestione_prenotazioni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import riccardomamoli.gestione_prenotazioni.entities.Edificio;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {
    boolean existsByNomeEdificio(String nome);
}
