package in.ineuron;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class DaoSpringDataJpaCrudRepositoryApplication {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(DaoSpringDataJpaCrudRepositoryApplication.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);
		
	/*	CoronaVaccine vaccine = new CoronaVaccine(null, "covishield", "serum", "IND", 750.0, 2);
		System.out.println(service.registerVacine(vaccine));
	*/
		
	/*	List<CoronaVaccine> vaccines = new ArrayList<CoronaVaccine>();
		vaccines.add(new CoronaVaccine(null,"sputnik", "russie", "Russia", 567.8, 2));
		vaccines.add(new CoronaVaccine(null,"Pyzer", "Pyzwer", "USA", 678.8, 2));
		vaccines.add(new CoronaVaccine(null,"moderena", "moderena", "USA", 455.8, 2));
		Iterable<CoronaVaccine> listVaccines = service.registerInBatch(vaccines);
		listVaccines.forEach(vaccine->System.out.println(vaccine.getRegNo()));
		
	*/
		
	//	System.out.println("Total no of vaccine count is :: "+service.getVaccineCount());
		
	//	System.out.println("Checking for availability for the id::3 is =>  "+service.checkAvailablityByRegNo(3L));
		
	//	service.fetchAllDetails().forEach(System.out::println);
		
	/*	List<Long> ids = new ArrayList<Long>();
		ids.add(1L);
		ids.add(2L);
		ids.add(3L);
		Iterable<CoronaVaccine> records = service.fetchAllDetailsByID(ids);
		records.forEach(vaccine->System.out.println(vaccine));
    */
		
	/*	Optional<CoronaVaccine> optional = service.fecthVaccineById(3L); 
		if(optional.isPresent())
			System.out.println(optional.get());
		optional.orElseThrow(() -> new IllegalArgumentException("record not found"));
		
		System.out.println(service.fecthVaccineById(10L).orElse(new CoronaVaccine()));
		System.out.println(service.fecthVaccineById(6L).orElseGet(()->new CoronaVaccine()));
    */
		
	//	System.out.println(service.removeVaccineById(3L));

	/*	CoronaVaccine vaccine = new CoronaVaccine(3L, "pyzer", "pyzwer", "USA", 678.8, 2); 
        System.out.println(service.removeVaccineByObject(vaccine));
	 */
	
		List<Long> list = new ArrayList<Long>();
		list.add(1L);
		list.add(2L);
		list.add(4L);
		System.out.println(service.removeVaccinesById(list));
		
		((ConfigurableApplicationContext) factory).close();
		
	}

}
