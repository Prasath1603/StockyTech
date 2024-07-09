package com.example.Product;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MobileRepository {
    private final JdbcClient jdbcClient;
    private final JdbcTemplate jdbcTemplate;
    public MobileRepository(JdbcClient jdbcClient, JdbcTemplate jdbcTemplate) {
        this.jdbcClient = jdbcClient;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Mobile> getAllMobiles() {
        return jdbcClient.sql("SELECT * FROM mobile")
                .query((rs, rowNum) -> new Mobile(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("model"),
                        rs.getString("os_version"),
                        rs.getString("storage"),
                        rs.getLong("price")))
                .list();
    }

    public void addMobile(Mobile newMobile) {
        String sql = "INSERT INTO mobile (id, name, model, os_version, storage, price) VALUES (?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql(sql)
                .params(newMobile.getId(), newMobile.getName(), newMobile.getModel(), newMobile.getOs_version(), newMobile.getStorage(), newMobile.getPrice())
                .update(keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
            newMobile.setId(key.longValue());
        }
    }
    public void deleteMobileById(Long id) {
        jdbcClient.sql("DELETE FROM mobile WHERE id = ? or id=NULL")
                .params(id)
                .update();
    }
    public void updateMobile(Mobile mobile) {
        String sql = "UPDATE mobile SET name = ?, model = ?, os_version = ?, storage = ?, price = ? WHERE id = ?";
        jdbcClient.sql(sql)
                .params(mobile.getName(), mobile.getModel(), mobile.getOs_version(), mobile.getStorage(), mobile.getPrice(), mobile.getId())
                .update();
    }

//    public void updateMobile(Mobile mobile) {
//        String sql = "UPDATE mobile SET name = ?, model = ?, os_version = ?, storage = ?, price = ? WHERE id = ?";
//        jdbcClient.sql(sql)
//                .params(mobile.getName(), mobile.getModel(), mobile.getOs_version(), mobile.getStorage(), mobile.getPrice(), mobile.getId())
//                .update();
//    }

//    public Optional<Mobile> update(Long id, Mobile mobile) {
//        int updateCount = jdbcClient.sql("UPDATE mobile SET id=:id,name = :name,model = :model,os_version = :os_version,storage = :storage,price = :price WHERE id = :id")
//                .params(Map.of(
//                        "id", id,
//                        "name", mobile.getName(),
//                        "model",mobile.getModel(),
//                        "os_version", mobile.getOs_version(),
//                        "storage", mobile.getStorage(),"price",mobile.getPrice()
//                ))
//                .update();
//        if (updateCount == 0) {
//            return Optional.empty();
//        }
//        mobile.setId(Long.valueOf(id));
//        return Optional.of(mobile);
//    }

//    public void deleteMobileById(Long id) {
//        String sql = "DELETE FROM mobile WHERE id = :id";
//        jdbcTemplate.update(sql, id);
//    }

//    public void deleteMobileById(Long id) {
//        String sql = "DELETE FROM mobile WHERE id = :id";
//        jdbcClient.sql(sql)
//                .params(id)
//                .update();
//    }


    public Mobile getMobileById(Long id) {
        return jdbcClient.sql("SELECT * FROM mobile WHERE id = :id")
                .params(Map.of("id", id))
                .query((rs, rowNum) -> new Mobile(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("model"),
                        rs.getString("os_version"),
                        rs.getString("storage"),
                        rs.getLong("price")))
                .single();
    }

}
//package com.example.Product;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.simple.JdbcClient;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.stereotype.Repository;
//import org.springframework.jdbc.support.KeyHolder;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class MobileRepository {
//    private final JdbcClient jdbcClient;
//    public MobileRepository(JdbcTemplate template,JdbcClient jdbcClient){
//        this.jdbcClient=jdbcClient;
//    }
//    public List<Mobile> getAllMobiles(){
//        return jdbcClient.sql("SELECT * FROM mobile").query(
//                (rs,rowNum) -> new Mobile(rs.getLong("id"),rs.getString("name"),rs.getString("model"),rs.getString("os_version"),rs.getString("storage"),rs.getLong("price"))).list();
//    }
//    public void addMobile(Mobile newMobile){
//        String sql ="INSERT INTO mobile(id,name,model,os_version,storage,price) VALUES (?,?,?,?,?)";
//        keyHolder keyHolder= new GeneratedKeyHolder();
//        jdbcClient.sql(sql).params(newMobile.getId(),newMobile.getName(),newMobile.getModel(),newMobile.getOs_version(),newMobile.getStorage(),newMobile.getPrice()).update(keyHolder);
//        Number key = keyHolder.getKey();
//        if(key!=null){
//            newMobile.setName(String.valueOf(key.longValue()));
//        }
//    }
//    public Mobile getMobileById(Long id){
//        return jdbcClient.sql("SELECT *  FROM mobile WHERE id=:id ")
//                .params(Map.of("id",id)).query((rs, rowNum) -> new Mobile(rs.getLong("id"),rs.getString("name"),rs.getString("model"),rs.getString("os_version"),rs.getString("storage"),rs.getLong("price"))).single();
//    }
//}

