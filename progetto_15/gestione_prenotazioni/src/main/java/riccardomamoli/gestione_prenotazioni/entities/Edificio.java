package riccardomamoli.gestione_prenotazioni.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "edificio")
public class Edificio {

    @Column(name = "id_edificio")
    @Id
    @GeneratedValue
    private long idEdificio;

    @Column(name = "nome_edificio")
    private String nomeEdificio;

    @Column(name = "indirizzo_edificio")
    private String indirizzEdificio;

    @Column(name = "citta_edificio")
    private String cittEdificio;

    public Edificio(){};

    public Edificio(String nomeEdificio, String indirizzEdificio, String cittEdificio) {
        this.nomeEdificio = nomeEdificio;
        this.indirizzEdificio = indirizzEdificio;
        this.cittEdificio = cittEdificio;
    }

    public long getIdEdificio() {
        return idEdificio;
    }

    public String getNomeEdificio() {
        return nomeEdificio;
    }

    public void setNomeEdificio(String nomeEdificio) {
        this.nomeEdificio = nomeEdificio;
    }

    public String getIndirizzEdificio() {
        return indirizzEdificio;
    }

    public void setIndirizzEdificio(String indirizzEdificio) {
        this.indirizzEdificio = indirizzEdificio;
    }

    public String getCittEdificio() {
        return cittEdificio;
    }

    public void setCittEdificio(String cittEdificio) {
        this.cittEdificio = cittEdificio;
    }

    @Override
    public String toString() {
        return "Edificio{" +
                "idEdificio=" + idEdificio +
                ", nomeEdificio='" + nomeEdificio + '\'' +
                ", indirizzEdificio='" + indirizzEdificio + '\'' +
                ", cittEdificio='" + cittEdificio + '\'' +
                '}';
    }
}
