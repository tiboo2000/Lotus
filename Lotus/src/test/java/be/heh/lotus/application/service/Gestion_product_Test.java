package be.heh.lotus.application.service;

import be.heh.lotus.application.domain.Product;
import be.heh.lotus.port.out.Product_Out;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Gestion_product_Test {
    private static final Product prod1 = new Product(1,"produit1",25);
    @Test
    void test_if_exist(){

        Product_Out mocklist = Mockito.mock(Product_Out.class);
        when(mocklist.get_Product_Id(1)).thenReturn(true);

        Gestion_product gestion1 = new Gestion_product(mocklist);
        gestion1.add(prod1);
        verify(mocklist).add_Product(prod1);

        verify(mocklist).remove_Product(prod1);
    }
}
