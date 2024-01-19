package be.heh.lotus.application.domain.service;

import be.heh.lotus.application.domain.model.Categories;
import be.heh.lotus.application.domain.service.GestionCategories;
import be.heh.lotus.application.port.out.Categories_Out;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TEST_addCategoryIfNoExist {
    private static final Categories CATEGORY=new Categories(1,"Ordinateur");
    private static final boolean CONDITION = false;
    @Test
    public void shouldAddCategory(){
        Categories_Out categoriesOut = mock(Categories_Out.class);
        GestionCategories gestionCategories =new GestionCategories(categoriesOut);
        when(categoriesOut.verifyCategories(CATEGORY.getId())).thenReturn(CONDITION);
        gestionCategories.add(CATEGORY);
        verify(categoriesOut).addCategory(CATEGORY);
    }
}
