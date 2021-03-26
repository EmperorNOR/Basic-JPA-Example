package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3")
@IdClass(ProsjektAnsattePK.class)
public class ProsjektAnsatte {
	
	@Id
	private int ansattId;
	
	@Id
	private int prosjektId;
	
	@ManyToOne
	@JoinColumn(name = "Ansatt_Id")
	private Ansatt ansattProsjekt;
	
	
	@ManyToOne
	@JoinColumn(name = "Prosjekt_Id")
	private Prosjekt prosjektAnsatt;
	
	private String rolle;
	private int timer;
	
	
	
	public ProsjektAnsatte() {
	
	}
	
	public ProsjektAnsatte(Ansatt ansatt, Prosjekt prosjekt, String rolle, int timer) {
		this.ansattProsjekt = ansatt;
		this.prosjektAnsatt = prosjekt;
		this.rolle = rolle;
		this.timer = timer;
		
		ansattProsjekt.LeggTilProsjekt(this);
		prosjektAnsatt.LeggTilProsjekt(this);
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
