package riccardomamoli.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import riccardomamoli.entities.Prestito;
import riccardomamoli.exceptions.PrestitoNotFoundException;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;


public class PrestitoDAO {
    private final EntityManager entityManager;

    public PrestitoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createPrestito(Prestito prestito){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(prestito);
        transaction.commit();
        System.out.println("Il prestito numero " + prestito.getId() + " è stato generato correttamente.");
    }

    public List<Prestito> findByTessera(int numero_tessera) {
        TypedQuery<Prestito> query = entityManager.createQuery("SELECT p FROM Prestito p WHERE p.utente.numero_tessera = :numero_tessera", Prestito.class);
        query.setParameter("numero_tessera", numero_tessera);
        List<Prestito> prestiti = query.getResultList();
        if(prestiti.isEmpty()) {
            throw new PrestitoNotFoundException(numero_tessera);
        } else {
            return prestiti;
        }
    }

    public List<Prestito> findScaduti() {
        TypedQuery<Prestito> query = entityManager.createQuery("FROM Prestito p WHERE p.data_restituzione_prevista < :dataOdierna", Prestito.class);
        query.setParameter("dataOdierna", LocalDate.now());
        return query.getResultList();

    }
}
