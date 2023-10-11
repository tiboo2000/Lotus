package be.heh.lotus.application.service;

import be.heh.lotus.application.domain.Categories;
import be.heh.lotus.port.out.Categories_Out;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class TEST_getCategoryIfExistAndGetAllCategory {
    private static final int ID_CATEGORY1=1;
    private static final Categories CATEGORY1=new Categories(1,"Ordinateur");
    private static final Categories CATEGORY2=new Categories(2,"Tablette");
    private static final ArrayList<Categories> CATEGORIES_LIST =new ArrayList<>();
    private static final boolean CONDITION = true;
    @Test
    public void shouldAddCategory(){
        CATEGORIES_LIST.add(CATEGORY1);
        CATEGORIES_LIST.add(CATEGORY2);
        Categories_Out categoriesOut = mock(Categories_Out.class);
        GestionCategories gestionCategories =new GestionCategories(categoriesOut);
        when(categoriesOut.verifyCategories(CATEGORY1.getId())).thenReturn(CONDITION);
        when(categoriesOut.getCategoriesById(CATEGORY1.getId())).thenReturn(CATEGORY1);
        when(categoriesOut.getCategories()).thenReturn(CATEGORIES_LIST);
        Assertions.assertEquals(CATEGORY1,gestionCategories.getById(ID_CATEGORY1));
        Assertions.assertEquals(CATEGORIES_LIST,gestionCategories.get());
    }
}
