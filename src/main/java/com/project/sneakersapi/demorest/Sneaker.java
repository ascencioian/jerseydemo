package com.project.sneakersapi.demorest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sneaker {
	
	private String sku;
	private String name;
	private String brand;
	private String gender;
	private String colorway;
	private String releasedate;
	private Integer retailprice;
	private Integer marketvalue;
	private String image;
	
	public Sneaker(String sku, String name, String brand, String gender, String colorway, String releasedate,
			Integer retailprice, Integer marketvalue, String image) {
		super();
		this.sku = sku;
		this.name = name;
		this.brand = brand;
		this.gender = gender;
		this.colorway = colorway;
		this.releasedate = releasedate;
		this.retailprice = retailprice;
		this.marketvalue = marketvalue;
		this.image = image;
	}
	
	//default constructor
	public Sneaker(){}
	
	//getter setters
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getColorway() {
		return colorway;
	}
	public void setColorway(String colorway) {
		this.colorway = colorway;
	}
	public String getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}
	public Integer getRetailprice() {
		return retailprice;
	}
	public void setRetailprice(Integer retailprice) {
		this.retailprice = retailprice;
	}
	public Integer getMarketvalue() {
		return marketvalue;
	}
	public void setMarketvalue(Integer marketvalue) {
		this.marketvalue = marketvalue;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	
	//convert hashcode to string
	@Override
	public String toString() {
		return "Sneaker [sku=" + sku + ", name=" + name + ", brand=" + brand + ", gender=" + gender + ", colorway="
				+ colorway + ", releasedate=" + releasedate + ", retailprice=" + retailprice + ", marketvalue="
				+ marketvalue + ", image=" + image + "]";
	}
	
	
	
}
