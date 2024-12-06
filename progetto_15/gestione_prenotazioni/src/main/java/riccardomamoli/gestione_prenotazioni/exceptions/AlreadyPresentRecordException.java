package riccardomamoli.gestione_prenotazioni.exceptions;

public class AlreadyPresentRecordException extends RuntimeException {
    public AlreadyPresentRecordException(String message) {
        super(message);
    }
}
