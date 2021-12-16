package io.github.jester0027.hplusapp.repository;

import io.github.jester0027.hplusapp.beans.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
