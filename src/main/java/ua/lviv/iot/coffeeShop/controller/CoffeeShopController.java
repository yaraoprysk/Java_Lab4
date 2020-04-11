package ua.lviv.iot.coffeeShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.coffeeShop.business.CoffeeService;
import ua.lviv.iot.coffeeShop.model.AbstractProduct;

@RequestMapping("/coffees")
@RestController
public class CoffeeShopController {

	@Autowired
	private CoffeeService coffeeService;

	@GetMapping
	public List<AbstractProduct> getAllCoffees() {
		return coffeeService.getAllCoffees();
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<AbstractProduct> getCoffee(final @PathVariable("id") Integer coffeeId) {
		return coffeeService.getCoffee(coffeeId);
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public AbstractProduct createCoffee(final @RequestBody AbstractProduct newCoffee) {
		return coffeeService.createCoffee(newCoffee);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<AbstractProduct> deleteCoffee(final @PathVariable("id") Integer coffeeId) {
		HttpStatus status = coffeeService.deleteCoffee(coffeeId);
		return ResponseEntity.status(status).build();
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<AbstractProduct> updateCoffee(final @PathVariable("id") Integer coffeeId,
			final @RequestBody AbstractProduct coffee) {
		return coffeeService.updateCoffee(coffee, coffeeId);
	}
}
