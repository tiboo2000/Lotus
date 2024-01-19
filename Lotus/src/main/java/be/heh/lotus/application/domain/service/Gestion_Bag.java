package be.heh.lotus.application.domain.service;

import be.heh.lotus.application.domain.model.Bag;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;
import be.heh.lotus.application.port.in.UseCase_In_Bag;
import be.heh.lotus.application.port.out.Bag_Out;

import java.util.ArrayList;

public class Gestion_Bag implements UseCase_In_Bag {

    public Bag_Out bag_out;
    public Gestion_Bag(Bag_Out bag_out){this.bag_out = bag_out;}

    @Override
    public void AddToBag(Product produit, User user) {
        bag_out.AddToBag(produit, user);
    }

    @Override
    public void SuppFromBag(Product produit, User user) {
        bag_out.SuppFromBag(produit, user);
    }

    @Override
    public void ResetBag(User user) {
        bag_out.ResetBag(user);
    }

    @Override
    public void modifyQuantity(int quattinit, int qtttomdf, String operation,User user, Product produit) {
        switch (operation){
            case "set":
                bag_out.setQuantity(produit, user, qtttomdf);
            case "fastadd":
                bag_out.setQuantity(produit, user, qtttomdf + 1);
            case "fastsub":
                bag_out.setQuantity(produit, user, qtttomdf - 1);
        }
    }
}
