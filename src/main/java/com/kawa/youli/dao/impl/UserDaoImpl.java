package com.kawa.youli.dao.impl;

import com.kawa.youli.dao.UserDao;
import com.kawa.youli.entity.DO.User;
import com.kawa.youli.exception.UserAlreadyExistException;
import com.kawa.youli.exception.UserNotExistException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getByUserId(String id)  {
        String sql="select * from user where userId=?";
        Object[] args={id};
        try {
            User res=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),args);
            return res;
        }catch (EmptyResultDataAccessException e){
            String errMsg = e.getMessage();
            if (StringUtils.isNotBlank(errMsg) && errMsg.contains("Incorrect result size: expected 1, actual 0")) {
                throw new UserNotExistException(e);
            } else {
                throw e;
            }
        }

    }

    @Override
    public List<User> getByUserName(String userName) {
        String sql="select * from user where userName like ?";
        userName="%"+userName+"%";
        Object[] args={userName};
        List<User> res=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class),args);
        return res;
    }

    @Override
    public String insert(User user) {
        String sql="insert into user(userId,userName,password,sex,birthday,company,school,telephone,email,status,headShotId) values(?,?,?,?,?,?,?,?,?,?,?)";
        Object[] args={
                user.getUserId(),
                user.getUserName(),
                user.getPassword(),
                user.getSex(),
                user.getBirthday(),
                user.getCompany(),
                user.getSchool(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getHeadShotId()
        };
        try {
            jdbcTemplate.update(sql, args);
            return "Success";
        }catch (Exception e){
            Throwable cause = e.getCause();
            if (null!=cause && cause instanceof SQLIntegrityConstraintViolationException) {
                String errMsg = ((SQLIntegrityConstraintViolationException) cause).getMessage();
                if (StringUtils.isNotBlank(errMsg) && errMsg.contains("user.PRIMARY")) {
                    throw new UserAlreadyExistException(cause);
                } else {
                    throw e;
                }
            }
            else throw e;
        }

    }

    @Override
    public String update(User user) {
        String sql="update user set userName=?,password=?,sex=?,birthday=?,company=?,school=?,telephone=?,email=?,status=?,headShotId=? where userId=?";
        Object[] args={
                user.getUserName(),
                user.getPassword(),
                user.getSex(),
                user.getBirthday(),
                user.getCompany(),
                user.getSchool(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getHeadShotId(),
                user.getUserId()
        };
        Integer res=jdbcTemplate.update(sql,args);
        return "更新了"+res.toString()+"条记录";
    }

    @Override
    public String delete(String userId) {
        String sql="delete from user where userId=?";
        Object[] args={userId};
        Integer res=jdbcTemplate.update(sql,args);
        return "更新了"+res.toString()+"条记录";
    }
}
