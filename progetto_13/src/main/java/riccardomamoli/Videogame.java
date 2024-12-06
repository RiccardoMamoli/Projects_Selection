package riccardomamoli;

public class Videogame extends GameBasicClass {
    private String piattaforma;
    private double ore;
    private Generi generi;

    public Videogame(Integer id, String titolo, Integer annoPubblicazione, double prezzo, String piattaforma, double ore, Generi generi) {
        super(id, titolo, annoPubblicazione, prezzo);
        this.piattaforma = piattaforma;
        this.ore = ore;
        this.generi = generi;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public double getOre() {
        return ore;
    }

    public void setOre(double ore) {
        this.ore = ore;
    }

    public Generi getGeneri() {
        return generi;
    }

    public void setGeneri(Generi generi) {
        this.generi = generi;
    }

    @Override
    public String toString() {
        return "Videogame{" + super.toString() +
                "piattaforma='" + piattaforma + '\'' +
                ", ore=" + ore +
                ", generi=" + generi +
                "}";
    }
}
