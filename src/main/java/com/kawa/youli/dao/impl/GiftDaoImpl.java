package com.kawa.youli.dao.impl;

import com.kawa.youli.dao.GiftDao;
import com.kawa.youli.entity.DO.Gift;
import com.kawa.youli.exception.GiftNotExistException;
import com.kawa.youli.exception.StrategyNotExistException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GiftDaoImpl implements GiftDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Gift getById(Integer id) {
        String sql="select * from gift where id=?";
        Object[] args={id};
        try {
            Gift res = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Gift.class), args);
            return res;
        }catch (EmptyResultDataAccessException e){
            String errMsg = e.getMessage();
            if (StringUtils.isNotBlank(errMsg) && errMsg.contains("Incorrect result size: expected 1, actual 0")) {
                throw new GiftNotExistException(e);
            } else {
                throw e;
            }
        }
    }

    @Override
    public List<Gift> getByName(String name) {
        String sql="select * from gift where name like ?";
        name="%"+name+"%";
        Object[] args={name};
        List<Gift> res=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Gift.class),args);
        return res;
    }

    @Override
    public List<Gift> getByPriceRange(Integer min, Integer max) {
        String sql="select * from gift where price between ? and ?";
        Object[] args={min,max};
        List<Gift> res=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Gift.class),args);
        return res;
    }

    @Override
    public List<Gift> getPopularRank() {
        String sql="select * from gift order by popular desc limit 10";
        List<Gift> res=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Gift.class));
        return res;
    }

    @Override
    public String insert(Gift gift) {
        String sql="insert into gift(name,brand,introductionId,pictureId,price,link,popular) values(?,?,?,?,?,?,?)";
        Object[] args={
                gift.getName(),
                gift.getBrand(),
                gift.getIntroductionId(),
                gift.getPictureId(),
                gift.getPrice(),
                gift.getLink(),
                gift.getPopular()
        };
        Integer res=jdbcTemplate.update(sql,args);
        return "更新了"+res.toString()+"条记录";
    }

    @Override
    public String update(Gift gift) {
        String sql="update gift set name=?,brand=?,introductionId=?,pictureId=?,price=?,link=?,popular=? where id=?";
        Object[] args={
                gift.getName(),
                gift.getBrand(),
                gift.getIntroductionId(),
                gift.getPictureId(),
                gift.getPrice(),
                gift.getLink(),
                gift.getPopular(),
                gift.getId()
        };
        Integer res=jdbcTemplate.update(sql,args);
        return "更新了"+res.toString()+"条记录";
    }

    @Override
    public String delete(Integer id) {
        String sql="delete from gift where id=?";
        Object[] args={id};
        Integer res=jdbcTemplate.update(sql,args);
        return "更新了"+res.toString()+"条记录";
    }

    @Override
    public String popular(Integer id) {
        String sql="update gift set popular=popular+1 where id=?";
        Object[] args={id};
        Integer res=jdbcTemplate.update(sql,args);
        return "更新了"+res.toString()+"条记录";
    }
}
