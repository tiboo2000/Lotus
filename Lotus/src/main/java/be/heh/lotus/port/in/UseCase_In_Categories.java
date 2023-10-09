package be.heh.lotus.port.in;

import be.heh.lotus.application.domain.Categories;

import java.util.ArrayList;

public interface UseCase_In_Categories {
    public void add(Categories category);
    public void remove(Categories category);
    public ArrayList<Categories> get();
    public Categories get(Categories category);
}