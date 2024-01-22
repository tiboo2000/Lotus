package be.heh.lotus.application.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class TEST_Bag {

    private Bag bag;
    private ArrayList<Product> productList;

    @BeforeEach
    void setUp() {
        productList = new ArrayList<>();
        productList.add(new Product(/* paramètres du produit */));
        productList.add(new Product(/* paramètres du produit */));
        bag = new Bag(productList, "UserTest");
    }

    @Test
    void testGetListProduct() {
        assertEquals(productList, bag.getListProduct(), "La liste des produits doit être égale à celle fournie au constructeur.");
    }

    @Test
    void testSetListProduct() {
        ArrayList<Product> newProductList = new ArrayList<>();
        newProductList.add(new Product(/* paramètres du produit */));
        bag.setListProduct(newProductList);
        assertEquals(newProductList, bag.getListProduct(), "La liste des produits doit être mise à jour.");
    }

    @Test
    void testGetUser() {
        assertEquals("UserTest", bag.getUser(), "L'utilisateur doit être celui fourni au constructeur.");
    }

    @Test
    void testSetUser() {
        String newUser = "AnotherUser";
        bag.setUser(newUser);
        assertEquals(newUser, bag.getUser(), "L'utilisateur doit être mis à jour.");
    }

    @Test
    void testGetId() {
        bag.setId(123);
        assertEquals(123, bag.getId(), "L'ID doit être celui défini par setId.");
    }
}
