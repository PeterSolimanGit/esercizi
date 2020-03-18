package it.objectmethod.world.dao;

import java.util.List;

import it.objectmethod.world.model.CityModel;

public interface ICityDao {
	public List<CityModel> getCityByCountrycode(String countrycode);

	public void deleteCityByID(int cityid);

	public void insertCity(CityModel city);
}
