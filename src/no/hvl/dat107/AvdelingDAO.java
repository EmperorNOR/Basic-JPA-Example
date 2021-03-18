package no.hvl.dat107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
