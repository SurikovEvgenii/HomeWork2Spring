package org.surikov.top.springshops.dao;

import org.surikov.top.springshops.model.Shop;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopRowMapper implements RowMapper<Shop> {
    @Override
    public Shop mapRow(ResultSet rs, int rowNum) throws SQLException {
        Shop shop = new Shop();
        shop.setId(rs.getInt(1));
        shop.setName(rs.getString(2));
        shop.setAddress(rs.getString(3));
        shop.setTelephone(rs.getString(4));
        shop.setEmail(rs.getString(5));
        shop.setSite(rs.getString(6));
        shop.setCategory_id(rs.getInt(7));
        shop.setDescription(rs.getString(8));
        return shop;
    }
}
