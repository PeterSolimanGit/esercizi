package it.objectmethod.world.dao;

import java.util.List;

import it.objectmethod.world.model.CityModel;

public interface ICityDao {
	public List<CityModel> getCityByCode(String countrycode);
}
