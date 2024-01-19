package be.heh.lotus.application.domain.service;



import be.heh.lotus.application.domain.model.Bag;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.mockito.Mockito.mock;
import static org.springframework.test.util.AssertionErrors.*;

public class TEST_Bag {
    private Bag bag;
    @Mock
    private User mockUser;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ArrayList<Product> productList = new ArrayList<>();

        Product product1 = mock(Product.class);
        Product product2 = mock(Product.class);
        productList.add(product1);
        productList.add(product2);

        bag = new Bag(productList, mockUser);
    }
    @Test
    public void testBagInitialization() {
        assertNotNull("Bag ne doit pas être null", bag);
        assertEquals("Le sac doit appartenir à l'utilisateur mock", mockUser, bag.getBagOfUser());

        LinkedHashMap<Product, Integer> listProduct = bag.getListProduct();
        assertNotNull("ListProduct ne doit pas être null", listProduct);
        assertEquals("ListProduct doit contenir 2 produits", 2, listProduct.size());
    }
}
