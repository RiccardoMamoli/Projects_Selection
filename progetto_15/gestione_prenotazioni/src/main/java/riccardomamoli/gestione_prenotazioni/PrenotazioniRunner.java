package riccardomamoli.gestione_prenotazioni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import riccardomamoli.gestione_prenotazioni.entities.Edificio;
import riccardomamoli.gestione_prenotazioni.entities.Postazione;
import riccardomamoli.gestione_prenotazioni.entities.Prenotazione;
import riccardomamoli.gestione_prenotazioni.entities.Utente;
import riccardomamoli.gestione_prenotazioni.enums.TipologiaPostazione;
import riccardomamoli.gestione_prenotazioni.services.PrenotazioneService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Component
public class PrenotazioniRunner implements CommandLineRunner {
    @Autowired
    PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {


/*
        Utente utente1 = new Utente("riccardoM", "Riccardo Mamoli", "ric@gmail.com");
        Utente utente2 = new Utente("marcoP", "Marco Panarelli", "marco1@gmail.com");
        Utente utente3 = new Utente("francescoR", "Francesco Rizzoli", "franc@gmail.com");
        prenotazioneService.creaUtente(utente1);
        prenotazioneService.creaUtente(utente2);
        prenotazioneService.creaUtente(utente3);


        Edificio edificio1 = new Edificio("Edificio Rosso", "Via Rossi 16" , "Reggio Emilia");
        Edificio edificio2 = new Edificio("Edifcio Blu", "Via Blu 43", "Milano");
        Edificio edificio3 = new Edificio("Edifcio Verde", "Via Verdi 2", "Parma");


        Edificio edificio4 = new Edificio("Edificio Azzurro", "Via Martiri", "Parma");
        Edificio edificio5 = new Edificio("Edificio Nero", "Via Piero", "Reggio Emilia");
        Edificio edificio6 = new Edificio("Edificio Arancio", "Via Martinelli", "Milano");
        Edificio edificio7 = new Edificio("Edificio Marrone", "Via Acquaviva", "Reggio Emilia");

        prenotazioneService.creaEdificio(edificio5);
        prenotazioneService.creaEdificio(edificio6);
        prenotazioneService.creaEdificio(edificio7);

 */




        Edificio edificioTrovato4 = prenotazioneService.trovaEdificio(Long.valueOf(52));
        Edificio edificioTrovato5 = prenotazioneService.trovaEdificio(Long.valueOf(102));
        Edificio edificioTrovato6 = prenotazioneService.trovaEdificio(Long.valueOf(103));
        Edificio edificioTrovato7 = prenotazioneService.trovaEdificio(Long.valueOf(104));

        Utente utenteTrovato1 = prenotazioneService.trovaUtente(Long.valueOf(1));
        Utente utenteTrovato2 = prenotazioneService.trovaUtente(Long.valueOf(2));
        Utente utenteTrovato3 = prenotazioneService.trovaUtente(Long.valueOf(3));

        Postazione postazioneTrovata1 = prenotazioneService.trovaPostazione(Long.valueOf(1));
        Postazione postazioneTrovata2 = prenotazioneService.trovaPostazione(Long.valueOf(2));
        Postazione postazioneTrovata3 = prenotazioneService.trovaPostazione(Long.valueOf(52));



        Postazione postazione1 = new Postazione(edificioTrovato4, "45453", "Postazione molto carina", TipologiaPostazione.PRIVATO, 14);
        Postazione postazione2 = new Postazione(edificioTrovato4, "543454524", "Altra postazione carina", TipologiaPostazione.SALA_RIUNIONI,55);
        Postazione postazione3 = new Postazione(edificioTrovato4, "9543532453","Molta carina anche questa", TipologiaPostazione.PRIVATO, 4);
        Postazione postazione4 = new Postazione(edificioTrovato4, "345460965", "cute", TipologiaPostazione.PRIVATO, 109);
        // prenotazioneService.creaPostazione(postazione1);
         // prenotazioneService.creaPostazione(postazione2);
        // prenotazioneService.creaPostazione(postazione3);
         // prenotazioneService.creaPostazione(postazione4);

        /*
        System.out.println(" ");
        System.out.println("Hai creato una nuova postazione: ");
        System.out.println(" ");
        System.out.println("ID: " + postazione3.getIdPostazione());
        System.out.println("Presso l'edificio: " + postazione3.getEdificio().getNomeEdificio());
        System.out.println("Tipologia: " + postazione3.getTipoPostazione());
        System.out.println("Numero massimo partecipanti: " + postazione3.getMaxPartecipanti());
        System.out.println(" ");

         */




        //Prenotazione prenotazione1 = new Prenotazione(utenteTrovato1, postazioneTrovata1, LocalDate.of(2024 , 10, 1));
        //Prenotazione prenotazione2 = new Prenotazione(utenteTrovato2, postazioneTrovata2, LocalDate.of(2024, 9,10));
        // Prenotazione prenotazione3 = new Prenotazione(utenteTrovato3, postazioneTrovata3, LocalDate.of(2024, 10, 12));
        //prenotazioneService.creaPrenotazione(prenotazione1);
        //prenotazioneService.creaPrenotazione(prenotazione2);
        //prenotazioneService.creaPrenotazione(prenotazione3);

         // Prenotazione prenotazione4 = new Prenotazione(utenteTrovato1, postazioneTrovata2, LocalDate.of(2024, 9,10));
         // prenotazioneService.creaPrenotazione(prenotazione4);

       List<Postazione> listaPostazioni =  prenotazioneService.trovaPostazioniPerTipoECittà(TipologiaPostazione.SALA_RIUNIONI, "Reggio Emilia");
       listaPostazioni.forEach(postazione -> {
           System.out.println(" ");
           System.out.println("Postazione numero " + postazione.getIdPostazione());
           System.out.println("Situata a: " + postazione.getEdificio().getCittEdificio());
           System.out.println("In via " + postazione.getEdificio().getIndirizzEdificio());
           System.out.println("Edificio: " + postazione.getEdificio().getNomeEdificio());
           System.out.println("Tipologia:" + postazione.getTipoPostazione());
           System.out.println(" ");
       });

    }
}
