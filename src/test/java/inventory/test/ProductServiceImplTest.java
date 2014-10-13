package inventory.test;

import static org.junit.Assert.*;

import org.junit.Test;

import inventory.dao.ProductDao;
import inventory.service.ProductService;
import inventory.service.impl.ProductServiceImpl;
import inventory.config.DBManage;

public class ProductServiceImplTest {
	 @Test  
	public void ProductServiceTest() {
		DBManage dbManage = new DBManage();
		dbManage.createConnection();
		ProductService pService = new ProductServiceImpl();
		ProductDao pDao = new StubProductDao();
		pService.setProductDao(pDao);
		boolean isSuccess = pService.addProduct("1004", "奥朵吸顶灯", 269.5, "CL80026");
		assertTrue(isSuccess);
	}
}
