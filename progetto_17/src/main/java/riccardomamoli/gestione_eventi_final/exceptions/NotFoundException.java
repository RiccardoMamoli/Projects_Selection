package riccardomamoli.gestione_eventi_final.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {
        super("Il record con id " + id + " non è stato trovato!");
    }

    public NotFoundException(String msg) {
        super(msg);
    }
}
