package in.ineuron.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.Product;

/*
CREATE DEFINER=`root`@`localhost` PROCEDURE `Get_Product_Details_by_name`(in name1 varchar(20), in name2 varchar(20))
BEGIN
       select pid,pname,pprice,pquantity from product where pname in (name1,name2);
END
*/

@Service("service")
public class ProductMgmtServiceImpl implements IProductMgmtService {

	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Product> fetchProductsByName(String product1, String product2) {
		
		System.out.println("EntityManager => " + manager.getClass().getName());
		
		StoredProcedureQuery query = manager.createStoredProcedureQuery("Get_Product_Details_by_name", Product.class);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		
		query.setParameter(1, product1);
		query.setParameter(2, product2);
		
		List<Product> listProducts = query.getResultList();
		
		return listProducts;
	}

}
