package in.ineuron;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class DaoSpringDataJpaCrudRepositoryApplication {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(DaoSpringDataJpaCrudRepositoryApplication.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);

		//service.fetchVaccineByCompany("serum").forEach(System.out::println);
		
		//service.fetchVaccineByPriceLessThan(450.5).forEach(System.out::println);
		
		List<String> countries = new ArrayList<String>();
		countries.add("CHINA");
		countries.add("RUSSIA");
		
		//service.searchVaccineByCountriesAndPriceRange(countries, 200.0, 500.0).forEach(System.out::println);
		
		service.fetchVaccineNotByCountry(countries);
		
		((ConfigurableApplicationContext) factory).close();

	}

}
