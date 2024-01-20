package be.heh.lotus.application.domain.model;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.springframework.test.util.AssertionErrors.*;

public class TEST_Bag {
    private Bag bag;
    private User user;
    @Test
    public void testBagInitialization() {
        ArrayList<Product> productList = new ArrayList<>();
        Product product1 = new Product(1,"test",1,1); // Supposons que Product a un constructeur par défaut
        Product product2 = new Product(2,"test",1,1); // Idem pour product2
        productList.add(product1);
        productList.add(product2);

        User testUser = new User("test","test",1,1,productList); // Supposons que User a un constructeur par défaut

        Bag testBag = new Bag(productList, testUser);

        assertNotNull("La liste des produits ne devrait pas être null", testBag.getListProduct());
        assertEquals("La taille de la liste des produits devrait être 2", 2, testBag.getListProduct().size() );
        assertEquals("L'utilisateur du sac ne correspond pas à l'attendu", testUser, testBag.getBagOfUser());

        for (Product product : productList) {
            assertTrue("Le produit devrait être dans la liste", testBag.getListProduct().containsKey(product) );
            assertEquals("La quantité du produit devrait être 1", 1, testBag.getListProduct().get(product).intValue());
        }

    }
}
