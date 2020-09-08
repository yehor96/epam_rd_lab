package com.epam.test.ht12.models.requests.createorder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderModel {

	@JsonProperty("petId")
	private long petId;

	@JsonProperty("quantity")
	private int quantity;

	@JsonProperty("id")
	private long id;

	@JsonProperty("shipDate")
	private String shipDate;

	@JsonProperty("complete")
	private boolean complete;

	@JsonProperty("status")
	private String status;

	public void setPetId(long petId){
		this.petId = petId;
	}

	public long getPetId(){
		return petId;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}

	public void setShipDate(String shipDate){
		this.shipDate = shipDate;
	}

	public String getShipDate(){
		return shipDate;
	}

	public void setComplete(boolean complete){
		this.complete = complete;
	}

	public boolean isComplete(){
		return complete;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"CreateOrderResponse{" + 
			"petId = '" + petId + '\'' + 
			",quantity = '" + quantity + '\'' + 
			",id = '" + id + '\'' + 
			",shipDate = '" + shipDate + '\'' + 
			",complete = '" + complete + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}