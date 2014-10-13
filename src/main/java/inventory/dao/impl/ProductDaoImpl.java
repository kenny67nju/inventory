package inventory.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import inventory.config.DBManage;
import inventory.dao.ProductDao;
import inventory.model.Product;

public class ProductDaoImpl implements ProductDao{
	private Connection conn;
	public ProductDaoImpl() {
		conn = DBManage.conn;
	}
	

	public boolean add(Product product) {
		try {
			String sql = "insert into product values(?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setDouble(3, product.getPrice());
			pstmt.setString(4, product.getType());
			pstmt.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modify(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Product> search(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
