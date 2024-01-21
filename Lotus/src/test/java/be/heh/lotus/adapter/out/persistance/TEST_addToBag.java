package be.heh.lotus.adapter.out.persistance;

import be.heh.lotus.LotusApp;
import be.heh.lotus.adapter.out.persistance.repository.BagRepository;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

@SpringBootTest(classes= LotusApp.class)
public class TEST_addToBag {

    @Autowired
    private BagRepository bagRepository ;

    private BagAdapterPersistence bagAdapterPersistence ;

    private static final Product PRODUCT = new Product(1,"test",1.0,1);

    @Test
    public void testAddToBag() {
        bagAdapterPersistence = new BagAdapterPersistence(bagRepository);
        Product produit = new Product(1,"test",1.0,1);
        ArrayList<Product> produitList = new ArrayList<>();
        produitList.add(produit);
        bagAdapterPersistence.AddToBag(PRODUCT, "test");
    }

    @Test
    public void getall() {
        bagAdapterPersistence = new BagAdapterPersistence(bagRepository);
        System.out.println(bagAdapterPersistence.getbaguser("test"));
    }
}
