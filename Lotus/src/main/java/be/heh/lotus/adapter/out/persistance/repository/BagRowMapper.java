package be.heh.lotus.adapter.out.persistance.repository;

import be.heh.lotus.application.domain.model.Bag;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class BagRowMapper implements RowMapper<Bag> {
    @Override
    public Bag mapRow(ResultSet rs, int rowNum) throws SQLException {
        ArrayList<Product> ListProduct = new ArrayList<>();
        String temp = rs.getString("bag");
        try {
            ArrayList<String> temp2 = new ArrayList<String>(Arrays.asList(temp.split("\\.")));
            temp2.forEach((n) -> {
                ArrayList<String> toproduct = new ArrayList<String>(Arrays.asList(n.split(";")));
                ListProduct.add(new Product(Integer.parseInt(toproduct.get(0)) , toproduct.get(1), Double.parseDouble(toproduct.get(2)), Integer.parseInt(toproduct.get(3))));
            });
        } catch (Exception e) {
            ArrayList<String> toproduct = new ArrayList<String>(Arrays.asList(temp.split(";")));
            ListProduct.add(new Product(Integer.parseInt(toproduct.get(0)) , toproduct.get(1), Double.parseDouble(toproduct.get(2)), Integer.parseInt(toproduct.get(3))));
        }
        User user = new User(rs.getString("username"), "null", 0, 0, ListProduct);

        return new Bag(user.getPannier(), user);
    }
}
