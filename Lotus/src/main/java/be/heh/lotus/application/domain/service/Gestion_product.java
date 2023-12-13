package be.heh.lotus.application.domain.service;

import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.port.in.UseCase_In_Product;
import be.heh.lotus.application.port.out.Product_Out;

import java.util.ArrayList;

public class Gestion_product implements UseCase_In_Product {
    Product_Out product_out;

    public Gestion_product(Product_Out productOut) {
        this.product_out = productOut;
    }

    @Override
    public void add(Product product) {
        if (!product_out.fetch_Product_Id(product.getId())) {
            product_out.add_Product(product);
        } else {
            System.out.println("Le produit existe déjà !");
        }
    }

    @Override
    public void del(int id) {
        if (product_out.fetch_Product_Id(id)){
            product_out.remove_Product(id);
        } else {
            System.out.println("Le produit n'existe pas !");
        }
    }

    @Override
    public Product get_Product_By_ID_Product(int id) {
        if (product_out.fetch_Product_Id(id)) {
            return product_out.fetch_Product_By_ID_Product(id);
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Product> get_All_Product_By_Id_Category(int id_cat) {
        ArrayList<Product> productIds = new ArrayList<>();

        for (Product product : product_out.fetch_All_Product_By_Id_Category(id_cat)) {
            productIds.add(product);
        }

        return productIds;
    }
}
