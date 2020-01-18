package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	static Map<Integer, Car> map = new HashMap<Integer, Car>();

	static Car[] source = { new RedCar(), new GreenCar(), new Car() };

	public static void main(String[] args) {
		getCarInfo();
	}

	public static void getCarInfo() {
		collectCarData(source);

		System.out.println(map.size() + " araç var: ");
		System.out.println();
		for (int i = 0; i < map.size(); i++) {
			System.out.println((i + 1) + ". " + map.get(i).toString());
		}

		if (source.length != 0) {
			Car bestOne = sortCarPrices(source).get(0);

			System.out.println();
			System.out.println("En uygun fiyat teklifi: " + bestOne.getPrice() + " TL ile '" + bestOne.getColor()
					+ "' renkli araca ait.");
			System.out.println();
			System.out.println("Fiyat sýralamasý:");
			System.out.println(sortCarPrices(source).toString());

		} else {
			System.out.println("Herhangi bir araç bulunamadý");
		}

	}

	private static Map<Integer, Car> collectCarData(Car[] c) {
		int x = 0;

		for (Car carItem : c) {
			carItem.setPrice(300000 + x);
			map.put(map.size(), carItem);
			x -= 50000;
		}
		return map;
	}

	public static List<Car> sortCarPrices(Car[] c) {
		Car temp;
		List<Car> carList = new ArrayList<Car>();

		for (int i = 0; i < c.length; i++) {
			for (int j = i; j < c.length; j++) {
				if (c[i].getPrice() > c[j].getPrice()) {
					temp = c[i];
					c[i] = c[j];
					c[j] = temp;
				}
			}
		}

		Collections.addAll(carList, c);
		return carList;
	}

	public static Map<Integer, Car> getMap() {
		return map;
	}

}