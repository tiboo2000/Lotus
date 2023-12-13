package be.heh.lotus.adapter.out.persistance;

import be.heh.lotus.adapter.out.persistance.repository.CategoriesRepository;
import be.heh.lotus.application.domain.model.Categories;
import be.heh.lotus.application.port.out.Categories_Out;

import java.util.List;

public class CategoryAdapterPersistence implements Categories_Out {
    private CategoriesRepository categoriesRepository;
    public CategoryAdapterPersistence(CategoriesRepository categoriesRepository){
        this.categoriesRepository=categoriesRepository;
    }
    @Override
    public List<Categories> getCategoriesById(int id) {
        return categoriesRepository.getCategoryRep(id);
    }
    @Override
    public List<Categories> getCategories() {
        return categoriesRepository.getAllCategoriesRep();
    }
    @Override
    public boolean verifyCategories(int id) {
        return categoriesRepository.verifyCategoryRep(id);
    }
    @Override
    public void addCategory(Categories category) {
        categoriesRepository.addCategoryRep(category);
    }
    @Override
    public void removeCategoryById(int idCategory) {
        categoriesRepository.removeCategoryRep(idCategory);
    }
}
