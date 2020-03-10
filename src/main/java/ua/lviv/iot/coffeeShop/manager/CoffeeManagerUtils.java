package ua.lviv.iot.coffeeShop.manager;

import java.util.Comparator;
import java.util.List;

import ua.lviv.iot.coffeeShop.model.AbstractProduct;
import ua.lviv.iot.coffeeShop.model.SortType;

public class CoffeeManagerUtils {

	private static final CapacityComparator CAPACITY_COMPARATOR = new CapacityComparator();

	public static void findByCapacity(List<AbstractProduct> coffees, SortType sortType) {
		coffees.sort(sortType == SortType.ASC ? CAPACITY_COMPARATOR : CAPACITY_COMPARATOR.reversed());
	}

	// sorting by static inner class
	public static class CapacityComparator implements Comparator<AbstractProduct> {

		@Override
		public int compare(AbstractProduct firstCoffee, AbstractProduct secondCoffee) {
			if (firstCoffee.getCapacity() > secondCoffee.getCapacity()) {
				return 1;
			} else if (firstCoffee.getCapacity() < secondCoffee.getCapacity()) {
				return -1;
			}
			return 0;
		}
	}

	public static void findByPriceInUAH(List<AbstractProduct> coffees, SortType sortType,
			Comparator<AbstractProduct> priceInUAHComparator) {

		coffees.sort(sortType == SortType.ASC ? priceInUAHComparator : priceInUAHComparator.reversed());
	}

	// sorting by inner class
	public class PriceInUAHComparator implements Comparator<AbstractProduct> {

		@Override
		public int compare(AbstractProduct firstCoffee, AbstractProduct secondCoffee) {
			if (firstCoffee.getPriceInUAH() > secondCoffee.getPriceInUAH()) {
				return 1;
			} else if (firstCoffee.getPriceInUAH() < secondCoffee.getPriceInUAH()) {
				return -1;
			}
			return 0;
		}
	}

	public static void sortByCapacityAndPriceInUAH(List<AbstractProduct> coffees, SortType sortType) {

		// sorting by anonymous inner class

		Comparator<AbstractProduct> comparator = new Comparator<AbstractProduct>() {

			@Override
			public int compare(AbstractProduct firstCoffee, AbstractProduct secondCoffee) {

				if (firstCoffee.getCapacity() > secondCoffee.getCapacity()) {
					return 1;
				} else if (firstCoffee.getCapacity() < secondCoffee.getCapacity()) {
					return -1;
				} else if (firstCoffee.getPriceInUAH() > secondCoffee.getPriceInUAH()) {
					return 1;
				} else if (firstCoffee.getPriceInUAH() < secondCoffee.getPriceInUAH()) {
					return -1;
				}
				return 0;

			}
		};
		coffees.sort(sortType == SortType.ASC ? comparator : comparator.reversed());
	}
}