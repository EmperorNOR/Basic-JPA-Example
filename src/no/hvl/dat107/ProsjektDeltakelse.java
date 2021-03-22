package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prosjektansatte", schema = "oblig3")
@IdClass(ProsjektDeltakelsePK.class)
public class ProsjektDeltakelse {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "Ansatt_Id")
	private Ansatt ansatt;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "Prosjekt_Id")
	private Prosjekt prosjekt;
	
	private int ansattId;
	private int prosjektId;
	private String rolle;
	private int timer;
	
	
	
	public ProsjektDeltakelse() {
	
	}
	
	public ProsjektDeltakelse(Ansatt ansatt, Prosjekt prosjekt, String rolle, int timer) {
		this.ansatt = ansatt;
		this.prosjekt = prosjekt;
		this.rolle = rolle;
		this.timer = timer;
		
		ansatt.LeggTilProsjekt(this);
		prosjekt.LeggTilProsjekt(this);
	}
	
	public int getAnsattId() {
		return ansattId;
	}
	public void setAnsattId(int ansattId) {
		this.ansattId = ansattId;
	}
	public int getProsjektId() {
		return prosjektId;
	}
	public void setProsjektId(int prosjektId) {
		this.prosjektId = prosjektId;
	}
	public String getRolle() {
		return rolle;
	}
	public void setRolle(String rolle) {
		this.rolle = rolle;
	}
	public int getTimer() {
		return timer;
	}
	public void setTimer(int timer) {
		this.timer = timer;
	}
	
	
}
