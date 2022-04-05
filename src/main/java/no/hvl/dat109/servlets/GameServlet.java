package main.java.no.hvl.dat109.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat109.app.Spill;
import no.hvl.dat109.app.Spiller;
import no.hvl.dat109.database.Bruker;
import no.hvl.dat109.utils.InnloggingUtils;

// TODO javadoc
@WebServlet(name = "GameServlet", urlPatterns = "/game")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Spill spill;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!InnloggingUtils.isInnlogget(request)) {
			request.setAttribute("FEILMELDING", "Du har blitt logget ut!");
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
			return;
		}

		HttpSession session = request.getSession(false);
		this.spill = (Spill) session.getAttribute("spill");

		request.setAttribute("spill", spill);

		request.getRequestDispatcher("WEB-INF/game.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean[] trille = new boolean[5];

		String t1 = req.getParameter("t1");
		if (t1 != null)
			trille[0] = true;

		String t2 = req.getParameter("t2");
		if (t2 != null)
			trille[1] = true;

		String t3 = req.getParameter("t3");
		if (t3 != null)
			trille[2] = true;

		String t4 = req.getParameter("t4");
		if (t4 != null)
			trille[3] = true;

		String t5 = req.getParameter("t5");
		if (t5 != null)
			trille[4] = true;

		HttpSession session = req.getSession(false);
		Spiller spiller = (Spiller) session.getAttribute("spiller");

		spiller.SpillRunde(trille);

		doGet(req, resp);
	}

}
