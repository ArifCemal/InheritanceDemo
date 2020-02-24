package main.service;

import main.dto.Car;
import main.dto.GreenCar;
import main.dto.RedCar;

public class CarService {
	private Car[] source = { new Car(), new RedCar(), new GreenCar() };

	public Car[] getSource() {
		return source;
	}

	public void setSource(Car[] source) {
		this.source = source;
	}
}
