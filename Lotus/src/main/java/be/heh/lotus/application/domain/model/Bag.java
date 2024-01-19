package be.heh.lotus.application.domain.model;

import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Bag {
    private LinkedHashMap<Product, Integer> ListProduct;

    private User BagOfUser ;

    public Bag(ArrayList<Product> ListProduct, User BagOfUser){

        ListProduct.forEach((product) -> {
            this.ListProduct.put(product, 1);
        });
        this.BagOfUser = BagOfUser;
    }

    public ArrayList<Product> getListProduct() {
        ArrayList<Product> TempListProduct = new ArrayList<>();
        ListProduct.forEach((product, integer) -> {
            if (integer == 0){
                TempListProduct.add(product);
            }
        });
        return TempListProduct;
    }
    public LinkedHashMap<Product, Integer> getAllListProduct() {
        return ListProduct;
    }

    public void setQuantityProduct(Product product, int quantity) {
        this.ListProduct.put(product, quantity);
    }

    public void setListProduct(ArrayList<Product> listProduct) {
        listProduct.forEach((product) -> {
            this.ListProduct.put(product, 1);
        });
    }

    public User getUser() {
        return BagOfUser;
    }

}

