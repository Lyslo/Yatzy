package main.java.no.hvl.dat109.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import no.hvl.dat109.database.Bruker;

/**
 * Klasse som kun inneholder statiske metoder knyttet til innlogging.
 * 
 * Hentet fra DAT108 forelesningsnotater fra høsten 2021
 *
 */
public class InnloggingUtils {

	// Antall sekunder en http-sesjon kan være logget inn, for eventuell timeout
	// hvis en spiller er inaktiv. Satt høyt (midlertidig?)
	public static int timeoutISekunder = 100000000;

	/**
	 * Sjekker om en http-sesjon er innlogget
	 * 
	 * @param request http-request til klient
	 * @return true, hvis klient er innlogget, ellers false
	 */
	public static boolean isInnlogget(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		return session != null && session.getAttribute("innlogget") != null;
	}

	/**
	 * Henter brukerobjektet som en bruker er innlogget med.
	 * 
	 * @param request http-request til klient
	 * @return Bruker-objekt som http-sesjonen har som sin "innlogget" attributten
	 */
	public static Bruker getInnlogget(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		return (Bruker) session.getAttribute("innlogget");
	}

	/**
	 * Logger en http-sesjon inn i "timeoutISekunder" antall sekunder. Knytter også
	 * et brukerobjekt til "innlogget" attributten.
	 * 
	 * @param request http-request til klient
	 * @param bruker  bruker-objekt som klient logget inn med
	 */
	public static void loggInnMedTimeout(HttpServletRequest request, Bruker bruker) {

		loggUt(request);
		HttpSession sesjon = request.getSession(true);
		sesjon.setMaxInactiveInterval(timeoutISekunder);
		sesjon.setAttribute("innlogget", bruker);
	}

	/**
	 * Logger ut en http-sesjon
	 * 
	 * @param request http-request til klient
	 */
	public static void loggUt(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}

}
