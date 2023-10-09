package be.heh.lotus.port.in;

import be.heh.lotus.application.domain.Product;

public interface UseCase_In_Product {
    public void add (Product product);
    public void del (Product product);
}
