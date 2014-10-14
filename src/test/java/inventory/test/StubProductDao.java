package inventory.test;

import java.util.ArrayList;

import inventory.dao.ProductDao;
import inventory.model.Product;

public class StubProductDao implements ProductDao {


	public boolean add(Product product) {
		// TODO Auto-generated method stub
		;
		return true;
	}


	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return true;
	}


	public boolean modify(Product product) {
		// TODO Auto-generated method stub
		return true;
	}


	public ArrayList<Product> search(String key) {
		// TODO Auto-generated method stub
		return new ArrayList<Product>();
	}

}
