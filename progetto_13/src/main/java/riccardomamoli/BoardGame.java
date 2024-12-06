package riccardomamoli;

import riccardomamoli.exceptions.OutOfRangeNumberOfPlayersExceptions;

public class BoardGame extends GameBasicClass {
    private Integer numGiocatori;
    private double durataPartita;

    public BoardGame(Integer id, String titolo, Integer annoPubblicazione,  double prezzo, Integer numGiocatori, double durataPartita) throws OutOfRangeNumberOfPlayersExceptions {
        super(id, titolo, annoPubblicazione, prezzo);

        if (numGiocatori < 2 || numGiocatori > 10) {
            throw new OutOfRangeNumberOfPlayersExceptions("Il numero di giocatori non è nel range accettato (2-10).");
        }
        this.numGiocatori = numGiocatori;
        this.durataPartita = durataPartita;
    }

    public Integer getNumGiocatori() {
        return numGiocatori;
    }

    public void setNumGiocatori(Integer numGiocatori) {
        this.numGiocatori = numGiocatori;
    }

    public double getDurataPartita() {
        return durataPartita;
    }

    public void setDurataPartita(double durataPartita) {
        this.durataPartita = durataPartita;
    }

    @Override
    public String toString() {
        return "BoardGame{"  + super.toString() +
                "numGiocatori=" + numGiocatori +
                ", durataPartita=" + durataPartita +
                "}";
    }
}
