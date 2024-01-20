package be.heh.lotus.adapter.out.persistance;

import be.heh.lotus.adapter.out.persistance.repository.BagRepository;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;
import be.heh.lotus.application.port.out.Bag_Out;

import java.util.ArrayList;

public class BagAdapterPersistence implements Bag_Out {

    private BagRepository bagRepository;

    public BagAdapterPersistence(BagRepository bagRepository){
        this.bagRepository=bagRepository;
    }
    @Override
    public void AddToBag(Product produit, User user) {
        bagRepository.addBag(produit,user);
    }

    @Override
    public void SuppFromBag(Product produit, User user) {

    }

    @Override
    public void ResetBag(User user) {

    }

    @Override
    public void setQuantity(Product produit, User user, int quantity) {

    }

    @Override
    public int getQuantity(Product produit, User user) {
        return 0;
    }

    @Override
    public ArrayList<Product> getbaguser(User user) {
        return null;
    }
}
