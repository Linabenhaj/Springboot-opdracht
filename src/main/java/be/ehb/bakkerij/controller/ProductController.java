package be.ehb.bakkerij.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;




@RestController


@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    public List<String> getAllProducts() {

        return List.of("Brood", "Croissant", "Cake");
    }
}
