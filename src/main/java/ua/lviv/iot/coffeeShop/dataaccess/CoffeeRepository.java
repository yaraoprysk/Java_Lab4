package ua.lviv.iot.coffeeShop.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.coffeeShop.model.AbstractProduct;

@Repository
public interface CoffeeRepository extends JpaRepository<AbstractProduct, Integer> {

}
