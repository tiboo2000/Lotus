package be.heh.lotus.application.port.out;

import be.heh.lotus.application.domain.model.Product;
import java.util.List;

public interface Product_Out {
    void createProduct(Product product);
    void deleteProduct(int id);
    void updateProduct(Product product);
    Product getProductById(int id);
    List<Product> getAllProductsByCategoryId(int categoryId);
    boolean existsProductById(int id);
}
