package be.heh.lotus.adapter.out.persistance.repository;

import be.heh.lotus.application.domain.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        double price = rs.getDouble("price");
        int categoryId = rs.getInt("category_id");

        return new Product(id, name, price, categoryId);
    }
}
