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

		// CoronaVaccine vaccine = new CoronaVaccine(null,
		// "covidshield","serum","IND",450.0,2);

		/*
		 * CoronaVaccine vaccine = new CoronaVaccine(); vaccine.setPrice(450.0);
		 * service.searchVaccinesByGivenData(vaccine,
		 * true,"price","name").forEach(System.out::println);
		 */

		
	/*	try {
			CoronaVaccine vaccine = service.getVaccineById(10L);
			if (vaccine != null) {
				System.out.println("vaccine details are :: " + vaccine);
			} else {
				System.out.println("Record not available for the given id");
			}
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}

    */
		
		List<Long> list = new ArrayList<Long>();
		list.add(6L);
		list.add(7L);
		list.add(8L);
		System.out.println(service.removeVaccinesByRegNo(list));
		
		((ConfigurableApplicationContext) factory).close();

	}

}
