package riccardomamoli.gestione_eventi_final.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import riccardomamoli.gestione_eventi_final.entities.Utente;

import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
    Optional<Utente> findByEmailUtente(String emailUtente);
    Optional<Utente> findByUsernameUtente(String usernameUtente);
}
