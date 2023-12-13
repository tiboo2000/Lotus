package be.heh.lotus.application.port.out;

import be.heh.lotus.application.domain.model.Categories;

import java.util.List;

public interface Categories_Out {
    public List<Categories> getCategoriesById(int id);
    public List<Categories> getCategories();
    public boolean verifyCategories(int id);
    public void addCategory(Categories category);
    public void removeCategoryById(int idCategory);
}
