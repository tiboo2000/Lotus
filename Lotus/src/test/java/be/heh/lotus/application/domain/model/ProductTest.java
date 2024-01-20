package be.heh.lotus.application.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    @Test
    public void Test(){
        Product oeil = new Product(1,"yeux",1000,1);
        Assertions.assertEquals(1,oeil.getId());
        Assertions.assertEquals("yeux",oeil.getName());
        Assertions.assertEquals(1000,oeil.getPrix());
    }
}
