package inventory.service.impl;

import java.util.ArrayList;

import inventory.dao.ProductDao;
import inventory.model.Product;
import inventory.service.ProductService;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	
	public void setProductDao(ProductDao pDao) {
		this.productDao = pDao;
	}
	
	public boolean addProduct(String id, String name, double price, String type) {
		Product product = new Product(id, name, price, type);
		return productDao.add(product);
	}

	public boolean deleteProduct(String id) {
		// TODO Auto-generated method stub
		return productDao.delete(id);
	}

	public boolean modifyProduct(String id, String name, double price, String type) {
		// TODO Auto-generated method stub
		Product product = new Product(id, name, price, type);
		return productDao.modify(product);
	}

	public ArrayList<Product> searchProduct(String key) {
		// TODO Auto-generated method stub
		return productDao.search(key);
	}

}
