package no.hvl.dat107;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3")
public class Avdeling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String navn;
	private Ansatt sjef;
	
	@OneToMany(mappedBy = "avdeling", fetch = FetchType.EAGER)
	private List<Ansatt> ansatte;
	
	public Avdeling()
	{
		
	}

	public Avdeling(String navn, Ansatt sjef) {
		this.navn = navn;
		this.sjef = sjef;
	}
	
	public void leggTilAnsatt(Ansatt ansatt)
	{
		ansatte.add(ansatt);
	}
	
	public void fjernAnsatt(Ansatt ansatt)
	{
		ansatte.remove(ansatt);
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


	public Ansatt getSjef() {
		return sjef;
	}

	public void setSjef(Ansatt sjef) {
		this.sjef = sjef;
	}

	@Override
	public String toString() {
		return "Avdeling [id=" + id + ", navn=" + navn + ", sjefId=" + this.getSjef().getId() + ", ansatte=" + ansatte.toString() + "]";
	}
	
	

}
