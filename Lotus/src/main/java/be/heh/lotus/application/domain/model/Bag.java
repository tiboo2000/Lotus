package be.heh.lotus.application.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@Getter
@Setter
public class Bag {

    private int id;

    private LinkedHashMap<Product, Integer> ListProduct;

    private String User ;

    public Bag(ArrayList<Product> listProduct, String User) {
        ListProduct = new LinkedHashMap<>();
        for (Product product : listProduct) {
            ListProduct.put(product, 1);
        }
        this.User = User;
    }
}