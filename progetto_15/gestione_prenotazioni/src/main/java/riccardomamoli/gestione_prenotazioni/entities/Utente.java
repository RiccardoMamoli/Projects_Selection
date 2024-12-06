package riccardomamoli.gestione_prenotazioni.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "utente")

public class Utente {

    @Id
    @GeneratedValue
    private long idUtente;

    @Column(name = "username")
    private String username;

    @Column(name = "nome")
    private String nomeUtente;

    @Column(name = "email")
    private String emailUtente;

    public Utente(){};

    public Utente(String username, String nomeUtente, String emailUtente) {
        this.username = username;
        this.nomeUtente = nomeUtente;
        this.emailUtente = emailUtente;
    }

    public long getIdUtente() {
        return idUtente;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getEmailUtente() {
        return emailUtente;
    }

    public void setEmailUtente(String emailUtente) {
        this.emailUtente = emailUtente;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "idUtente=" + idUtente +
                ", username='" + username + '\'' +
                ", nomeUtente='" + nomeUtente + '\'' +
                ", emailUtente='" + emailUtente + '\'' +
                '}';
    }
}
