package be.heh.lotus.adapter.in.web;

import be.heh.lotus.application.domain.model.Categories;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.port.in.UseCase_In_Categories;
import be.heh.lotus.application.port.in.UseCase_In_Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdapterWeb {
    private final UseCase_In_Categories categoriesUseCase;
    private final UseCase_In_Product productUseCase;

    public AdapterWeb(UseCase_In_Categories categoriesUseCase, UseCase_In_Product productUseCase) {
        this.categoriesUseCase = categoriesUseCase;
        this.productUseCase = productUseCase;
    }

    // Categories
    @GetMapping("/categories")
    public ResponseEntity<List<Categories>> getAllCategories() {
        List<Categories> categories = categoriesUseCase.get();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Categories> getCategoryById(@PathVariable int id) {
        Categories category = categoriesUseCase.getById(id).stream().findFirst().orElse(null);
        return category != null ?
                ResponseEntity.ok(category) :
                ResponseEntity.notFound().build();
    }

    @PostMapping("/category")
    public ResponseEntity<String> addCategory(@Validated @RequestBody Categories category) {
        categoriesUseCase.add(category);
        return ResponseEntity.status(HttpStatus.CREATED).body("Category added successfully");
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<String> removeCategory(@PathVariable int id) {
        categoriesUseCase.removeById(id);
        return ResponseEntity.ok("Category deleted successfully");
    }

    // Products
    @PostMapping("/product")
    public ResponseEntity<String> addProduct(@Validated @RequestBody Product product) {
        productUseCase.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product added successfully");
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
        Product product = productUseCase.getProductById(productId);
        return product != null ?
                ResponseEntity.ok(product) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int productId) {
        productUseCase.deleteProduct(productId);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProductsByCategory(@RequestParam int idCategory) {
        List<Product> products = productUseCase.getAllProductsByCategoryId(idCategory);
        return products != null && !products.isEmpty() ?
                ResponseEntity.ok(products) :
                ResponseEntity.notFound().build();
    }
}