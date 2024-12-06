package riccardomamoli.gestione_prenotazioni.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import riccardomamoli.gestione_prenotazioni.entities.Edificio;
import riccardomamoli.gestione_prenotazioni.entities.Postazione;
import riccardomamoli.gestione_prenotazioni.entities.Prenotazione;
import riccardomamoli.gestione_prenotazioni.entities.Utente;
import riccardomamoli.gestione_prenotazioni.enums.TipologiaPostazione;
import riccardomamoli.gestione_prenotazioni.exceptions.AlreadyPresentRecordException;
import riccardomamoli.gestione_prenotazioni.exceptions.IdNotFoundException;
import riccardomamoli.gestione_prenotazioni.exceptions.SameDateException;
import riccardomamoli.gestione_prenotazioni.exceptions.SameIdException;
import riccardomamoli.gestione_prenotazioni.repositories.EdificioRepository;
import riccardomamoli.gestione_prenotazioni.repositories.PostazioneRepository;
import riccardomamoli.gestione_prenotazioni.repositories.PrenotazioneRepository;
import riccardomamoli.gestione_prenotazioni.repositories.UtenteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private EdificioRepository edificioRepository;

    // UTENTE

   public Utente creaUtente(Utente utente){
       return utenteRepository.save(utente);
   }

   public Utente trovaUtente(Long id) {
       return utenteRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Non c'è una postazione con questo ID!"));
   }

   // POSTAZIONE

    public Postazione creaPostazione(Postazione postazione){
       return postazioneRepository.save(postazione);
    }

    public Postazione trovaPostazione(Long id) {
        return postazioneRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Non c'è una postazione con questo ID!"));
    }

    public List<Postazione> trovaPostazioniPerTipoECittà(TipologiaPostazione tipologia, String citta) {
    return postazioneRepository.findByTipoPostazioneAndEdificio_CittEdificio(tipologia, citta);
    }



   // PRENOTAZIONE

    public Prenotazione creaPrenotazione(Prenotazione prenotazione) {

       if(prenotazioneRepository.existsByUtenteAndDataPrenotazione(prenotazione.getUtente(), prenotazione.getDataPrenotazione())){
           throw new SameIdException(prenotazione.getUtente().getNomeUtente() + " ha già una prenotazione per la data " + prenotazione.getDataPrenotazione() + ".");

       }  else if (prenotazioneRepository.existsByPostazioneAndDataPrenotazione(prenotazione.getPostazione(), prenotazione.getDataPrenotazione())) {
          throw new SameDateException("La postazione numero " + prenotazione.getPostazione().getIdPostazione() + " è gia occupata in data " + prenotazione.getDataPrenotazione());
        }
        return prenotazioneRepository.save(prenotazione);
    }

    public Prenotazione trovaPrenotazione(Long id){
        return prenotazioneRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Non c'è una prenotazione con questo ID!"));
    }



    // EDIFICIO

    public Edificio creaEdificio(Edificio edificio){
       if(edificioRepository.existsByNomeEdificio(edificio.getNomeEdificio())) {
           throw new AlreadyPresentRecordException("Esiste gia un edificio con questo nome!");
       } else {
           return edificioRepository.save(edificio);
       }
    }

    public Edificio trovaEdificio(Long id){
       return edificioRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Non c'è un edificio con questo ID!"));
    }

}
