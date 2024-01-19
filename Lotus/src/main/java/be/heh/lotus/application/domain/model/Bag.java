package be.heh.lotus.application.domain.model;

import java.util.ArrayList;

public class Bag {//définition de ce qu'est un panier + methode pour acceder au information du panier et pour le modifier
    private ArrayList<Product> ListProduct;
    private User BagOfUser ;

    public Bag(ArrayList<Product> ListProduct, User BagOfUser){
        this.ListProduct = ListProduct;
        this.BagOfUser = BagOfUser;
    }

    public ArrayList<Product> getListProduct() {
        return ListProduct;
    }

    public void setListProduct(ArrayList<Product> listProduct) {
        ListProduct = listProduct;
    }

    public User getBagOfUser() {
        return BagOfUser;
    }

    public void setBagOfUser(User bagOfUser) {
        BagOfUser = bagOfUser;
    }
}

