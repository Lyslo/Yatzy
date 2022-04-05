package main.java.no.hvl.dat109.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//TODO javadoc
@Entity
@Table(schema = "prosjekt")
public class Bruker {

	@Id
	private String epost;
	private String brukernavn;
	private String navn;
	private String passord;

	// Getters / Setters / toString

	public String getEpost() {
		return epost;
	}

	public void setEpost(String epost) {
		this.epost = epost;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	@Override
	public String toString() {
		return "Bruker [epost=" + epost + ", brukernavn=" + brukernavn + ", passord=" + passord + "]";
	}

}
