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

public class DeleteCityServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 204209658464417563L;

	protected void doGet(HttpServletRequest richiesta, HttpServletResponse risposta)
			throws ServletException, IOException {

		String idcitta = richiesta.getParameter("id");
		String nomecitta = richiesta.getParameter("name");
		String countrycode = richiesta.getParameter("countrycode");
		int cityid = Integer.parseInt(idcitta);
		String messaggiodelete = "Città " + nomecitta + " eliminata";
		ICityDao daoCitta = new CityDaoImpl();
		List<CityModel> city = null;
	    daoCitta.deleteCityByID(cityid);
	    city = daoCitta.getCityByCode(countrycode);
		richiesta.setAttribute("cities", city);
		richiesta.setAttribute("messaggio", messaggiodelete);
		richiesta.getRequestDispatcher("/CittaUpdated.jsp").forward(richiesta, risposta);
	}
}
