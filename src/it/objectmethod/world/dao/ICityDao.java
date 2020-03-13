package it.objectmethod.world.dao;

import java.util.List;

import it.objectmethod.world.model.CityModel;

public interface ICityDao {
	public List<CityModel> getCityByCode(String countrycode);
	public void deleteCityByID(int cityid);
	public void insertCity(String name,String countrycode, int population,String district );
}
