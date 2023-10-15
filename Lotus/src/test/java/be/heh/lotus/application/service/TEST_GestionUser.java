package be.heh.lotus.application.service;

import be.heh.lotus.application.domain.Categories;
import be.heh.lotus.application.domain.User;

import java.util.ArrayList;

import be.heh.lotus.port.out.Categories_Out;
import be.heh.lotus.port.out.GestionUser_Out;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TEST_GestionUser {

    private static final ArrayList<String> initPannier = new ArrayList<>();
    private static User USER1=new User("AAAAAAAAAAAAA", "bbbbbbbbbbbb",0,1,initPannier);

    @Test
    public void shouldGestUser(){
        GestionUser_Out Gestion_User_Out = mock(GestionUser_Out.class);
        GestionUser Gest_User = new GestionUser(Gestion_User_Out);
        Gest_User.DeleteUser(USER1);
        Gest_User.AddUser(USER1);
        Gest_User.ChangePannier(initPannier,USER1);
        Gest_User.ChangePassword("aaaaaaaaaaaa",USER1);
        Gest_User.ChangeUserName("BBBBBBBBBBB",USER1);
        Gest_User.DeleteUser(USER1);
    }
}
