package be.heh.lotus.adapter.out.persistance.repository;

import be.heh.lotus.application.domain.model.Categories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriesRepository {
    private final JdbcTemplate jdbc;
    public CategoriesRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    public List<Categories> getAllCategoriesRep(){
        String sql ="SELECT * FROM category";
        return jdbc.query(sql,new CategoryRowMapper());
    }
    public List<Categories> getCategoryRep(int id){
        String sql ="SELECT category.*"+
                "FROM category"+
                "WHERE category.id = ?;";
        return jdbc.query(sql,new CategoryRowMapper(),id);
    }
    public void addCategoryRep(Categories category){
        String sql ="INSERT INTO category (name)"+
                "VALUES (?);";
        jdbc.update(sql,new CategoryRowMapper(),category.getName());
    }
    public void removeCategoryRep(int id){
        String sql ="DELETE FROM category"+
                "WHERE id = ?;";
        jdbc.update(sql,new CategoryRowMapper(),id);
    }
    public boolean verifyCategoryRep(int id){
        String sql ="SELECT category.*"+
                "FROM category"+
                "WHERE category.id = ?;";
        if (jdbc.query(sql,new CategoryRowMapper(),id)==null){
            return false;
        }
        return true;
    }
}
