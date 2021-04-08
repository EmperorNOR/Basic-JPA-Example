package no.hvl.dat107;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ProsjektDAO {
	
	private EntityManagerFactory emf;
	
	public ProsjektDAO()
	{
		emf = Persistence.createEntityManagerFactory("bedriftPersistenceUnit");
	}
	
	public Prosjekt LeggTilProsjekt(Prosjekt prosjekt)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(prosjekt);
			tx.commit();
        	return prosjekt;
        	
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
	
	public void RegistrerDeltakelse(int prosjektId, int ansatteId, String rolle, int timer)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			Ansatt a = em.find(Ansatt.class, ansatteId);
			Prosjekt p = em.find(Prosjekt.class, prosjektId);
			ProsjektAnsatte ap = new ProsjektAnsatte(a, p, rolle, timer);
			tx.begin();
			em.persist(ap);
			tx.commit();
        	
        }
		   catch (Throwable e)
        {
        	e.printStackTrace();
        	tx.rollback();
        }
		finally {
            em.close();
        }
	}
	
	public void ForeTimer(int prosjektId, int ansatteId, int timer)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			ProsjektAnsattePK pk = new ProsjektAnsattePK(ansatteId, prosjektId);
			ProsjektAnsatte ap = em.find(ProsjektAnsatte.class, pk);
			ap.setTimer(timer);	
        }
		   catch (Throwable e)
        {
        	e.printStackTrace();
        }
		finally {
            em.close();
        }
	}
	
	 public List<ProsjektAnsatte> alleProsjekter() {
	        
	        EntityManager em = emf.createEntityManager();
	        
	        try {
	        	String queryString = "SELECT ap FROM ProsjektAnsatte ap";
	        	TypedQuery<ProsjektAnsatte> query = em.createQuery(queryString, ProsjektAnsatte.class);
	        	return query.getResultList();
	        	
	        } finally {
	            em.close();
	        }
	    }

}
