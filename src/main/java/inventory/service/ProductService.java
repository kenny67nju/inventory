package inventory.service;

import inventory.dao.ProductDao;
import inventory.model.Product;

import java.util.ArrayList;

public interface ProductService {
	public void setProductDao(ProductDao pDao);
	
	public boolean addProduct(String id, String name, double price, String type);
	
	public boolean deleteProduct(String id);
	
	public boolean modifyProduct(String id, String name, double price, String type);
	
	public ArrayList<Product> searchProduct(String key);
}
