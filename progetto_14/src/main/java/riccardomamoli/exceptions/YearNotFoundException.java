package riccardomamoli.exceptions;

public class YearNotFoundException extends RuntimeException {
    public YearNotFoundException(int anno_pubblicazione) {
        super("Nessun risultato per l'anno " + anno_pubblicazione + " trovato.");
    }
}
