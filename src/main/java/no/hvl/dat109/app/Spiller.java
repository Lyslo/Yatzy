package main.java.no.hvl.dat109.app;

import no.hvl.dat109.database.Bruker;

//TODO javadoc
public class Spiller {

	private Spill spill;
	private Bruker bruker;
	private Poengtabell tabell;
	private int kast = 0;
	private Terning[] terninger;

	public Spiller(Bruker bruker) {
		this.bruker = bruker;
		this.terninger = new Terning[] { new Terning(), new Terning(), new Terning(), new Terning(), new Terning() };
	}

	public Spill getSpill() {
		return spill;
	}

	public void setSpill(Spill spill) {
		Spill.fjernSpillerFraAlleSpill(this);
		this.spill = spill;
		this.tabell = new Poengtabell();
	}

	public void ForlatSpill() {
		Spill.fjernSpillerFraAlleSpill(this);
		this.spill = null;
		this.tabell = null;
	}

	public void SpillRunde(boolean[] trill) {
		for (int i = 0; i < terninger.length; i++) {
			if (trill[i])
				terninger[i].roll();
		}

		kast++;

		if (kast == 3) {
			tabell.leggInn(spill.getRunderSpilt(), terninger);
			spill.spillRunde();
			kast = 0;
		}

	}

	public int[] getHand() {
		if (kast == 0 && spill.getAktivSpiller().getEpost().equals(this.getEpost())) {
			terninger = new Terning[] { new Terning(), new Terning(), new Terning(), new Terning(), new Terning() };
		}

		int[] tab = new int[terninger.length];
		for (int i = 0; i < terninger.length; i++) {
			tab[i] = terninger[i].getFaceValue();
		}
		return tab;
	}

	// Getters / Setters / toString

	public String getBrukernavn() {
		return bruker.getBrukernavn();
	}

	public String getEpost() {
		return bruker.getEpost();
	}

	public Poengtabell getTabell() {
		return tabell;
	}

	public int getKast() {
		return kast;
	}

	@Override
	public String toString() {
		return "Spiller [bruker=" + bruker + "]";
	}

}
