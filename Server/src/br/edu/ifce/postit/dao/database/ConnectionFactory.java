package br.edu.ifce.postit.dao.database;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
  
public class ConnectionFactory {  
       
   private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";  
  
   public static Connection connection(String url, String name, String password, int database)
		   throws ClassNotFoundException, SQLException {  
		Class.forName(MYSQL_DRIVER);  
		return DriverManager.getConnection(url, name, password);  
   }  
}  