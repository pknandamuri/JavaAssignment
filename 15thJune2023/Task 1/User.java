package com.dal.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

//import main.java.com.mph.setterinj.Car;
import com.dal.setter.Car;
@Configuration
public class User {

	@Value("Phani Kumar")
	private String userName;
	@Autowired
	private Car car;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User(String userName, Car car) {
		super();
		this.userName = userName;
		this.car = car;
	}


	public String getUserName() {
	
		return userName;
	}

	public void setUserName(String userName) {
		System.out.println("From setter username");
		this.userName = userName;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", car=" + car + "]";
	}

}
