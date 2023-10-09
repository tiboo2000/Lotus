package be.heh.lotus.application.domain;

public class Product {
    private int id;
    private String name;
    private double prix;
    public Product(int id,String name,double prix){
        this.id = id;
        this.name = name;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrix() {
        return prix;
    }
}
