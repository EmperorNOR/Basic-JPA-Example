package no.hvl.dat107;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProsjektAnsattePK implements Serializable {

	private int ansattProsjekt;
	private int prosjektAnsatt;
	
	public ProsjektAnsattePK() {
	}
	
	public ProsjektAnsattePK(int ansatt, int prosjekt) {
		this.ansattProsjekt = ansatt;
		this.prosjektAnsatt = prosjekt;
	}
	
}
