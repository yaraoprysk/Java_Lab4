package ua.lviv.iot.coffeeShop.model;

public class Americano extends AbstractProduct {

	public Americano(VarietyOfCoffee variety, int capacity, PackingOfCoffee packing, String coffeeRoasting,
			String producer, double priceInUAH) {
		super(variety, capacity, packing, coffeeRoasting, producer, priceInUAH);
	}
}