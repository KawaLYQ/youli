package com.kawa.youli.dao.impl;

import com.kawa.youli.dao.EvaluateDao;
import com.kawa.youli.entity.DO.Evaluate;
import com.kawa.youli.exception.StrategyNotExistException;
import com.kawa.youli.exception.UserAlreadyExistException;
import com.kawa.youli.exception.UserNotExistException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Repository
public class EvaluateDaoImpl implements EvaluateDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Evaluate> getByGiftId(Integer id) {
        String sql="select * from evaluateAboutGift where viewId=?";
        Object[] args={id};
        List<Evaluate> res=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Evaluate.class),args);
        return res;
    }

    @Override
    public List<Evaluate> getByStrategyId(Integer id) {
        String sql="select * from evaluateAboutStrategy where viewId=?";
        Object[] args={id};
        List<Evaluate> res=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Evaluate.class),args);
        return res;
    }

    @Override
    public String insertAboutGift(Evaluate evaluate) {
        String sql="insert into evaluateAboutGift(authorId,likes,level,viewId,content,time) values(?,?,?,?,?,?)";
        Object[] args={
                evaluate.getAuthorId(),
                evaluate.getLikes(),
                evaluate.getLevel(),
                evaluate.getViewId(),
                evaluate.getContent(),
                evaluate.getTime()
        };
        try {
            Integer res = jdbcTemplate.update(sql, args);
            return "更新了" + res.toString() + "条记录";
        }catch (Exception e){
            Throwable cause = e.getCause();
            if (null!=cause && cause instanceof SQLIntegrityConstraintViolationException) {
                String errMsg = ((SQLIntegrityConstraintViolationException) cause).getMessage();
                if (StringUtils.isNotBlank(errMsg) && errMsg.contains("FOREIGN KEY (`viewId`) REFERENCES `gift` (`id`)")) {
                    throw new StrategyNotExistException(cause);
                } else {
                    throw e;
                }
            }
            else throw e;
        }
    }

    @Override
    public String insertAboutStrategy(Evaluate evaluate) {
        String sql="insert into evaluateAboutStrategy(authorId,likes,level,viewId,content,time) values(?,?,?,?,?,?)";
        Object[] args={
                evaluate.getAuthorId(),
                evaluate.getLikes(),
                evaluate.getLevel(),
                evaluate.getViewId(),
                evaluate.getContent(),
                evaluate.getTime()
        };
        try {
            Integer res = jdbcTemplate.update(sql, args);
            return "更新了" + res.toString() + "条记录";
        }catch (Exception e){
            Throwable cause = e.getCause();
            if (null!=cause && cause instanceof SQLIntegrityConstraintViolationException) {
                String errMsg = ((SQLIntegrityConstraintViolationException) cause).getMessage();
                if (StringUtils.isNotBlank(errMsg) && errMsg.contains("FOREIGN KEY (`viewId`) REFERENCES `strategy` (`id`)")) {
                    throw new StrategyNotExistException(cause);
                } else {
                    throw e;
                }
            }
            else throw e;
        }
    }

    @Override
    public String updateAboutGift(Evaluate evaluate) {
        String sql="update evaluateAboutGift set authorId=?,likes=?,level=?,viewId=?,content=?,time=? where id=?";
        Object[] args={
                evaluate.getAuthorId(),
                evaluate.getLikes(),
                evaluate.getLevel(),
                evaluate.getViewId(),
                evaluate.getContent(),
                evaluate.getTime(),
                evaluate.getId()
        };
        try {
            Integer res = jdbcTemplate.update(sql, args);
            return "更新了" + res.toString() + "条记录";
        }catch (Exception e){
            Throwable cause = e.getCause();
            if (null!=cause && cause instanceof SQLIntegrityConstraintViolationException) {
                String errMsg = ((SQLIntegrityConstraintViolationException) cause).getMessage();
                if (StringUtils.isNotBlank(errMsg) && errMsg.contains("FOREIGN KEY (`viewId`) REFERENCES `gift` (`id`)")) {
                    throw new StrategyNotExistException(cause);
                } else {
                    throw e;
                }
            }
            else throw e;
        }
    }

    @Override
    public String updateAboutStrategy(Evaluate evaluate) {
        String sql="update evaluateAboutStrategy set authorId=?,likes=?,level=?,viewId=?,content=?,time=? where id=?";
        Object[] args={
                evaluate.getAuthorId(),
                evaluate.getLikes(),
                evaluate.getLevel(),
                evaluate.getViewId(),
                evaluate.getContent(),
                evaluate.getTime(),
                evaluate.getId()
        };
        try {
            Integer res = jdbcTemplate.update(sql, args);
            return "更新了" + res.toString() + "条记录";
        }catch (Exception e){
            Throwable cause = e.getCause();
            if (null!=cause && cause instanceof SQLIntegrityConstraintViolationException) {
                String errMsg = ((SQLIntegrityConstraintViolationException) cause).getMessage();
                if (StringUtils.isNotBlank(errMsg) && errMsg.contains("FOREIGN KEY (`viewId`) REFERENCES `strategy` (`id`)")) {
                    throw new StrategyNotExistException(cause);
                } else {
                    throw e;
                }
            }
            else throw e;
        }
    }

    @Override
    public String deleteByGiftId(Integer id) {
        String sql="delete from evaluateAboutGift where id=?";
        Object[] args={id};
        Integer res=jdbcTemplate.update(sql,args);
        return "更新了"+res.toString()+"条记录";
    }

    @Override
    public String deleteByStrategyId(Integer id) {
        String sql="delete from evaluateAboutStrategy where id=?";
        Object[] args={id};
        Integer res=jdbcTemplate.update(sql,args);
        return "更新了"+res.toString()+"条记录";
    }
}
