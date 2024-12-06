package riccardomamoli.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "Rivista")

public class Rivista extends elementoBaseCatalogo {

    @Column(name = "Periodicità")
    @Enumerated(EnumType.STRING)
    private Periodicità periodicità;

    public Rivista(){}

    public Rivista(String titolo, int anno_pubblicazione, int numero_pagine, Periodicità periodicità) {
        super(titolo, anno_pubblicazione, numero_pagine);
        this.periodicità = periodicità;
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicità=" + periodicità +
                ", id=" + id +
                ", titolo='" + titolo + '\'' +
                ", anno_pubblicazione=" + anno_pubblicazione +
                ", numero_pagine=" + numero_pagine +
                "} " + super.toString();
    }
}
