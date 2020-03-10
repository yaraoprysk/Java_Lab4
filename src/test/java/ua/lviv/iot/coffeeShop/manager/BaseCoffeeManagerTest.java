package ua.lviv.iot.coffeeShop.manager;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import ua.lviv.iot.coffeeShop.model.AbstractProduct;
import ua.lviv.iot.coffeeShop.model.Americano;
import ua.lviv.iot.coffeeShop.model.Cocoa;
import ua.lviv.iot.coffeeShop.model.Latte;
import ua.lviv.iot.coffeeShop.model.PackingOfCoffee;
import ua.lviv.iot.coffeeShop.model.VarietyOfCoffee;

public abstract class BaseCoffeeManagerTest {

	protected List<AbstractProduct> coffees;

	@BeforeEach
	public void createCoffees() {

		coffees = new LinkedList<AbstractProduct>();

		coffees.add(new Americano(VarietyOfCoffee.GRAIN, 100, PackingOfCoffee.CAN, "Colombia", "Light", 23.50));
		coffees.add(new Latte(VarietyOfCoffee.GROUND, 250, PackingOfCoffee.CAN, "Brasil", "Medium", 36.00));
		coffees.add(new Cocoa(VarietyOfCoffee.INSTANT, 180, PackingOfCoffee.CAN, "Ethiopia", "Dark", 21.00));
	}
}