package it.objectmethod.world.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.world.dao.ICityDao;
import it.objectmethod.world.dao.impl.CityDaoImpl;
import it.objectmethod.world.model.CityModel;

public class CityServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7970979120915108459L;

	protected void doGet(HttpServletRequest richiesta, HttpServletResponse risposta)
			throws ServletException, IOException {
		String codicecitta = richiesta.getParameter("Code");
		ICityDao daoCitta = new CityDaoImpl();
		List<CityModel> city = null;
		city = daoCitta.getCityByCountrycode(codicecitta);
		richiesta.setAttribute("cities", city);
		richiesta.getRequestDispatcher("/Citta.jsp").forward(richiesta, risposta);

	}
}
