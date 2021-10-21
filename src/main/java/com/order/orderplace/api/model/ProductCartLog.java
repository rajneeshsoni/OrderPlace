package com.order.orderplace.api.model;

import java.util.Date;
import java.util.List;



public class ProductCartLog {
	
	String service;
	String operation;
	String info;
	Date date;
	
	List<ProductCart> listOfProduct;
	
	 @Override
	    public String toString() {
	        final StringBuffer sb = new StringBuffer("AuditLog{");
	        sb.append("service='").append(service).append('\'');
	        sb.append(", operation='").append(operation).append('\'');
	        sb.append(", info='").append(info).append('\'');
	        sb.append(", date='").append(date).append('\'');
	        sb.append('}');
	        return sb.toString();
	    }
	
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public List<ProductCart> getListOfProduct() {
		return listOfProduct;
	}

	public void setListOfProduct(List<ProductCart> listOfProduct) {
		this.listOfProduct = listOfProduct;
	}

}
