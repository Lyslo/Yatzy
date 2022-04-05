package main.java.no.hvl.dat109.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.database.Bruker;
import no.hvl.dat109.database.BrukerDAO;
import no.hvl.dat109.utils.InnloggingUtils;

/**
 * Servlet som håndterer
 * "/DAT109_PROSJEKT_GR7/src/main/webapp/WEB-INF/login.jsp" og eventuell
 * innlogging, eller feil ved innlogging. Hvis man prøver å aksessere en annen
 * side og ikke er innlogget blir man sendt hit.
 *
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	BrukerDAO brukerDAO;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InnloggingUtils.loggUt(request);
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String epost = request.getParameter("epost");
		String passord = request.getParameter("passord");

		List<Bruker> alleBrukere = brukerDAO.hentAlle();

		alleBrukere.forEach(b -> {
			if (b.getEpost().equals(epost) && b.getPassord().equals(passord)) {

				// Hvis innlogging stemmer, logg inn!

				InnloggingUtils.loggInnMedTimeout(request, b);

			}

		});

		if (InnloggingUtils.isInnlogget(request)) {
			response.sendRedirect("browse");
			return;
		}

		request.setAttribute("FEILMELDING", "Epost og/eller passord er feil!");
		doGet(request, response);

	}
}
