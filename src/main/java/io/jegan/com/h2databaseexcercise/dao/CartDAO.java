package io.jegan.com.h2databaseexcercise.dao;

import io.jegan.com.h2databaseexcercise.domain.Price;
import io.jegan.com.h2databaseexcercise.domain.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class CartDAO {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CartDAO(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void addProduct(Product product) {

        String sql = "INSERT into Product values(:id,:name,:description)";
         namedParameterJdbcTemplate.update(sql,new BeanPropertySqlParameterSource(product));

    }

    public void addPrice(Price price) {
        String sql = "INSERT into Price values(:priceId,:productId,:price,:discount)";
         namedParameterJdbcTemplate.update(sql,new BeanPropertySqlParameterSource(price));
    }

    public int updateProduct(Product product) {
        String sql = "UPDATE Product set description = :description where id = :id)";
        return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(product));
    }

    public int updatePrice(Price price) {
        String sql = "UPDATE Price set discount = :discount where priceId = :priceId)";
        return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(price));
    }
    public List<Product> listAllProduct() {
        String sql="SELECT * from Product";
     return namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));

    }
    public List<Price> listAllPrice() {
        String sql="SELECT * from Price";
        return namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Price.class));

    }

    public List<Price> finalCart() {
    String sql="SELECT sum(price) from Price";

    return namedParameterJdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Price.class));

    }
}
