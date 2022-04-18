package br.edu.unoesc.rent.entities;

public enum CarBrand {

	MARVEL("Marvel"), DC("DC");

	private final String brand;

	CarBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

}
