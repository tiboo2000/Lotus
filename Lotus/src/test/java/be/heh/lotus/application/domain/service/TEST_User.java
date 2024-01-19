package be.heh.lotus.application.domain.service;


import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class TEST_User {
    private static final ArrayList<Product> initPannier = new ArrayList<>();
    private static final ArrayList<Product> chngPannier = new ArrayList<>(){{
        add(new Product(1,"Produit1",1,1));
        add(new Product(2,"Produit2",2,1));
        add(new Product(3,"Produit3",3,1));
    }};;
    User user1 = new User("","",0,1,initPannier);

    @Test
    public void ShouldUser(){
        assertEquals("Ok","",user1.getUserName());
        user1.setUserName("a");
        assertEquals("Ok","a", user1.getUserName());

        assertEquals("Ok" ,user1.getSolde(),0.0);
        user1.setSolde(1);
        assertEquals("Ok" ,user1.getSolde(),1.0);

        assertEquals("Ok" ,user1.getPannier(),initPannier);
        user1.setPannier(chngPannier);
        assertEquals("Ok" ,user1.getPannier(),chngPannier);

        assertEquals("Ok" ,user1.getId(),1);
        user1.setId(2);
        assertEquals("Ok" ,user1.getId(),2);

        assertEquals("Ok" ,user1.getPassword(),"");
        user1.setPassword("ttttt");
        assertEquals("Ok" ,user1.getPassword(),"ttttt");

    }
}
