package be.heh.lotus.adapter.out.persistance;

import be.heh.lotus.adapter.in.web.AdapterWeb;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.port.in.UseCase_In_Bag;
import be.heh.lotus.application.port.in.UseCase_In_Categories;
import be.heh.lotus.application.port.in.UseCase_In_Product;
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
        UseCase_In_Product productUseCase = Mockito.mock(UseCase_In_Product.class);
        AdapterWeb adapterWeb = new AdapterWeb(categoriesUseCase,productUseCase,bagUseCase);

        Product product = new Product(1,"test", 2 ,1 );
        String user = "testUser";
        int quantity = 5;

        when(bagUseCase.getQuantity(product, user)).thenReturn(quantity);
        // Act
        ResponseEntity<Integer> response = adapterWeb.getBagWeb(  String.valueOf(product.getId()),product.getName(), String.valueOf(product.getPrice()), String.valueOf(product.getCategoryId()), user);

        // Assert
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(quantity, response.getBody());
    }

    @Test
    public void testAddBagWeb() {
        // Arrange
        UseCase_In_Categories categoriesUseCase = Mockito.mock(UseCase_In_Categories.class);
        UseCase_In_Bag bagUseCase = Mockito.mock(UseCase_In_Bag.class);
        UseCase_In_Product productUseCase = Mockito.mock(UseCase_In_Product.class);
        AdapterWeb adapterWeb = new AdapterWeb(categoriesUseCase,productUseCase,bagUseCase);

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
        UseCase_In_Product productUseCase = Mockito.mock(UseCase_In_Product.class);
        AdapterWeb adapterWeb = new AdapterWeb(categoriesUseCase,productUseCase,bagUseCase);

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
        UseCase_In_Product productUseCase = Mockito.mock(UseCase_In_Product.class);
        AdapterWeb adapterWeb = new AdapterWeb(categoriesUseCase,productUseCase,bagUseCase);

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
        UseCase_In_Product productUseCase = Mockito.mock(UseCase_In_Product.class);
        AdapterWeb adapterWeb = new AdapterWeb(categoriesUseCase,productUseCase,bagUseCase);

        Product product = new  Product(1,"test", 2 ,1 );
        String user = "testUser";
        int quantity = 5;
        String operation = "add";

        // Act
        ResponseEntity<String> response = adapterWeb.updateBagWeb(user, quantity, operation,product, null);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Quantity Product updated successfully", response.getBody());
    }
}