package no.hvl.dat107;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3")
public class Ansatt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String brukerNavn;
	private String forNavn;
	private String etterNavn;
	private LocalDate ansettelsesDato;
	private String stilling;
	private int lonn;
	
	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Avdeling avdeling;
	
	
	public Ansatt()
	{
		
	}
	
	public Ansatt(String brukerNavn, String forNavn, String etterNavn, LocalDate ansettelsesDato, String stilling,
			int lonn, Avdeling avdeling) {

		this.brukerNavn = brukerNavn;
		this.forNavn = forNavn;
		this.etterNavn = etterNavn;
		this.ansettelsesDato = ansettelsesDato;
		this.stilling = stilling;
		this.lonn = lonn;
		this.avdeling = avdeling;
	}

	@OneToMany(mappedBy = "prosjektAnsatt")
	private List<ProsjektAnsatte> deltakelseAnsatt;
	
	public void LeggTilProsjekt(ProsjektAnsatte prosjekt)
	{
		deltakelseAnsatt.add(prosjekt);
	}

	public int getId() {
		return id;
	}

	public String getBrukerNavn() {
		return brukerNavn;
	}

	public void setBrukerNavn(String brukerNavn) {
		this.brukerNavn = brukerNavn;
	}

	public String getForNavn() {
		return forNavn;
	}

	public void setForNavn(String forNavn) {
		this.forNavn = forNavn;
	}

	public String getEtterNavn() {
		return etterNavn;
	}

	public void setEtterNavn(String etterNavn) {
		this.etterNavn = etterNavn;
	}

	public LocalDate getAnsettelsesDato() {
		return ansettelsesDato;
	}

	public void setAnsettelsesDato(LocalDate ansettelsesDato) {
		this.ansettelsesDato = ansettelsesDato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public int getLonn() {
		return lonn;
	}

	public void setLonn(int lonn) {
		this.lonn = lonn;
	}

	public Avdeling getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(Avdeling avdeling) {
		this.avdeling = avdeling;
	}

	@Override
	public String toString() {
		return "Ansatt [id=" + id + ", brukerNavn=" + brukerNavn + ", forNavn=" + forNavn + ", etterNavn=" + etterNavn
				+ ", ansettelsesDato=" + ansettelsesDato + ", stilling=" + stilling + ", lonn=" + lonn + ", avdeling="
				+ avdeling + ", deltakelse=" + deltakelseAnsatt + "]";
	}


}
