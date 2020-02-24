package main.coordinator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import main.dto.Car;
import main.service.CarService;

public class CarCoordinator {
	CarService carService = new CarService();

	public Boolean isOpportunity() {
		Map<Integer, Car> carCollection = new HashMap<Integer, Car>();

		Car[] carList = carService.getSource(); // Servisten araç listesi alýnýyor.

		if (carList == null || carList.length == 0) { // Servisten gelen bilgiler dolu mu? 
			System.out.println("There is no car!");

			return false;
		} else {
			carCollection = collectCarData(carList);

			System.out.println("There is " + carCollection.size() + " car:"); // Toplam araç sayýsý
			System.out.println();

			for (int i = 0; i < carCollection.size(); i++) { // Araçlarýn Renk ve fiyat bilgisi listeleniyor.
				System.out.println((i + 1) + ". " + carCollection.get(i).toString());
			}

			Car bestOne = getBestOffer(carList); // En uygun fiyat fýrsatlý araç bulunuyor.

			System.out.println();
			System.out.println("The best car offer is: " + bestOne.getPrice() + " TL ('" + bestOne.getColor()
					+ "' colored car), Price ranking:"); // En uygun fýrsata ait bilgiler görüntüleniyor.
			System.out.println();
			System.out.println(sortCarPrices(carService.getSource()).toString()); // Tüm araçlar fiyata göre
																					// listeleniyor.
			if (bestOne.getPrice() > 250000) { // En uygun fýrsatýn bütçeyi aþtýðý durum.
				System.out.println("The car exceeds your budget, over 200000 TL!");

				return false;
			}
			return true;
		}
	}

	public Map<Integer, Car> collectCarData(Car[] c) {
		Map<Integer, Car> carCollection = new HashMap<Integer, Car>();
		for (Car carItem : c) {
			carItem.setPrice(200000 + priceDiff());
			carCollection.put(carCollection.size(), carItem);
		}
		return carCollection;
	}

	public static List<Car> sortCarPrices(Car[] c) {
		Car temp;
		List<Car> carList = new ArrayList<Car>();
		for (int i = 0; i < c.length; i++) { // Fiyata göre sýralama
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

	public Car getBestOffer(Car[] carList) {
		return sortCarPrices(carList).get(0);
	}

	public int priceDiff() {
		Random rand = new Random();
		int diff = rand.nextInt(100000);
		return diff;
	}
}
