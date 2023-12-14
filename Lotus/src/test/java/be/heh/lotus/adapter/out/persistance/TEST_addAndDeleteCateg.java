package be.heh.lotus.adapter.out.persistance;

import be.heh.lotus.LotusApp;
import be.heh.lotus.adapter.out.persistance.repository.CategoriesRepository;
import be.heh.lotus.application.domain.model.Categories;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes= LotusApp.class)
public class TEST_addAndDeleteCateg {
    @Autowired
    private CategoriesRepository categoriesRepository;
    private CategoryAdapterPersistence persistence;
    private static final Categories CATEGORY=new Categories(1,"Ordinateur");
    @Test
    public void testgetdb(){
        persistence=new CategoryAdapterPersistence(categoriesRepository);
        persistence.addCategory(CATEGORY);
        List<Categories> categoriesList = persistence.getCategories();
        Assertions.assertEquals(4,categoriesList.size());
        persistence.removeCategoryById(12);
        categoriesList = persistence.getCategories();
        Assertions.assertEquals(3,categoriesList.size());
    }
}
