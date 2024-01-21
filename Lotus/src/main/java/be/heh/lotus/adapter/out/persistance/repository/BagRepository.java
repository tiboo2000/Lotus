package be.heh.lotus.adapter.out.persistance.repository;
import be.heh.lotus.application.domain.model.Bag;
import be.heh.lotus.application.domain.model.Categories;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;
import com.google.gson.Gson;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BagRepository {
    private final JdbcTemplate jdbc;
    public BagRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Bag> getAllInformation(){//va rechercher tout le pannier
        String sql ="SELECT * FROM bag";
        return jdbc.query(sql,new BagRowMapper());
    }

    public void addBag(Product produit, String user){//ajoute un produit au pannier
        if (getbaguser(user) == null){
            String sql ="INSERT INTO bag (username,bagcontent) VALUES (?,?);";
            ArrayList<Product> ListProduct = new ArrayList<>();
            ListProduct.add(produit);
            Gson gson = new Gson();
            String json = gson.toJson(ListProduct);
            jdbc.update(sql,user,json);
        }
        else {
            String sql ="UPDATE bag SET bagcontent = ? WHERE username = ?;";
            ArrayList<Product> ListProduct = getbaguser(user);
            ListProduct.add(produit);
            Gson gson = new Gson();
            String json = gson.toJson(ListProduct);
            jdbc.update(sql,json, user);
        }
    }

    public int getQuantity(Product produit, String user){
        ArrayList<Product> temp = getbaguser(user);
        final int[] quantity = {0};
        temp.forEach((n) -> {
            if(Objects.equals(produit.getName(), n.getName())){
                quantity[0] = quantity[0] + 1;
            }
        });
        return quantity[0];
    }

    public ArrayList<Product> getbaguser(String user){
        String sql ="SELECT bag.* FROM bag WHERE bag.username = ?;";
        List<Bag> temp = jdbc.query(sql,new BagRowMapper(),user);
        if (temp.isEmpty()){
            return null;
        }
        else {
            ArrayList<Product> ListProduct = new ArrayList<>();
            temp.get(0).getListProduct().forEach((n, i) -> {
                ListProduct.add(n);
            });

            return ListProduct;
        }
    }

    public void deleteFromBag(Product produit, String user){
        String sql ="SELECT bag.* FROM bag WHERE bag.username = ?;";
        List<Bag> temp = jdbc.query(sql,new BagRowMapper(),user);

        ArrayList<Product> ListProduct = new ArrayList<>();
        temp.get(0).getListProduct().forEach((n, i) -> {
            ListProduct.add(n);
        });
        Gson gson = new Gson();
        ArrayList<Product> ListProduct2 = new ArrayList<>();
        for (int i = 0; i < ListProduct.size(); i++) {
            if(ListProduct.get(i).getId() != produit.getId()){
                ListProduct2.add(ListProduct.get(i));
            }
        }
        String json = gson.toJson(ListProduct2);
        String sql2 ="UPDATE bag SET bagcontent = ? WHERE username = ?;";
        jdbc.update(sql2,json,user);
    }

    public void resetBag(String user){
        String sql ="UPDATE bag SET bagcontent = ? WHERE username = ?;";
        ArrayList<Product> ListProduct = new ArrayList<>();
        Gson gson = new Gson();
        String json = gson.toJson(ListProduct);
        jdbc.update(sql,json,user);
    }

    public void setQuantity(Product produit, String user, int quantity){
        deleteFromBag(produit,user);
        ArrayList<Product> ListProduct = getbaguser(user);
        for(int i = 0; i < quantity; i++){
            ListProduct.add(produit);
        }
        Gson gson = new Gson();
        String json = gson.toJson(ListProduct);
        String sql2 ="UPDATE bag SET bagcontent = ? WHERE username = ?;";
        jdbc.update(sql2,json,user);
    }

}