package be.heh.lotus.application.domain.service;

import be.heh.lotus.application.domain.model.Bag;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.port.in.UseCase_In_Bag;
import be.heh.lotus.application.port.out.Bag_Out;

import java.util.ArrayList;

public class Gestion_Bag implements UseCase_In_Bag {

    public Bag_Out bag_out;
    public Gestion_Bag(Bag_Out bag_out){this.bag_out = bag_out;}

    @Override
    public void AddToBag(Product produit, String user) {
        bag_out.AddToBag(produit, user);
    }

    @Override
    public void SuppFromBag(Product produit, String user) {
        bag_out.SuppFromBag(produit, user);
    }

    @Override
    public void ResetBag(String user) {
        bag_out.ResetBag(user);
    }

    @Override
    public void modifyQuantity(int quattinit, int qtttomdf, String operation,String user, Product produit) {
        switch (operation){
            case "set":
                bag_out.setQuantity(produit, user, qtttomdf);
            case "fastadd":
                bag_out.setQuantity(produit, user, qtttomdf + 1);
            case "fastsub":
                bag_out.setQuantity(produit, user, qtttomdf - 1);
        }
    }

    @Override
    public Bag getBagUser(String user) {
        return bag_out.getbaguser(user);
    }
    @Override
    public int getQuantity(Product produit, String user) {
        return bag_out.getQuantity(produit, user);
    }
}
