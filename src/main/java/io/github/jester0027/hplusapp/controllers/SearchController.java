package io.github.jester0027.hplusapp.controllers;

import io.github.jester0027.hplusapp.beans.Product;
import io.github.jester0027.hplusapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AsyncTaskExecutor executor;

    @GetMapping("/search")
    public DeferredResult<String> search(@RequestParam("search") String search, Model model, HttpServletRequest request) {
        DeferredResult<String> deferredResult = new DeferredResult<>();
        System.out.println(request.isAsyncSupported());
        System.out.println("Thread from servlet container: " + Thread.currentThread().getName());
//        return () -> {
//            System.out.println("Thread from spring mvc task executor: " + Thread.currentThread().getName());
//            List<Product> products = productRepository.searchByName(search);
//            model.addAttribute("products", products);
//            products.forEach(System.out::println);
//            System.out.println(products.size());
//            return "search";
//        };

        executor.execute(() -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread from spring mvc task executor: " + Thread.currentThread().getName());
            List<Product> products = productRepository.searchByName(search);
            model.addAttribute("products", products);
            products.forEach(System.out::println);
            System.out.println(products.size());
            deferredResult.setResult("search");
        });

        return deferredResult;
    }
}
