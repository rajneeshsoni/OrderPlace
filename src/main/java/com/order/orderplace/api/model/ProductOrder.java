package com.order.orderplace.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity(name = "ForeignKeyAssoProductEntity")
@Table(name = "ProductOrder")
public class ProductOrder {
		 @Id
		 @GeneratedValue(strategy = GenerationType.IDENTITY)
		 @Column
		 private int id;
		
	    @Column
		private int productId;
		
		@Column
		private String productName;
		
		@Column
		private int productUnit;
		
		@Column
		private Double productAmount;
		
		
		@Column
		private String username;

		
		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public int getProductUnit() {
			return productUnit;
		}

		public void setProductUnit(int productUnit) {
			this.productUnit = productUnit;
		}

		public Double getProductAmount() {
			return productAmount;
		}

		public void setProductAmount(Double productAmount) {
			this.productAmount = productAmount;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
	}


