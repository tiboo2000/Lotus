package be.heh.lotus.application.port.in;

import be.heh.lotus.application.domain.model.Categories;

import java.util.List;

public interface UseCase_In_Categories {
    public void add(Categories category);
    public void removeById(int idCategory);
    public List<Categories> get();
    public List<Categories> getById(int idCategory);
}