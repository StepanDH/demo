package lab.dao;

import lab.domain.Country;

import java.util.List;


public interface CountryDao {
	
	public void insert(Country country);
	
	public Country select(int id);
	
	public List<Country> selectAll();
	
}
