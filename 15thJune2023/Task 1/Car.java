package com.dal.setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Car {

	@Value("Maruth")
	private String name;
	
	@Value("Wagnor")
	private String model;

	@Value("7072")
	private int carnumber;
	
	public int getCarnumber() {
		return carnumber;
	}


	public void setCarnumber(int carnumber) {
		this.carnumber = carnumber;
	}


	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Car(String name, String model) {
		super();
		this.name = name;
		this.model = model;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", model=" + model + "]";
	}

}
