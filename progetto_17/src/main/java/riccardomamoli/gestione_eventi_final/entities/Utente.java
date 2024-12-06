package riccardomamoli.gestione_eventi_final.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import riccardomamoli.gestione_eventi_final.enums.Ruolo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "utenti")
public class Utente implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeUtente;
    private String cognomeUtente;
    private LocalDate dataNascita;
    private String usernameUtente;
    private String emailUtente;
    private String passwordUtente;

    @Enumerated(EnumType.STRING)
    private Ruolo ruolo;

    @OneToMany(mappedBy = "utente")
    private List<Partecipazione> partecipazioni;

    public Utente(){}

    public Utente(String nomeUtente, String cognomeUtente, LocalDate dataNascita, String usernameUtente, String emailUtente, String passwordUtente, Ruolo ruolo) {
        this.nomeUtente = nomeUtente;
        this.cognomeUtente = cognomeUtente;
        this.dataNascita = dataNascita;
        this.usernameUtente = usernameUtente;
        this.emailUtente = emailUtente;
        this.passwordUtente = passwordUtente;
        this.ruolo = ruolo;
    }

    public void setPasswordUtente(String passwordUtente) {
        this.passwordUtente = passwordUtente;
    }

    public String getPasswordUtente() {
        return passwordUtente;
    }

    public String getEmailUtente() {
        return emailUtente;
    }

    public void setEmailUtente(String emailUtente) {
        this.emailUtente = emailUtente;
    }

    public Long getId() {
        return id;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getCognomeUtente() {
        return cognomeUtente;
    }

    public void setCognomeUtente(String cognomeUtente) {
        this.cognomeUtente = cognomeUtente;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getUsernameUtente() {
        return usernameUtente;
    }

    public void setUsernameUtente(String usernameUtente) {
        this.usernameUtente = usernameUtente;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.ruolo.name()));
    }

    @Override
    public String getUsername() {
        return this.getEmailUtente();
    }

    @Override
    public String getPassword() {
        return this.getPasswordUtente();
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nomeUtente='" + nomeUtente + '\'' +
                ", cognomeUtente='" + cognomeUtente + '\'' +
                ", dataNascita=" + dataNascita +
                ", usernameUtente='" + usernameUtente + '\'' +
                ", ruolo=" + ruolo +
                '}';
    }
}
