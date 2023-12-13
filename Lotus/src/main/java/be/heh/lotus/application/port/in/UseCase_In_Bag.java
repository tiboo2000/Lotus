package be.heh.lotus.application.port.in;

import be.heh.lotus.application.domain.model.Bag;
import be.heh.lotus.application.domain.model.Product;

public interface UseCase_In_Bag {
    public void AddToBag(Product produit, Bag bag);
    public void SuppFromBag(Product produit, Bag bag);
    public void ResetBag(Bag bag);

    public int modifyQuantity(int initproduct, int qtttomdf, String operation);
}