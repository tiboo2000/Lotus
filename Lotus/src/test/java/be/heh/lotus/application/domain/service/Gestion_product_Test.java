package be.heh.lotus.application.domain.service;

import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.port.out.Product_Out;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class Gestion_product_Test {
    private Product_Out productOutMock;
    private Gestion_Product gestionProduct;
    private Product prod1;

    @BeforeEach
    void setUp() {
        productOutMock = Mockito.mock(Product_Out.class);
        gestionProduct = new Gestion_Product(productOutMock);
        prod1 = new Product(1, "produit1", 25, 1);
    }

    @Test
    void testAddProductWhenNotExists() {
        when(productOutMock.existsProductById(anyInt())).thenReturn(false);
        gestionProduct.addProduct(prod1);
        verify(productOutMock).createProduct(prod1);
    }

    @Test
    void testAddProductWhenExists() {
        when(productOutMock.existsProductById(prod1.getId())).thenReturn(true);
        Assertions.assertThrows(IllegalStateException.class, () -> gestionProduct.addProduct(prod1));
    }

    @Test
    void testDeleteProductWhenExists() {
        when(productOutMock.existsProductById(anyInt())).thenReturn(true);
        gestionProduct.deleteProduct(prod1.getId());
        verify(productOutMock).deleteProduct(prod1.getId());
    }

    @Test
    void testDeleteProductWhenNotExists() {
        when(productOutMock.existsProductById(anyInt())).thenReturn(false);
        Assertions.assertThrows(IllegalStateException.class, () -> gestionProduct.deleteProduct(prod1.getId()));
    }

    @Test
    void testGetProductById() {
        when(productOutMock.getProductById(prod1.getId())).thenReturn(prod1);
        Product result = gestionProduct.getProductById(prod1.getId());
        Assertions.assertNotNull(result);
        Assertions.assertEquals(prod1.getName(), result.getName());
    }

    @Test
    void testGetAllProductsByCategoryId() {
        List<Product> products = new ArrayList<>();
        products.add(prod1);
        products.add(new Product(2, "produit2", 30, 1));

        when(productOutMock.getAllProductsByCategoryId(prod1.getCategoryId())).thenReturn(products);

        List<Product> results = gestionProduct.getAllProductsByCategoryId(prod1.getCategoryId());
        Assertions.assertFalse(results.isEmpty());
        Assertions.assertEquals(2, results.size());
        Assertions.assertEquals(prod1.getName(), results.get(0).getName());
    }
}
