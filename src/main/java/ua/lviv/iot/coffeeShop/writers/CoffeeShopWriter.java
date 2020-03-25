package ua.lviv.iot.coffeeShop.writers;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import ua.lviv.iot.coffeeShop.model.AbstractProduct;

public class CoffeeShopWriter {

	private Writer textWriter;

	public void setTextWriter(Writer textWriter) {
		this.textWriter = textWriter;
	}

	public void writeToFile(List<AbstractProduct> coffees) throws IOException {
		
		 for (AbstractProduct coffee : coffees) {
	            textWriter.write(coffee.getHeaders());
	            textWriter.write("\r\n");
	            textWriter.write(coffee.toCSV());
	            textWriter.write("\r\n");
		
	}
		 textWriter.flush();
	     textWriter.close();
	}
	
	@Override
	public String toString() {
        return textWriter.toString();
    }
}