package com.order.orderplace.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity(name = "ForeignKeyAssoOrderEntity")
@Table(name = "EcomOrder")
public class EcomOrder {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Integer id;

@ManyToMany(cascade=CascadeType.ALL)
@JoinColumn(name="id")
List<ProductOrder> productList;

public Integer getId() {
	return id;
}

public List<ProductOrder> getProductList() {
	return productList;
}

public void setProductList(List<ProductOrder> productList) {
	this.productList = productList;
}
	
}
