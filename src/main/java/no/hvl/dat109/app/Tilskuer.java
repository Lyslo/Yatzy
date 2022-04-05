package main.java.no.hvl.dat109.app;

import no.hvl.dat109.database.Bruker;

//TODO javadoc
public class Tilskuer extends Bruker {

	public Spill spill;

	public Tilskuer(Bruker bruker) {

	}

	public Spill getSpill() {
		return spill;
	}

	public void setSpill(Spill spill) {
		this.spill = spill;
	}
}
