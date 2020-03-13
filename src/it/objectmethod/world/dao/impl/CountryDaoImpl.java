package it.objectmethod.world.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.world.config.JdbcConnection;
import it.objectmethod.world.dao.ICountryDao;
import it.objectmethod.world.model.CountryModel;

public class CountryDaoImpl implements ICountryDao {
	public List<String> getContinent() {
		List<String> listContinent = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcConnection.getConnection();
			String sql = "SELECT DISTINCT Continent FROM country";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {

				listContinent.add(rs.getString("Continent"));
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
		int dimensionelista = listContinent.size();
		for (int posizione = 0; posizione < dimensionelista; posizione++)
			System.out.println(listContinent.get(posizione));
		return listContinent;
	}

	public List<CountryModel> getCountryByContinent(String continentname) {
		List<CountryModel> listCountries = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		CountryModel countries = null;
		try {
			conn = JdbcConnection.getConnection();
			String sql = "SELECT Code, Name,Continent FROM country WHERE Continent = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, continentname);
			rs = stmt.executeQuery();
			while (rs.next()) {

				countries = new CountryModel();
				countries.setCode(rs.getString("Code"));
				countries.setName(rs.getString("Name"));
				countries.setContinent(rs.getString("Continent"));
				listCountries.add(countries);
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
		return listCountries;
	}
	public List<CountryModel> getCountryByCountrycode(String countrycode) {
		List<CountryModel> listCountries = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		CountryModel countries = null;
		try {
			conn = JdbcConnection.getConnection();
			String sql = "SELECT Code, Name,Continent FROM country WHERE Continent = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, countrycode);
			rs = stmt.executeQuery();
			while (rs.next()) {

				countries = new CountryModel();
				countries.setCode(rs.getString("Code"));
				countries.setName(rs.getString("Name"));
				countries.setContinent(rs.getString("Continent"));
				listCountries.add(countries);
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
		return listCountries;
}
	public List<CountryModel> getCountry() {
		List<CountryModel> listCountries = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		CountryModel countries = null;
		try {
			conn = JdbcConnection.getConnection();
			String sql = "SELECT * FROM country";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {

				countries = new CountryModel();
				countries.setCode(rs.getString("Code"));
				countries.setName(rs.getString("Name"));
				countries.setContinent(rs.getString("Continent"));
				listCountries.add(countries);
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
		return listCountries;
	}
}