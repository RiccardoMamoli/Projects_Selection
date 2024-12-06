package riccardomamoli.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(String autore) {
        super("Nessun risultato trovato con autore " + autore);
    }
}
