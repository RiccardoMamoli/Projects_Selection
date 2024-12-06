package riccardomamoli.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import riccardomamoli.entities.Utente;
import riccardomamoli.entities.elementoBaseCatalogo;
import riccardomamoli.exceptions.NotFoundException;

public class UtenteDAO {
    private final EntityManager entityManager;

    public UtenteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    public void saveUser(Utente utente){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(utente);
        transaction.commit();
        System.out.println("L'utente " + utente.getNome() + " " + utente.getCognome() + " è stato salvato correttamente.");
    }

    public Utente findUserById(long id) {
        Utente elementFound = entityManager.find(Utente.class, id);
        if (elementFound == null) throw new NotFoundException(id);
        return elementFound;
    }
}
