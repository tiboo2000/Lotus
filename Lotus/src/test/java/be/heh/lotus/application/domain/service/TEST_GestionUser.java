package be.heh.lotus.application.domain.service;



import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;
import be.heh.lotus.application.port.out.GestionUser_Out;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

class TEST_GestionUser {

    @Mock
    private GestionUser_Out User_Out;

    private GestionUser gestionUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gestionUser = new GestionUser(User_Out);
    }

    @Test
    void testChangePannier() {
        User user = new User("Test","aa",40,1,new ArrayList<Product>());
        ArrayList<Product> pannier = new ArrayList<>();

        when(User_Out.fetchUser(user.getId())).thenReturn(false);

        gestionUser.ChangePannier(pannier, user);

        verify(User_Out, times(1)).fetchUser(user.getId());
        verifyNoMoreInteractions(User_Out);
    }

    @Test
    void testChangeUserName() {
        User user = new User("Test","aa",40,1,new ArrayList<Product>());
        String userName = "newUserName";

        when(User_Out.fetchUser(user.getId())).thenReturn(false);

        gestionUser.ChangeUserName(userName, user);

        verify(User_Out, times(1)).fetchUser(user.getId());
        verifyNoMoreInteractions(User_Out);
    }

    @Test
    void testChangePassword() {
        User user = new User("Test","aa",40,1,new ArrayList<Product>());
        String password = "newPassword";

        when(User_Out.fetchUser(user.getId())).thenReturn(false);

        gestionUser.ChangePassword(password, user);

        verify(User_Out, times(1)).fetchUser(user.getId());
        verifyNoMoreInteractions(User_Out);
    }

    @Test
    void testChangeSolde() {
        User user = new User("Test","aa",40,1,new ArrayList<Product>());
        double amount = 100.0;
        String operation = "addition";

        when(User_Out.fetchUser(user.getId())).thenReturn(false);

        gestionUser.ChangeSolde(amount, user, operation);

        verify(User_Out, times(1)).fetchUser(user.getId());
        verifyNoMoreInteractions(User_Out);
    }

    @Test
    void testAddUser() {
        User user = new User("Test","aa",40,1,new ArrayList<Product>());

        when(User_Out.fetchUser(user.getId())).thenReturn(false);

        gestionUser.AddUser(user);

        verify(User_Out, times(1)).fetchUser(user.getId());
        verify(User_Out, times(1)).AddUser(user);
        verifyNoMoreInteractions(User_Out);
    }

    @Test
    void testDeleteUser() {
        User user = new User("Test","aa",40,1,new ArrayList<Product>());

        when(User_Out.fetchUser(user.getId())).thenReturn(false);

        gestionUser.DeleteUser(user);

        verify(User_Out, times(1)).fetchUser(user.getId());
        verify(User_Out, times(1)).DeleteUser(user);
        verifyNoMoreInteractions(User_Out);
    }
}


