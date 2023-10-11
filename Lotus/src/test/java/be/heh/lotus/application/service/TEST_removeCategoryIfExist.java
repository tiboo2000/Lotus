package be.heh.lotus.application.service;

import be.heh.lotus.application.domain.Categories;
import be.heh.lotus.port.out.Categories_Out;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TEST_removeCategoryIfExist {
    private static final int ID_CATEGORY=1;
    private static final boolean CONDITION = true;
    @Test
    public void shouldAddCategory(){
        Categories_Out categoriesOut = mock(Categories_Out.class);
        GestionCategories gestionCategories =new GestionCategories(categoriesOut);
        when(categoriesOut.verifyCategories(ID_CATEGORY)).thenReturn(CONDITION);
        gestionCategories.removeById(ID_CATEGORY);
        verify(categoriesOut).removeCategoryById(ID_CATEGORY);
    }
}
