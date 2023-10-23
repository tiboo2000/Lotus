package be.heh.lotus.port.out;

import be.heh.lotus.application.domain.User;

public interface GestionUser_Out {
    public boolean fetchUser(int id);

    public void AddUser(User users);

    public void DeleteUser(User users);
}
