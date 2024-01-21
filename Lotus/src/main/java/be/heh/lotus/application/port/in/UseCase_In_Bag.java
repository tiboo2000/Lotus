package be.heh.lotus.application.port.in;

import be.heh.lotus.application.domain.model.Bag;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;

public interface UseCase_In_Bag {
    public void AddToBag(Product produit, String user);
    public void SuppFromBag(Product produit, String user);
    public void ResetBag(String user);
    public void modifyQuantity(int initproduct, int qtttomdf, String operation, String user, Product produit);
}