package in.ineuron.service;

import java.util.List;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineMgmtService {

	public List<CoronaVaccine> fetchVaccineByCompany(String company);
	
	public List<CoronaVaccine> fetchVaccineByPriceLessThan(Double price);
	
	public List<CoronaVaccine> searchVaccineByCountriesAndPriceRange(List<String> countries, double startRange, double endRange);
	
	public List<CoronaVaccine> fetchVaccineNotByCountry(List<String> countries);
	
}
