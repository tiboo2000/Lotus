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

    private ArrayList<Product> ListProduct;

    private String User ;

    public Bag(ArrayList<Product> listProduct, String User) {
        this.ListProduct = listProduct;
        this.User = User;
    }
}