package lab.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lab.dao.CountryDao;
import lab.model.Country;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

	@Override
	public void save(Country country) {
//		TODO: Implement it
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(country);
		em.getTransaction().commit();

		if (em != null) {
			em.close();
		}
	}

	@Override
	public List<Country> getAllCountries() {
//	TODO: Implement it
		EntityManager em = emf.createEntityManager();
		List<Country> countryList = null;

		if (em != null) {
			countryList = em.createQuery( "select p from Country p", Country.class)
				.getResultList();

			em.close();
		}

		return countryList;

	}// getAllcountries()

	@Override
	public Country getCountryByName(String name) {
//		TODO: Implement it
		EntityManager em = emf.createEntityManager();
		Country country = null;

		if (em != null) {
			country = em.createQuery("SELECT c FROM Country c WHERE c.name LIKE :name", Country.class)
					.setParameter("name", name)
					.getSingleResult();

			em.close();
		}

		return country;
	}

}
