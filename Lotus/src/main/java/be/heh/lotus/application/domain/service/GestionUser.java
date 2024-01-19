package be.heh.lotus.application.domain.service;

import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;
import be.heh.lotus.application.port.in.UseCase_In_User;
import be.heh.lotus.application.port.out.GestionUser_Out;

import java.util.ArrayList;

public class GestionUser implements UseCase_In_User {

    private GestionUser_Out User_Out;
    public GestionUser(GestionUser_Out User_Out){
        this.User_Out = User_Out;
    }

    @Override
    public void ChangePannier(ArrayList<Product> Pannier, User user) {
        if(!User_Out.fetchUser(user.getId())){
            if(user.getPannier() != Pannier){
                user.setPannier(Pannier);
            }
        }
        else{
            System.out.println("L utulisateur n'est pas présent dans la base de donnée");
        }
    }

    @Override
    public void ChangeUserName(String UserName, User user) {
        if(!User_Out.fetchUser(user.getId())){
            if(user.getUserName() != UserName){
                user.setUserName(UserName);
            }
        }
        else{
            System.out.println("L utulisateur n'est pas présent dans la base de donnée");
        }
    }

    @Override
    public void ChangePassword(String Password, User user) {
        if(!User_Out.fetchUser(user.getId())){
            if(Password.length()>=9){
                if(user.getPassword() != Password){
                    user.setPassword(Password);
                }
            }
        }
        else{
            System.out.println("L utulisateur n'est pas présent dans la base de donnée");
        }
    }

    @Override
    public void ChangeSolde(double amount, User user,String Operation) {
        if(!User_Out.fetchUser(user.getId())){
            switch (Operation){
                case "soustract":
                    if(user.getSolde()>amount){
                        user.setSolde(user.getSolde()-amount);
                    }
                    break;

                case "addition":
                    user.setSolde(user.getSolde()+ amount);
                    break;

                case "reset":
                    user.setSolde(0);
                    break;
            }
        }
        else{
            System.out.println("L utulisateur n'est pas présent dans la base de donnée");
        }
    }

    @Override
    public void AddUser(User user) {
        if(!User_Out.fetchUser(user.getId())){
            if(!User_Out.fetchUser(user.getId())){
                User_Out.AddUser(user);
            }
            else{
                System.out.println("Cette utulisateur existe déja");
            }
        }
        else{
            System.out.println("L utulisateur n'est pas présent dans la base de donnée");
        }
    }

    @Override
    public void DeleteUser(User user) {
        if(!User_Out.fetchUser(user.getId())){
            if(!User_Out.fetchUser(user.getId())){
                User_Out.DeleteUser(user);
            }
            else{
                System.out.println("Cette utulisateur existe déja");
            }
        }
        else{
            System.out.println("L utulisateur n'est pas présent dans la base de donnée");
        }
    }
}