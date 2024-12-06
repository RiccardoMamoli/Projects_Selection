package riccardomamoli.gestione_prenotazioni.exceptions;

public class SameIdException extends RuntimeException {
    public SameIdException(String message) {
        super(message);
    }
}
