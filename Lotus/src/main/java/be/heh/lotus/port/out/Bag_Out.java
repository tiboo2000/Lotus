package be.heh.lotus.port.out;

import be.heh.lotus.application.domain.Product;
import be.heh.lotus.application.domain.User;

import java.util.ArrayList;

public interface Bag_Out {
    ArrayList<Product> getbaguser(User user);
}
