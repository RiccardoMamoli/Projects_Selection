package riccardomamoli.gestione_prenotazioni.exceptions;

public class SameDateException extends RuntimeException {
    public SameDateException(String message) {
        super(message);
    }
}
