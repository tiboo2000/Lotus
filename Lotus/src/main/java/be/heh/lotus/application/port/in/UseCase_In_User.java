package be.heh.lotus.application.port.in;

import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;

import java.util.ArrayList;

public interface UseCase_In_User {
         void ChangePannier(ArrayList<Product> Pannier, User user);
         void ChangeUserName(String UserName, User user);
         void ChangePassword(String Password, User user);
         void ChangeSolde(double Solde, User user, String Operation);

         void AddUser(User user);
         void DeleteUser(User user);

}
