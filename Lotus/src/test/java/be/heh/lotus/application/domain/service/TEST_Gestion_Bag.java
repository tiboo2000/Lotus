package be.heh.lotus.application.domain.service;

import be.heh.lotus.application.domain.model.Bag;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;
import be.heh.lotus.application.port.out.Bag_Out;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TEST_Gestion_Bag {

    @Mock
    private Bag_Out bagOutMock;

    private Gestion_Bag gestionBag;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gestionBag = new Gestion_Bag();
    }

    @Test
    void testAddToBag() {
        Product product = new Product(1,"Produit1",1,1);
        ArrayList<Product> listtestproduct = new ArrayList<Product>();
        listtestproduct.add(product);
        Bag bag = new Bag(listtestproduct, new User("Test","aa",40,1,new ArrayList<Product>()));
        ArrayList<Product> expectedList = new ArrayList<>();
        expectedList.add(product);

        gestionBag.AddToBag(product, bag);

        assertEquals(expectedList, bag.getListProduct());
    }

    @Test
    void testSuppFromBag() {
        Product product = new Product(1,"Produit1",1,1);
        ArrayList<Product> listtestproduct = new ArrayList<Product>();
        listtestproduct.add(product);
        Bag bag = new Bag(listtestproduct, new User("Test","aa",40,1,new ArrayList<Product>()));
        bag.getListProduct().add(product);

        gestionBag.SuppFromBag(product, bag);

        assertEquals(new ArrayList<>(), bag.getListProduct());
    }

    @Test
    void testResetBag() {
        Product product = new Product(1,"Produit1",1,1);
        ArrayList<Product> listtestproduct = new ArrayList<Product>();
        listtestproduct.add(product);
        Bag bag = new Bag(listtestproduct, new User("Test","aa",40,1,new ArrayList<Product>()));
        assertEquals(listtestproduct, bag.getListProduct());
        gestionBag.ResetBag(bag);
        assertEquals(new ArrayList<Product>(), bag.getListProduct());
    }

    @Test
    void testModifyQuantity_SetOperation() {
        int initialQuantity = 5;
        int modifiedQuantity = 10;
        String operation = "set";

        int result = gestionBag.modifyQuantity(initialQuantity, modifiedQuantity, operation);

        assertEquals(modifiedQuantity, result);
    }

    @Test
    void testModifyQuantity_FastAddOperation() {
        int initialQuantity = 5;
        int expectedQuantity = initialQuantity + 1;
        String operation = "fastadd";

        int result = gestionBag.modifyQuantity(initialQuantity, 0, operation);

        assertEquals(expectedQuantity, result);
    }

    @Test
    void testModifyQuantity_FastSubOperation() {
        int initialQuantity = 5;
        int expectedQuantity = initialQuantity - 1;
        String operation = "fastsub";

        int result = gestionBag.modifyQuantity(initialQuantity, 0, operation);

        assertEquals(expectedQuantity, result);
    }

    @Test
    void testModifyQuantity_DefaultOperation() {
        int initialQuantity = 5;
        String operation = "unknown";

        int result = gestionBag.modifyQuantity(initialQuantity, 0, operation);

        assertEquals(initialQuantity, result);
    }

    @Test
    void testGetBagUser() {
        User user = new User("Test","aa",40,1,new ArrayList<Product>());
        ArrayList<Product> expectedList = new ArrayList<>();
        when(bagOutMock.getbaguser(user)).thenReturn(expectedList);

        ArrayList<Product> result = bagOutMock.getbaguser(user);

        assertEquals(expectedList, result);
        verify(bagOutMock, times(1)).getbaguser(user);
    }
}