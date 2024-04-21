package org.surikov.top.springshops.dao;

import org.surikov.top.springshops.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShopJDBCDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ShopJDBCDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Shop find(int id){
            List<Shop> shops = jdbcTemplate.query("SELECT * FROM shops WHERE id=?", new Object[]{id}, new ShopRowMapper());
            if(shops.isEmpty()){
                return null;
            } else {
                return shops.get(0);
            }
    }

    public void save(Shop shop){
        jdbcTemplate.update("INSERT INTO shops(name,address,telephone,email,site,category_id,description) VALUES (?,?,?,?,?,?,?)", shop.getName(), shop.getAddress(), shop.getTelephone(), shop.getEmail(), shop.getSite(), shop.getCategory_id(), shop.getDescription());
    }

    public void update(int id, Shop shop){
            jdbcTemplate.update("UPDATE shops SET name=? WHERE id=?",shop.getName(), id);
    }

    public void delete(int id){
            jdbcTemplate.update("DELETE FROM shops WHERE id=?", id);
    }

    public List<Shop> findAll(){
            return jdbcTemplate.query("SELECT * FROM shops", new ShopRowMapper());
    }



}
