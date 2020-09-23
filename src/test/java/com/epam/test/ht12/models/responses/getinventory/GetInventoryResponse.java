package com.epam.test.ht12.models.responses.getinventory;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetInventoryResponse{

	@JsonProperty("\r\nx-tinfoil-response-splitting: true")
	private int xTinfoilResponseSplittingTrue;

	@JsonProperty("sold")
	private int sold;

	@JsonProperty("string")
	private int string;

	@JsonProperty("avaliable")
	private int avaliable;

	@JsonProperty("pending")
	private int pending;

	@JsonProperty("available")
	private int available;

	@JsonProperty("not available")
	private int notAvailable;

	@JsonProperty("Pending")
	private int Pending;

	public int getNotAvailable() {
		return notAvailable;
	}

	public void setNotAvailable(int notAvailable) {
		this.notAvailable = notAvailable;
	}

	public void setXTinfoilResponseSplittingTrue(int xTinfoilResponseSplittingTrue){
		this.xTinfoilResponseSplittingTrue = xTinfoilResponseSplittingTrue;
	}

	public int getXTinfoilResponseSplittingTrue(){
		return xTinfoilResponseSplittingTrue;
	}

	public void setSold(int sold){
		this.sold = sold;
	}

	public int getSold(){
		return sold;
	}

	public void setString(int string){
		this.string = string;
	}

	public int getString(){
		return string;
	}

	public void setAvaliable(int avaliable){
		this.avaliable = avaliable;
	}

	public int getAvaliable(){
		return avaliable;
	}

	public void setPending(int pending){
		this.pending = pending;
	}

	public int getPending(){
		return pending;
	}

	public void setPPending(int Pending){
		this.Pending = Pending;
	}

	public int getPPending(){
		return Pending;
	}

	public void setAvailable(int available){
		this.available = available;
	}

	public int getAvailable(){
		return available;
	}

	@Override
 	public String toString(){
		return 
			"GetInventoryResponse{" + 
			"\r\nx-tinfoil-response-splitting: true = '" + xTinfoilResponseSplittingTrue + '\'' +
			",sold = '" + sold + '\'' + 
			",string = '" + string + '\'' + 
			",avaliable = '" + avaliable + '\'' + 
			",pending = '" + pending + '\'' + 
			",available = '" + available + '\'' +
			",not available = '" + notAvailable + '\'' +
			"}";
		}
}