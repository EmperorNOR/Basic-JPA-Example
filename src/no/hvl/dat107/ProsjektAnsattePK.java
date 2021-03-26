package no.hvl.dat107;

import java.io.Serializable;

public class ProsjektAnsattePK implements Serializable {

	private int ansattId;
	private int prosjektId;
	
	public ProsjektAnsattePK(int ansatt, int prosjekt) {
		this.ansattId = ansatt;
		this.prosjektId = prosjekt;
	}
	
	public ProsjektAnsattePK() {
	}
	
	
}
