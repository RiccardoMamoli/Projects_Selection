package riccardomamoli;

import riccardomamoli.exceptions.NoIdFoundExceptions;
import riccardomamoli.exceptions.OutOfRangeNumberOfPlayersExceptions;
import riccardomamoli.exceptions.SameIdExceptions;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws OutOfRangeNumberOfPlayersExceptions, SameIdExceptions {

        Collezione collezione = new Collezione();


        Videogame videogame1 = new Videogame(1, "NBA 2k22", 2021, 24.95, "PS4", 150, Generi.SPORT );
        Videogame videogame2 = new Videogame(2, "FC2025", 2024, 84.00, "PS4", 200, Generi.SPORT );
        Videogame videogame3 = new Videogame(3, "MADDEN NFL 24", 2023, 30.75, "XBOX", 150, Generi.SPORT );
        Videogame videogame4 = new Videogame(4, "FINAL FANTASY XVI", 2023, 38.95, "XBOX", 50, Generi.RPG );
        Videogame videogame5 = new Videogame(5, "KINGDOM HEARTS III", 2019, 25.95, "PS4", 50, Generi.RPG );

        collezione.aggiungiGioco(videogame1);
        collezione.aggiungiGioco(videogame2);
        collezione.aggiungiGioco(videogame3);
        collezione.aggiungiGioco(videogame4);
        collezione.aggiungiGioco(videogame5);

        BoardGame boardGame1 = new BoardGame(6, "CLUEDO", 1949, 25.00, 4, 60);
        BoardGame boardGame2 = new BoardGame(7, "UNO", 1971, 10.00, 6, 35);
        BoardGame boardGame3 = new BoardGame(8, "MAGIC", 1993, 25.00, 2, 20);
        BoardGame boardGame4 = new BoardGame(9, "EXPLODING KITTENS", 2015, 20.00, 4, 20);
        BoardGame boardGame5 = new BoardGame(10, "CARCASSONE", 2000, 30, 6, 60);

        collezione.aggiungiGioco(boardGame1);
        collezione.aggiungiGioco(boardGame2);
        collezione.aggiungiGioco(boardGame3);
        collezione.aggiungiGioco(boardGame4);
        collezione.aggiungiGioco(boardGame5);

        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("Benvenuto nel nostro gestionale. Scegli un'operazione che vuoi eseguire.");
            System.out.println("1) Aggiungi un gioco.");
            System.out.println("2) Ricerca un gioco tramite ID.");
            System.out.println("3) Filtra giochi per prezzo.");
            System.out.println("4) Filtra giochi per numero di giocatori.");
            System.out.println("5) Elimina un gioco.");
            System.out.println("6) Stampa le statistiche dell'intera collezione.");
            System.out.println("7) Termina.");
            System.out.println(" ");

            int selezione = sc.nextInt();
            sc.nextLine();

            switch (selezione) {

                case 1:
                        System.out.println(" ");
                        System.out.println("Che tipo di gioco vuoi aggiungere?");
                        System.out.println(" ");
                        System.out.println("1) Videogame ");
                        System.out.println("2) Boardgame");
                        int tipo = sc.nextInt();

                        switch (tipo) {
                            case 1: {
                                try {
                                    System.out.println(" ");
                                    System.out.println("Inserisci un ID: ");
                                    int id = sc.nextInt();
                                    sc.nextLine();

                                    System.out.println("Inserisci il titolo del gioco: ");
                                    String titolo = sc.nextLine();

                                    System.out.println("Inserisci l'anno di pubblicazione:");
                                    int annoPub = sc.nextInt();
                                    sc.nextLine();

                                    System.out.println("Inserisci il prezzo: ");
                                    double prezzo = sc.nextDouble();
                                    sc.nextLine();

                                    System.out.println("Per quale piattaforma? ");
                                    String piattaforma = sc.nextLine();

                                    System.out.println("Quante ore di gioco ha? ");
                                    double oredigioco = sc.nextDouble();

                                    Videogame nuovoVideogame = new Videogame(id, titolo, annoPub, prezzo, piattaforma, oredigioco, Generi.SPORT);
                                    collezione.aggiungiGioco(nuovoVideogame);

                                    System.out.println(" ");
                                    System.out.println("Videogioco aggiunto con successo!");
                                    System.out.println(" ");
                                } catch (SameIdExceptions e) {
                                    System.out.println(e.getMessage());
                                }
                                break;

                            }

                            case 2: {

                                try {
                                    System.out.println(" ");
                                    System.out.println("Inserisci un ID: ");
                                    int id = sc.nextInt();
                                    sc.nextLine();

                                    System.out.println("Inserisci il titolo del gioco: ");
                                    String titolo = sc.nextLine();

                                    System.out.println("Inserisci l'anno di pubblicazione:");
                                    int annoPub = sc.nextInt();

                                    System.out.println("Inserisci il prezzo: ");
                                    double prezzo = sc.nextDouble();

                                    System.out.println("Per quanti giocatori? ");
                                    int numeroGiocatori = sc.nextInt();

                                    System.out.println("Quante dura una partita? ");
                                    double durataPartita = sc.nextDouble();

                                    BoardGame nuovoBoardgame = new BoardGame(id, titolo, annoPub, prezzo, numeroGiocatori, durataPartita);
                                    collezione.aggiungiGioco(nuovoBoardgame);

                                    System.out.println(" ");
                                    System.out.println("Gioco da tavolo aggiunto con successo!");
                                    System.out.println(" ");
                                } catch (OutOfRangeNumberOfPlayersExceptions | SameIdExceptions e) {
                                    System.out.println(e.getMessage());
                                }
                                break;

                            }
                        }
                        break;


                case 2:
                    try {
                        System.out.println(" ");
                        System.out.println("Inserisci l'ID da cercare: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        collezione.ricercaGioco(id);
                    } catch (NoIdFoundExceptions e) {
                        System.out.println(" ");
                        System.out.println(e.getMessage());
                        System.out.println(" ");
                    }
                    break;

                case 3:
                    System.out.println(" ");
                    System.out.println("Inserisci un prezzo per filtrare i giochi.");
                    System.out.println(" ");
                    double prezzo = sc.nextDouble();
                    List<GameBasicClass> giochiFiltrati = collezione.filtraGiochi(prezzo);
                    System.out.println("I giochi con prezzo inferiore a " + prezzo + " sono: ");
                    giochiFiltrati.forEach(System.out::println);
                    break;

                case 4:
                    try {
                        System.out.println(" ");
                        System.out.println("In quanti volete giocare?");
                        System.out.println(" ");
                        int giocatori = sc.nextInt();
                        collezione.ricercaPerGiocatori(giocatori);
                    } catch (OutOfRangeNumberOfPlayersExceptions e) {
                        System.out.println(" ");
                        System.out.println(e.getMessage());
                        System.out.println(" ");
                    }
                    break;

                case 5:
                    try {
                        System.out.println(" ");
                        System.out.println("Inserisci l'ID del gioco da eliminare.");
                        System.out.println(" ");
                        int id = sc.nextInt();
                        collezione.eliminaID(id);

                    } catch (NoIdFoundExceptions e) {
                        System.out.println(" ");
                        System.out.println(e.getMessage());
                        System.out.println(" ");
                    }
                    break;

                case 6:
                        collezione.stampaCollezione();
                        break;

                case 7:
                    sc.close();
                    return;
            }
        }
    }
}
