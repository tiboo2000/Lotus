package be.heh.lotus.application.service;

import be.heh.lotus.application.domain.Bag;
import be.heh.lotus.application.domain.Product;
import be.heh.lotus.port.in.UseCase_In_Bag;

import java.util.ArrayList;

public class Gestion_Bag implements UseCase_In_Bag {

    @Override
    public void AddToBag(Product produit, Bag bag) {
        ArrayList<Product> Temp = bag.getListProduct();
        Temp.add(produit);
        bag.setListProduct(Temp);
    }

    @Override
    public void SuppFromBag(Product produit, Bag bag) {
        ArrayList<Product> Temp = bag.getListProduct();
        if(Temp.indexOf(produit)!= -1){
            Temp.remove(produit);
            bag.setListProduct(Temp);
        }

    }

    @Override
    public void ResetBag( Bag bag) {
        ArrayList<Product> Temp = bag.getListProduct();
        bag.setListProduct(Temp);
    }

    @Override
    public int modifyQuantity(int quattinit, int qtttomdf, String operation) {
        switch (operation){
            case "set":
                return qtttomdf;
            case "fastadd":
                return quattinit + 1;
            case "fastsub":
                return quattinit - 1;
            default:
                return quattinit;
        }
    }
}
