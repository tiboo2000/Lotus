package be.heh.lotus.application.domain;

public class Product {
    private int id;
    private String name;
    private double prix;
    private int id_cat;
    public Product(int id,String name,double prix,int id_cat){
        this.id = id;
        this.name = name;
        this.prix = prix;
        this.id_cat = id_cat;
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

    public int getId_cat(){
        return id_cat;
    }
}
