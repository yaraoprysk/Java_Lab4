package ua.lviv.iot.coffeeShop.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.coffeeShop.model.AbstractProduct;

class CoffeeManagerTest extends BaseCoffeeManagerTest {

	public CoffeeManager coffeeManager;

	@BeforeEach
	public void setUp() throws Exception {
		coffeeManager = new CoffeeManager();
		coffeeManager.addCoffees(coffees);
	}

	@Test
	public void testFindByCapacity() {
		List<AbstractProduct> result = coffeeManager.findByCapacity(250);
		assertEquals(1, result.size());

		assertEquals(250, coffees.get(1).getCapacity());

	}

	@Test
	public void testFindByPriceInUAH() {
		List<AbstractProduct> result = coffeeManager.findByPriceInUAH(23.50);
		assertEquals(1, result.size());

		assertEquals(23.50, coffees.get(0).getPriceInUAH());
	}

}