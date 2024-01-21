package be.heh.lotus.adapter.out.persistance.repository;
import be.heh.lotus.application.domain.model.Bag;
import be.heh.lotus.application.domain.model.Categories;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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


}