package inventory.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManage {
	public static Connection conn;
	public void createConnection() {
		  try {			  
			  Class.forName("com.mysql.jdbc.Driver");     //加载Mysql JDBC驱动程序   
		      System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		    	System.out.print("Error loading Mysql Driver!");
		    	e.printStackTrace();
		    }
		  
		  try {
			  //连接URL为'jdbc:mysql//服务器地址/数据库名 ' ，后面的2个参数分别是登陆用户名和密码
			  conn = DriverManager.getConnection(
					  "jdbc:mysql://localhost:3306/test","root","");
			  System.out.println("Success connect Mysql server!");
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }

	}

}
