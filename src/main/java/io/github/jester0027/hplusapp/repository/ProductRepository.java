package io.github.jester0027.hplusapp.repository;

import io.github.jester0027.hplusapp.beans.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.name like %:name%")
    public List<Product> searchByName(@Param("name") String name);
}
