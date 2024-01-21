package be.heh.lotus.adapter.out.persistance;

import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.adapter.out.persistance.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ProductAdapterPersistenceTest {

    @Mock
    private ProductRepository productRepository;

    private ProductAdapterPersistence productAdapterPersistence;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productAdapterPersistence = new ProductAdapterPersistence(productRepository);
    }

    @Test
    void createProduct_ShouldCallRepository() {
        Product product = new Product(1, "Test Product", 100.0, 1);
        productAdapterPersistence.createProduct(product);
        verify(productRepository).createProductRep(product);
    }

    @Test
    void deleteProduct_ShouldCallRepository() {
        productAdapterPersistence.deleteProduct(1);
        verify(productRepository).deleteProductRep(1);
    }

    @Test
    void updateProduct_ShouldCallRepository() {
        Product product = new Product(1, "Updated Product", 150.0, 1);
        productAdapterPersistence.updateProduct(product);
        verify(productRepository).updateProductRep(product);
    }

    @Test
    void getProductById_ShouldReturnProduct() {
        Product expectedProduct = new Product(1, "Test Product", 100.0, 1);
        when(productRepository.getProductByIdRep(1)).thenReturn(expectedProduct);

        Product actualProduct = productAdapterPersistence.getProductById(1);

        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void getAllProductsByCategoryId_ShouldReturnProductList() {
        List<Product> expectedProducts = Arrays.asList(
                new Product(1, "Test Product 1", 100.0, 1),
                new Product(2, "Test Product 2", 200.0, 1)
        );
        when(productRepository.getAllProductsByCategoryIdRep(1)).thenReturn(expectedProducts);

        List<Product> actualProducts = productAdapterPersistence.getAllProductsByCategoryId(1);

        assertEquals(expectedProducts, actualProducts);
    }

    @Test
    void existsProductById_ShouldReturnTrueIfExists() {
        when(productRepository.existsProductByIdRep(1)).thenReturn(true);

        boolean exists = productAdapterPersistence.existsProductById(1);

        assertTrue(exists);
    }

    @Test
    void existsProductById_ShouldReturnFalseIfNotExists() {
        when(productRepository.existsProductByIdRep(2)).thenReturn(false);

        boolean exists = productAdapterPersistence.existsProductById(2);

        assertFalse(exists);
    }
}
