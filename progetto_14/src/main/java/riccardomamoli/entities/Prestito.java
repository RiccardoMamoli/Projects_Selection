package riccardomamoli.entities;


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "Prestito")
public class Prestito {

    @Id
    @GeneratedValue
    @Column(name = "ID Prestito")
    private long id;

    @ManyToOne
    @JoinColumn(name = "ID Utente")
    private Utente utente;

    @OneToOne
    @JoinColumn(name = "ID Elemento")
    private elementoBaseCatalogo elementoBaseCatalogo;

    @Column(name = "Data Inizio Prestito")
    private LocalDate data_inizio_prestito;

    @Column(name = "Data Restituzione Prevista")
    private LocalDate data_restituzione_prevista;

    @Column(name = "Data Restituazione Effettiva")
    private LocalDate data_restituzione_effettiva;

    public Prestito(){}

    public Prestito(Utente utente, riccardomamoli.entities.elementoBaseCatalogo elementoBaseCatalogo, LocalDate data_restituzione_effettiva) {
        this.utente = utente;
        this.elementoBaseCatalogo = elementoBaseCatalogo;
        this.data_inizio_prestito = LocalDate.now();
        this.data_restituzione_prevista = LocalDate.now().plusDays(30);
        this.data_restituzione_effettiva = data_restituzione_effettiva;
    }

    public long getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public riccardomamoli.entities.elementoBaseCatalogo getElementoBaseCatalogo() {
        return elementoBaseCatalogo;
    }

    public void setElementoBaseCatalogo(riccardomamoli.entities.elementoBaseCatalogo elementoBaseCatalogo) {
        this.elementoBaseCatalogo = elementoBaseCatalogo;
    }

    public LocalDate getData_inizio_prestito() {
        return data_inizio_prestito;
    }

    public void setData_inizio_prestito(LocalDate data_inizio_prestito) {
        this.data_inizio_prestito = data_inizio_prestito;
    }

    public LocalDate getData_restituzione_prevista() {
        return data_restituzione_prevista;
    }

    public void setData_restituzione_prevista(LocalDate data_restituzione_prevista) {
        this.data_restituzione_prevista = data_restituzione_prevista;
    }

    public LocalDate getData_restituzione_effettiva() {
        return data_restituzione_effettiva;
    }

    public void setData_restituzione_effettiva(LocalDate data_restituzione_effettiva) {
        this.data_restituzione_effettiva = data_restituzione_effettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", data_inizio_prestito=" + data_inizio_prestito +
                ", data_restituzione_prevista=" + data_restituzione_prevista +
                ", data_restituzione_effettiva=" + data_restituzione_effettiva +
                '}';
    }

}
