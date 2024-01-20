package be.heh.lotus.application.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    // Test pour voir si un produit retourne le bon id
    @Test
    public void whenGettingId_shouldReturnCorrectId() {
        Product product = new Product(1, "yeux", 1000, 1);
        Assertions.assertEquals(1, product.getId());
    }

    // Test si la fonction retourne le bon nom
    @Test
    public void whenGettingName_shouldReturnCorrectName() {
        Product product = new Product(1, "yeux", 1000, 1);
        Assertions.assertEquals("yeux", product.getName());
    }

    // Test si la méthode retourne le bon prix
    @Test
    public void whenGettingPrice_shouldReturnCorrectPrice() {
        Product product = new Product(1, "yeux", 1000, 1);
        Assertions.assertEquals(1000, product.getPrice());
    }

    // Test si la méthode retourne la bonne catégorie
    @Test
    public void whenGettingCategoryID_shouldReturnCorrectCategoryID() {
        Product product = new Product(1, "yeux", 1000, 1);
        Assertions.assertEquals(1, product.getCategoryID());
    }

    // Test si la méthode retourne la bonne catégorie qui a été modifiée
    @Test
    public void whenSettingCategoryID_shouldUpdateCategoryID() {
        Product product = new Product(1, "yeux", 1000, 1);
        product.setCategoryID(2);
        Assertions.assertEquals(2, product.getCategoryID());
    }
}
