package ua.lviv.iot.coffeeShop.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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

import ua.lviv.iot.coffeeShop.model.AbstractProduct;

@RequestMapping("/coffees")
@RestController
public class CoffeeShopController {

	private static Map<Integer, AbstractProduct> coffees = new HashMap<>();

	private static AtomicInteger idCounter = new AtomicInteger();

	@GetMapping
	public List<AbstractProduct> getCoffees() {
		return new LinkedList<AbstractProduct>(coffees.values());
	}

	@GetMapping(path = "/{id}")
	public AbstractProduct getCoffee(final @PathVariable("id") Integer coffeeId) {
		return coffees.get(coffeeId);
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public AbstractProduct createCoffee(final @RequestBody AbstractProduct coffee) {
		coffee.setId(idCounter.incrementAndGet());
		coffees.put(coffee.getId(), coffee);
		return coffee;
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deleteCoffee(final @PathVariable("id") Integer coffeeId) {
		HttpStatus status = coffees.remove(coffeeId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		return ResponseEntity.status(status).build();
	}

	@PutMapping(path = "/{id}")
	public AbstractProduct updateCoffee(final @PathVariable("id") Integer coffeeId,
			final @RequestBody AbstractProduct coffee) {
		coffee.setId(coffeeId);
		return coffees.put(coffeeId, coffee);
	}
}

