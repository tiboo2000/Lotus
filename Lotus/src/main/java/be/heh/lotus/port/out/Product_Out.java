package be.heh.lotus.port.out;

import be.heh.lotus.application.domain.Product;

public interface Product_Out {
    public boolean get_Product_Id(int id);
    public void add_Product(Product produit);
    public void remove_Product(Product product);
}
