package main.java.no.hvl.dat109.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.database.Bruker;
import no.hvl.dat109.database.BrukerDAO;
import no.hvl.dat109.utils.InnloggingUtils;
import no.hvl.dat109.utils.Verifisering;

/**
 * Servlet som håndterer
 * "/DAT109_PROSJEKT_GR7/src/main/webapp/WEB-INF/registrer.jsp" og håndterer
 * registrering av nye brukere i databasen, i tillegg til å gjøre eventuell
 * backend verifisering.
 */
@WebServlet(name = "RegistrerServlet", urlPatterns = "/registrer")
public class RegistrerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	BrukerDAO brukerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/registrer.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Bruker nyBruker = new Bruker();
		nyBruker.setEpost(request.getParameter("email"));
		nyBruker.setPassord(request.getParameter("psw"));
		nyBruker.setBrukernavn(request.getParameter("uname"));
		nyBruker.setNavn(request.getParameter("name"));

		// TODO feilhåndtering / verifisering
		if (Verifisering.verifiser(nyBruker)) {
			brukerDAO.leggTilBruker(nyBruker);
			InnloggingUtils.loggInnMedTimeout(request, nyBruker);
			response.sendRedirect("browse");
			return;
		}

		doGet(request, response);

	}

}
