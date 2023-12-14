package be.heh.lotus.application.domain.service;



import be.heh.lotus.application.domain.model.Bag;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TEST_Bag {
    private Bag bag;
    private ArrayList<Product> productList;
    private User user;

    @BeforeEach
    public void setUp() {
        productList = new ArrayList<>();
        user = new User("Test","aa",40,1,productList); // Replace "John Doe" with actual user data
        bag = new Bag(productList, user);
    }

    @Test
    public void testGetListProduct() {
        Assertions.assertEquals(productList, bag.getListProduct());
    }

    @Test
    public void testSetListProduct() {
        ArrayList<Product> newProductList = new ArrayList<>();
        bag.setListProduct(newProductList);
        Assertions.assertEquals(newProductList, bag.getListProduct());
    }

    @Test
    public void testGetBagOfUser() {
        Assertions.assertEquals(user, bag.getBagOfUser());
    }

    @Test
    public void testSetBagOfUser() {
        User newUser = new User("Test","aa",40,1,productList); // Replace "Jane Smith" with actual user data
        bag.setBagOfUser(newUser);
        Assertions.assertEquals(newUser, bag.getBagOfUser());
    }
}
