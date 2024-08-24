package com.product;

public class Product {
     	int id;
		private String productName;
		private double productPrice;
		
		public Product() {
		
		}
		public Product(int id, String productName, double productPrice) {
			super();
			this.id = id;
			this.productName = productName;
			this.productPrice = productPrice;
		}
       public Product(String productName, double productPrice) {
			super();
			
			this.productName = productName;
			this.productPrice = productPrice;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public double getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(double productPrice) {
			this.productPrice = productPrice;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}

        @Override
		public String toString() {
			return "Product [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice + "]";
		}
		
		

	}


