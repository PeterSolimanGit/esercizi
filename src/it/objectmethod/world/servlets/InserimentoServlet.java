package it.objectmethod.world.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.world.dao.ICityDao;
import it.objectmethod.world.dao.impl.CityDaoImpl;
import it.objectmethod.world.model.CityModel;

@SuppressWarnings("serial")
public class InserimentoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest richiesta, HttpServletResponse risposta)
			throws ServletException, IOException {
		String nomecitta = richiesta.getParameter("name");
		String population = richiesta.getParameter("population");
		String district = richiesta.getParameter("district");
		String countrycode = richiesta.getParameter("ccnazione");
		String messaggioaggiunta = "Città " + nomecitta + " aggiunta";
		ICityDao daoCitta = new CityDaoImpl();
		CityModel city = new CityModel();
		city.setName(nomecitta);
		city.setPopulation(population);
		city.setDistrict(district);
		city.setCountrycode(countrycode);
		daoCitta.insertCity(city);
		richiesta.setAttribute("messaggio", messaggioaggiunta);
		richiesta.getRequestDispatcher("cities?Code=" + countrycode).forward(richiesta, risposta);

	}
}
