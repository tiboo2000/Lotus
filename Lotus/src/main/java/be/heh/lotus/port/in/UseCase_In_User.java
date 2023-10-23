package be.heh.lotus.port.in;

import be.heh.lotus.application.domain.User;

import java.util.ArrayList;

public interface UseCase_In_User {
        public void ChangePannier(ArrayList<String> Pannier, User user);
        public void ChangeUserName(String UserName, User user);
        public void ChangePassword(String Password, User user);
        public void ChangeSolde(double Solde, User user, String Operation);

        public void AddUser(User user);
        public void DeleteUser(User user);

}
