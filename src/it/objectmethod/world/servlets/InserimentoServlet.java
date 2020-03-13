package it.objectmethod.world.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.world.dao.ICityDao;
import it.objectmethod.world.dao.impl.CityDaoImpl;

@SuppressWarnings("serial")
public class InserimentoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest richiesta, HttpServletResponse risposta)
			throws ServletException, IOException {
		String nomecitta = richiesta.getParameter("name");
		String population = richiesta.getParameter("population");
		int popolazione = Integer.parseInt(population);
		String district = richiesta.getParameter("district");
		String countrycode = richiesta.getParameter("ccnazione");
		String messaggioaggiunta = "Città " + nomecitta + " eliminata";
		ICityDao daoCitta = new CityDaoImpl();
		daoCitta.insertCity(nomecitta, countrycode, popolazione, district);
		richiesta.setAttribute("messaggio", messaggioaggiunta);
		richiesta.getRequestDispatcher("cities").forward(richiesta, risposta);
		
		
	}
}
