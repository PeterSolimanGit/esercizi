package it.objectmethod.world.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.world.dao.ICountryDao;
import it.objectmethod.world.dao.impl.CountryDaoImpl;
import it.objectmethod.world.model.CountryModel;

public class CountryServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1701088298474622534L;

	@Override
	protected void doGet(HttpServletRequest richiesta, HttpServletResponse risposta)
			throws ServletException, IOException {
		String nomecontinente = richiesta.getParameter("continente");
		ICountryDao countries = new CountryDaoImpl();
		List<CountryModel> country = null;
		country = countries.getCountryByContinent(nomecontinente);
		richiesta.setAttribute("countries", country);
		richiesta.getRequestDispatcher("/Nazioni.jsp").forward(richiesta, risposta);
	}
}
