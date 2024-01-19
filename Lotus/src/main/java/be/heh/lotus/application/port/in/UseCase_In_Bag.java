package be.heh.lotus.application.port.in;

import be.heh.lotus.application.domain.model.Bag;
import be.heh.lotus.application.domain.model.Product;

public interface UseCase_In_Bag { //défini les méthodes que l'on va utiliser dans le usecase et qui définissent les actions que l'on va faire sur le bag et donc les cas d'utulisation
    public void AddToBag(Product produit, Bag bag);
    public void SuppFromBag(Product produit, Bag bag);
    public void ResetBag(Bag bag);

    public int modifyQuantity(int initproduct, int qtttomdf, String operation);
}