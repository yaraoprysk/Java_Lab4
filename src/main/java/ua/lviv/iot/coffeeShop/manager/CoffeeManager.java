package ua.lviv.iot.coffeeShop.manager;

import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.coffeeShop.model.AbstractProduct;

public class CoffeeManager {
	private List<AbstractProduct> coffees = new LinkedList<>();

	public void addCoffees(List<AbstractProduct> coffees) {
		this.coffees.addAll(coffees);
	}

	public void addCoffee(AbstractProduct coffee) {
		this.coffees.add(coffee);
	}

	public List<AbstractProduct> findByCapacity(int capacity) {

		List<AbstractProduct> result = new LinkedList<>();

		for (AbstractProduct coffee : coffees) {

			if (coffee.getCapacity() == capacity) {

				result.add(coffee);
			}
		}
		return result;
	}

	public List<AbstractProduct> findByPriceInUAH(double priceInUAH) {

		List<AbstractProduct> result = new LinkedList<>();

		for (AbstractProduct coffee : coffees) {

			if (coffee.getPriceInUAH() == priceInUAH) {

				result.add(coffee);
			}
		}
		return result;

	}
}