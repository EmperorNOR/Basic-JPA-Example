package no.hvl.dat107;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BedriftDAO {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bedriftPersistenceUnit");
	
}
