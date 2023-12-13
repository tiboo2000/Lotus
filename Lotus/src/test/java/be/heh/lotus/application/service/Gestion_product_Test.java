package be.heh.lotus.application.service;

import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.service.Gestion_product;
import be.heh.lotus.application.port.out.Product_Out;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Gestion_product_Test {
    private static final Product prod1 = new Product(1,"produit1",25,1);
    @Test
    void test_if_exist(){

        Product_Out mocklist = Mockito.mock(Product_Out.class);
        when(mocklist.fetch_Product_Id(1)).thenReturn(true);

        Gestion_product gestion1 = new Gestion_product(mocklist);
        gestion1.add(prod1);
        verify(mocklist).add_Product(prod1);

        verify(mocklist).remove_Product(prod1);
    }

    @Test
    /*Ici je test si la méthode renvoie bien, le bon objet quand je demande --> Il faudra ensuite ajouter la
    requête à la DB dans l'adaptateur out.*/
    void testArrayProductById() {
        Product produit1 = new Product(1, "Yaris", 1000, 1);
        Product produit2 = new Product(2, "Peugeot", 2000, 1);
        List<Product> products = new ArrayList<>();
        products.add(produit1);
        products.add(produit2);

        Product_Out productOutMock = Mockito.mock(Product_Out.class);
        when(productOutMock.fetch_All_Product_By_Id_Category(1)).thenReturn(products);

        Gestion_product gestionProduct = new Gestion_product(productOutMock);

        ArrayList<Product> productsFromCategory = gestionProduct.get_All_Product_By_Id_Category(1);

        Assertions.assertEquals(1, productsFromCategory.get(0).getId_cat());
    }
}
