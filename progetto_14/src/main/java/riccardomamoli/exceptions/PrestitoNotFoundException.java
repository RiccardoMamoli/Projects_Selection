package riccardomamoli.exceptions;

public class PrestitoNotFoundException extends RuntimeException {
    public PrestitoNotFoundException(int numero_tessera) {
        super("Non ci sono prestiti sulla tessera numero " + numero_tessera);
    }
}
