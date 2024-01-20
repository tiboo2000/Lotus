package be.heh.lotus.application.port.in;

import be.heh.lotus.application.domain.model.Product;
import java.util.List;

public interface UseCase_In_Product {
    void addProduct(Product product);
    void deleteProduct(int id);
    void updateProduct(Product product);
    Product getProductById(int id);
    List<Product> getAllProductsByCategoryId(int categoryId);
}
