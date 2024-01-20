package be.heh.lotus.adapter.out.persistance.repository;

import be.heh.lotus.application.domain.model.Bag;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BagRowMapper implements RowMapper<Bag> {
    @Override
    public Bag mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
