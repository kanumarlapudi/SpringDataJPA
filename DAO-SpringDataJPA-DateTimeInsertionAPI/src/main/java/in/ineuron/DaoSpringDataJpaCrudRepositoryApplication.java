package in.ineuron;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import in.ineuron.bo.Customer;
import in.ineuron.service.ICustomerMgmtService;

@SpringBootApplication
public class DaoSpringDataJpaCrudRepositoryApplication {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(DaoSpringDataJpaCrudRepositoryApplication.class, args);
		ICustomerMgmtService service = factory.getBean(ICustomerMgmtService.class);

		Customer customer = new Customer(null, "Dhoni", "CSK", LocalDateTime.of(1981, 07, 07, 10, 35, 50), LocalTime.of(10, 43), LocalDate.now());
		
		String status = service.registerCustomer(customer);
		System.out.println(status);
		
		service.getAllCustomers().forEach(System.out::println);
		
		((ConfigurableApplicationContext) factory).close();

	}

}
