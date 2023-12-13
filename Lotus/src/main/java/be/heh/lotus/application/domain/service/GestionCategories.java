package be.heh.lotus.application.domain.service;

import be.heh.lotus.application.domain.model.Categories;
import be.heh.lotus.application.port.in.UseCase_In_Categories;
import be.heh.lotus.application.port.out.Categories_Out;

import java.util.List;

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
    public void removeById(int idCategory) {
        boolean isCategoryExist=categoriesOut.verifyCategories(idCategory);
        if (isCategoryExist){
            categoriesOut.removeCategoryById(idCategory);
        }
    }

    @Override
    public List<Categories> get() {
        List<Categories> categoriesList;
        categoriesList=categoriesOut.getCategories();
        return categoriesList;
    }
    @Override
    public List<Categories> getById(int idCategory) {
        boolean isCategoryExist=categoriesOut.verifyCategories(idCategory);
        if (isCategoryExist){
            return categoriesOut.getCategoriesById(idCategory);
        }else{
            return null;
        }

    }
}
