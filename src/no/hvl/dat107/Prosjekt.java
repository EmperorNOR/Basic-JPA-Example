package no.hvl.dat107;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Prosjekt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String navn;
	private String beskrivelse;
	
	public Prosjekt()
	{
		
	}
	
	public Prosjekt(String navn, String beskrivelse) {
		this.navn = navn;
		this.beskrivelse = beskrivelse;
	}



	public int getId() {
		return id;
	}



	public String getNavn() {
		return navn;
	}



	public void setNavn(String navn) {
		this.navn = navn;
	}



	public String getBeskrivelse() {
		return beskrivelse;
	}



	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}



	@Override
	public String toString() {
		return "Prosjekt [id=" + id + ", navn=" + navn + ", beskrivelse=" + beskrivelse + "]";
	}
	
	

}
