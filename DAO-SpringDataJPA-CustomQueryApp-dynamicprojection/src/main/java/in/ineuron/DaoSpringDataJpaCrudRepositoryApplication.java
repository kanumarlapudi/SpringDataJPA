package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.ICoronaVaccineMgmtService;
import in.ineuron.type.ResultView1;
import in.ineuron.type.ResultView2;
import in.ineuron.type.ResultView3;

@SpringBootApplication
public class DaoSpringDataJpaCrudRepositoryApplication {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(DaoSpringDataJpaCrudRepositoryApplication.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);
		
		service.searchVaccineByCompany("BharathBiotech", ResultView2.class).forEach(view-> {
			System.out.println(view.getRegNo() + " " + view.getCountry() + " " + view.getPrice());
		});
		
		service.searchVaccineByCompany("serum", ResultView1.class).forEach(view-> {
			System.out.println(view.getName() + " " + view.getCompany());
		});
		
		service.searchVaccineByCompany("serum", ResultView3.class).forEach(view-> {
			System.out.println(view.getCompany() + " " + view.getName() + " " + view.getPrice());
		});
		
		((ConfigurableApplicationContext) factory).close();

	}

}
