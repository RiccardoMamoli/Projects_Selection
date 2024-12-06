package riccardomamoli.gestione_prenotazioni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import riccardomamoli.gestione_prenotazioni.entities.Postazione;
import riccardomamoli.gestione_prenotazioni.enums.TipologiaPostazione;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
List<Postazione> findByTipoPostazioneAndEdificio_CittEdificio(TipologiaPostazione tipologiaPostazione, String cittEdificio);
}
