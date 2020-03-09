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

public class CityDaoImpl implements ICityDao {
	public List<CityModel> getCityByCode(String countrycode) {
		List<CityModel> listCities = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		CityModel cities = null;
		try {
			conn = JdbcConnection.getConnection();
			String sql = "Select * from city WHERE city.CountryCode = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, countrycode);
			rs = stmt.executeQuery();
			while (rs.next()) {

				cities = new CityModel();
				cities.setName(rs.getString("Name"));
				cities.setPopulation(rs.getString("Population"));
				cities.setCountrycode(rs.getString("CountryCode"));
				cities.setId(rs.getInt("ID"));
				cities.setDistrict(rs.getString("District"));
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

		return listCities;
	}

	public void deleteCityByID(int cityid) {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = JdbcConnection.getConnection();
			String sql = "DELETE FROM city WHERE ID = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cityid);
			stmt.executeUpdate();

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

	}
}
