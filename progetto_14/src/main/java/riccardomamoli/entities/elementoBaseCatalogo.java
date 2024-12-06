package riccardomamoli.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "catalogo")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class elementoBaseCatalogo {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    protected long id;

    @Column(name = "Titolo")
    protected String titolo;

    @Column(name = "Anno Pubblicazione")
    protected int anno_pubblicazione;

    @Column(name = "Numero Pagine")
    protected int numero_pagine;

    public elementoBaseCatalogo(){}

    public elementoBaseCatalogo(String titolo, int anno_pubblicazione, int numero_pagine) {
        this.titolo = titolo;
        this.anno_pubblicazione = anno_pubblicazione;
        this.numero_pagine = numero_pagine;
    }

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnno_pubblicazione() {
        return anno_pubblicazione;
    }

    public void setAnno_pubblicazione(int anno_pubblicazione) {
        this.anno_pubblicazione = anno_pubblicazione;
    }

    public int getNumero_pagine() {
        return numero_pagine;
    }

    public void setNumero_pagine(int numero_pagine) {
        this.numero_pagine = numero_pagine;
    }

    @Override
    public String toString() {
        return "elementoBaseCatalogo{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", anno_pubblicazione=" + anno_pubblicazione +
                ", numero_pagine=" + numero_pagine +
                '}';
    }
}
