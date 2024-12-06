package riccardomamoli.gestione_prenotazioni.entities;

import jakarta.persistence.*;
import riccardomamoli.gestione_prenotazioni.enums.TipologiaPostazione;

import java.util.List;

@Entity
@Table(name = "postazione")
public class Postazione {

    @Column(name = "id_postazione")
    @Id
    @GeneratedValue
    private long idPostazione;

    @ManyToOne
    @JoinColumn(name = "id_edificio")
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;

    @Column(name = "codice_univoco", unique = true)
    private String codiceUnivoco;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "tipo_postazione")
    @Enumerated(EnumType.STRING)
    private TipologiaPostazione tipoPostazione;

    @Column(name = "max_partecipanti")
    private int maxPartecipanti;

    public Postazione(){}

    public Postazione(Edificio edificio, String codiceUnivoco, String descrizione, TipologiaPostazione tipoPostazione, int maxPartecipanti) {
        this.edificio = edificio;
        this.codiceUnivoco = codiceUnivoco;
        this.descrizione = descrizione;
        this.tipoPostazione = tipoPostazione;
        this.maxPartecipanti = maxPartecipanti;
    }

    public long getIdPostazione() {
        return idPostazione;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    public String getCodiceUnivoco() {
        return codiceUnivoco;
    }

    public void setCodiceUnivoco(String codiceUnivoco) {
        this.codiceUnivoco = codiceUnivoco;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipologiaPostazione getTipoPostazione() {
        return tipoPostazione;
    }

    public void setTipoPostazione(TipologiaPostazione tipoPostazione) {
        this.tipoPostazione = tipoPostazione;
    }

    public int getMaxPartecipanti() {
        return maxPartecipanti;
    }

    public void setMaxPartecipanti(int maxPartecipanti) {
        this.maxPartecipanti = maxPartecipanti;
    }

    @Override
    public String toString() {
        return "Postazione{" +
                "idPostazione=" + idPostazione +
                ", edificio=" + edificio +
                ", prenotazioni=" + prenotazioni +
                ", codiceUnivoco='" + codiceUnivoco + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", tipoPostazione=" + tipoPostazione +
                ", maxPartecipanti=" + maxPartecipanti +
                '}';
    }
}
