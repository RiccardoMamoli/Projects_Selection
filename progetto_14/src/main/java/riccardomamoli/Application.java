package riccardomamoli;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import riccardomamoli.dao.CatalogoDAO;
import riccardomamoli.dao.PrestitoDAO;
import riccardomamoli.dao.UtenteDAO;
import riccardomamoli.entities.*;

import java.time.LocalDate;


public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("progetto_settimana_14");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        CatalogoDAO cd = new CatalogoDAO(em);
        UtenteDAO ud = new UtenteDAO(em);
        PrestitoDAO pd = new PrestitoDAO(em);

        Libro libro1 = new Libro("Harry Potter", 2007, 1000, "JK. Rowling", "Fantasy");
        Libro libro2 = new Libro("1984", 1949, 328, "George Orwell", "Dystopian");
        Libro libro3 = new Libro("To Kill a Mockingbird", 1960, 281, "Harper Lee", "Historical Fiction");

        Rivista rivista1 = new Rivista("National Geographic", 2023, 50, Periodicità.MENSILE);
        Rivista rivista2 = new Rivista("Scientific American", 2023, 98, Periodicità.MENSILE);
        Rivista rivista3 = new Rivista("Time", 2023, 60, Periodicità.SETTIMANALE);

        // AGGIUNTA ELEMENTI //

       /* cd.saveElement(libro1);
        cd.saveElement(libro2);
        cd.saveElement(libro3);
        cd.saveElement(rivista1);
        cd.saveElement(rivista2);
        cd.saveElement(rivista3);
        */

        // AGGIUNTA UTENTI //

        Utente utente1 = new Utente("Marco", "Rossi", LocalDate.of(1996, 2, 2), 1234);
        Utente utente2 = new Utente("Pietro", "Verdi", LocalDate.of(1997, 5, 20), 5678);
        Utente utente3 = new Utente("Mirco", "Neri", LocalDate.of(1990, 10, 29), 9101);

        /*
        ud.saveUser(utente1);
        ud.saveUser(utente2);
        ud.saveUser(utente3);
         */

        // CREAZIONE PRESTITO //

        Utente utente = ud.findUserById(2);
        elementoBaseCatalogo elementoPrestito = cd.findById(6);

        Prestito prestito1 = new Prestito(utente, elementoPrestito, LocalDate.of(2024, 12, 10));
         // pd.createPrestito(prestito1);



        // RICERCA ELEMENTI CON ID //

        elementoBaseCatalogo elemento = cd.findById(4);
        System.out.println(" ");
        System.out.println("Ecco qui il risultato della ricerca:");
        System.out.println(" ");
        if(elemento instanceof Libro) {
            System.out.println("Titolo: " + elemento.getTitolo() + "\nAutore: " + ((Libro) elemento).getAutore() +
                    "\nAnno di pubblicazione: " + elemento.getAnno_pubblicazione() + "\nGenere: " + ((Libro) elemento).getGenere());
        } else if(elemento instanceof Rivista) {
            System.out.println("Titolo: " + elemento.getTitolo() + "\nPeriodicità: " + ((Rivista) elemento).getPeriodicità() + "\nNumero di pagine: " + elemento.getNumero_pagine());
        }

        // ELIMINA ELEMENTI PER ID //

        /* elementoBaseCatalogo elementoDaEliminare = cd.findElementAndDelete(1);
        System.out.println(" ");
        System.out.println("Hai eliminato il seguente elemento: " + elementoDaEliminare);
        System.out.println(" ");

         */

        // FILTRA PER ANNO //

        System.out.println(" ");
        cd.findByYear(2023).forEach(System.out::println);
        System.out.println(" ");

        // FILTRA PER AUTORE //

        System.out.println(" ");
        cd.findByAuthor("George").forEach(System.out::println);
        System.out.println(" ");

        // FILTRA PER TITOLO O PARTE //
        System.out.println(" ");
        cd.findByTitle("19").forEach(System.out::println);
        System.out.println(" ");

        // RICERCA PER TESSERA //

        System.out.println(" ");
        pd.findByTessera(5678).forEach(System.out::println);
        System.out.println(" ");

        // RICERCA SCADUTI //
        System.out.println(" ");
        pd.findScaduti().forEach(System.out::println);
        System.out.println(" ");












        em.close();
        emf.close();
    }
}
