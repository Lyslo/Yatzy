package main.java.no.hvl.dat109.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//TODO javadoc
public class Spill {

	public static Map<Integer, Spill> spill;

	public int ID; // TODO basere denne på alle spill spilt og ikke bare de i minnet

	public Admin admin;

	public Map<String, Spiller> spillere;

	private boolean startet = false;
	private boolean ferdig = false;
	private boolean slettes = false;
	public int runderSpilt = -1;

	private Spiller aktivSpiller;
	private int spillerIndex;
	private String winner;

	/**
	 * Opprette nytt spill, med en admin som eneste spiller. Legger spillet til i
	 * listen av spill
	 * 
	 * @param admin Spiller-object som administrerer spillet
	 */
	public Spill(Admin admin) {
		this.ID = getSpill().size() + 1;
		this.admin = admin;
		this.spillere = new ConcurrentHashMap<String, Spiller>();
		spillere.put(admin.getEpost(), admin);

		admin.setSpill(this);
		spill.put(ID, this);
	}

	/**
	 * Starter et spill
	 */
	public void start() {
		this.startet = true;
		this.runderSpilt = 1; // ???????
		spillerIndex = 0;
		this.aktivSpiller = getSpillere().get(0);
	}

	/**
	 * Håndterer hvem sin runde det er
	 */
	public void spillRunde() {
		
		if (runderSpilt > 0) {
			Spiller winner = getSpillere().get(0);

			for (int i = 0; i < getSpillere().size(); i++) {
				if (getSpillere().get(i).getTabell().sluttresultat() > winner.getTabell().sluttresultat()) {
					winner = getSpillere().get(i);
				}
			}
			this.winner = winner.getBrukernavn();
		}

		spillerIndex++;
		if (spillerIndex >= getSpillere().size()) {
			spillerIndex = 0;
			runderSpilt++;
		}

		aktivSpiller = getSpillere().get(spillerIndex);
		
		if(runderSpilt > 15) {
			aktivSpiller = null;
			// TODO hva skal skje når man vinner?
			ferdig = true;
		}
	}

	public String winner() {
		return winner;
	}

	/**
	 * Hente liste av alle pågående spill, hvis det er ingen initialisert lag en ny
	 * liste
	 * 
	 * @return alle spill i minnet
	 */
	public static List<Spill> getSpill() {
		if (spill == null) {
			spill = new ConcurrentHashMap<Integer, Spill>();
		}
		return new ArrayList(spill.values());
	}

	/**
	 * Hente peker til et spill i minne basert på ID
	 * 
	 * @param ID - til spillet du leter etter
	 * @return Spill peker
	 */
	public static Spill getSpillFraID(int ID) {
		return spill.get(ID);
	}

	/**
	 * Hente ID til et spill
	 * 
	 * @return ID til spill
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Hente spillets admin
	 * 
	 * @return spiller som administrerer dette spillet
	 */
	public Admin getAdmin() {
		return admin;
	}

	/**
	 * Hente liste av alle spillere i et spill
	 * 
	 * @return
	 */
	public List<Spiller> getSpillere() {
		return new ArrayList(spillere.values());
	}

	/**
	 * Hent rundenummer
	 * 
	 * @return rundenummer
	 */
	public int getRunderSpilt() {
		return runderSpilt;
	}

	/**
	 * Hent den spilleren som har sin tur
	 * 
	 * @return
	 */
	public Spiller getAktivSpiller() {
		return aktivSpiller;
	}

	/**
	 * Sjekker om spillet har startet
	 * 
	 * @return om spillet har startet
	 */
	public boolean startet() {
		return startet;
	}

	/**
	 * Sletter et spill fra minnet
	 */
	public void slettSpill() {
		spill.remove(this.ID);
		this.slettes = true;
	}

	/**
	 * Fjerner en spiller, hvis det er eneste spiller eller admin, sletter spillet.
	 * faen dette er rotete -arne
	 * 
	 * @param spiller som skal fjernes
	 */
	public void fjernSpiller(Spiller spiller) {
		if (this.admin.getEpost().equals(spiller.getEpost())) {
			slettSpill();

			getSpillere().forEach(s -> s.ForlatSpill());

			return;
		}
		spillere.remove(spiller.getEpost());
	}

	/**
	 * Legg til ny spiller i spillet, hvis bruker (spiller) med likt brukernavn
	 * allerede deltar skjer ingenting. Hvis spillere = 6 aka spillet er fullt eller
	 * spillet allerede har startet, returner
	 * 
	 * @param spiller som skal legges til
	 */
	public void join(Spiller spiller) {
		if (startet) {
			return;
		}

		if (getSpillere().size() >= 6) {
			return;
		}

		for (int i = 0; i < getSpillere().size(); i++) {
			if (getSpillere().get(i).getBrukernavn().equals(spiller.getBrukernavn()))
				return;
		}

		spiller.setSpill(this);
		this.spillere.put(spiller.getEpost(), spiller);

	}

	/**
	 * Legger til tilskuer til spillet
	 * 
	 * @param tilskuer
	 */
	public void spectate(Tilskuer tilskuer) {
		// TODO Auto-generated method stub

	}

	/**
	 * Returnerer statusen til spillet
	 * 
	 * @return
	 */
	public String status() {
		if (!startet) {
			return "Ikke startet";
		} else {
			return "Spillet har startet! Runde: " + runderSpilt;
		}
	}

	/**
	 * Rydde opp i ting
	 * 
	 * @param epost
	 */
	public static void fjernSpillerFraAlleSpill(Spiller spiller) {
		List<Spill> spills = getSpill();
		spills.forEach(s -> s.fjernSpiller(spiller));
		spill = new ConcurrentHashMap<Integer, Spill>();

		spills.forEach(s -> {
			if (!s.slettes)
				spill.put(s.getID(), s);
		});

	}
	
	public boolean isFerdig() {
		return ferdig;
	}

	public void setFerdig(boolean ferdig) {
		this.ferdig = ferdig;
	}

	@Override
	public String toString() {
		return "Spill [ID=" + ID + ", admin=" + admin + "]";
	}

}
