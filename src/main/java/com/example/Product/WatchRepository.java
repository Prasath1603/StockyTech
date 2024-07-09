package com.example.Product;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class WatchRepository {
    private final JdbcClient jdbcClient;
    private final JdbcTemplate jdbcTemplate;
    public WatchRepository(JdbcClient jdbcClient, JdbcTemplate jdbcTemplate) {
        this.jdbcClient = jdbcClient;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Watch> getAllWatches() {
        return jdbcClient.sql("SELECT * FROM watch")
                .query((rs, rowNum) -> new Watch(
                        rs.getLong("wid"),
                        rs.getString("wname"),
                        rs.getString("wtype"),
                        rs.getString("wmodel"),
                        rs.getLong("wprice")))
                .list();
    }

    public void addWatch(Watch newWatch) {
        String sql = "INSERT INTO watch (wid, wname,wtype, wmodel,wprice) VALUES (?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql(sql)
                .params(newWatch.getWid(), newWatch.getWname(), newWatch.getWtype(), newWatch.getWmodel(), newWatch.getWprice())
                .update(keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
            newWatch.setWid(key.longValue());
        }
    }
    public void deleteWatchById(Long id) {
        jdbcClient.sql("DELETE FROM watch WHERE wid = ? or wid=NULL")
                .params(id)
                .update();
    }


    public Mobile getWatchById(Long id) {
        return jdbcClient.sql("SELECT * FROM watch WHERE wid = :id")
                .params(Map.of("id", id))
                .query((rs, rowNum) -> new Watch(
                        rs.getLong("wid"),
                        rs.getString("wname"),
                        rs.getString("wtype"),
                        rs.getString("wmodel"),
                        rs.getLong("wprice")))
                .single();
    }
    public void updateWatch(Watch updatedWatch) {
        String sql = "UPDATE watch SET wname = ?, wtype = ?, wmodel = ?, wprice = ? WHERE wid = ?";
        jdbcClient.sql(sql)
                .params(updatedWatch.getWname(), updatedWatch.getWtype(), updatedWatch.getWmodel(), updatedWatch.getWprice(), updatedWatch.getWid())
                .update();
    }
}