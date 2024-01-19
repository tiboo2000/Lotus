package be.heh.lotus.application.domain;


import be.heh.lotus.port.in.UseCase_In_Product;

import java.util.ArrayList;

public class Product {

    private String name;
    private int prix;
    private int id;

    public Product(int id, String name,int prix){
        this.id=id;
        this.name=name;
        this.prix=prix;
    }

    public String get_Product() {
        return name;
    }

    public int get_Prix() {
        return prix;
    }

    public int get_id() {
        return id;
    }
}