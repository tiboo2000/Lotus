package be.heh.lotus.application.port.out;

import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;

import java.util.ArrayList;

public interface Bag_Out {
    void AddToBag(Product produit, User user);

    void SuppFromBag(Product produit, User user);

    void ResetBag(User user);

    void setQuantity(Product produit, User user, int quantity);

    int getQuantity(Product produit, User user);

    ArrayList<Product> getbaguser(User user);

}
