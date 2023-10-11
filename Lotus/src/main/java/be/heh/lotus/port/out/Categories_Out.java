package be.heh.lotus.port.out;

import be.heh.lotus.application.domain.Categories;

import java.util.ArrayList;

public interface Categories_Out {
    public Categories getCategoriesById(int id);
    public ArrayList<Categories> getCategories();
    public boolean verifyCategories(int id);
    public void addCategory(Categories category);
    public void removeCategoryById(int idCategory);
}
