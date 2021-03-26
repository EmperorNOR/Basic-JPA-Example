package no.hvl.dat107;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3")
public class Prosjekt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String navn;
	private String beskrivelse;
	
	public Prosjekt()
	{
		
	}
	
	@OneToMany(mappedBy = "ansattProsjekt")
	private List<ProsjektAnsatte> deltakelseProsjekt;
	
	public void LeggTilProsjekt(ProsjektAnsatte ansatt)
	{
		deltakelseProsjekt.add(ansatt);
	}
	
	public void fjernAnsatt(ProsjektAnsatte ansatt)
	{
		deltakelseProsjekt.remove(ansatt);
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
