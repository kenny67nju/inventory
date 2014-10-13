package inventory.test;

import static org.junit.Assert.*;

import org.junit.Test;


import inventory.dao.ProductDao;
import inventory.dao.impl.ProductDaoImpl;
import inventory.model.Product;
import inventory.config.DBManage;

public class ProductDaoImplTest {
	
	 @Test  
	    public void ProductDaoTest()  {
		DBManage dbManage = new DBManage();
		dbManage.createConnection();
		ProductDao pDao = new ProductDaoImpl();
		Product product = new Product("1003", "欧普照明", 399, "12-XD-38849");
		boolean isSuccess = pDao.add(product);		
		assertTrue(isSuccess);
	}
}
