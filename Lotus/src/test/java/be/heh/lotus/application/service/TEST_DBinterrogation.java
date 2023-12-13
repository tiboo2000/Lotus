package be.heh.lotus.application.service;

import be.heh.lotus.LotusApp;
import be.heh.lotus.adapter.out.persistance.CategoryAdapterPersistence;
import be.heh.lotus.adapter.out.persistance.repository.CategoriesRepository;
import be.heh.lotus.application.domain.model.Categories;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes= LotusApp.class)
public class TEST_DBinterrogation {
    @Autowired
    private CategoriesRepository categoriesRepository;
    private CategoryAdapterPersistence persistence;
    @Test
    public void testgetdb(){
        persistence=new CategoryAdapterPersistence(categoriesRepository);
        List<Categories> categoriesList = persistence.getCategories();
        Assertions.assertEquals(3,categoriesList.size());
    }
}
