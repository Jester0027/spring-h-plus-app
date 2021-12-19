package io.github.jester0027.hplusapp.restcontrollers;

import io.github.jester0027.hplusapp.beans.Product;
import io.github.jester0027.hplusapp.exceptions.http.HttpNotFoundException;
import io.github.jester0027.hplusapp.repository.ProductRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    private final ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(@RequestParam(value = "name", required = false) String name) {
        if (name != null) {
            List<Product> products = productRepository.searchByName(name);
            return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
        }
        Iterable<Product> productsIterable = productRepository.findAll();
        return new ResponseEntity<List<Product>>(
                StreamSupport
                        .stream(productsIterable.spliterator(), false)
                        .collect(Collectors.toList()),
                HttpStatus.OK
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") String id) {
        return new ResponseEntity<Product>(
                productRepository
                    .findById(Integer.valueOf(id))
                    .orElseThrow(() -> new HttpNotFoundException("Product not found at id: " + id)),
                HttpStatus.OK
        );
    }
}
