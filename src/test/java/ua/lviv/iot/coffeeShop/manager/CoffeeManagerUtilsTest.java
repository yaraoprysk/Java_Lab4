package ua.lviv.iot.coffeeShop.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.coffeeShop.model.SortType;

class CoffeeManagerUtilsTest extends BaseCoffeeManagerTest {

	@Test
	public void testSortByCapacityDescending() {
		CoffeeManagerUtils.findByCapacity(coffees, SortType.DESC);
		assertEquals(250, coffees.get(0).getCapacity());
		assertEquals(180, coffees.get(1).getCapacity());
		assertEquals(100, coffees.get(2).getCapacity());
	}
	
	CoffeeManagerUtils coffeeManagerUtils = new CoffeeManagerUtils();
	CoffeeManagerUtils.PriceInUAHComparator priceInUAHComparator = coffeeManagerUtils.new PriceInUAHComparator();
	
	@Test
	public void testSortByPriceInUAHAscending() {
		CoffeeManagerUtils.findByPriceInUAH(coffees, SortType.ASC, priceInUAHComparator);
		assertEquals(21.00, coffees.get(0).getPriceInUAH());
		assertEquals(23.50, coffees.get(1).getPriceInUAH());
		assertEquals(36.00, coffees.get(2).getPriceInUAH());
	}


}