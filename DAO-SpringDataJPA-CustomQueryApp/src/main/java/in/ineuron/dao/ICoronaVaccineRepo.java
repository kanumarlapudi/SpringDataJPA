package in.ineuron.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

	public List<CoronaVaccine> findByCompany(String Company);
	
	public List<CoronaVaccine> findByCompanyEquals(String Company);
	
	public List<CoronaVaccine> findByCompanyIs(String Company);
	
	public List<CoronaVaccine> findByPriceLessThan(Double Price);
	
	public List<CoronaVaccine> findByCountryInAndPriceBetween(Collection<String> countries, double startRange, Double endRange);
	
	public List<CoronaVaccine> findByCountryNotIn(Collection<String> countries);

}
