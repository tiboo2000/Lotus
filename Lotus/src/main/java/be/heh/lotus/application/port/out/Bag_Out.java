package be.heh.lotus.application.port.out;

import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;

import java.util.ArrayList;

public interface Bag_Out {
    ArrayList<Product> getbaguser(User user);
}
