package be.heh.lotus.adapter.out.persistance.repository;

import be.heh.lotus.application.domain.model.Bag;
import be.heh.lotus.application.domain.model.Product;
import be.heh.lotus.application.domain.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class BagRowMapper implements RowMapper<Bag> {
    @Override
    public Bag mapRow(ResultSet rs, int rowNum) throws SQLException {
        Gson gson = new Gson();
        String name = rs.getString("username");
        Type productListType = new TypeToken<ArrayList<Product>>(){}.getType();
        ArrayList<Product> listProduct = gson.fromJson(rs.getString("bagcontent"), productListType);

        return new Bag(listProduct, name);
    }
}
