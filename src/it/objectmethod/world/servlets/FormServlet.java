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

public class FormServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1225124419013767576L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ICountryDao daoNazioni = new CountryDaoImpl();
		List<CountryModel> country = null;
		country = daoNazioni.getCountry();
		req.setAttribute("tendina", country);
		req.getRequestDispatcher("/Form.jsp").forward(req, res);
	}

}
