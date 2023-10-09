package be.heh.lotus.application.domain;

import java.util.ArrayList;ArrayList

public class User {

    private String UserName;
    private String Password;
    private double Solde;

    private ArrayList<String> Pannier;

    //coordonnées utulisateurs

    public  User(String Username, String Password, double Solde, ArrayList<String> Pannier){
        this.UserName = Username;
        this.Password = Password;
        this.Solde= Solde;
        this.Pannier = Pannier;
    }

    public ArrayList<String> GetPannier(){
        return Pannier;
    }
    public String GetUserName(){
        return UserName;
    }
    public String GetPassword(){
        return Password;
    }
    public double GetSolde(){
        return Solde;
    }

}
