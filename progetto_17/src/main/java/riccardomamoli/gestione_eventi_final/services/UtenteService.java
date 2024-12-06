package riccardomamoli.gestione_eventi_final.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import riccardomamoli.gestione_eventi_final.entities.Utente;
import riccardomamoli.gestione_eventi_final.exceptions.BadRequestException;
import riccardomamoli.gestione_eventi_final.exceptions.NotFoundException;
import riccardomamoli.gestione_eventi_final.payloads.NewUtenteDTO;
import riccardomamoli.gestione_eventi_final.repositories.UtenteRepository;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PasswordEncoder bcrypt;

    public Utente salvaUtente(NewUtenteDTO body) {

        this.utenteRepository.findByEmailUtente(body.emailUtente()).ifPresent(
                user -> {
                    throw new BadRequestException("Email " + body.emailUtente() + " già in uso!");
                }
        );

        this.utenteRepository.findByEmailUtente(body.usernameUtente()).ifPresent(
                user -> {
                    throw new BadRequestException("Username " + body.usernameUtente() + " già in uso!");
                }
        );

        Utente newUtente = new Utente(
                body.nomeUtente(),
                body.cognomeUtente(),
                body.dataNascita(),
                body.usernameUtente(),
                body.emailUtente(),
                bcrypt.encode(body.passwordUtente()),
                body.ruolo()
        );

        Utente savedUtente = this.utenteRepository.save(newUtente);

        return savedUtente;
    }

    public Utente findByEmail(String email) {
        return this.utenteRepository.findByEmailUtente(email).orElseThrow(() -> new NotFoundException("L'utente con email " + email + " non è stato trovato"));
    }

    public Utente findById(Long id) {
        return this.utenteRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Page<Utente> findAll(int page, int size, String sortBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.utenteRepository.findAll(pageable);
    }

    public Utente findByIdAndUpdate(Long userId, NewUtenteDTO body) {
        Utente found = this.findById(userId);

        if (!found.getEmailUtente().equals(body.emailUtente())) {
            this.utenteRepository.findByEmailUtente(body.emailUtente()).ifPresent(
                    user -> {
                        throw new BadRequestException("Email " + body.emailUtente() + " già in uso!");
                    }
            );
        }

        found.setNomeUtente(body.nomeUtente());
        found.setCognomeUtente(body.cognomeUtente());
        found.setUsernameUtente(body.usernameUtente());
        found.setEmailUtente(body.emailUtente());
        found.setPasswordUtente(body.passwordUtente());

        return this.utenteRepository.save(found);
    }

    public void findByIdAndDelete(Long userId) {
        Utente found = this.findById(userId);
        this.utenteRepository.delete(found);
    }
}
