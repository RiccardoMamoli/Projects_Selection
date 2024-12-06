package riccardomamoli.gestione_eventi_final.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUtente", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "idEvento", nullable = false)
    private Evento evento;

    public Partecipazione(){}

    public Partecipazione(Utente utente, Evento evento) {
        this.utente = utente;
        this.evento = evento;
    }

    public Long getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", utente=" + utente +
                ", evento=" + evento +
                '}';
    }
}