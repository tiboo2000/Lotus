package be.heh.lotus.application.domain.model;

import java.util.ArrayList;

public class User{
    private String UserName;
    private String Password;
    private double Solde;

    private int id;
    private ArrayList<Product> Pannier;

    public User(String UserName, String Password ,double Solde ,int id ,ArrayList<Product> Pannier){
        this.UserName = UserName;
        this.Password = Password;
        this.Solde = Solde;
        this.id = id;
        this.Pannier = Pannier;
    }
    public ArrayList<Product> getPannier() {
        return Pannier;
    }

    public void setPannier(ArrayList<Product> pannier) {
        Pannier = pannier;
    }

    public double getSolde() {
        return Solde;
    }

    public void setSolde(double solde) {
        Solde = solde;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
