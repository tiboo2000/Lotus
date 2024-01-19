package be.heh.lotus.application.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@Getter
@Setter
public class Bag {
    private LinkedHashMap<Product, Integer> ListProduct;

    private User BagOfUser ;

    public Bag(ArrayList<Product> listProduct, User bagOfUser) {
        ListProduct = new LinkedHashMap<>();
        for (Product product : listProduct) {
            ListProduct.put(product, 1);
        }
        BagOfUser = bagOfUser;
    }
}