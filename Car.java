package main.dto;

public class Car {

	String color = "Default";
	int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Car() {
		this.setColor(color);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) { 
		this.color = color;
	}

	@Override
	public String toString() {
		return this.getColor() + " colored: "+this.getPrice();
	}

}
