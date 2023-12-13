package be.heh.lotus.application.service;

import be.heh.lotus.application.domain.model.Categories;
import be.heh.lotus.application.domain.service.GestionCategories;
import be.heh.lotus.application.port.out.Categories_Out;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class TEST_getCategoryIfExistAndGetAllCategory {
    private static final int ID_CATEGORY1=1;
    private static final Categories CATEGORY1=new Categories(1,"Ordinateur");
    private static final Categories CATEGORY2=new Categories(2,"Tablette");
    private static final ArrayList<Categories> CATEGORIES_LIST_A =new ArrayList<>();
    private static final ArrayList<Categories> CATEGORIES_LIST_B =new ArrayList<>();
    private static final boolean CONDITION = true;
    @Test
    public void shouldAddCategory(){
        CATEGORIES_LIST_A.add(CATEGORY1);
        CATEGORIES_LIST_A.add(CATEGORY2);
        CATEGORIES_LIST_B.add(CATEGORY1);
        Categories_Out categoriesOut = mock(Categories_Out.class);
        GestionCategories gestionCategories =new GestionCategories(categoriesOut);
        when(categoriesOut.verifyCategories(CATEGORY1.getId())).thenReturn(CONDITION);
        when(categoriesOut.getCategoriesById(CATEGORY1.getId())).thenReturn(CATEGORIES_LIST_B);
        when(categoriesOut.getCategories()).thenReturn(CATEGORIES_LIST_A);
        Assertions.assertEquals(CATEGORIES_LIST_B,gestionCategories.getById(ID_CATEGORY1));
        Assertions.assertEquals(CATEGORIES_LIST_A,gestionCategories.get());
    }
}
