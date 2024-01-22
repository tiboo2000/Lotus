package be.heh.lotus.adapter.out.persistance;

import be.heh.lotus.adapter.in.web.AdapterWeb;
import be.heh.lotus.application.domain.model.Bag;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.port.in.UseCase_In_Bag;
import be.heh.lotus.application.port.in.UseCase_In_Categories;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AdapterWebTest {

    @Test
    public void testGetBagWeb() {
        // Arrange
        UseCase_In_Categories categoriesUseCase = Mockito.mock(UseCase_In_Categories.class);
        UseCase_In_Bag bagUseCase = Mockito.mock(UseCase_In_Bag.class);
        AdapterWeb adapterWeb = new AdapterWeb(categoriesUseCase, bagUseCase);

        Product product = new Product(1,"test", 2 ,1 );
        String user = "testUser";
        int quantity = 5;

        when(bagUseCase.getQuantity(product, user)).thenReturn(quantity);

        // Act
        ResponseEntity<Integer> response = adapterWeb.getBagWeb(product, user, null);

        // Assert
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(quantity, response.getBody());
    }

    @Test
    public void testAddBagWeb() {
        // Arrange
        UseCase_In_Categories categoriesUseCase = Mockito.mock(UseCase_In_Categories.class);
        UseCase_In_Bag bagUseCase = Mockito.mock(UseCase_In_Bag.class);
        AdapterWeb adapterWeb = new AdapterWeb(categoriesUseCase, bagUseCase);

        Product product = new  Product(1,"test", 2 ,1 );
        String user = "testUser";

        // Act
        ResponseEntity<String> response = adapterWeb.addBagWeb(user, product, null);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Bag added successfully", response.getBody());
    }

    @Test
    public void testRemoveBagWeb() {
        // Arrange
        UseCase_In_Categories categoriesUseCase = Mockito.mock(UseCase_In_Categories.class);
        UseCase_In_Bag bagUseCase = Mockito.mock(UseCase_In_Bag.class);
        AdapterWeb adapterWeb = new AdapterWeb(categoriesUseCase, bagUseCase);

        String user = "testUser";

        // Act
        ResponseEntity<String> response = adapterWeb.removeBagWeb(user, null);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Bag deleted successfully", response.getBody());
    }

    @Test
    public void testRemoveProductFromBagWeb() {
        // Arrange
        UseCase_In_Categories categoriesUseCase = Mockito.mock(UseCase_In_Categories.class);
        UseCase_In_Bag bagUseCase = Mockito.mock(UseCase_In_Bag.class);
        AdapterWeb adapterWeb = new AdapterWeb(categoriesUseCase, bagUseCase);

        Product product = new  Product(1,"test", 2 ,1 );
        String user = "testUser";

        // Act
        ResponseEntity<String> response = adapterWeb.removeBagWeb(user, product, null);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Product deleted successfully", response.getBody());
    }

    @Test
    public void testUpdateBagWeb() {
        // Arrange
        UseCase_In_Categories categoriesUseCase = Mockito.mock(UseCase_In_Categories.class);
        UseCase_In_Bag bagUseCase = Mockito.mock(UseCase_In_Bag.class);
        AdapterWeb adapterWeb = new AdapterWeb(categoriesUseCase, bagUseCase);

        Product product = new  Product(1,"test", 2 ,1 );
        String user = "testUser";
        int quantity = 5;
        String operation = "add";

        // Act
        ResponseEntity<String> response = adapterWeb.updateBagWeb(user, product, quantity, operation, null);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Quantity Product updated successfully", response.getBody());
    }
}