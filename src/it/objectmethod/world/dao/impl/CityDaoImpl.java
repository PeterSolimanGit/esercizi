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
	public List<CityModel> getCityByCountrycode(String countrycode) {
		List<CityModel> listCity = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		CityModel city = null;
		try {
			conn = JdbcConnection.getConnection();
			String sql = "Select * from city WHERE city.CountryCode = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, countrycode);
			rs = stmt.executeQuery();
			while (rs.next()) {

				city = new CityModel();
				city.setName(rs.getString("Name"));
				city.setPopulation(rs.getString("Population"));
				city.setCountrycode(rs.getString("CountryCode"));
				city.setId(rs.getInt("ID"));
				city.setDistrict(rs.getString("District"));
				listCity.add(city);
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

		return listCity;
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

	public void insertCity(CityModel city) {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = JdbcConnection.getConnection();
			String sql = "INSERT INTO city (Name, CountryCode, District, Population )\n" + "VALUES (?, ?, ?, ?);";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, city.getName());
			stmt.setString(2, city.getCountrycode());
			stmt.setString(3, city.getDistrict());
			stmt.setString(4, city.getPopulation());

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
