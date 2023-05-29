package in.ineuron;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import in.ineuron.bo.Product;
import in.ineuron.service.IProductMgmtService;

@SpringBootApplication
public class DaoSpringDataJpaCrudRepositoryApplication {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(DaoSpringDataJpaCrudRepositoryApplication.class, args);
		IProductMgmtService service = factory.getBean(IProductMgmtService.class);
		
		service.fetchProductsByName("fossil", "tissot").forEach(System.out::println);
		
		((ConfigurableApplicationContext) factory).close();

	}

}
