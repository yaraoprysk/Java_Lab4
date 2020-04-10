package ua.lviv.iot.coffeeShop.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ua.lviv.iot.coffeeShop.dataaccess.CoffeeRepository;
import ua.lviv.iot.coffeeShop.model.AbstractProduct;

@Service
public class CoffeeService {

	@Autowired
	private CoffeeRepository coffeeRepository;

	public List<AbstractProduct> getAllCoffees() {
		return coffeeRepository.findAll();
	}

	public AbstractProduct createCoffee(AbstractProduct coffee) {
		return coffeeRepository.save(coffee);
	}

	public ResponseEntity<AbstractProduct> getCoffee(Integer coffeeId) {
		if (coffeeRepository.existsById(coffeeId)) {
			AbstractProduct selectedCoffee = coffeeRepository.findById(coffeeId).get();
			return new ResponseEntity<AbstractProduct>(selectedCoffee, HttpStatus.OK);
		} else {
			return new ResponseEntity<AbstractProduct>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<AbstractProduct> updateCoffee(AbstractProduct coffeeToUpdate, Integer coffeeId) {
		if (coffeeRepository.existsById(coffeeId)) {
			coffeeToUpdate.setId(coffeeId);
			AbstractProduct updatedCoffee = coffeeRepository.save(coffeeToUpdate);
			return new ResponseEntity<AbstractProduct>(updatedCoffee, HttpStatus.OK);
		} else {
			return new ResponseEntity<AbstractProduct>(HttpStatus.NOT_FOUND);
		}
	}

	public HttpStatus deleteCoffee(Integer coffeeId) {
		if (coffeeRepository.existsById(coffeeId)) {
			coffeeRepository.deleteById(coffeeId);
			return HttpStatus.OK;
		} else {
			return HttpStatus.NOT_FOUND;
		}
	}
}
