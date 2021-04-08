package no.hvl.dat107;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AnsattDAO {
	
	private EntityManagerFactory emf;
	
	public AnsattDAO()
	{
		emf = Persistence.createEntityManagerFactory("bedriftPersistenceUnit");
	}
	
	public Ansatt finnAnsatt(int ansNr)
	{
		EntityManager em = emf.createEntityManager();
		try {
        	return em.find(Ansatt.class, ansNr);

        } finally {
            em.close();
        }
	}
	
	 public List<Ansatt> finnInitialer(String brukerNavn) {
	        
	        EntityManager em = emf.createEntityManager();
	        
	        try {
	        	String queryString = "SELECT a FROM Ansatt a WHERE a.brukerNavn = " + "'" + brukerNavn + "'";
	        	TypedQuery<Ansatt> query = em.createQuery(queryString, Ansatt.class);
	        	return query.getResultList();
	        } finally {
	            em.close();
	        }
	    }
	 
	 public List<Ansatt> alleAnsatte() {
	        
	        EntityManager em = emf.createEntityManager();
	        
	        try {
	        	String queryString = "SELECT a FROM Ansatt a";
	        	TypedQuery<Ansatt> query = em.createQuery(queryString, Ansatt.class);
	        	return query.getResultList();
	        	
	        } finally {
	            em.close();
	        }
	    }
	 
		public Ansatt oppdaterAnsatt(int ansNr, String stilling, int lonn)
		{
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			try {
				tx.begin();
				Ansatt a = em.find(Ansatt.class, ansNr);
				a.setStilling(stilling);
				a.setLonn(lonn);
				tx.commit();
	        	return a;
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
		
		public Ansatt LeggTilAnsatt(Ansatt ansatt)
		{
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			try {
				tx.begin();
				Ansatt a = ansatt;
				em.persist(a);
				tx.commit();
	        	return a;
	        	
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
