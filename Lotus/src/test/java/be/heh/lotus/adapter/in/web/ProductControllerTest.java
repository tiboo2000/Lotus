package be.heh.lotus.adapter.in.web;

import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.port.in.UseCase_In_Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UseCase_In_Product useCaseInProduct;

    @InjectMocks
    private AdapterWeb productController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    // Test pour ajouter un produit
    @Test
    public void addProduct_ShouldAddProduct() throws Exception {
        Product product = new Product(1, "New Product", 100.0, 1);

        ObjectMapper objectMapper = new ObjectMapper();
        String productJson = objectMapper.writeValueAsString(product);

        mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productJson))
                .andExpect(status().isCreated());

        verify(useCaseInProduct, times(1)).addProduct(any(Product.class));
    }

    // Test pour avoir un produit avec son id
    @Test
    public void getProductById_ShouldReturnProduct() throws Exception {
        Product product = new Product(1, "Test Product", 100.0, 1);
        when(useCaseInProduct.getProductById(1)).thenReturn(product);

        mockMvc.perform(get("/product/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test Product"));
    }

    // Test pour supprimer un produit
    @Test
    public void deleteProduct_ShouldDeleteProduct() throws Exception {
        mockMvc.perform(delete("/product/1"))
                .andExpect(status().isOk());
    }

    // Test pour avoir les produits par catégorie
    @Test
    public void getProductsByCategory_ShouldReturnProducts() throws Exception {
        List<Product> productList = Collections.singletonList(new Product(1, "Product 1", 100.0, 1));
        when(useCaseInProduct.getAllProductsByCategoryId(1)).thenReturn(productList);

        mockMvc.perform(get("/products").param("idCategory", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Product 1"));
    }
}