package be.heh.lotus.port.in;

import be.heh.lotus.application.domain.Product;

import java.util.ArrayList;

public interface UseCase_In_Product {
    public void add_Product(Product product);
    public void del_Product(Product product);
}
