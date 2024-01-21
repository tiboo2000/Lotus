package be.heh.lotus.adapter.out.persistance.repository;
import be.heh.lotus.application.domain.model.Bag;
import be.heh.lotus.application.domain.model.Categories;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BagRepository {
    private final JdbcTemplate jdbc;
    public BagRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Bag> getAllInformation(){//va rechercher tout le pannier
        String sql ="SELECT * FROM Bag";
        return jdbc.query(sql,new BagRowMapper());
    }

    public void addBag(Product produit, String user){//ajoute un produit au pannier
        String sql ="INSERT INTO Bag (username,bagcontent) VALUES (?,?);";
        jdbc.update(sql,produit.toString(),user);
    }

    public int getQuantity(Product produit, String user){//supprime le pannier
        String sql ="SELECT Bag.bagcontent FROM Bag WHERE Bag.username = ?;";
        List<Bag> temp = jdbc.query(sql,new BagRowMapper(),produit,user);
        final int[] quantity = {0};
        temp.get(0).getListProduct().forEach((n, i) -> {
            if(produit.getName() == n.getName()){
                quantity[0] = quantity[0] + 1;
            }
        });
        return quantity[0];
    }

    public ArrayList<Product> getbaguser(String user){//supprime le pannier
        String sql ="SELECT Bag.bagcontent FROM Bag WHERE Bag.username = ?;";
        List<Bag> temp = jdbc.query(sql,new BagRowMapper(),user);

        ArrayList<Product> ListProduct = new ArrayList<>();
        temp.get(0).getListProduct().forEach((n, i) -> {
            ListProduct.add(n);
        });

        return ListProduct;
    }

    public void deleteFromBag(Product produit, String user){//supprime le pannier
        String sql ="SELECT Bag.bagcontent FROM Bag WHERE Bag.username = ?;";
        List<Bag> temp = jdbc.query(sql,new BagRowMapper(),user);

        ArrayList<Product> ListProduct = new ArrayList<>();
        temp.get(0).getListProduct().forEach((n, i) -> {
            ListProduct.add(n);
        });

        ListProduct.remove(produit);

        String sql2 ="UPDATE Bag SET bagcontent = ? WHERE username = ?;";
        jdbc.update(sql2,ListProduct.toString(),user);
    }

    public void resetBag(String user){//supprime le pannier
        String sql ="UPDATE Bag SET bagcontent = ? WHERE username = ?;";
        jdbc.update(sql,"",user);
    }

    public void setQuantity(Product produit, String user, int quantity){//supprime le pannier
        String sql ="SELECT Bag.bagcontent FROM Bag WHERE Bag.username = ?;";
        List<Bag> temp = jdbc.query(sql,new BagRowMapper(),user);

        ArrayList<Product> ListProduct = new ArrayList<>();
        temp.get(0).getListProduct().forEach((n, i) -> {
            ListProduct.add(n);
        });

        ListProduct.remove(produit);

        for(int i = 0; i < quantity; i++){
            ListProduct.add(produit);
        }

        String sql2 ="UPDATE Bag SET bagcontent = ? WHERE username = ?;";
        jdbc.update(sql2,ListProduct.toString(),user);
    }

}