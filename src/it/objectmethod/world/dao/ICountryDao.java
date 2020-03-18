package it.objectmethod.world.dao;

import java.util.List;

import it.objectmethod.world.model.CountryModel;

public interface ICountryDao {
	public List<String> getContinent();

	public List<CountryModel> getCountryByContinent(String continentname);

	public List<CountryModel> getCountry();
}
