
	//Productmanagementsystem

	package com.product;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.*;

	public class ProductDao {

		List<Product>listOfProduct=new ArrayList<Product>();
		
		public void createTheProduct(String productName,double productPrice) throws ClassNotFoundException, SQLException {
			Product product=new Product(productName, productPrice);//stored in heap memory
			
			Connection connection=	DbConnectionNew.getConnection();
			String query="insert into productservlet(productName ,productPrice) values(?,?);";
			
			PreparedStatement preparedStatement=   connection.prepareStatement(query);
			preparedStatement.setString(1, productName);
			preparedStatement.setDouble(2, productPrice);

			int rows=preparedStatement.executeUpdate();
			System.out.println(rows+"rows affected");
			
			listOfProduct.add(product);
			
			
		}
		public List<Product> readTheData() throws ClassNotFoundException, SQLException {
			
			Connection connection=	DbConnectionNew.getConnection();
			Statement statement=	connection.createStatement();
			String query="SELECT * FROM productdb.productservlet;";
			ResultSet resultSet= statement.executeQuery(query);
			while(resultSet.next()) {
			int id= resultSet.getInt("id");
			 String productName=resultSet.getString("productName");
			 Double productPrice=resultSet.getDouble("productPrice");
			 
			 Product product=new Product(id, productName, productPrice);
			 listOfProduct.add(product);
			}
			return listOfProduct;
		}
		public Product retriveTheDataForUpdateForm(int id) throws ClassNotFoundException, SQLException {
		    Product product = null;
		    Connection connection = DbConnectionNew.getConnection();
		    String query = "SELECT productName, productPrice FROM productservlet WHERE id = ?";
		    PreparedStatement preparedStatement = connection.prepareStatement(query);
		    preparedStatement.setInt(1, id);
		    ResultSet resultSet = preparedStatement.executeQuery();
		    while (resultSet.next()) {
		        String productName = resultSet.getString("productName");
		        double price = resultSet.getDouble("productPrice");
		        System.out.println(productName);
		        product = new Product(id, productName, price);
		    }
		    return product;
		}
        public void updateTheData(int id,String productName,double productPrice) throws ClassNotFoundException, SQLException {
			Connection connection=	DbConnectionNew.getConnection();
			String query="update productservlet set productName=?,productPrice=? where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, productName);
			preparedStatement.setDouble(2, productPrice);
			preparedStatement.setInt(3, id);
			int rows=preparedStatement.executeUpdate();
			System.out.println(rows+" rows affected");
		}
		public void deletetheData(int id) throws ClassNotFoundException, SQLException {
			Connection connection=	DbConnectionNew.getConnection();
			String deleteQuery="delete from productservlet where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, id);
			int rows=preparedStatement.executeUpdate();
			System.out.println(rows+"1 rows affected");
		}
}
