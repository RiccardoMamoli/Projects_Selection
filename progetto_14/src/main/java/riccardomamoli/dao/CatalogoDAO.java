package riccardomamoli.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import riccardomamoli.entities.elementoBaseCatalogo;
import riccardomamoli.exceptions.AuthorNotFoundException;
import riccardomamoli.exceptions.NotFoundException;
import riccardomamoli.exceptions.TitleNotFoundException;
import riccardomamoli.exceptions.YearNotFoundException;

import java.util.List;



public class CatalogoDAO {
    private final EntityManager entityManager;

    public CatalogoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveElement(elementoBaseCatalogo elementoBaseCatalogo){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(elementoBaseCatalogo);
        transaction.commit();
        System.out.println("L'elemento " + elementoBaseCatalogo.getTitolo() + " è stato salvato correttamente.");
    }

    public elementoBaseCatalogo findById(long ISBN) {
        elementoBaseCatalogo elementFound = entityManager.find(elementoBaseCatalogo.class, ISBN);
        if (elementFound == null) throw new NotFoundException(ISBN);
        return elementFound;
    }

    public elementoBaseCatalogo findElementAndDelete(long ISBN) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        elementoBaseCatalogo elemento = findById(ISBN);
        entityManager.remove(elemento);
        transaction.commit();
        System.out.println(elemento + "cancellato con successo!");
        return elemento;
    }

    public List<elementoBaseCatalogo> findByYear(int anno_pubblicazione) {
        TypedQuery<elementoBaseCatalogo> query = entityManager.createQuery("SELECT e FROM elementoBaseCatalogo e WHERE e.anno_pubblicazione = :anno_pubblicazione", elementoBaseCatalogo.class);
       query.setParameter("anno_pubblicazione", anno_pubblicazione);
       List<elementoBaseCatalogo> results = query.getResultList();
       if (results == null) {
           throw new YearNotFoundException(anno_pubblicazione);
       } else {
           return results;
       }
    }

    public List<elementoBaseCatalogo> findByAuthor(String autore) {
        TypedQuery<elementoBaseCatalogo> query = entityManager.createQuery("SELECT e FROM elementoBaseCatalogo e WHERE e.autore = :autore", elementoBaseCatalogo.class);
        query.setParameter("autore", autore);
        List<elementoBaseCatalogo> results = query.getResultList();
        if (results == null) {
            throw new AuthorNotFoundException(autore);
        } else {
            return results;
        }
    }

    public List<elementoBaseCatalogo> findByTitle(String titolo) {
        TypedQuery<elementoBaseCatalogo> query = entityManager.createQuery("SELECT e FROM elementoBaseCatalogo e WHERE e.titolo LIKE :titolo", elementoBaseCatalogo.class);
        query.setParameter("titolo", "%" + titolo + "%");
        List<elementoBaseCatalogo> results = query.getResultList();
        if (results.isEmpty()) {
            throw new TitleNotFoundException(titolo);
        } else {
            return results;
        }
    }





}
