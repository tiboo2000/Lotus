package be.heh.lotus.application.domain.service;

import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.port.in.UseCase_In_Product;
import be.heh.lotus.application.port.out.Product_Out;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Gestion_Product implements UseCase_In_Product {
    private final Product_Out productOut;
    @Autowired
    public Gestion_Product(Product_Out productOut) {
        this.productOut = productOut;
    }

    @Override
    public void addProduct(Product product) {
        if (!productOut.existsProductById(product.getId())) {
            productOut.createProduct(product);
        } else {
            throw new IllegalStateException("Product with ID " + product.getId() + " already exists.");
        }
    }

    @Override
    public void deleteProduct(int id) {
        if (productOut.existsProductById(id)) {
            productOut.deleteProduct(id);
        } else {
            throw new IllegalStateException("Product with ID " + id + " does not exist.");
        }
    }

    @Override
    public void updateProduct(Product product) {
        if (productOut.existsProductById(product.getId())) {
            productOut.updateProduct(product);
        } else {
            throw new IllegalStateException("Product with ID " + product.getId() + " does not exist.");
        }
    }

    @Override
    public Product getProductById(int id) {
        return productOut.getProductById(id);
    }

    @Override
    public List<Product> getAllProductsByCategoryId(int categoryId) {
        return productOut.getAllProductsByCategoryId(categoryId);
    }
}
