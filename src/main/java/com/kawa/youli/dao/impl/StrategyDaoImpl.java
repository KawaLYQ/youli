package com.kawa.youli.dao.impl;

import com.kawa.youli.dao.StrategyDao;
import com.kawa.youli.entity.DO.Strategy;
import com.kawa.youli.exception.StrategyNotExistException;
import com.kawa.youli.exception.UserNotExistException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StrategyDaoImpl implements StrategyDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Strategy getById(Integer id) {
        String sql="select * from strategy where id=?";
        Object[] args={id};
        try {
            return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Strategy.class),args);
        }catch (EmptyResultDataAccessException e){
            String errMsg = e.getMessage();
            if (StringUtils.isNotBlank(errMsg) && errMsg.contains("Incorrect result size: expected 1, actual 0")) {
                throw new StrategyNotExistException(e);
            } else {
                throw e;
            }
        }

    }

    @Override
    public List<Strategy> getByAuthorId(String authorId) {
        String sql="select * from strategy where authorId = ?";
        Object[] args={authorId};
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Strategy.class),args);
    }

    @Override
    public List<Strategy> getByStrategyName(String strategyName) {
        String sql="select * from strategy where strategyName like ?";
        strategyName="%"+strategyName+"%";
        Object[] args={strategyName};
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Strategy.class),args);
    }

    @Override
    public String insert(Strategy strategy) {
        String sql="insert into strategy(strategyKW,strategyName,authorId,contentId,writeTime,views,likes,comments) values(?,?,?,?,?,?,?,?)";
        Object[] args={
                strategy.getStrategyKW(),
                strategy.getStrategyName(),
                strategy.getAuthorId(),
                strategy.getContentId(),
                strategy.getWriteTime(),
                strategy.getViews(),
                strategy.getLikes(),
                strategy.getComments()
        };
        Integer res=jdbcTemplate.update(sql,args);
        return "更新了"+res.toString()+"条记录";
    }

    @Override
    public String update(Strategy strategy) {
        String sql="update strategy set strategyKW=?,strategyName=?,authorId=?,contentId=?,writeTime=?,views=?,likes=?,comments=? where id=?";
        Object[] args={
                strategy.getStrategyKW(),
                strategy.getStrategyName(),
                strategy.getAuthorId(),
                strategy.getContentId(),
                strategy.getWriteTime(),
                strategy.getViews(),
                strategy.getLikes(),
                strategy.getComments(),
                strategy.getId()
        };
        Integer res=jdbcTemplate.update(sql,args);
        return "更新了"+res.toString()+"条记录";
    }

    @Override
    public String delete(Integer id) {
        String sql="delete from strategy where id=?";
        Object[] args={id};
        Integer res=jdbcTemplate.update(sql,args);
        return "更新了"+res.toString()+"条记录";
    }

    @Override
    public String views(Integer id){
        String sql="update strategy set views=views+1 where id=?";
        Object[] args={id};
        Integer res=jdbcTemplate.update(sql,args);
        return "更新了"+res.toString()+"条记录";
    }

    @Override
    public String likes(Integer id){
        String sql="update strategy set likes=likes+1 where id=?";
        Object[] args={id};
        Integer res=jdbcTemplate.update(sql,args);
        return "更新了"+res.toString()+"条记录";
    }

    @Override
    public String comments(Integer id){
        String sql="update strategy set comments=comments+1 where id=?";
        Object[] args={id};
        Integer res=jdbcTemplate.update(sql,args);
        return "更新了"+res.toString()+"条记录";
    }
}
