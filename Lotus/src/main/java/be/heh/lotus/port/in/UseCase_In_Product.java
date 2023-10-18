package be.heh.lotus.port.in;

import be.heh.lotus.application.domain.Product;

import java.util.ArrayList;

public interface UseCase_In_Product {
    public void add (Product product);
    public void del (int id); //Refaire avec l'id
    public Product get_Product_By_ID_Product(int id);
    public ArrayList<Product> get_All_Product_By_Id_Category(int id_cat);
}
