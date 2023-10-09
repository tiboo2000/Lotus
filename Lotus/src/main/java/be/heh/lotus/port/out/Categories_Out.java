package be.heh.lotus.port.out;

import be.heh.lotus.application.domain.Categories;

public interface Categories_Out {
    public boolean getCategories(int id);
    public void addCategory(Categories category);
}
