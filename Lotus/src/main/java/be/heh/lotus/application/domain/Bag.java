package be.heh.lotus.application.domain;

import java.util.ArrayList;

public class Bag {
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

