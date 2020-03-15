package ua.lviv.iot.coffeeShop.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.coffeeShop.model.AbstractProduct;
import ua.lviv.iot.coffeeShop.writers.CoffeeShopWriter;

public class WriterTest extends BaseCoffeeManagerTest {

	File file = new File("coffeesFile.csv");
	CoffeeShopWriter coffeeWriter = new CoffeeShopWriter();

	@Test
	void WriteToFileTest() throws IOException {
		coffeeWriter.setTextWriter(new FileWriter("coffeeFile.csv"));
		coffeeWriter.writeToFile(coffees);
	}

	@Test
	void StringWriterTest() throws IOException {
		String expectedResult = "";

		coffeeWriter.setTextWriter(new StringWriter());
		coffeeWriter.writeToFile(coffees);

		for (AbstractProduct coffee : coffees) {
			expectedResult += coffee.getHeaders() + "\r\n" + coffee.toCSV() + "\r\n";
		}
		assertEquals(expectedResult, coffeeWriter.toString());
	}

}
