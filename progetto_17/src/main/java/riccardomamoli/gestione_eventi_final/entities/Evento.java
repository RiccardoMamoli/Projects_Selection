package riccardomamoli.gestione_eventi_final.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "eventi")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeEvento;

    private String descrizioneEvento;

    private LocalDate dataEvento;

    private String luogoEvento;

    private int postiDisponibili;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<Partecipazione> partecipazioni;

    public Evento(){}

    public Evento(String nomeEvento, String descrizioneEvento, LocalDate dataEvento, String luogoEvento, int postiDisponibili) {
        this.nomeEvento = nomeEvento;
        this.descrizioneEvento = descrizioneEvento;
        this.dataEvento = dataEvento;
        this.luogoEvento = luogoEvento;
        this.postiDisponibili = postiDisponibili;
    }

    public Long getIdEvento() {
        return id;
    }


    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDescrizioneEvento() {
        return descrizioneEvento;
    }

    public void setDescrizioneEvento(String descrizioneEvento) {
        this.descrizioneEvento = descrizioneEvento;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getLuogoEvento() {
        return luogoEvento;
    }

    public void setLuogoEvento(String luogoEvento) {
        this.luogoEvento = luogoEvento;
    }

    public int getPostiDisponibili() {
        return postiDisponibili;
    }

    public void setPostiDisponibili(int postiDisponibili) {
        this.postiDisponibili = postiDisponibili;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nomeEvento='" + nomeEvento + '\'' +
                ", descrizioneEvento='" + descrizioneEvento + '\'' +
                ", dataEvento=" + dataEvento +
                ", luogoEvento='" + luogoEvento + '\'' +
                ", postiDisponibili=" + postiDisponibili +
                ", partecipazioni=" + partecipazioni +
                '}';
    }
}
