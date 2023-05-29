package in.ineuron;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.service.ICoronaVaccineMgmtService;
import in.ineuron.type.ResultView;

@SpringBootApplication
public class DaoSpringDataJpaCrudRepositoryApplication {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(DaoSpringDataJpaCrudRepositoryApplication.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);
		
		List<ResultView> listVaccines = service.searchVaccineBystartPrice(500.0);
		listVaccines.forEach(vaccine -> {
			System.out.println(vaccine.getClass().getName() + " " + Arrays.toString(vaccine.getClass().getDeclaredMethods()));
			System.out.println(vaccine.getName() + " " + vaccine.getCountry());
		});
		
		((ConfigurableApplicationContext) factory).close();

	}

}
