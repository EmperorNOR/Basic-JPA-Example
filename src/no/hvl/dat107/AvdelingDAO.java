package no.hvl.dat107;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class AvdelingDAO {

	
private EntityManagerFactory emf;
	
	public AvdelingDAO()
	{
		emf = Persistence.createEntityManagerFactory("bedriftPersistenceUnit");
	}
	
	public Avdeling finnAvdelingMedId(int id)
	{
		EntityManager em = emf.createEntityManager();
		try {
        	return em.find(Avdeling.class, id);

        } finally {
            em.close();
        }
	}
	
	public List<Ansatt> alleAnsatte(int id) {
        
        EntityManager em = emf.createEntityManager();
        
        try {
        
        	String queryString = "SELECT ad FROM Avdeling ad LEFT JOIN ad.ansatte a WHERE a.id =  "+ id;
        	TypedQuery<Ansatt> query = em.createQuery(queryString, Ansatt.class);
        	return query.getResultList();
        	
        }
        finally {
            em.close();
        }
    }
	
	public Avdeling LeggTilAvdeling(String navn, Ansatt sjef)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Avdeling ad = new Avdeling(navn, sjef);
			em.persist(ad);
			tx.commit();
        	return ad;
        	
        }
		   catch (Throwable e)
        {
        	e.printStackTrace();
        	tx.rollback();
        	return null;
        }
		finally {
            em.close();
        }
	}
}
