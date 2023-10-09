package be.heh.lotus.port.in;

import be.heh.lotus.application.domain.Categories;

public interface UseCase_In_Categories {

    void add(Categories category);
    public void remove(Categories category);
    public Categories get();
}