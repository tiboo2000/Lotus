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
    public void AddToBag(Product produit, String user) {
        bagRepository.addBag(produit,user);
    }

    @Override
    public void SuppFromBag(Product produit, String user) {
        bagRepository.deleteFromBag(produit,user);
    }

    @Override
    public void ResetBag(String user) {
        bagRepository.resetBag(user);
    }

    @Override
    public void setQuantity(Product produit, String user, int quantity) {
        bagRepository.setQuantity(produit,user,quantity);
    }

    @Override
    public int getQuantity(Product produit, String user) {
        return bagRepository.getQuantity(produit,user);
    }

    @Override
    public ArrayList<Product> getbaguser(String user) {
        return bagRepository.getbaguser(user);
    }
}
