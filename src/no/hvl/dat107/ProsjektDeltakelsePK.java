package no.hvl.dat107;

import javax.persistence.Entity;


public class ProsjektDeltakelsePK {

	private int ansatt;
	private int prosjekt;
	
	public ProsjektDeltakelsePK(int ansatt, int prosjekt) {
		this.ansatt = ansatt;
		this.prosjekt = prosjekt;
	}
	
	public ProsjektDeltakelsePK() {
	}
	
	
	public int getAnsatt() {
		return ansatt;
	}
	public void setAnsatt(int ansatt) {
		this.ansatt = ansatt;
	}
	public int getProsjekt() {
		return prosjekt;
	}
	public void setProsjekt(int prosjekt) {
		this.prosjekt = prosjekt;
	}
}
