package be.heh.lotus.application.domain.service;

import be.heh.lotus.application.domain.model.Bag;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;
import be.heh.lotus.application.port.out.Bag_Out;
import be.heh.lotus.application.port.out.Product_Out;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TEST_Gestion_Bag {

    private Bag_Out bagOutMock;
    private Gestion_Bag gestionBag;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bagOutMock = Mockito.mock(Bag_Out.class);
        gestionBag = new Gestion_Bag(bagOutMock);
    }

    @Test
    void testAddToBag() {
        Product produit = new Product(1, "test", 1, 1);
        User user = new User("test", "test", 50, 12, new ArrayList<Product>());
        bagOutMock.AddToBag(produit, user);
        when(bagOutMock.getbaguser(user)).thenReturn((ArrayList<Product>) List.of(produit));

        assertTrue(bagOutMock.getbaguser(user).contains(produit));
    }

    @Test
    void testSuppFromBag() {
        Product produit = new Product(1, "test", 1, 1);
        User user = new User("test", "test", 50, 12, new ArrayList<Product>());

        bagOutMock.AddToBag(produit, user);
        when(bagOutMock.getbaguser(user)).thenReturn((ArrayList<Product>) List.of(produit));
        assertTrue(bagOutMock.getbaguser(user).contains(produit));

        bagOutMock.SuppFromBag(produit, user);
        when(bagOutMock.getbaguser(user)).thenReturn(new ArrayList<Product>());
        assertFalse(bagOutMock.getbaguser(user).contains(produit));
    }

    @Test
    void testResetBag() {
        Product produit = new Product(1, "test", 1, 1);
        User user = new User("test", "test", 50, 12, new ArrayList<Product>());

        bagOutMock.AddToBag(produit, user);
        when(bagOutMock.getbaguser(user)).thenReturn((ArrayList<Product>) List.of(produit));
        assertTrue(bagOutMock.getbaguser(user).contains(produit));

        bagOutMock.ResetBag(user);
        when(bagOutMock.getbaguser(user)).thenReturn(new ArrayList<Product>());
        assertFalse(bagOutMock.getbaguser(user).contains(produit));
    }

    @Test
    void testModifyQuantity_SetOperation() {
        Product produit = new Product(1, "test", 1, 1);
        User user = new User("test", "test", 50, 12, new ArrayList<Product>());

        bagOutMock.AddToBag(produit, user);
        when(bagOutMock.getQuantity(produit, user)).thenReturn(1);
        assertEquals(1, bagOutMock.getQuantity(produit, user));

        bagOutMock.setQuantity(produit, user, 2);
        when(bagOutMock.getQuantity(produit, user)).thenReturn(2);
        assertEquals(2, bagOutMock.getQuantity(produit, user));
    }

    @Test
    void testGetBagUser() {
        Product produit = new Product(1, "test", 1, 1);
        User user = new User("test", "test", 50, 12, new ArrayList<Product>());

        bagOutMock.AddToBag(produit, user);
        when(bagOutMock.getbaguser(user)).thenReturn((ArrayList<Product>) List.of(produit));
        assertEquals(List.of(produit), bagOutMock.getbaguser(user));
    }
}