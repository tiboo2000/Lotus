package be.heh.lotus.adapter.out.persistance.repository;
import org.springframework.jdbc.core.JdbcTemplate;

public class BagRepository {
    private final JdbcTemplate jdbc;
    public BagRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
}