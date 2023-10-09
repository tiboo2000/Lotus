package be.heh.lotus.application.service;

import be.heh.lotus.application.domain.Product;
import be.heh.lotus.port.in.UseCase_In_Product;
import be.heh.lotus.port.out.Product_Out;

import java.util.ArrayList;

public class Gestion_product implements UseCase_In_Product {
    Product_Out product_out;

    Gestion_product(Product_Out productOut){
        this.product_out = productOut;
    }

    @Override
    public void add(Product product) {
        if(!product_out.get_Product_Id(product.getId())){
            product_out.add_Product(product);
        }else {
            System.out.println("Le produit existe déjà !");
        }
    }
    @Override
    public void del(Product product) {
        if(product_out.get_Product_Id(product.getId())){
            product_out.remove_Product(product);
        }else {
            System.out.println("Le produit n'existe pas !");
        }
    }
}
