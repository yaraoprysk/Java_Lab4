package ua.lviv.iot.coffeeShop.model;

public class Latte extends AbstractProduct {

	public Latte(VarietyOfCoffee variety, int capacity, PackingOfCoffee packing, String coffeeRoasting, String producer,
			double priceInUAH) {
		super(variety, capacity, packing, coffeeRoasting, producer, priceInUAH);
	}
} 