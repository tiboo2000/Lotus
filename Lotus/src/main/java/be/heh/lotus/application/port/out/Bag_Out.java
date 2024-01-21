package be.heh.lotus.application.port.out;

import be.heh.lotus.application.domain.model.Bag;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;

import java.util.ArrayList;

public interface Bag_Out {
    void AddToBag(Product produit, String user);

    void SuppFromBag(Product produit, String user);

    void ResetBag(String user);

    void setQuantity(Product produit, String user, int quantity);

    int getQuantity(Product produit, String user);

    Bag getbaguser(String user);

}
