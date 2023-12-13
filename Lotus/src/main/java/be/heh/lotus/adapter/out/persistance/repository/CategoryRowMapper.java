package be.heh.lotus.adapter.out.persistance.repository;

import be.heh.lotus.application.domain.model.Categories;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Categories> {

    @Override
    public Categories mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Categories(
                rs.getInt("id"),
                rs.getString("name")
        );
    }
}
