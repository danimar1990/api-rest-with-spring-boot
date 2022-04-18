package br.edu.unoesc.rent.dto;

import br.edu.unoesc.rent.entities.Car;

public class CarDTO {

	private Long id;
	private String brand;
	private String model;
	private Integer vyear;
	private Float price;
	private byte[] photo;
	
	public CarDTO() {}

	public CarDTO(Long id, String brand, String model, Integer vyear, Float price, byte[] photo) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.vyear = vyear;
		this.price = price;
		this.photo = photo;
	}
	
	public CarDTO(Car car) {
		this.id = car.getId();
		this.brand = car.getBrand();
		this.model = car.getModel();
		this.vyear = car.getVyear();
		this.price = car.getPrice();
		this.photo = car.getPhoto();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the year
	 */
	public Integer getVyear() {
		return vyear;
	}

	/**
	 * @param year the year to set
	 */
	public void setVyear(Integer vyear) {
		this.vyear = vyear;
	}

	/**
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * @return the photo
	 */
	public byte[] getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
}
