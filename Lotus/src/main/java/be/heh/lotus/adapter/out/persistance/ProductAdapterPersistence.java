package be.heh.lotus.adapter.out.persistance;

import be.heh.lotus.adapter.out.persistance.repository.ProductRepository;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.port.out.Product_Out;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProductAdapterPersistence implements Product_Out {
    private final ProductRepository productRepository;

    @Autowired
    public ProductAdapterPersistence(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void createProduct(Product product) {
        productRepository.createProductRep(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteProductRep(id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.updateProductRep(product);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.getProductByIdRep(id);
    }

    @Override
    public List<Product> getAllProductsByCategoryId(int categoryId) {
        return productRepository.getAllProductsByCategoryIdRep(categoryId);
    }

    @Override
    public boolean existsProductById(int id) {
        return productRepository.existsProductByIdRep(id);
    }
    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProductsRep();
    }
}
