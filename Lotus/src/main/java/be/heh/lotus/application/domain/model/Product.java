package be.heh.lotus.application.domain.model;

import lombok.Getter;
import lombok.Setter;

public class Product {
    // Getters
    @Getter
    private int id;
    // Setters
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private double price;
    private int categoryId;

    public Product(int id, String name, double price, int categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
    }

    public int getCategoryID() {
        return categoryId;
    }

    public void setCategoryID(int categoryId) {
        this.categoryId = categoryId;
    }
}
