package com.product;

import java.sql.*;

public class DbConnectionNew {
		
	public static Connection  getConnection() throws ClassNotFoundException, SQLException{
			
			String url="jdbc:mysql://localhost:3306/productdb";
			String username="root";
			String password="root";
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			/*Driver manager track of the drivers that are available and handles establishing 
			 * a connection between a database and the appropriate driver
			 */
		Connection connection=	DriverManager.getConnection(url,username,password);
		if(connection==null) {
			System.out.println("the value is null");
		}
			else {
				System.out.println("got the connection");
			}
		return connection;
		}
			
		}


