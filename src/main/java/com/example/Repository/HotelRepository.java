package com.example.Repository;

import com.example.Domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * hotelsテーブルを操作するリポジトリ.
 */
@Repository
public class HotelRepository {

    @Autowired
    private NamedParameterJdbcTemplate temp;

    /**
     * SQLから情報を取得して、hotelクラスに一行ごとにセットする。
     * ""野中はSQLのカラムと一致するように書く。
     */
    private static final RowMapper<Hotel> HOTEL_ROW_MAPPER
            = (rs, rowNum) -> {
        Hotel hotel = new Hotel();
        hotel.setId(rs.getInt("id"));
        hotel.setAreaName(rs.getString("area_name"));
        hotel.setAddress(rs.getString("address"));
        hotel.setNearestStation(rs.getString("nearest_station"));
        hotel.setPrice(rs.getInt("price"));
        hotel.setParking(rs.getString("parking"));
        return hotel;
    };

    /**
     * 値段順の全件ホテル一覧を取得.
     *
     * @return ホテル情報
     */
    public List<Hotel> findAll(){

        String sql = "SELECT id, area_name, address, nearestStation, price, parking " +
                "FROM hotels ORDER BY price";

        List<Hotel> hotelList = temp.query(sql, HOTEL_ROW_MAPPER);

        return hotelList;
    }

    /**
     * 指定した値段以下のホテルを取得する.
     *
     * @param price ホテルの値段
     * @return ホテル情報
     */
    public Hotel findByPrice(Integer price){
        String sql = "SELECT id, area_name, address, nearestStation, price, parking " +
                "FROM hotels WHERE price <=:price";

        SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);

        return temp.queryForObject(sql, param, HOTEL_ROW_MAPPER);
    }





}
