package no.hvl.dat107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BedriftDAO {
	
	private EntityManagerFactory emf;
	
	public BedriftDAO()
	{
		emf = Persistence.createEntityManagerFactory("bedriftPersistenceUnit");
	}
	
	public Ansatt kontaktDatabase(int ansNr)
	{
		EntityManager em = emf.createEntityManager();
		try {
        	return em.find(Ansatt.class, ansNr);

        } finally {
            em.close();
        }
	}
	
	
}
