package no.hvl.dat107;


public class ProsjektAnsattePK {

	private int ansatt;
	private int prosjekt;
	
	public ProsjektAnsattePK(int ansatt, int prosjekt) {
		this.ansatt = ansatt;
		this.prosjekt = prosjekt;
	}
	
	public ProsjektAnsattePK() {
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
