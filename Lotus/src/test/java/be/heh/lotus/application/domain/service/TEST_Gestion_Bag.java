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

    private ArrayList<Product> baglist = new ArrayList<Product>();

    private Product produit = new Product(1, "test", 1, 1);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bagOutMock = Mockito.mock(Bag_Out.class);
        gestionBag = new Gestion_Bag(bagOutMock);
        baglist.add(produit);
    }

    @Test
    void testAddToBag() {
        bagOutMock.AddToBag(produit, "test");

        when(bagOutMock.getbaguser("test")).thenReturn(baglist);
        assertTrue(bagOutMock.getbaguser("test").contains(produit));
    }

    @Test
    void testSuppFromBag() {

        bagOutMock.AddToBag(produit, "test");
        when(bagOutMock.getbaguser("test")).thenReturn(baglist);
        assertTrue(bagOutMock.getbaguser("test").contains(produit));

        bagOutMock.SuppFromBag(produit, "test");
        when(bagOutMock.getbaguser("test")).thenReturn(new ArrayList<Product>());
        assertFalse(bagOutMock.getbaguser("test").contains(produit));
    }

    @Test
    void testResetBag() {
        bagOutMock.AddToBag(produit, "test");
        when(bagOutMock.getbaguser("test")).thenReturn(baglist);
        assertTrue(bagOutMock.getbaguser("test").contains(produit));

        bagOutMock.ResetBag("test");
        when(bagOutMock.getbaguser("test")).thenReturn(new ArrayList<Product>());
        assertFalse(bagOutMock.getbaguser("test").contains(produit));
    }

    @Test
    void testModifyQuantity_SetOperation() {

        bagOutMock.AddToBag(produit, "test");
        when(bagOutMock.getQuantity(produit, "test")).thenReturn(1);
        assertEquals(1, bagOutMock.getQuantity(produit, "test"));

        bagOutMock.setQuantity(produit, "test", 2);
        when(bagOutMock.getQuantity(produit, "test")).thenReturn(2);
        assertEquals(2, bagOutMock.getQuantity(produit, "test"));
    }

    @Test
    void testGetBagUser() {
        bagOutMock.AddToBag(produit, "test");

        when(bagOutMock.getbaguser("test")).thenReturn(baglist);
        assertEquals(List.of(produit), bagOutMock.getbaguser("test"));
    }
}