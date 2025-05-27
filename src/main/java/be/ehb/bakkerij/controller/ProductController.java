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
        // Dit is een dummy-lijst met producten. Later kun je dit vervangen door echte data uit de database.
        return List.of("Brood", "Croissant", "Cake");
    }
}
