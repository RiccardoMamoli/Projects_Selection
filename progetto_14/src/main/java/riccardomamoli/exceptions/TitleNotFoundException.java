package riccardomamoli.exceptions;

public class TitleNotFoundException extends RuntimeException {
    public TitleNotFoundException(String titolo) {
        super("Nessun libro con titolo " + titolo + " trovato.");
    }
}
