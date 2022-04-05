package main.java.no.hvl.dat109.database;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//TODO javadoc
@Stateless
public class BrukerDAO {

	@PersistenceContext(name = "DB")
	private EntityManager em;

	/**
	 * Henter alle brukere i databasen
	 * 
	 * @return List<Bruker> brukere
	 */
	public List<Bruker> hentAlle() {
		List<Bruker> all = em.createQuery("select m from Bruker m", Bruker.class).getResultList();
		return all;
	}

	/**
	 * Persister ny bruker i databasen
	 * 
	 * @param epost
	 * @param passord
	 * @param brukernavn
	 * @param navn
	 */
	public void leggTilBruker(Bruker nyBruker) {
		em.persist(nyBruker);
	}

}
