package lab.service;

import lab.dao.CountryDao;
import lab.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryService {

	private CountryDao countryDao;

	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
	public List<Country> loadAllCountries() {

		List<Country> countryList = countryDao.selectAll();
		return countryList;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
	public void saveCountry(Country country) {
		countryDao.insert(country);
	}

	public CountryDao getCountryDao() {
		return countryDao;
	}

	@Autowired
	@Required
	public void setCountryDao(CountryDao countryDao) {
		this.countryDao = countryDao;
	}
}
