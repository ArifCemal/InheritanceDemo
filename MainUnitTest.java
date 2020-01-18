package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import main.Car;
import main.Main;
import mockit.Deencapsulation;

class MainUnitTest {

	Main main;

	@Before
	void test() {
		main = new Main();
	}

	@Test
	public void getCarInfoUnitTest() {
		Main.getCarInfo();
		assertNotNull(Main.getMap());
		assertTrue(Main.getMap().size() > 1);
		assertTrue(Main.getMap().size() == 3);
	}

	@Test
	public void collectCarDataUnitTest() {
		Deencapsulation.invoke(Main.class, "collectCarData", (Object) new Car[] {});
		assertNotNull(Main.getMap());
	}

	@Test
	public void collectCarDataWithNullParameter() {
		assertThrows(NullPointerException.class,

				() -> Deencapsulation.invoke(Main.class, "collectCarData", Car[].class));
		assertNotNull(Main.getMap());
	}

	@Test
	public void sortCarPricesUnitTestWithNonEmptyCarList() {
		Car car = new Car();
		car.setPrice(100000);
		List<Car> c = Deencapsulation.invoke(Main.class, "sortCarPrices", (Object) new Car[] { car });
		assertNotNull(c);
	}

	@Test
	public void sortCarPricesWithEmptyCarList() {
		List<Car> c = Deencapsulation.invoke(Main.class, "sortCarPrices", (Object) new Car[] {});
		assertNotNull(c);
	}

	@Test
	public void sortCarPricesWithNullParameter() {
		assertThrows(NullPointerException.class,

				() -> Deencapsulation.invoke(Main.class, "sortCarPrices", Car[].class));
	}

	@Test
	public void sortCarPricesWhenPricesAreEqual() {
		Car[] carArray = new Car[2];

		for (int i = 0; i < 2; i++) {
			Car car = new Car();
			car.setPrice(100000);
			carArray[i] = car;
		}

		List<Car> c = Deencapsulation.invoke(Main.class, "sortCarPrices", (Object) carArray);
		assertNotNull(c);
	}

	@Test
	public void sortCarPricesUnitTest() {
		Car[] carArray = new Car[2];
		int x = 20000;
		for (int i = 0; i < 2; i++) {
			Car car = new Car();
			car.setPrice(100000 + x);
			carArray[i] = car;
			x += 10000;
		}

		List<Car> c = Deencapsulation.invoke(Main.class, "sortCarPrices", (Object) carArray);
		assertNotNull(c);
	}

	@Test
	public void sortCarPricesWithEmptyCarArray() {
		Car[] carArray = new Car[2];

		assertThrows(NullPointerException.class,

				() -> Deencapsulation.invoke(Main.class, "sortCarPrices", (Object) carArray));
	}

}