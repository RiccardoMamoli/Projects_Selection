package riccardomamoli.gestione_prenotazioni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazione")
public class Prenotazione {

    @Id
    @GeneratedValue
    private long idPrenotazione;

    @ManyToOne
    @JoinColumn(name = "idUtente")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "idPostazione")
    private Postazione postazione;

    @Column(name = "data_prenotazione")
    private LocalDate dataPrenotazione;

    public Prenotazione(){};

    public Prenotazione(Utente utente, Postazione postazione, LocalDate dataPrenotazione) {
        this.utente = utente;
        this.postazione = postazione;
        this.dataPrenotazione = dataPrenotazione;
    }

    public long getIdPrenotazione() {
        return idPrenotazione;
    }


    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Postazione getPostazione() {
        return postazione;
    }

    public void setPostazione(Postazione postazione) {
        this.postazione = postazione;
    }

    public LocalDate getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setDataPrenotazione(LocalDate dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "idPrenotazione=" + idPrenotazione +
                ", utente=" + utente +
                ", postazione=" + postazione +
                ", dataPrenotazione=" + dataPrenotazione +
                '}';
    }
}
