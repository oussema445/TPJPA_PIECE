package com.oussema.dao; 

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.oussema.entities.Piece; 
import com.oussema.util.JPAutil; 

public class PieceDao { 

    private EntityManager entityManager = JPAutil.getEntityManager("MonProjetJPA_PIECE"); 

    public void ajouter(Piece p) { 
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(p);
        tx.commit();
    }

    public void modifier(Piece p) { 
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(p);
        tx.commit();
    }

    public void supprimer(Piece p) { 
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        p = entityManager.merge(p);
        entityManager.remove(p);
        tx.commit();
    }

    public Piece consulter(Piece p, Object id) { 
        return entityManager.find(p.getClass(), id);
    }

    public List<Piece> listerTous() {
        List<Piece> pieces = entityManager.createQuery("select p from Piece p").getResultList(); // Changement du nom de la classe dans la requête

        return pieces;
    }

    public List<Piece> listerParNom(String nom_piece) { 
        List<Piece> pieces = entityManager.createQuery("select p from Piece p where p.nom_piece like :pnom")
                .setParameter("pnom", "%" + nom_piece + "%")
                .getResultList();

        return pieces;
    }
}
