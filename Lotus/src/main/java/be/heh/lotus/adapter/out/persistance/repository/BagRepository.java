package be.heh.lotus.adapter.out.persistance.repository;
import be.heh.lotus.application.domain.model.Bag;
import be.heh.lotus.application.domain.model.Categories;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class BagRepository {
    private final JdbcTemplate jdbc;
    public BagRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Bag> getAllInformation(){//va rechercher tout le pannier
        String sql ="SELECT * FROM bag";
        return jdbc.query(sql,new BagRowMapper());
    }

    public void addBag(Product produit, User user){//ajoute un produit au pannier
        List<Bag> bag = getAllInformation();
        ArrayList<Product> newBag =  bag.get(0).getBagOfUser().getPannier();
        newBag.add(produit);
        String sql ="INSERT INTO bag (username,bag) VALUES (?,?);";
        jdbc.update(sql,user,newBag);
    }
}