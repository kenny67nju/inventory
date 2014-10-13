package inventory.dao;

import java.util.ArrayList;

import inventory.model.Product;

public interface ProductDao {
	public boolean add(Product product);
	
	public boolean delete(String id);
	
	public boolean modify(Product product);
	
	public ArrayList<Product> search(String key);
}
