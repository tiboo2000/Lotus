package be.heh.lotus.application.service;

import be.heh.lotus.application.domain.Categories;
import be.heh.lotus.port.out.Categories_Out;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TEST_removeCategoryIfExist {
    private static final Categories CATEGORY=new Categories(1,"Ordinateur");
    private static final boolean CONDITION = true;
    @Test
    public void shouldAddCategory(){
        Categories_Out categoriesOut = mock(Categories_Out.class);
        GestionCategories gestionCategories =new GestionCategories(categoriesOut);
        when(categoriesOut.verifyCategories(CATEGORY.getId())).thenReturn(CONDITION);
        gestionCategories.remove(CATEGORY);
        verify(categoriesOut).removeCategory(CATEGORY);
    }
}
