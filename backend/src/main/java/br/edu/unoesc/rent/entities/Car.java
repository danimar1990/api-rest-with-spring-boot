package br.edu.unoesc.rent.entities;

import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.tomcat.util.codec.binary.Base64;

@Entity
@Table(name = "cars")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Brand is mandatory")
	private String brand;
	
	@NotEmpty(message = "Model is mandatory")
	private String model;
	
	@NotNull(message = "Year is mandatory")
	private Integer vyear;
	
	@NotNull(message = "Price is mandatory")
	private Float price;
	@Column(name = "photo", nullable = true)
	@Lob
	private byte[] photo;

	public Car() {
	}

	public Car(Long id, String brand, String model, Integer vyear, Float price, byte[] photo) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.vyear = vyear;
		this.price = price;
		this.photo = photo;
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
	 * @return the vyear
	 */
	public Integer getVyear() {
		return vyear;
	}

	/**
	 * @param vyear the vyear to set
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

	public String getPhotoBase64() {
		return Base64.encodeBase64String(this.getPhoto());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(photo);
		result = prime * result + Objects.hash(brand, id, model, price, vyear);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(id, other.id) && Objects.equals(model, other.model)
				&& Arrays.equals(photo, other.photo) && Objects.equals(price, other.price)
				&& Objects.equals(vyear, other.vyear);
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", model=" + model + ", vyear=" + vyear + ", price=" + price
				+ ", photo=" + Arrays.toString(photo) + "]";
	}

}