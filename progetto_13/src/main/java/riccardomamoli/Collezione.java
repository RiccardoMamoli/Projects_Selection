package riccardomamoli;

import riccardomamoli.exceptions.NoIdFoundExceptions;
import riccardomamoli.exceptions.OutOfRangeNumberOfPlayersExceptions;
import riccardomamoli.exceptions.SameIdExceptions;

import java.util.*;
import java.util.stream.Collectors;


public class Collezione {

    private List<GameBasicClass> tuttiGiochi;

    public Collezione () {
        this.tuttiGiochi = new ArrayList<>();
    }

    public void aggiungiGioco(GameBasicClass giocoSingolo) throws SameIdExceptions {
        for (GameBasicClass g : tuttiGiochi) {
            if (g.getId().equals(giocoSingolo.getId())) {
                throw new SameIdExceptions("L'ID " + giocoSingolo.getId() + " esiste già.");
            }
        }
        tuttiGiochi.add(giocoSingolo);
    }

    public void ricercaGioco(Integer id) throws NoIdFoundExceptions {
        Optional<GameBasicClass> giocoRicercatoID = tuttiGiochi.stream()
                .filter(g -> g.getId().equals(id)).findFirst();

        if (giocoRicercatoID.isPresent()) {
            System.out.println(" ");
            System.out.println("----------------------------------------- ");
            System.out.println("Ecco il gioco da te richiesto: ");
            GameBasicClass giocoFiltratoID = giocoRicercatoID.get();
            System.out.println(" ");
            System.out.println("ID: " + giocoFiltratoID.getId() + "\nTitolo: " + giocoFiltratoID.getTitolo() + "\nPrezzo: " + giocoFiltratoID.getPrezzo());
            System.out.println(" ");
        } else {
            throw new NoIdFoundExceptions("Non esiste nessun gioco con questo ID.");
        }


    }

    public void stampaCollezione() {
        System.out.println(" ");
        System.out.println("----------------------------------------- ");
        System.out.println(" ");
        System.out.println("Statistiche della collezione: ");
        System.out.println(" ");
        System.out.println("In totale abbiamo " + tuttiGiochi.size() + " giochi a database.");
        System.out.println(" ");
        GameBasicClass giocoCostoso = tuttiGiochi.stream().max(Comparator.comparingDouble(GameBasicClass::getPrezzo)).orElse(null);
        System.out.println("Il gioco piu costoso è " + giocoCostoso.getTitolo() + ". Costa " + giocoCostoso.getPrezzo() + " Euro.");
        System.out.println(" ");
    }

    public void ricercaPerGiocatori(Integer numeroGiocatori) throws OutOfRangeNumberOfPlayersExceptions {
        System.out.println(" ");
        System.out.println("----------------------------------------- ");
        System.out.println(" ");
        System.out.println("Lista filtrata per giocatori: ");
        System.out.println(" ");
        List<BoardGame> giochiRicercatiPerGiocatori = tuttiGiochi.stream().filter(gioco -> gioco instanceof BoardGame).map(gioco -> (BoardGame) gioco)
                .filter(g -> g.getNumGiocatori() == numeroGiocatori).collect(Collectors.toList());

        if(giochiRicercatiPerGiocatori.isEmpty()) {
            System.out.println("Non c'è nessun gioco per " + numeroGiocatori + " giocatori.");
        } else {
            giochiRicercatiPerGiocatori.forEach(gioco ->
                    System.out.println("ID:  " + gioco.getId() +
                            "\nTitolo: " + gioco.getTitolo() +
                            "\nNumero giocatori: " + gioco.getNumGiocatori() +
                            "\nPrezzo: " + gioco.getPrezzo() + "\n"));

        }
    }

    public void eliminaID(Integer id) throws NoIdFoundExceptions{
       GameBasicClass giocoEliminato = tuttiGiochi.stream().filter(gioco -> gioco.getId().equals(id)).findFirst().orElse(null);

       if(giocoEliminato == null) {
           throw new NoIdFoundExceptions("Nessun gioco ha questo ID.");
       } else {
           tuttiGiochi.remove(giocoEliminato);
           System.out.println(" ");
           System.out.println("Il gioco con ID " + id + " è stato rimosso con successo!");
           System.out.println(" ");
       }
    }



    public List<GameBasicClass> filtraGiochi (double prezzo) {
      return tuttiGiochi.stream().filter(gioco -> gioco.getPrezzo() < prezzo).collect(Collectors.toList());
      };


    public List<GameBasicClass> getTuttiGiochi() {
        return tuttiGiochi;
    }




    public void setTuttiGiochi(List<GameBasicClass> tuttiGiochi) {
        this.tuttiGiochi = tuttiGiochi;
    }

    @Override
    public String toString() {
        return "Collezione{" +
                "tuttiGiochi=" + tuttiGiochi +
                '}';
    }
}
