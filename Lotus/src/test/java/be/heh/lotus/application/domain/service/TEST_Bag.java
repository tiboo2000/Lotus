package be.heh.lotus.application.domain.service;



import be.heh.lotus.application.domain.model.Bag;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class TEST_Bag {
    private Bag bag;
    private User user;
    private ArrayList<Product> productList;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
        user = new User("test", "test", 50 , 12, new ArrayList<Product>()); // Suppose que User a un constructeur par défaut
        product1 = new Product(1, "Test", 12, 4);
        product2 = new Product(2, "Test", 12, 4);
        productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        bag = new Bag(productList, user);
    }

    @Test
    public void testGetListProduct() {
        ArrayList<Product> products = bag.getListProduct();
        assertTrue("La liste des produits devrait être vide initialement", products.isEmpty());
    }

    @Test
    public void testGetAllListProduct() {
        LinkedHashMap<Product, Integer> allProducts = bag.getAllListProduct();
        assertEquals("La taille de la liste devrait être 2", 2, allProducts.size());
        assertTrue("La liste devrait contenir product1", allProducts.containsKey(product1));
        assertTrue("La liste devrait contenir product2", allProducts.containsKey(product2));
    }

    @Test
    public void testSetListProduct() {
        ArrayList<Product> newProductList = new ArrayList<>();
        Product product3 = new Product(3, "Test", 12, 4); // Idem
        newProductList.add(product3);
        bag.setListProduct(newProductList);

        LinkedHashMap<Product, Integer> allProducts = bag.getAllListProduct();
        assertTrue("La liste devrait contenir product3", allProducts.containsKey(product3));
    }

    @Test
    public void testGetUser() {
        assertEquals("L'utilisateur doit correspondre à celui fourni", user, bag.getUser());
    }

    @Test
    public void testSetQuantityProduct() {
        bag.setQuantityProduct(product1, 5);
        assertEquals("La quantité du produit1 doit être 5", (Integer)5, bag.getAllListProduct().get(product1));
    }

}
