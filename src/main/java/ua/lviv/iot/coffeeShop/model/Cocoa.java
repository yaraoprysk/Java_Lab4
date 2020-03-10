package ua.lviv.iot.coffeeShop.model;

public class Cocoa extends AbstractProduct {

	public Cocoa(VarietyOfCoffee variety, int capacity, PackingOfCoffee packing, String coffeeRoasting, String producer,
			double priceInUAH) {
		super(variety, capacity, packing, coffeeRoasting, producer, priceInUAH);
	}
} 