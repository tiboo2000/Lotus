package be.heh.lotus.application.service;

import be.heh.lotus.application.domain.Categories;
import be.heh.lotus.port.in.UseCase_In_Categories;
import be.heh.lotus.port.out.Categories_Out;

import java.util.ArrayList;

public class GestionCategories implements UseCase_In_Categories {

    Categories_Out categoriesOut;
    public GestionCategories(Categories_Out categoriesOut){
        this.categoriesOut=categoriesOut;
    }
    @Override
    public void add(Categories category) {
        boolean isCategoryExist=categoriesOut.verifyCategories(category.getId());
        if(!isCategoryExist){
            categoriesOut.addCategory(category);
        }
    }

    @Override
    public void remove(Categories category) {
        boolean isCategoryExist=categoriesOut.verifyCategories(category.getId());
        if (isCategoryExist){
            categoriesOut.removeCategory(category);
        }
    }

    @Override
    public ArrayList<Categories> get() {
        ArrayList<Categories> categoriesList = new ArrayList<>();
        categoriesList=categoriesOut.getCategories();
        return categoriesList;
    }
    @Override
    public Categories get(Categories category) {
        boolean isCategoryExist=categoriesOut.verifyCategories(category.getId());
        if (isCategoryExist){
            return category;
        }
        return null;
    }
}
