package it.objectmethod.world.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.world.dao.ICountryDao;
import it.objectmethod.world.dao.impl.CountryDaoImpl;

public class ContinentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4327403058080007080L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> listContinent = new ArrayList<>();
		ICountryDao daoContinenti = new CountryDaoImpl();
		listContinent = daoContinenti.getContinent();
		req.setAttribute("continents", listContinent);
		req.getRequestDispatcher("/Continenti.jsp").forward(req, resp);

	}
}
