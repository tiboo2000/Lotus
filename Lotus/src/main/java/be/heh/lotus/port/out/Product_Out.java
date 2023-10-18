package be.heh.lotus.port.out;

import be.heh.lotus.application.domain.Product;

import java.util.List;

public interface Product_Out {
    public boolean fetch_Product_Id(int id);
    public boolean get_Category_ID(int id);
    public void add_Product(Product produit);
    public void remove_Product(int id);
    public Product fetch_Product_By_ID_Product(int id);
    public List<Product> fetch_All_Product_By_Id_Category(int id_cat);
}
