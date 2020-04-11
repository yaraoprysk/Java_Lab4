package ua.lviv.iot.coffeeShop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AbstractProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private VarietyOfCoffee variety;
	private int capacity;
	private PackingOfCoffee packing;

	private String producer;
	private String coffeeRoasting;

	private double priceInUAH;

	public AbstractProduct(VarietyOfCoffee variety, int capacity, PackingOfCoffee packing, String producer,
			String coffeeRoasting, double priceInUAH) {
		super();
		this.variety = variety;
		this.capacity = capacity;
		this.packing = packing;
		this.producer = producer;
		this.coffeeRoasting = coffeeRoasting;
		this.priceInUAH = priceInUAH;
	}

	public String getHeaders() {
		return "variety," + "capacity," + "packing," + "producer," + "coffeeRoasting," + "priceInUAH";

	}

	public String toCSV() {
		return getVariety() + "," + getCapacity() + "," + getPacking() + "," + getProducer() + "," + getCoffeeRoasting()
				+ "," + getPriceInUAH();
	}

	public VarietyOfCoffee getVariety() {
		return variety;
	}

	public void setVariety(VarietyOfCoffee variety) {
		this.variety = variety;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public PackingOfCoffee getPacking() {
		return packing;
	}

	public void setPacking(PackingOfCoffee packing) {
		this.packing = packing;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getCoffeeRoasting() {
		return coffeeRoasting;
	}

	public void setCoffeeRoasting(String coffeeRoasting) {
		this.coffeeRoasting = coffeeRoasting;
	}

	public double getPriceInUAH() {
		return priceInUAH;
	}

	public void setPriceInUAH(double priceInUAH) {
		this.priceInUAH = priceInUAH;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}