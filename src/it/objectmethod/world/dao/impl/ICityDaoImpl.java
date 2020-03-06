package it.objectmethod.world.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.world.config.JdbcConnection;
import it.objectmethod.world.dao.ICityDao;
import it.objectmethod.world.model.CityModel;

public class ICityDaoImpl implements ICityDao {
	public List<CityModel> getCityByCode(String countrycode) {
		List<CityModel> listCities = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		CityModel cities = null;
		try {
			conn = JdbcConnection.getConnection();
			String sql = "Select city.Name,city.Population from city inner join country on city.CountryCode = country.Code WHERE country.Code = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, countrycode);
			rs = stmt.executeQuery();
			while (rs.next()) {

				cities = new CityModel();
				cities.setName(rs.getString("Name"));
				cities.setPopulation(rs.getString("Population"));

				listCities.add(cities);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se2) {
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		int dimensionelista = listCities.size();
		for (int posizione = 0; posizione < dimensionelista; posizione++)
			System.out.println(listCities.get(posizione));
		return listCities;
	}

}
