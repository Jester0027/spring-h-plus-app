package io.github.jester0027.hplusapp.controllers;

import io.github.jester0027.hplusapp.beans.Product;
import io.github.jester0027.hplusapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/search")
    public String search(@RequestParam("search") String search, Model model) {
        List<Product> products = productRepository.searchByName(search);
        model.addAttribute("products", products);
        products.forEach(System.out::println);
        System.out.println(products.size());
        return "search";
    }
}
